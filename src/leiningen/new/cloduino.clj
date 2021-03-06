(ns leiningen.new.cloduino
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "cloduino"))

(defn cloduino
  "Generate the cloduino project."
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' cloduino project.")
    (->files data
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["test/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["project.clj" (render "project.clj" data)])))
