pipeline {
    agent {
        docker { image 'maven:3.6-jdk-11-slim' }
    }
    stages {
        stage('build and test') {
            steps {
                sh 'mvn -B -Pprod clean install'
            }
        }
        stage('sonar') {
            steps {
                sh 'mvn -B sonar:sonar -Dsonar.host.url=http://10.2.4.254:9090'
            }
        }
        stage('check coverage') {
            steps {
             sh 'mvn -B '
            }
        }
        stage('build docker') {
            steps {
            // TODO : build docker image
            }
        }
    }
}