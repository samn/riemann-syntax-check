(defproject riemann-syntax-check "0.1.0"
  :description "A Riemann config syntax checker"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main riemann-syntax-check
  :profiles {:dev {:dependencies [[midje "1.6.3" :scope "test"]]}}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [riemann "0.2.4"]])
