(defproject ws-close-handling "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [ring/ring "1.8.0"]
                 [compojure "1.6.2"]
                 [ring/ring-codec "1.2.0"]
                 [ring/ring-json "0.5.0"]
                 [ring-cors "0.1.13"]
                 [luminus/ring-undertow-adapter "1.3.1"]]
  :repl-options {:init-ns ws-close-handling.core})
