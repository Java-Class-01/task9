pipeline {
    agent any
    stages {
        stage('Deploy') {
            steps {
                bat 'kubectl create deployment myapp --image=nginx'
                bat 'kubectl expose deployment myapp --port=80 --type=LoadBalancer'
            }
        }
    }
}
