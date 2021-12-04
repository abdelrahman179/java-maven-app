def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'Docker_Hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t abdelrahmanzaki179/demo-app:jma-4.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push abdelrahmanzaki179/demo-app:jma-4.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
