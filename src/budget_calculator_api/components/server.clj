(ns budget-calculator-api.components.server
  (:require  [ring.adapter.jetty :refer [run-jetty]]
             [reitit.ring :as ring]
             [com.stuartsierra.component :as component]
             [budget-calculator-api.components.routers :as r]
             [ring.middleware.json :refer [wrap-json-body wrap-json-response]]))


(defn wrap-storage [f storage]
  (fn [req]
    (f (assoc req :storage storage))))

(defn create-server [port storage]
  (run-jetty (-> #'budget-calculator-api.components.routers/router
                 (wrap-storage storage)
                 (wrap-json-body {:keywords? true})
                 (wrap-json-response)) {:port port :storage storage}))

(defn stop [server]
  ((:close server)))


(defrecord Server [port]
  component/Lifecycle

  (start [component]
    (let [server (create-server port (:storage component)) ]
      (assoc component :web-server server) component))

  (stop [component]
    (stop (:web-server component))
    (assoc component :web-server nil)))


(defn new-server [port]
  (map->Server {:port port}))

