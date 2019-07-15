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
                sh 'mvn -B sonar:sonar -Dsonar.host.url=http://vv0442:9090'
            }
        }
        stage('check coverage') {
            steps {
            }
        }
        stage('build docker') {
            steps {
            }
        }
    }
}