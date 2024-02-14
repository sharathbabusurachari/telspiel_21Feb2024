pipeline {
    agent any
    tools {
        maven 'MAVEN'

    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the env using pipeline'
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/sharathbabusurachari/telspiel']])
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }}
        stage('Test') {
            steps {
                echo 'Testing the env using pipeline'
            }}
        stage('Deploy') {
            steps {
                echo 'Deploying the env using pipeline'
                sh '''
                chmod 755 $WORKSPACE/javadeploy.sh;
                bash $WORKSPACE/javadeploy.sh;
                status=`ps -ef | grep telspiel | grep jar | awk '{print $2}'`

                if [ -z "$status" ];
                        then echo "Deployment is unsuccessful...";
                        else echo "Deployment is Successful...";
                fi
                '''}
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