(ns budget-calculator-api.components.storage
  (:require [com.stuartsierra.component :as component]
            [budget-calculator-api.protocols.storage-client :as storage-client]))

(defrecord InMemoryStorage [storage]
  component/Lifecycle
  (start [this] this)
  (stop  [this]
    (reset! storage {})
    this)

  storage-client/StorageClient
  (read-all [_this] @storage)
  (put! [_this update-fn] (swap! storage update-fn))
  (clear-all! [_this] (reset! storage {})))

(defn new-in-memory []
  (->InMemoryStorage (atom [{:id 1
                             :bill-title "Gastei com remedio"
                             :ammount "R$ 200 moedinhas"}])))
