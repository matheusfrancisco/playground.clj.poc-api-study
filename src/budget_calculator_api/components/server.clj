(ns budget-calculator-api.components.server
  (:require  [ring.adapter.jetty :refer [run-jetty]]
             [reitit.ring :as ring]
             [com.stuartsierra.component :as component]
             [budget-calculator-api.components.routers :as r]
             [ring.middleware.json :refer [wrap-json-body wrap-json-response]]))


(defn wrap-storage [f storage]
  (fn [req]
    (f (assoc req :storage storage))))

(defn create-server [port storage join]
  (run-jetty (-> #'budget-calculator-api.components.routers/router
                 (wrap-storage storage)
                 (wrap-json-body {:keywords? true})
                 (wrap-json-response)) {:port port :storage storage :join? join}))

(defn stopped [server]
  ((.stop server)
   (.join server)))


(defrecord Server [port join]
  component/Lifecycle

  (start [component]
    (let [server (create-server port (:storage component) join)]
      (assoc component :web-server server) component))

  (stop [component]
    (stopped (:web-server component))
    (dissoc component :web-server)))


(defn new-server [port join]
  (map->Server {:port port :join join}))

