pipeline {
    agent any
    stages {
        stage('Run Container') {
            steps {
                bat '''
                docker run -d --name myapp -p 8080:80 nginx
                echo "✅ Container running at http://localhost:8080"
                '''
            }
        }
    }
}
