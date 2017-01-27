(defproject com.roomkey/annotate "1.0.1"
  :description "Type annotations and type checking."
  :url "https://github.com/roomkey/annotate"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :profiles {:dev {:dependencies [[midje "1.6.3"]]
                   :source-paths ["dev"]
                   :plugins [[codox "0.8.11"]
                             [lein-gorilla "0.3.4"]]
                   :codox {:src-dir-uri "https://github.com/roomkey/annotate/blob/master/"
                           :src-linenum-anchor-prefix "L"
                           :output-dir "."
                           :exclude [annotate.examples]}}
             :1.7 {:dependencies [[org.clojure/clojure "1.7.0-beta2"]]}})
