pipeline {
    agent any
    tools{
        maven 'maven3.8.3'
    }

    stages {
        stage('clone the code') {
            steps {
                git branch: 'static-code-analysis-jenkinsfile', credentialsId: 'github-token', url: 'https://github.com/Dilliraju/java-application.git'
            }
        }
        stage('static code deploy') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Static code analysis') {
            steps {
        withSonarQubeEnv('sonarqube') {
                    sh  "mvn sonar:sonar"
                }
                }
                
            }
    }
}
