#!/usr/bin/env bash

mvn -P nexus deploy -B -DskipTests=true

bash $(dirname $0)/deploy-docker.sh