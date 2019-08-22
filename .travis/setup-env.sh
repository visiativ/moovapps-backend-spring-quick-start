#!/usr/bin/env bash

PROJECT_ARTIFACT_ID=$(mvn org.apache.maven.plugins:maven-help-plugin:3.1.0:evaluate -Dexpression=project.artifactId -q -DforceStdout)
PROJECT_VERSION=$(mvn org.apache.maven.plugins:maven-help-plugin:3.1.0:evaluate -Dexpression=project.version -q -DforceStdout)

echo "#!/usr/bin/env bash" > /$HOME/ci-tools.sh
echo "PROJECT_ARTIFACT_ID=${PROJECT_ARTIFACT_ID}" >> /$HOME/ci-tools.sh
echo "PROJECT_VERSION=${PROJECT_VERSION}" >> /$HOME/ci-tools.sh
echo "" > /$HOME/ci-tools.sh # add empty line at EOF