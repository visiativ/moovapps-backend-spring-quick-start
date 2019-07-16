pipeline {
    agent {
        docker { image 'maven:3.6-jdk-11-slim' }
    }
    environment {
      ARTIFACT_VERSION = readMavenPom().getVersion()
      ARTIFACT_ID    = readMavenPom().getArtifactId()()
    }
    stages {
        stage('build and test') {
            steps {
                sh 'mvn -B -Pprod clean install'
            }
        }
        stage('sonar') {
            steps {
                sh 'mvn -B sonar:sonar -Dsonar.host.url=http://10.2.0.61:9090'
            }
        }
        stage('build docker') {
            steps {
              script {
                var pom = readMavenPom
                ARTIFACT_ID = pom.artifactId
                ARTIFACT_VERSION = pom.version
              }
              dir("boot") {

                sh "docker build --build-arg project=${ARTIFACT_ID} --build-arg version=${ARTIFACT_VERSION} --file=src/main/docker/Dockerfile --tag=quick-start:latest ."
              }
            }
        }
    }
}