pipeline {
    agent none

    stages {
            stage('Build') {
                steps {
                    sh 'mvn clean install'
                }
            }
        }

    post {
        success {
            pom = readMavenPom file: 'pom.xml'
            env.POM_VERSION = pom.version
            echo 'Successful build, will push the image to docker'
            sh 'docker push rvanwyk91/eportfolio:${POM_VERSION}'
        }
    }
}