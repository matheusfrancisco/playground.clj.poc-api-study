(ns budget-calculator-api.controllers
  (:require [ring.util.response :refer [response]]))



(defn add-budget!
  [budget]
  budget)

(defn add [request]
  {:body "Funciona"})

(defn add-budget
  [request]
  (response {:body (add-budget! (:body request))}))
