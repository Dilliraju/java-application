pipeline {
    agent any
    tools{
        maven 'maven3.9.1'
    }

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
        
        stage('clone the code') {
            steps {
                git branch: 'build-and-deploy-to-tomcat-jenkinsfile', credentialsId: 'github-token', url: 'https://github.com/Dilliraju/java-application.git'
            }
        }
        
        stage('build the code in maven') {
            steps {
                sh 'mvn clean install'
            }
        }
        
        stage('deploy to tomcat') {
            steps {
                deploy adapters: [tomcat7(credentialsId: 'tomcat-cred-id', path: '', url: 'http://44.203.4.80:8080')], contextPath: null, war: '**/*.war'
            }
        }
    }
}
