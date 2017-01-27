(ns get-profiles.analytics
  (:require [taoensso.timbre :as timbre
             :refer [spy error]]))

(defn parse-project [[_ name version & xs]]
  (merge (apply hash-map xs)
         {:name name
          :version version}))

(defn read-and-parse-project [f]
  (try
    (-> f slurp read-string parse-project)
    (catch Exception e
      (error "Couldn't read and parse project" (.getName f)))))

(defn read-projects [path]
  (let [projects (rest (file-seq (clojure.java.io/file path)))]
    (keep read-and-parse-project projects)))

(defn most-popular-deps [projects]
  (->> projects
       (mapcat :dependencies)
       (map first)
       frequencies
       (sort-by second)
       reverse))

(defn most-popular-clojure-versions [projects]
  (->> projects
       (mapcat :dependencies)
       (keep #(when (= 'org.clojure/clojure (first %))
                 (second %)))
       frequencies
       (sort-by second)
       reverse))

(defn has-clojure [p]
  (let [deps (:dependencies p)]
    (when (filter #(= 'org.clojure/clojure (first %)) deps)
      p)))

(defn projects-without-deps [projects]
  (->> projects
       (filter (complement :dependencies))
       (map :name)))

(defn projects-without-clojure [projects]
  (->> projects
       (keep #(when ((complement has-clojure) %)
                (:dependencies %)))))

(defn has-version-range [p]
  (let [deps (:dependencies p)]
    (seq (filter (fn [dep]
                   (when-let [version (some-> dep
                                         second)]
                     (or (.contains version ")")
                         (.contains version "(")
                         (.contains version ",")))) deps))))

(defn with-ranges [projects]
  (->> projects
       (filter has-version-range)
       (map :name)))
