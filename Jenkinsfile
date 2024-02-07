pipeline {
    agent any

    stages {
        stage('check out source code from git hub') {
            steps {
                checkout scmGit(branches: [[name: '*/${branch}']], extensions: [], userRemoteConfigs: [[credentialsId: '97f52220-424c-47aa-bb95-ff4f9b1ddefc', url: 'https://github.com/pupillight/jpa-demo']])
            }
        }
        stage('mvn package dev') {
            steps {
                sh './mvnw clean  package -Dmaven.test.skip=true'
                sh ' docker build --build-arg JAR_FILE=target/jpa-demo-0.0.1-SNAPSHOT.jar -t jpa-demo . '
            }
        }

        stage('create docker image') {
                    steps {
                       // This step should not normally be used in your script. Consult the inline help for details.
                       withDockerContainer('jpa-demo') {
                           // some block
                       }

                       // This step should not normally be used in your script. Consult the inline help for details.
                       withDockerRegistry(credentialsId: '457b3a0d-b0d8-4176-b75a-8f8a9a2e439f', url: 'https://hub.docker.com/') {
                           // some block
                       }
                    }
        }


    }
}
