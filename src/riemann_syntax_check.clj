(ns riemann-syntax-check
  (:require [riemann.config])
  (:gen-class))

(defn validate-config!
  [config-path]
  (riemann.config/validate-config config-path))

(defn -main
  [config-path]
  (validate-config! config-path))
