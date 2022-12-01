
pipeline{
  agent any
  
  //the below is used to create custom environment variables to be used in file
  environment{
    NEW_VERSION = '1.0.1'
  }
 
  
  //param management
  parameters{
    string(name: 'VERSION', defaultValue: '1.0.1', description: 'version to deploy')
  }
  
  
  stages("clone project from repository"){
    echo 'clone the repository'
    deleteDir()
    sh 'git clone https://github.com/Mitch-mts/daily_read.git'
  }
  
  stages{
    stage("build"){
      steps{
        echo 'building the application...'
        echo "building version ${NEW_VERSION}"
      }
    }
    
    stage("test"){
      //condition used to to a task under a certain event has been done
      when{
        expression{
          BRANCH_NAME == 'dev' || BRANCH_NAME == 'main'
        }
      }
      steps{
        echo 'testing the application...'
      }
    }
    
    stage("deploy"){
      steps{
        echo 'deploying the application...'
      }
    }
  }
}
