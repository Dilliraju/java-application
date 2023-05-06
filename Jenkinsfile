pipeline {
    agent any
    tools{
        maven 'maven3.9.1'
    }

    stages {
        stage('clone the code') {
            steps {
                git branch: 'pushing-docker-image-to-dockerhub-jenkinsfile', credentialsId: 'github-token', url: 'https://github.com/Dilliraju/java-application.git'
            }
        }
        
        stage('build the code') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}
