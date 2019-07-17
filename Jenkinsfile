pipeline {
    agent {
        docker { image 'dregistry.moovapps.com/moovapps/java:11-openjdk-maven' }
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