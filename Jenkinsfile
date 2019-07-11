pipeline {
    agent {
        docker { image 'maven:3.6-alpine' }
    }
    stages {
        stage('build and test') {
            steps {
                sh 'mvn -Pprod clean install'
            }
        }
    }
}