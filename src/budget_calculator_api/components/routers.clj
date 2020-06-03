(ns budget-calculator-api.components.routers
  (:require [reitit.ring :as ring]
            [com.stuartsierra.component :as component]
            [ring.util.response :refer [response]]
            [budget-calculator-api.controllers :as c]
            [budget-calculator-api.protocols.storage-client :as storage-client]))


(defn test-get
  [request]
  (def storage (:storage request))
  (storage-client/put! storage #(%1 %2 conj {:id 3 :nome "Ola" :ammount "100 moedinhas"}))
  (response {:body (storage-client/read-all storage) :status 200}))


(def router
  (ring/ring-handler
    (ring/router
      [["/" {:get  test-get}]
       ["/add" {:get c/add}]])))
