(defproject arithmetic_primary "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.6.0"]]}}
  :java-source-paths ["src"]
  :javac-options ["-target" "1.6" "-source" "1.6" "-Xlint:-options"]
  :aot :all
  :main put.your.main.class.here)
