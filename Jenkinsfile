pipeline {
   agent any

   stages {
        stage('Read Pom Version'){

            }

        stage('Build') {

            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/rvanwyk9191/eportfolio-full-stack.git'

                // Run Maven on a Unix agent.
                sh "mvn -Dmaven.test.failure.ignore=true clean install"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
         }

         post {
            pom = readMavenPom file: 'pom.xml'
            env.POM_VERSION = pom.version
            // If Maven was able to run the tests, even if some of the test
            // failed, record the test results and archive the jar file.
            success {
               junit '**/target/surefire-reports/TEST-*.xml'
               archiveArtifacts 'target/*.jar'
               echo 'Successful build, will push the image to docker'
               sh 'docker push rvanwyk91/eportfolio:${POM_VERSION}'
            }
         }
      }
   }
}