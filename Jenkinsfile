pipeline {
    agent { dockerfile true }

    environment {
        MVN_VERSION = readMavenPom().getArtifactId()
    }

    post {
        success {
            docker push rvanwyk91/eportfolio:${MVN_VERSION}
        }
    }
}