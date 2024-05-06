(ns ws-close-handling.core
  (:require
   [compojure.core :refer [defroutes GET]]
   [ring.adapter.undertow :as undertow-adapter]
   [ring.adapter.undertow.websocket :as ws]))

(def id-atom (atom 0))
(defn ws-handler [_]
  (let [id (swap! id-atom inc)]
    {:undertow/websocket
     {:on-open (fn [{:keys [channel]}]
                 (println (format " [%s] online! id" id))
                 (ws/send (format " [%s] ok" id) channel))
      :on-message (fn [{:keys [channel data]}]
                    (if (= "break" data)
                      (do
                        (println (format " [%s] about to break!" id))
                        (.close channel))
                      (do
                        (println (format " [%s] received %s" id data))
                        (ws/send (format " [%s] received %s" id data) channel))))

      :on-close-message (fn [_]
                          (println (format " [%s] closed!" id)))

      :on-error (fn [_]
                  (println (format " [%s] error! " id)))}}))

(defroutes ws-routes
  (GET "/ws" [] ws-handler))

(defn start []
  (def server (undertow-adapter/run-undertow
               ws-routes
               {:host "0.0.0.0"
                :port 8484})))

(defn stop []
  (.stop server))

(defn restart []
  (stop)
  (start))

(defn -main [& args]
  (start))
