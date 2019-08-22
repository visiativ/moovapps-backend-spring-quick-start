#!/usr/bin/env bash

source /$HOME/ci-tools.sh

mvn -P nexus deploy -B -DskipTests=true

bash $(dirname $0)/deploy-docker.sh