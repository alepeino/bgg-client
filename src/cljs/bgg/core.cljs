(ns bgg.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [bgg.events]
              [bgg.subs]
              [bgg.routes :as routes]
              [bgg.views :as views]
              [bgg.config :as config]))

(defn dev-setup []
  (when config/debug?
    (enable-console-print!)
    (println "dev mode")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn init []
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (dev-setup)
  (mount-root))

(init)
