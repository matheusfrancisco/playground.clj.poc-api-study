(defproject budget-calculator-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ring/ring-core "1.7.1"]
                 [metosin/reitit-ring "0.4.2"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [ring/ring-json "0.4.0"]
                 [com.stuartsierra/component "0.3.2"]]
  :repl-options {:init-ns budget-calculator-api.core}
  :main ^:skip-aot budget-calculator-api.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
