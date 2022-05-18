(ns handler)

(defn has-type [event, type]
  (= (get event "type") type))

(defn has-type-foo [event]
  (has-type event "foo"))

(defn has-type-bar [event]
  (has-type event "bar"))

(defn -handler [event]
  (cond
    (has-type-foo event) "Received foo event"
    (has-type-bar event) "Received bar event"
    :else "Received unrecognised event"))

(gen-class
   :name Handler
   :methods [^:static [handler [java.util.Map] String]])
