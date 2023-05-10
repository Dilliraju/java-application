pipeline {
    agent any
    tools{
        maven "Maven3.9.1"
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
               docker tag web-application:$BUILD_NUMBER mmreddy424/web-application:$BUILD_NUMBER
                
                '''
                
            }
        }
    }
}
