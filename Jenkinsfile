pipeline {
    agent any
    tools{
    maven 'maven3.9.1'
    }

    stages {
        stage('clone the code') {
            steps {
                git branch: 'pushing-docker-image-to-jfrog-jenkinsfile', credentialsId: 'github-token', url: 'https://github.com/Dilliraju/java-application.git'
            }
        }
        
        stage('build the code') {
            steps {
                sh 'mvn clean install'
            }
        }
        
        stage('Build Docker Image') {
            steps {
                sh '''
              docker build . --tag web-apps:latest
              docker tag web-apps:latest dilliraju.jfrog.io/web-applications/web-apps:latest
                
                '''
                
            }
        }
        
    }
}
