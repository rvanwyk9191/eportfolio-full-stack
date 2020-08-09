pipeline {
    agent { dockerfile true }

    environment {
        MVN_VERSION = readMavenPom().getArtifactId()
    }
}