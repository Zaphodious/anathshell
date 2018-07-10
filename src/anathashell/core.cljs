(ns anathashell.core
    (:require [prum.core :as rum]
              [prum.compiler :as pr :refer [html]]))          

(enable-console-print!)

(println "This text is printed from src/anathashell/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))


(rum/defc hello-world []
  (html
    [:div
      [:h1 (:text @app-state)]
      [:h3 "Edit this and watch it change!"]]))

(def domnode (. js/document (getElementById "app")))

(def root (rum/mount (app)) domnode)

(rum/mount (hello-world)
           domnode
           root)

(defn on-js-reload [])
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)

