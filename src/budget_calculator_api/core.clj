(ns budget-calculator-api.core
  (:require  [budget-calculator-api.components.server :as server]
             [budget-calculator-api.components.storage :as storage]
             [com.stuartsierra.component :as component]))


(def system (atom nil))


(defn system-map [config]
  (component/system-map
    :storage (storage/new-in-memory)
    :http   (component/using (server/new-server (:port config)) [:storage])))


(defn start-all []
  (println "\nCreating your [DEV] server...")
  (def system (component/start (system-map {:port 8000}))))


(defn stop-all []
  (component/stop system))


(defn start-test
  []
  (println "Starting [TEST] server...")
  (system-map {:port 8080}))


(defn -main
  [& args]
  (start-all))
