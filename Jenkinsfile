pipeline {
    agent { dockerfile true }

    environment {
        MVN_VERSION = readMavenPom().getArtifactId()
    }

    post {
        success {
            echo 'Successful build, will push the image to docker'
            docker push rvanwyk91/eportfolio:${MVN_VERSION}
        }
    }
}