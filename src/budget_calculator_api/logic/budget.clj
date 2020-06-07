(ns budget-calculator-api.logic.budget
  (:import [java.util UUID]))


(defn create-budget
  [budget-name budget-description budget-ammount]
  {:id          (UUID/randomUUID)
   :name        budget-name
   :ammount     budget-ammount
   :description budget-description})
