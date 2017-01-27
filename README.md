# get-profiles

So this project began as a question.

Do people in the clojure community use version ranges in their
dependency vectors?

So how does one go about answering that? One way is to find a bunch of
`project.clj`s and have a look. And where do you find them? On github.

So. Included in this project is some 859 `project.clj`s that are
downloaded by using the code in `get-profiles/core.clj`. You can, if
you want, use that code to download even more files.

In `get-profiles/analytics.clj` there are some functions which do some
simple queries on the data.

So, to start out, read and parse the `project.clj`s

```clojure
(def projects (read-projects "./projects/"))
;; => #'get-profiles.analytics/projects
get-profiles.analytics> (count projects)
;; => 859
```
Then, what are the most popular dependencies?

```clojure
get-profiles.analytics> (take 10 (most-popular-deps projects))
;; => ([org.clojure/clojure 674] [org.clojure/clojurescript 170] [org.clojure/core.async 101] [org.clojure/tools.logging 80] [cheshire 78] [compojure 57] [clj-time 56] [clj-http 47] [prismatic/schema 43] [org.clojure/data.json 43])
```
So it seems like people really enjoy `core.async`, log quite a bit and
do a bunch of web-development.

But which version of clojure do they use?
```clojure
get-profiles.analytics> (clojure.pprint/pprint (most-popular-clojure-versions projects))
(["1.8.0" 156]
 ["1.5.1" 117]
 ["1.7.0" 103]
 ["1.6.0" 100]
 ["1.4.0" 66]
 ["1.3.0" 24]
 ["1.9.0-alpha14" 15]
 ["1.2.0" 14]
 ["1.5.0" 11]
 ["1.2.1" 7]
 ["1.9.0-alpha10" 5]
 ["1.7.0-RC1" 5]
 ["1.9.0-alpha13" 3]
 ["1.7.0-alpha1" 3]
 ["1.1.0" 3]
 ["1.9.0-alpha12" 3]
 ["1.9.0-master-SNAPSHOT" 3]
 ["1.9.0-alpha11" 2]
 ["1.7.0-alpha6" 2]
 ["1.3.0-beta1" 2]
 ["1.7.0-beta2" 2]
 ["1.2.0-master-SNAPSHOT" 2]
 ["1.7.0-beta1" 2]
 ["[1.2.0,1.3.0]" 1]
 ["1.5.0-beta1" 1]
 ["[1.3.0,)" 1]
 ["1.7.0-alpha4" 1]
 ["1.8.0-alpha5" 1]
 ["1.1.0-alpha-SNAPSHOT" 1]
 ["1.9.0-alpha1" 1]
 ["1.7.0-alpha3" 1]
 ["1.5.0-RC16" 1]
 ["1.9.0-alpha3" 1]
 ["1.5.0-master-SNAPSHOT" 1]
 ["1.6.0-beta1" 1]
 ["1.9.0-alpha6" 1]
 ["1.7.0-beta3" 1]
 ["1.8.0-master-SNAPSHOT" 1]
 ["1.9.0-alpha5" 1]
 ["1.7.0-RC2" 1]
 ["[1.2.0,)" 1]
 ["1.6.0-master-SNAPSHOT" 1]
 ["1.9.0-alpha7" 1]
 ["1.2.0-master-20100430.160229-59" 1]
 ["1.5.0-alpha3" 1]
 ["1.5.0-RC1" 1])
;; => nil
```
Interestingly, Clojure 1.5.1 is the second most popular Clojure
version. And here we can see version-ranges for the first time, used
in two projects  `["[1.3.0,)" 1]` `["[1.2.0,)" 1]`.

So how many of these projects use version-ranges?

```clojure
get-profiles.analytics> (with-ranges projects)
;; => (clj-tagsoup clj-redis net.cgrand/sjacket)
```
So three of them.

