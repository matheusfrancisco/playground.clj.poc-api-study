(ns budget-calculator-api.logic-test
  (:require [clojure.test :refer :all]
            [budget-calculator-api.logic.budget :as l]))

(deftest test-logic-bugdet
  (testing "create a budget"
    (let [budget-name "Netflix"
          budget-description "Payment netflix"
          budget-ammount "R$ 40"]
      (is (= (:name (l/create-budget budget-name budget-description budget-ammount)) budget-name ))
      (is (= (:description (l/create-budget budget-name budget-description budget-ammount)) budget-description )))))
