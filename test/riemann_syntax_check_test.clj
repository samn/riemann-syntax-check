(ns riemann-syntax-check-test
  (:require [riemann-syntax-check :refer :all]
            [midje.sweet :refer :all]))

(defmacro with-fake-slurp
  [slurped-value & body]
  `(with-redefs [clojure.core/slurp (fn [~'_] ~slurped-value)]
     ~@body))

;; riemann.config/validate-config expects its argument to be a path to a file

(fact "invalid syntax raises an exception"
  (with-fake-slurp "[[]" (validate-config! ...config-file...)) => (throws Exception)
  (with-fake-slurp "{{}" (validate-config! ...config-file...)) => (throws Exception)
  (with-fake-slurp "{:foo}" (validate-config! ...config-file...)) => (throws Exception)
  (with-fake-slurp "(()" (validate-config! ...config-file...)) => (throws Exception))

(fact "valid syntax does not raise an exception"
  (with-fake-slurp "()" (validate-config! ...config-file...)) =not=> (throws Exception)
  (with-fake-slurp "(cats) {:dogs true} [pets]" (validate-config! ...config-file...)) =not=> (throws Exception)
  (with-fake-slurp "dogs" (validate-config! ...config-file...)) =not=> (throws Exception))
