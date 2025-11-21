pipeline {
    agent any
    stages {
        stage('Build Docker Image') {
            steps {
                sh 'docker build -t myapp:latest .'
            }
        }
        stage('Deploy to K8s') {
            steps {
                sh '''
                kubectl create deployment myapp --image=myapp:latest
                kubectl expose deployment myapp --port=80 --type=LoadBalancer
                '''
            }
        }
    }
}
