#!/bin/bash
java -version

sys_args=""
app_args=""
sys_args="$sys_args -Dotel.traces.exporter=jaeger"
sys_args="$sys_args -Dotel.exporter.jaeger.endpoint=$JAEGER_ENDPOINT"
sys_args="$sys_args -Dotel.metrics.exporter=prometheus"
sys_args="$sys_args -Dotel.resource.attributes=service.name=$APP_NAME"

if [ $# -gt 0 ]; then
  for arg in "$@";do
    if [[ "$arg" =~ ^-D.+=.* ]]; then
      sys_args="$sys_args $arg"
    else
      app_args="$app_args $arg"
    fi
  done
fi

start_script="java -javaagent:opentelemetry.jar$sys_args -jar app.jar$app_args"
echo "run $start_script"
${start_script}
