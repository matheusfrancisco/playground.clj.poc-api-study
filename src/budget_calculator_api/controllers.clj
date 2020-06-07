(ns budget-calculator-api.controllers
  (:require [reitit.ring :as ring]
            [com.stuartsierra.component :as component]
            [ring.util.response :refer [response]]
            [budget-calculator-api.controllers :as c]
            [budget-calculator-api.protocols.storage-client :as storage-client]))

(defn add-budget!
  [budget]
  budget)


(defn add [request]
  {:body "Funciona"})


(defn add-budget
  [request]
  (response {:body (add-budget! (:body request))}))


(defn test-get
  "
      WIP only to understand how component injection works
  "
  [request]
  (def storage (:storage request))
  (storage-client/put! storage #(%1 %2 conj {:id 3 :nome "Ola" :ammount "100 moedinhas"}))
  (response {:body (storage-client/read-all storage) :status 200}))


(def router
  (ring/ring-handler
    (ring/router
      [["/" {:get  test-get}]
       ["/add-budget" {:post add-budget}]])))
