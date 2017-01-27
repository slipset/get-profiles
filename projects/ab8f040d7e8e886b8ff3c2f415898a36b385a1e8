(defproject frontend "0.1.0-SNAPSHOT"
  :description "CircleCI's frontend app"
  :url "https://circleci.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [inflections "0.8.2"]

                 [org.clojars.dwwoelfel/stefon "0.5.0-3198d1b33637d6bd79c7415b01cff843891ebfd4"
                  :exclusions [com.google.javascript/closure-compiler]]
                 [compojure "1.1.8"]
                 [ring/ring "1.2.2"]
                 [http-kit "2.1.18"]
                 [circleci/clj-yaml "0.5.2"]
                 [fs "0.11.1"]
                 [com.cemerick/url "0.1.1"]
                 [cheshire "5.3.1"]

                 ;; Prerelease version to avoid conflict with cljs.core/record?
                 ;; https://github.com/noprompt/ankha/commit/64423e04bf05459f96404ff087740bce1c9f9d37
                 [ankha "0.1.5.1-64423e"]
                 [org.clojure/clojurescript "1.9.227"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [org.clojure/core.match "0.3.0-alpha4"]
                 [cljs-ajax "0.3.13" :exclusions [com.cognitect/transit-cljs]]
                 ;; Use a slightly later version of transit-cljs than cljs-ajax
                 ;; depends on to avoid a ClojureScript warning.
                 [com.cognitect/transit-cljs "0.8.239"]
                 [cljsjs/react-with-addons "0.14.5-0"]
                 [cljsjs/react-dom "0.14.5-0"]
                 [cljsjs/c3 "0.4.10-0"]

                 [org.omcljs/om "1.0.0-alpha47"]
                 [compassus "1.0.0-alpha2"]

                 [hiccups "0.3.0"]
                 [sablono "0.7.2"]
                 [secretary "1.2.2"]
                 [com.andrewmcveigh/cljs-time "0.4.0"]
                 [prismatic/schema "1.1.3"]
                 [devcards "0.2.1-6"]

                 ;; Frontend tests
                 [org.clojure/tools.reader "1.0.0-beta3"]
                 [circleci/bond "0.2.9"]
                 [lein-doo "0.1.6"]

                 ;; For Dirac DevTools
                 [environ "1.0.1"]]

  :plugins [[lein-cljsbuild "1.1.1"]
            [lein-figwheel "0.5.8"]
            [cider/cider-nrepl "0.11.0"]
            [lein-environ "1.0.1"]
            [lein-doo "0.1.6"]]

  ;; Don't include these dependencies transitively. These are foundational
  ;; dependencies that lots of our direct dependencies depend on. We want to
  ;; make sure we get the version *we* asked for, not the version one of *them*
  ;; asked for (which means we're taking responsibility for the versions working
  ;; together). If Maven had useful version ranges like Bundler or npm, we could
  ;; let it take care of resolving the versions for us, but Maven's version
  ;; ranges are considered dysfuntional, so we can't.
  :exclusions [org.clojure/clojure
               org.clojure/clojurescript
               cljsjs/react]

  :main frontend.core

  :jvm-opts ["-Djava.net.preferIPv4Stack=true"
             "-server"
             "-XX:+UseConcMarkSweepGC"
             "-Xss1m"
             "-Xmx2g"
             "-XX:+CMSClassUnloadingEnabled"
             "-Djava.library.path=target/native/macosx/x86_64:target/native/linux/x86_64:target/native/linux/x86"
             "-Djna.library.path=target/native/macosx/x86_64:target/native/linux/x86_64:target/native/linux/x86"
             "-Dfile.encoding=UTF-8"
             "-Djava.awt.headless=true"]

  :clean-targets ^{:protect false} [:target-path "resources/public/cljs/"]

  :figwheel {:css-dirs ["resources/assets/css"]
             :nrepl-port 7888}

  :doo {:build "dev-test"
        :alias {:default [:chrome]}
        :paths {:karma "./node_modules/karma/bin/karma"}}

  :cljsbuild {:builds {:dev {:source-paths ["src-cljs" "test-cljs"]
                             ;; Port 4444 is proxied (with SSL) to 3449 (the Figwheel server port).
                             :figwheel {:websocket-url "wss://prod.circlehost:4444/figwheel-ws"}
                             :compiler {:output-to "resources/public/cljs/out/frontend-dev.js"
                                        :output-dir "resources/public/cljs/out"
                                        :optimizations :none
                                        ;; Speeds up Figwheel cycle, at the risk of dependent namespaces getting out of sync.
                                        :recompile-dependents false}}

                       :devcards {:source-paths ["src-cljs" "test-cljs"]
                                   :figwheel {:devcards true
                                              :websocket-url "wss://prod.circlehost:4444/figwheel-ws"
                                              :on-cssload "frontend.core/handle-css-reload"}
                                   :compiler {:main "frontend.core"
                                              :asset-path "cljs/devcards-out"
                                              :output-to "resources/public/cljs/devcards-out/frontend-devcards.js"
                                              :output-dir "resources/public/cljs/devcards-out"
                                              :optimizations :none
                                              :recompile-dependents false}}

                       ;; This is the build normally used for testing on
                       ;; development machines. Use it by running lein doo.
                       :dev-test {:source-paths ["src-cljs" "test-cljs"]
                                  :compiler {:output-to "resources/public/cljs/dev-test/frontend-dev.js"
                                             :output-dir "resources/public/cljs/dev-test"
                                             ;; This is the default when we have :optimizations :advanced. It causes some
                                             ;; unexpected behavior when using with-redefs, so leaving it on so dev-test
                                             ;; and test behave more similarly.
                                             :static-fns true
                                             :optimizations :none
                                             :main frontend.test-runner}}

                       :whitespace {:source-paths ["src-cljs"]
                                    :compiler {:output-to "resources/public/cljs/whitespace/frontend-whitespace.js"
                                               :output-dir "resources/public/cljs/whitespace"
                                               :optimizations :whitespace
                                               :source-map "resources/public/cljs/whitespace/frontend-whitespace.js.map"}}

                       ;; This build runs the tests
                       ;; with :optimizations :advanced to catch advanced
                       ;; compilation bugs. That's too slow to run in
                       ;; development, so we run this one in CI.
                       :test {:source-paths ["src-cljs" "test-cljs"]
                              :compiler {:output-to "resources/public/cljs/test/frontend-test.js"
                                         :output-dir "resources/public/cljs/test"
                                         :optimizations :advanced
                                         :main frontend.test-runner
                                         ;; :advanced uses the minified versions of libraries (:file-min), but the
                                         ;; minified React doesn't include React.addons.TestUtils.
                                         :foreign-libs [{:provides ["cljs.react"]
                                                         :file "cljsjs/development/react-with-addons.inc.js"
                                                         :file-min "cljsjs/development/react-with-addons.inc.js"}]
                                         :externs ["test-js/externs.js"
                                                   "src-cljs/js/pusher-externs.js"
                                                   "src-cljs/js/ci-externs.js"
                                                   "src-cljs/js/analytics-externs.js"
                                                   "src-cljs/js/intercom-jquery-externs.js"
                                                   "src-cljs/js/d3-externs.js"
                                                   "src-cljs/js/prismjs-externs.js"]
                                         :source-map "resources/public/cljs/test/frontend-test.js.map"}}

                       :production {:source-paths ["src-cljs"]
                                    :compiler {:pretty-print false
                                               :output-to "resources/public/cljs/production/frontend.js"
                                               :output-dir "resources/public/cljs/production"
                                               :optimizations :advanced
                                               :closure-defines {frontend.config/DEV false}
                                               :externs ["src-cljs/js/pusher-externs.js"
                                                         "src-cljs/js/ci-externs.js"
                                                         "src-cljs/js/analytics-externs.js"
                                                         "src-cljs/js/intercom-jquery-externs.js"
                                                         "src-cljs/js/d3-externs.js"
                                                         "src-cljs/js/prismjs-externs.js"
                                                         "src-cljs/js/bootstrap-externs.js"]
                                               :source-map "resources/public/cljs/production/frontend.js.map"}}}}
  :profiles {:devtools {:repl-options {:port 8230
                                       :nrepl-middleware [dirac.nrepl.middleware/dirac-repl]
                                       :init (do
                                               (require 'dirac.agent)
                                               (dirac.agent/boot!))}
                        :env {:devtools "true"}
                        :cljsbuild {:builds {:dev {:source-paths ["devtools"]}
                                             :devcards {:source-paths ["devtools"]}}}
                        :dependencies [[binaryage/devtools "0.7.2"]
                                       [binaryage/dirac "0.6.1"]]}
             :dev {:source-paths ["src-cljs" "test-cljs"]
                   :repl-options {:port 8230
                                  :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
                   :dependencies [[figwheel-sidecar "0.5.8"]
                                  [com.cemerick/piggieback "0.2.1"]
                                  [org.clojure/tools.nrepl "0.2.12"]]}})
