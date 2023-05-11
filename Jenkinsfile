pipeline {
    agent any
    tools{
        maven "maven3.9.1"
    }
    stages {
      stage('Clone the repository'){
        steps{
          git branch: 'deploy-to-eks-jfrog-jenkinsfile', credentialsId: 'Github-token', url: 'https://github.com/Dilliraju/java-application.git'
          
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
              docker build . --tag web-app:$BUILD_NUMBER
              docker tag web-app:$BUILD_NUMBER dilliraju.jfrog.io/web-applications/web-app:$BUILD_NUMBER
                
                '''
                
            }
        }
    
 stage('Push Docker Image') {
            steps {
                  withCredentials([usernamePassword(credentialsId: 'jfrog-credential', passwordVariable: 'JFROG_PASSWORD', usernameVariable: 'JFROG_USERNAME')]) {
       
                    sh '''
                    docker login -u $JFROG_USERNAME -p $JFROG_PASSWORD dilliraju.jfrog.io
                        docker push dilliraju.jfrog.io/web-applications/web-app:$BUILD_NUMBER
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
                      kubectl set image deployment/web-app web-applications=dilliraju.jfrog.io/web-applications/web-app:$BUILD_NUMBER
                 
                    '''
                }
           
        }
            
        }
         

      
    }
}
