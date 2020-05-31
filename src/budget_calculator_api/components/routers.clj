(ns budget-calculator-api.components.routers
  (:require [reitit.ring :as ring]
            [com.stuartsierra.component :as component]
            [ring.util.response :refer [response]]))


(defn test-get [request]
  (response {:body {:funcionou ["Sim" "Nao" "Testando" "Dale"]}}))

(def router
  (ring/ring-handler
    (ring/router
      [["/" {:get  test-get}]])))
