pipeline {
    agent any
    
    tools {
        jdk 'JDK11'
    }
    
    stages {
        stage('Checkout') {
            steps {
                // Using the specific branch that exists
                git branch: 'Branch1/userinterface', 
                url: 'https://github.com/Java-Class-01/task9.git'
                
                // Show what we have
                bat 'echo "Current directory structure:"'
                bat 'dir'
            }
        }
        
        stage('Explore Project') {
            steps {
                script {
                    // Check for build files
                    bat 'if exist pom.xml ( echo "Found pom.xml - Maven project" ) else ( echo "No pom.xml found" )'
                    bat 'if exist build.gradle ( echo "Found build.gradle - Gradle project" ) else ( echo "No build.gradle found" )'
                    
                    // Show project structure
                    bat 'echo "Java files:"'
                    bat 'dir *.java /s /b 2>nul || echo "No Java files found"'
                    
                    bat 'echo "All files in root:"'
                    bat 'dir'
                }
            }
        }
        
        stage('Build') {
            steps {
                script {
                    // Try Maven build if pom.xml exists
                    if (fileExists('pom.xml')) {
                        echo 'Building with Maven...'
                        bat 'mvn clean compile -DskipTests'
                    } 
                    // Add other build systems here if needed
                    else {
                        echo 'No supported build system detected'
                    }
                }
            }
        }
        
        stage('Package') {
            steps {
                script {
                    if (fileExists('pom.xml')) {
                        echo 'Packaging with Maven...'
                        bat 'mvn package -DskipTests'
                        
                        // Show what was created
                        bat 'echo "Build artifacts:"'
                        bat 'dir target\\*.jar 2>nul || echo "No JAR files in target"'
                        bat 'dir target\\*.war 2>nul || echo "No WAR files in target"'
                    }
                }
            }
        }
    }
    
    post {
        always {
            script {
                // Archive any JAR files found
                def jarFiles = findFiles(glob: 'target/*.jar')
                if (jarFiles) {
                    archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
                    echo "Archived ${jarFiles.length} JAR file(s)"
                } else {
                    echo "No JAR files to archive"
                }
            }
        }
        
        success {
            echo 'Step 1 completed successfully! Ready for Nexus/Artifactory integration.'
        }
    }
}
