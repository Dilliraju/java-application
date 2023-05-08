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
        
        stage('Push Docker Image') {
            steps {
                  withCredentials([usernamePassword(credentialsId: 'jfrog-credential', passwordVariable: 'JFROG_PASSWORD', usernameVariable: 'JFROG_USERNAME')]) {
       
                    sh '''
                    docker login -u $JFROG_USERNAME -p $JFROG_PASSWORD dilliraju.jfrog.io
                        docker push dilliraju.jfrog.io/web-applications/web-apps:latest
                    '''
                }
            } 
            
        } 
        
    }
}
