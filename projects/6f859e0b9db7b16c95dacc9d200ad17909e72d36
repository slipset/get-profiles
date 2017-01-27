(defproject yet-another-craft "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.51" :scope "provided"]
                 [org.clojure/core.async "0.2.374"]
                 [ring/ring-devel "1.4.0"]
                 [ring/ring-core "1.4.0"]
                 [ring/ring-defaults "0.2.0"]
                 [http-kit "2.1.19"]
                 [reagent "0.6.0-SNAPSHOT"]
                 [reagent-forms "0.5.23"]
                 [reagent-utils "0.1.8"]
                 [prone "1.1.1"]
                 [compojure "1.5.0"]
                 [hiccup "1.0.5"]
                 [environ "1.0.2"]
                 [secretary "1.2.3"]
                 [jarohen/chord "0.7.0"]
                 [org.clojure/tools.reader "0.10.0"]
                 [secretary "1.2.3"]
                 [com.taoensso/timbre "4.3.1"]
                 [mount "0.1.10"]]

  :plugins [[lein-environ "1.0.2"]
            [refactor-nrepl "2.3.0-SNAPSHOT"]
            [lein-asset-minifier "0.2.8"]
            [cider/cider-nrepl "0.13.0-SNAPSHOT"]]

  :ring {:handler yet-another-craft.handler/app
         :uberwar-name "yet-another-craft.war"}

  :min-lein-version "2.5.0"

  :uberjar-name "yet-another-craft.jar"

  :main yet-another-craft.server

  :clean-targets ^{:protect false} [:target-path
                                    [:cljsbuild :builds :app :compiler :output-dir]
                                    [:cljsbuild :builds :app :compiler :output-to]]

  :source-paths ["src/clj" "src/cljc"]

  :minify-assets
  {:assets
   {"resources/public/css/site.min.css" "resources/public/css/site.css"}}

  :cljsbuild {:builds {:app {:source-paths ["src/cljs" "src/cljc"]
                             :compiler {:output-to "resources/public/js/app.js"
                                        :output-dir "resources/public/js/out"
                                        :asset-path "js/out"
                                        :optimizations :none
                                        :pretty-print true}}}}

  :figwheel {:http-server-root "public"
             :server-port 3000
             :nrepl-port 7002
             :nrepl-middleware ["cider.nrepl/cider-middleware"
                                "refactor-nrepl.middleware/wrap-refactor"
                                "cemerick.piggieback/wrap-cljs-repl"]
             :css-dirs ["resources/public/css"]
             :ring-handler yet-another-craft.handler/app}

  :profiles {:dev {:repl-options {:init-ns yet-another-craft.repl
                                  :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl
                                                     cider.nrepl.middleware.apropos/wrap-apropos
                                                     cider.nrepl.middleware.classpath/wrap-classpath
                                                     cider.nrepl.middleware.complete/wrap-complete
                                                     cider.nrepl.middleware.info/wrap-info
                                                     cider.nrepl.middleware.inspect/wrap-inspect
                                                     cider.nrepl.middleware.macroexpand/wrap-macroexpand
                                                     cider.nrepl.middleware.ns/wrap-ns
                                                     cider.nrepl.middleware.resource/wrap-resource
                                                     cider.nrepl.middleware.stacktrace/wrap-stacktrace
                                                     cider.nrepl.middleware.test/wrap-test
                                                     cider.nrepl.middleware.trace/wrap-trace
                                                     cider.nrepl.middleware.undef/wrap-undef]}

                   :dependencies [[ring/ring-mock "0.3.0"]
                                  [ring/ring-devel "1.4.0"]
                                  [com.cemerick/piggieback "0.2.1"]
                                  [org.clojure/tools.nrepl "0.2.12"]
                                  [pjstadig/humane-test-output "0.8.0"]]

                   :source-paths ["env/dev/clj"]
                   :plugins [[lein-figwheel "0.5.2"]
                             [lein-cljsbuild "1.1.3"]]

                   :injections [(require 'pjstadig.humane-test-output)
                                (pjstadig.humane-test-output/activate!)]

                   :env {:dev true}

                   :cljsbuild {:builds {:app {:source-paths ["env/dev/cljs"]
                                              :compiler {:main "yet-another-craft.dev"
                                                         :source-map true}}}}}

             :uberjar {:hooks [leiningen.cljsbuild minify-assets.plugin/hooks]
                       :env {:production true}
                       :aot :all
                       :omit-source true
                       :cljsbuild {:jar true
                                   :builds {:app
                                            {:source-paths ["env/prod/cljs"]
                                             :compiler
                                             {:optimizations :advanced
                                              :pretty-print false}}}}}})
