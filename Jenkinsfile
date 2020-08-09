pipeline {
    agent { dockerfile true }

    environment {
        MVN_VERSION = readMavenPom().getArtifactId()
    }

    stages {
            stage('Build') {
                steps {
                    mvn clean install
                }
            }
        }

    post {
        success {
            echo 'Successful build, will push the image to docker'
            docker push rvanwyk91/eportfolio:${MVN_VERSION}
        }
    }
}