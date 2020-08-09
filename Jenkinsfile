pipeline {
    agent { dockerfile true }

    environment {
        MVN_VERSION = readMavenPom().getArtifactId()
    }

    stages {
            stage('Build') {
                steps {
                    echo 'In the build phase'
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