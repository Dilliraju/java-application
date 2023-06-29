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
                    sh  "mvn sonar:sonar -Dsonar.sonar.host.url=http://18.218.33.12:9000 -Dsonar.login=cc179aeba1cf794ff339e55754884e66350511b6"
                }
                }
                
            }
    }
}
