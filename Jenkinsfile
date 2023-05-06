pipeline {
    agent any

    stages {
        stage('clone the data') {
            steps {
                git branch: 'pushing-docker-image-to-ecr-jenkinsfile', credentialsId: 'github-token', url: 'https://github.com/Dilliraju/java-application.git'
            }
        }
        
        stage('Build the code') {
            steps {
                sh 'mvn clean install'
            }
        }    
        
    }
}
