#!/bin/bash

filename="k8s/api/deployment.yaml"
echo "search $1"
echo "replace $2"
sed -i "s/$1/$2/" $filename