(defproject get-profiles "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [tentacles "0.5.1"]
                 [clj-http "3.4.1"]
                 [cheshire "5.7.0"]
                 [timbre "0.5.1-SNAPSHOT"]
                 [com.taoensso/timbre "4.8.0"]]
  :main ^:skip-aot get-profiles.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
