(defproject im.chit/purnam "0.5.2"
  :description "Language extensions for clojurescript"  
  :url "http://www.github.com/purnam/purnam"
  :license {:name "The MIT License"
            :url "http://opensource.org/licencses/MIT"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :test-paths ["test/clj"]
  :profiles {:dev {:dependencies [[org.clojure/clojurescript "0.0-3115"]
                                  [midje "1.6.3"]]
                   :plugins [[lein-ancient "0.5.5"]
                             [lein-cljsbuild "1.0.5"]
                             [lein-midje "3.1.3"]
                             ;;[lein-midje-doc "0.0.24"]
                             ;;[lein-repack "0.2.3"]
                             ]}}
  :documentation {:files {"doc/index"
                        {:input "test/clj/midje_doc/purnam_guide.clj"
                         :title "purnam"
                         :sub-title "Language extensions for clojurescript"
                         :author "Chris Zheng"
                         :email  "z@caudate.me"
                         :tracking "UA-31320512-2"}}}
  :cljsbuild {:builds [{:source-paths ["src" "test/cljs"]
                        :compiler {:output-to "target/purnam-test.js"
                                   :optimizations :whitespace
                                   :pretty-print true}}]}
  :repack [{:type :clojure
            :levels 1
            :path "src"}])