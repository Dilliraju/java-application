pipeline {
    agent any
    tools{
        maven 'maven3.9.1'
    }

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
        
        stage('Build Docker Image') {
            steps {
                sh '''
              docker build . --tag web-application:$BUILD_NUMBER
              docker tag web-application:$BUILD_NUMBER 108290765801.dkr.ecr.us-east-1.amazonaws.com/web-application:$BUILD_NUMBER
                
                '''
                
            }
        }  
        
        stage('Push Docker Image') {
          steps{
 withAWS(credentials: 'aws-cred', region: 'us-east-1') {
                   sh '''
                   aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 108290765801.dkr.ecr.us-east-1.amazonaws.com
                   docker push 108290765801.dkr.ecr.us-east-1.amazonaws.com/web-application:$BUILD_NUMBER
                    '''
                }
            }
        }
    }
}
