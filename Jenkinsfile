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
        
        stage('Build Docker Image') {
            steps {
                sh '''
               docker build . --tag web-application:latest
               docker tag web-application:latest dilliraju/web-application:latest
                
                '''
                
            }
        }
        
        stage('Push Docker Image') {
            steps {
                  withCredentials([usernamePassword(credentialsId: 'docker-credential', passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB__USERNAME')]) {
                  sh '''
                    docker login -u $DOCKERHUB_USERNAME -p $DOCKERHUB_PASSWORD
                        docker push dilliraju/web-application:latest
                    '''
}
       
                    
                }
            } 
            
        }
        
    }
}
