(ns budget-calculator-api.components.routers
  (:require [reitit.ring :as ring]
            [com.stuartsierra.component :as component]
            [ring.util.response :refer [response]]
            [budget-calculator-api.protocols.storage-client :as storage-client]))


(defn test-get
  [request]
  (def storage (:storage request))
  (response {:body (storage-client/read-all storage) :status 200}))


(def router
  (ring/ring-handler
    (ring/router
      [["/" {:get  test-get}]])))
