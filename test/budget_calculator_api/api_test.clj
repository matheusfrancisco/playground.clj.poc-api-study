(ns budget-calculator-api.api-test
  (:require [clojure.test :refer :all]
            [com.stuartsierra.component :as component]
            [budget-calculator-api.components.routers :as routes]
            [clj-http.client :as client]
            [budget-calculator-api.components.server :as ss]
            [budget-calculator-api.core :refer :all]))

(defn with-system
  [f]
  (let [current-sys (component/start (start-test))]
    (f)
    (stop-all current-sys)))


(use-fixtures :each with-system)

;(defmacro dbg [x] `(let [x# ~x] (println '~x x#) x#))
;(dbg (component/start (dbg sys)))

(deftest testing-integration-routes
 (testing "GET"
   (let [resp (client/get "http://localhost:8080/")
         status (:status resp)]
     (is (= status 200)))))
