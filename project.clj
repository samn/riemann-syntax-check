(defproject riemann-syntax-check "0.2.1"
  :description "A Riemann config syntax checker"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main riemann-syntax-check
  :aot [riemann-syntax-check]
  :profiles {:dev {:dependencies [[midje "1.6.3" :scope "test"]]}}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [riemann "0.2.9"]])
