pipeline {
    agent any
    tools{
        maven 'Maven3.9.1'
    }

    stages {
        stage('Clone the repository ') {
            steps {
                
             git branch: 'build-and-push-to-jfrog-jenkinsfile', credentialsId: 'Github_credentails', url: 'https://github.com/Dilliraju/java-application.git'   
                
            }
        }
       
       stage("Build the code") {
           
           steps{
               sh 'mvn clean install'
           }
       }
      stage('Push the artifacts into Jfrog artifactory') {
            steps {
              rtUpload (
                serverId: 'jfrog-dev-server',
                spec: '''{
                      "files": [
                        {
                          "pattern": "*.war",
                           "target": "web-application/"
                        }
                    ]
                }'''
              )
          }
        }
     
        
        
        
    }
}
