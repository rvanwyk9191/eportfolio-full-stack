def POM_VERSION
pipeline {
   agent any

   stages {
        stage('Build') {

            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/rvanwyk9191/eportfolio-full-stack.git'
                git 'checkout develop'
                // Run Maven on a Unix agent.
                sh "mvn clean install"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
         }

         post {

            // If Maven was able to run the tests, even if some of the test
            // failed, record the test results and archive the jar file.
            success {
                script {
                    pom = readMavenPom file: 'pom.xml'
                    POM_VERSION = pom.version
                    echo POM_VERSION
                    echo 'Successful build, will push the image to docker'
                    docker.withRegistry('https://docker.com/', 'DOCKER') {
                        def pcImg = docker.build("rvanwyk91/eportfolio:" + POM_VERSION.minus("-SNAPSHOT"), '.')
                        pcImg.push();
                    }
                }
                junit '**/target/surefire-reports/TEST-*.xml'
                archiveArtifacts 'target/*.jar'
            }
         }
      }
   }
}