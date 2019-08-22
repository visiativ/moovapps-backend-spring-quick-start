#!/usr/bin/env bash

source /ci-tools.sh

# copy the final jar beside the Dockerfile with simple name
cp target/${PROJECT_ARTIFACT_ID}-${PROJECT_VERSION}.jar src/docker/app.jar

# build the docker image with version tag
docker build \
  -t dregistry.devops.moovapps.com/visiativ/process/${PROJECT_ARTIFACT_ID}:${PROJECT_VERSION} \
  src/docker/

# add tag with branch name
docker tag \
  dregistry.devops.moovapps.com/visiativ/process/${PROJECT_ARTIFACT_ID}:${PROJECT_VERSION} \
  dregistry.devops.moovapps.com/visiativ/process/${PROJECT_ARTIFACT_ID}:${TRAVIS_BRANCH}