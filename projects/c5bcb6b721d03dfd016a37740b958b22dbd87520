(defproject cljs-debugging "0.0.1"
  :description "a simple example of how to debug clojurescript"
  :source-paths ["src"]
  :test-paths ["test"]

  :dependencies
  [[org.clojure/clojure "1.5.1"]
   [org.clojure/clojurescript "0.0-2234"]
   [com.cemerick/piggieback "0.1.3"]
   [weasel "0.2.0"]]

  :plugins
  [[lein-cljsbuild "1.0.3"]
   [com.cemerick/clojurescript.test "0.3.0"]]

  :cljsbuild
  {:builds {:main {:source-paths ["src" "test"]
                   :compiler {:optimizations :whitespace
                              :pretty-print true
                              :output-to "example.js"
                              :output-dir "out"}}}

   :test-commands {"phantomjs" ["phantomjs" :runner
                                "jquery-1.9.1.min.js"
                                "example.js"]}}

  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
  :injections [(require 'weasel.repl.websocket)
               (def brepl #(cemerick.piggieback/cljs-repl :repl-env (weasel.repl.websocket/repl-env)))])
