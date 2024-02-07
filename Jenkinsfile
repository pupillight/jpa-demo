pipeline {
    agent any

    stages {
        stage('check out source code from git hub') {
            steps {
                checkout scmGit(branches: [[name: '*/${branch}']], extensions: [], userRemoteConfigs: [[credentialsId: '97f52220-424c-47aa-bb95-ff4f9b1ddefc', url: 'https://github.com/pupillight/jpa-demo']])
            }
        }
        stage('mvn package') {
            steps {
                sh './mvnw clean  package -Dmaven.test.skip=true'
                sh ' docker build --build-arg JAR_FILE=target/jpa-demo-0.0.1-SNAPSHOT.jar -t jpa-demo.jar . '
            }
        }
    }
}
