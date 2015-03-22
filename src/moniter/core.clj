(ns moniter.core
  (:use [clojure.pprint])
  (:require [simple-queue.core :as q]
            [clojure.data.json :as json]))


(q/defhandler message-handler
  (println "-----------")
  (-> data
      (json/read-str :key-fn keyword)
      pprint))

(defn -main [& args]
  (let [component (q/create-queue "rapids")]
    (println  " [*] Waiting for messages... To exit press CTRL+C")
    (q/subscribe component message-handler)
    (.stop component)))
