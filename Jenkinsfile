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
        
        stages {
        stage('build the code') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}
