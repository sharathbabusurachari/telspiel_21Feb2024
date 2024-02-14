pipeline {
    agent any

    stages {
        stage('Build and Run JAR') {
            steps {
                echo 'Building the env using pipeline'
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/sharathbabusurachari/telspiel']])
                script {
                    sh "mvn clean install"
                    withEnv(['JENKINS_NODE_COOKIE=dontkill']) {
                                        sh "nohup java -jar telspiel-0.0.1-SNAPSHOT.jar &"
                                    }
                    }
                }
            }
        stage('Test') {
            steps {
                echo 'Testing the env using pipeline'
                }
              }
        }

    post {
        always {
            junit(
                allowEmptyResults:true,
            testResults: '*test-reports/.xml'
                 )
               }
        }

}