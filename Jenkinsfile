pipeline {
    agent any
  
   environment{
    NEW_VERSION = '1.0.1'
  }
    
  stages {
      stage('Build') {
          steps {
              echo 'Build application'
            echo "Current version ${NEW_VERSION}"
          }
      }
    
       stage('Test') {
          steps {
              echo 'Test Application'
          }
      }

      stage('Deploy') {
          steps {
              echo 'Deploy Application'
          }
      }
  }
  
  post {
        always {
            emailext body: 'The pipeline has completed successfully', subject: 'Pipeline status', to: 'mitchtsevera@gmail.com'
        }
        failure {
            emailext body: 'The pipeline has completed', subject: 'Pipeline status', to: 'mitchtsevera@gmail.com'
        }
    }
}
