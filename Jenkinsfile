// groovy script check if there are changes in the git repo 
// CODE_CHANGES = getGitChanges()

/*
 --- To list all the environmental variables provided by Jenkins: localhost:8080/env-vars.html

 --- We can define credentials through env variables 
    SERVER_CREDENTIALS = credentials('')
    - it requires credentials bunding plugin
    - it takes the id of the credentials as a parameter
*/


pipeline {
    // create env var to be avail throughout the script
     /* environment {
        NEW_VERSION = '1.3.0'
    }*/ 
    
    agent any 
    
    
    // provides me with build tools such as MAVEN, npm   
    /* tools {
        gradle
        maven 'Maven' // name of the tool inside the configuration
        jdk
    }*/
    
    // define the selection of external config that we want to provide to build to change behavior 
    /*  - we have to use build with parameters 
        - 
    */
    parameters {
    // 
    // string(name:'VERSION', defaultValue:'', description:'version to deploy')
    choice(name:'VERSION', choices:['1.1.0', '1.2.0'], description:'')
    booleanParam(name:'executeTest', defaultValue:true, description:'')
    }
    
    stages {
        
        stage ("build") {
            // the steps will be executed if only the condition below is true, branch name is dev and there are changes occured
            /* when {
                expression {
                    BRANCH_NAME == 'dev' | CODE_CHANGES == true
                }    
            } */
            
            
            steps {
                  /*
                    to write normal groovy script
                  */   
             
                echo 'building the app'
                /*
                    calling env variable in single quotes wont work, 
                    to be interpreted as a var to be called, it has to be in a double quotes
                */
                // echo "building version ${NEW_VERSION}"
            }
        }
        
        stage ("test") {
            // the steps will be executed if only the condition below is true, branch name is dev
            /* when {
                expression {
                    BRANCH_NAME == 'dev' | BRANCH_NAME == 'master'
                }    
            } */
            when {
                expression {
                    params.executeTests == true
                }
            }
            
            steps {
                echo 'testing the app'
            }
        }
        
        stage ("deploy") {
            steps {
                echo 'deploying the app'
                echo "deploying version ${params.VERSION}"
                /* it takes the username and password and store into the defined vars below */
                /*
                withCredentials([
                    usernamePassword(credentials: 'GitHub', usernameVariable: USER, passwordVariable: PASSWORD)
                ]) {
                    sh "some script ${USER} ${PASSWORD}"
                }
                */
            }
        }
    }
    // define build status | build status change
    /* post {
        // this script, logic will be executed after all changes no matter failure, success
        always {   
        }
        // execued only on the success 
        sucess {
        }
        // executed only on failure
        failure {
        }
    } */
}
