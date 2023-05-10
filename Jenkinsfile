pipeline {
    agent any
    tools{
        maven "maven3.9.1"
    }
    stages {
      stage('Clone the repository'){
        steps{
          git branch: 'deploy-to-eks-dockerhub-jenkinsfile', credentialsId: 'Github-token', url: 'https://github.com/Dilliraju/java-application.git'
          
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
               docker tag web-application:$BUILD_NUMBER dilliraju/web-application:$BUILD_NUMBER
                
                '''
                
            }
        }
        
        stage('Push Docker Image') {
            steps{
                withCredentials([usernamePassword(credentialsId: 'docker-credential', passwordVariable: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_HUB_USERNAME')]) {
                 sh '''
                 docker login -u $DOCKER_HUB_USERNAME   -p $DOCKER_HUB_PASSWORD
                  docker push dilliraju/web-application:$BUILD_NUMBER
                    
                   ''' 
    }
            }
            
        }
    }
}
