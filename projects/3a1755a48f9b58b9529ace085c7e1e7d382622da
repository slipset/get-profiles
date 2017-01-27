(defproject im.chit/hara "2.4.8"
  :description "patterns and utilities"
  :url "https://github.com/zcaudate/hara"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :aliases {"test" ["run" "-m" "hara.test" "exit"]}
  :profiles {:dev {:dependencies [[compojure "1.4.0"]
                                  [ring "1.4.0"]
                                  [clj-http "2.1.0"]
                                  [org.eclipse.jgit "4.0.1.201506240215-r"]
                                  [joda-time "2.9.2"]]}}
  :publish {:theme  "bolton"
  
            :template {:author "Chris Zheng"
                       :email  "z@caudate.me"
                       :site   "hara"
                       :tracking-enabled "true"
                       :tracking "UA-31320512-2"}
            
            :files {"index"
                    {:template "home.html"
                     :input "test/documentation/home_hara.clj"
                     :title "hara"
                     :subtitle "patterns and utilities"}
                    "hara-class"
                    {:input "test/documentation/hara_class.clj"
                     :title "class"
                     :subtitle "functions for reasoning about classes"}
                    "hara-common"
                    {:input "test/documentation/hara_common.clj"
                     :title "common"
                     :subtitle "primitives declarations and functions"}
                    "hara-component"
                    {:input "test/documentation/hara_component.clj"
                     :title "component"
                     :subtitle "constructing composable systems"}
                    "hara-concurrent"
                    {:input "test/documentation/hara_concurrent.clj"
                     :title "concurrent"
                     :subtitle "methods and datastructures for concurrency"}
                    "hara-concurrent-ova"
                    {:input "test/documentation/hara_concurrent_ova.clj"
                     :title "concurrent.ova"
                     :subtitle "shared mutable state"}
                    "hara-concurrent-procedure"
                    {:input "test/documentation/hara_concurrent_procedure.clj"
                     :title "concurrent.procedure"
                     :subtitle "controllable execution"}
                    "hara-data"
                    {:input "test/documentation/hara_data.clj"
                     :title "data"
                     :subtitle "maps and representations of data"}
                    "hara-event"
                    {:input "test/documentation/hara_event.clj"
                     :title "event"
                     :subtitle "event signalling and conditional restart"}
                    "hara-expression"
                    {:input "test/documentation/hara_expression.clj"
                     :title "expression"
                     :subtitle "interchange between code and data"}
                    "hara-extend"
                    {:input "test/documentation/hara_extend.clj"
                     :title "extend"
                     :subtitle "macros for extensible objects"}
                    "hara-function"
                    {:input "test/documentation/hara_function.clj"
                     :title "function"
                     :subtitle "reasoning about functions"}
                    "hara-group"
                    {:input "test/documentation/hara_group.clj"
                     :title "group"
                     :subtitle "generic typed collections"}
                    "hara-io-file"
                    {:input "test/documentation/hara_io_file.clj"
                     :title "io.file"
                     :subtitle "tools for the file system"}
                    "hara-io"
                    {:input "test/documentation/hara_io.clj"
                     :title "io"
                     :subtitle "tools for files and io operations"}
                    "hara-io-scheduler"
                    {:input "test/documentation/hara_io_scheduler.clj"
                     :title "io.scheduler"
                     :subtitle "easy and intuitive task scheduling"}
                    "hara-io-watch"
                    {:input "test/documentation/hara_io_watch.clj"
                     :title "io.watch"
                     :subtitle "watch for filesystem changes"}
                    "hara-namespace"
                    {:input "test/documentation/hara_namespace.clj"
                     :title "namespace"
                     :subtitle "utilities for namespace manipulation"}
                    "hara-object"
                    {:input "test/documentation/hara_object.clj"
                     :title "object"
                     :subtitle "think data, escape encapsulation"}
                    "hara-reflect"
                    {:input "test/documentation/hara_reflect.clj"
                     :title "reflect"
                     :subtitle "java reflection made easy"}
                    "hara-security"
                    {:input "test/documentation/hara_security.clj"
                     :title "security"
                     :subtitle "cryptography that makes sense"}
                    "hara-sort"
                    {:input "test/documentation/hara_sort.clj"
                     :title "sort"
                     :subtitle "micellaneous sorting functions"}
                    "hara-string"
                    {:input "test/documentation/hara_string.clj"
                     :title "string"
                     :subtitle "methods for string manipulation"}
                    "hara-test"
                    {:input "test/documentation/hara_test.clj"
                     :title "test"
                     :subtitle "easy to use test framework"}
                    "hara-time"
                    {:input "test/documentation/hara_time.clj"
                     :title "time"
                     :subtitle "time as a clojure map"}
                    "hara-zip"
                    {:input "test/documentation/hara_zip.clj"
                     :title "zip"
                     :subtitle "data traversal in style"}}}
  :jvm-opts []
  :global-vars {*warn-on-reflection* true}
  :java-source-paths ["java"]
  :jar-exclusions [#"^test\..+\.class"]
  :distribute {:jars  :dependencies
               :files [{:type :clojure
                        :levels 2
                        :path "src"
                        :standalone #{"event" "reflect" "time" "object" "security" "test" "zip"}}]})
