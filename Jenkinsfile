pipeline {
    agent any
       tools {
                 maven 'Maven'
     }   
    stages {
        stage('Clone') {
            steps {
                 git branch: 'develop', credentialsId: 'GIT_CREDENTIAL' ,url: 'https://github.com/camilo1997/RetoTecnico.git'
            }
        }
        
       stage('Build') {
            steps {
                sh 'mvn clean compile -DskipTests=true'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn clean verify'
            }
        }
    }
            
    post {
        always {
            publishHTML(target: [
                reportName: 'Serenity',
                reportDir: 'target/site/serenity',
                reportFiles: 'index.html',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: false
            ])
            //sendSlackNotification(currentBuild.result);
        }
     }
        
   }
  




