FROM dregistry.moovapps.com/moovapps/java:11-openjdk

ARG project
ARG version
ENV PROJECT_ARTIFACT_ID=$project
ENV BOOT_ARTIFACT_ID="${PROJECT_ARTIFACT_ID}-boot"
ENV ARTIFACT_VERSION=$version
ENV SPRING_FAT_JAR="${BOOT_ARTIFACT_ID}-${ARTIFACT_VERSION}.jar"

RUN mkdir /opt/spring

WORKDIR /opt/spring

COPY target/${SPRING_FAT_JAR} .

RUN sh -c 'touch ${SPRING_FAT_JAR}'

ENTRYPOINT ["java","-jar","${SPRING_FAT_JAR}"]