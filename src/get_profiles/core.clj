(ns get-profiles.core
  (:require [tentacles.search :as search]
            [tentacles.repos :as repos]
            [clj-http.client :as http]
            [cheshire.core :as cheshire]
            [taoensso.timbre :as timbre
             :refer [spy error]])
  (:import java.util.Base64)
  (:gen-class))

(defn my-spy [s]
  (spy :debug "" s))

(defn get-clojure-repos [username auth-token]
  (let [pages (->> (search/search-repos nil
                                        {:language "clojure"}
                                        {:all-pages true
                                         :auth (str username ":" auth-token)})
                   (partition 3))]
    (mapcat (fn [page]
              (-> page
                  (nth 2)
                  second)) pages)))

(defn owner [repo]
  (get-in repo [:owner :login]))

(defn decode [to-decode]
  (String. (.decode (Base64/getDecoder) (clojure.string/replace to-decode "\n" ""))))

(defn download-and-store [path {:keys [content sha]}]
  (->> content
       decode
       (spit (my-spy (str path "/" sha)))))

(defn get-project-clj! [username auth-token path repo]
  (try
    (download-and-store
     path
     (-> (str "https://api.github.com/repos/" (owner repo) "/" (:name repo) "/contents/project.clj")
         my-spy
         (http/get {:basic-auth [username auth-token]})
         :body
         (cheshire/parse-string keyword)
         (select-keys [:content :sha])))
    (catch Exception e
      (error "Couldn't download project.clj for " (:name repo) (.getMessage e)))))

(defn -main [path username auth-token n]
  (doseq [repo (take n (get-clojure-repos username auth-token))]
    (get-project-clj! username auth-token path repo)))
