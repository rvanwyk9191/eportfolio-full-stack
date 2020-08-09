pipeline {
    agent none

    environment {
        MVN_VERSION = readMavenPom().getArtifactId()
    }

    stages {
            stage('Build') {
                steps {
                    sh 'mvn clean install'
                }
            }
        }

    post {
        success {
            echo 'Successful build, will push the image to docker'
            sh 'docker push rvanwyk91/eportfolio:${MVN_VERSION}'
        }
    }
}