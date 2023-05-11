pipeline {
    agent any
    tools{
        maven "maven3.9.1"
    }
    stages {
      stage('Clone the repository'){
        steps{
          git branch: 'deploy-to-eks-ecr-jenkinsfile', credentialsId: 'Github-token', url: 'https://github.com/Dilliraju/java-application.git'
          
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
              docker tag web-application:$BUILD_NUMBER 427112278691.dkr.ecr.us-east-1.amazonaws.com/web-application:$BUILD_NUMBER
                
                '''
                
            }
        }  
      
      stage('Push Docker Image') {
          steps{
 withAWS(credentials: 'aws', region: 'us-east-1') {
       
                    sh '''
                   aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 427112278691.dkr.ecr.us-east-1.amazonaws.com
                   docker push 427112278691.dkr.ecr.us-east-1.amazonaws.com/web-application:$BUILD_NUMBER
                    '''
                }
            } 
           }
        
        stage('Deployto AWS EKS') {
            steps {
                // configure AWS credentials
               withAWS(credentials: 'aws', region: 'us-east-1') {

                   // Connect to the EKS cluster
                    sh '''
                     aws eks update-kubeconfig --name dev-cluster --region us-east-1
                     
           
                      cd kubernetes-yaml
                      kubectl apply -f .
                      kubectl set image deployment/web-app web-application=427112278691.dkr.ecr.us-east-1.amazonaws.com/web-application:$BUILD_NUMBER
                    '''
                }
           
        }
            
        }
        
    }
}

