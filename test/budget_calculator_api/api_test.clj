(ns budget-calculator-api.api-test
  (:require [clojure.test :refer :all]
            [com.stuartsierra.component :as component]
            [ring.mock.request :as mock]
            [budget-calculator-api.components.server :as ss]
            [budget-calculator-api.core :refer :all]))

(def sys (start-test))

(deftest test-t
  (testing "GET"
    (let [ss (component/start sys)
          s (mock/request :get "http://localhost:8080/")]
      (is (= (:status s) 200)))))
