pipeline {
   agent any
   tools {
      maven 'maven-3.8.4'
   }
   stages {
    stage("build jar") {
     steps {
      script {
        echo "Building the application..."
        sh 'mvn package'
      }
     }
    }
    stage("build image") {
     steps {
      script {
        echo "Building the docker image...."
        withCredentials([usernamePassword(credentialsId: 'Docker_Hub', passwordVariable: 'PASS', usernameVariable: 'USER')]){
         // extract the username and password, execute docker commands
         sh 'docker build -t abdelrahmanzaki179/demo-app:jma-3.0 .'
         sh "echo $PASS | docker login -u $USER --password-stdin"
         sh 'docker push abdelrahmanzaki179/demo-app:jma-3.0'
        }
      }
     }
    }
    stage("deploy") {
     steps {
      script {
        echo "Deploying the application..."
      }
     }
    }
 }
}
