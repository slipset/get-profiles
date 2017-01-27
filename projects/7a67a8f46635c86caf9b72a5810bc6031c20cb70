(defproject im.chit/adi "0.3.4"
  :description "data modelling for the ambitious"
  :url "https://www.github.com/zcaudate/adi"
  :license {:name "The MIT License"
            :url "http://http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [im.chit/hara.common    "2.2.17"]
                 [im.chit/hara.string    "2.2.17"]
                 [im.chit/hara.data      "2.2.17"]
                 [im.chit/hara.function  "2.2.17"]
                 [im.chit/hara.component "2.2.17"]
                 [im.chit/hara.event "2.2.17"]
                 [inflections "0.9.14"]]
  :documentation {:site   "adi"
                  :output "docs"
                  :description "data modelling for the ambitious"
                  :tracking "UA-31320512-2"
                  :owners [{:name    "Chris Zheng"
                            :email   "z@caudate.me"
                            :website "http://z.caudate.me"}]
                  :template {:path "template"
                             :copy ["assets"]
                             :defaults {:template "article.html"
                                        :navbar  [:file "partials/navbar.html"]
                                        :sidebar [:file "partials/sidebar.html"]
                                        :footer  [:file "partials/footer.html"]
                                        :dependencies [:file "partials/deps-web.html"]
                                        :contentbar  :navigation
                                        :article     :article}}
                  :paths ["test/documentation"]
                  :files {"index"
                          {:template "home.html"
                           :title "adi"
                           :subtitle "data modelling for the ambitious"}
                          "adi-guide"
                          {:input "test/documentation/adi_guide.clj"
                           :title "adi"
                           :subtitle "data modelling for the ambitious"}
                          "adi-walkthrough"
                          {:input "test/documentation/adi_walkthrough.clj"
                           :title "walkthrough"
                           :subtitle "a whirlwind tour of the library"}}
                :link {:auto-tag    true
                       :auto-number true}}
  :profiles {:dev {:plugins [[lein-midje "3.1.3"]
                             [lein-hydrox "0.1.16"]]
                   :dependencies [[com.datomic/datomic-free "0.9.5350" :exclusions [joda-time]]
                                  [midje "1.6.3"]
                                  [clj-time "0.11.0"]
                                  [me.raynes/fs "1.4.6"]
                                  [cheshire "5.2.0"]
                                  [helpshift/hydrox "0.1.16"]]}})
