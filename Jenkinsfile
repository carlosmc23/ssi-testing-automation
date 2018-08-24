pipeline {
    agent any

    stages {
        stage('AutomationTestChrome') {
            steps {
                sh './gradlew runfeatures -DBROWSER=chrome'
            }
        }
        stage('AutomationTestFirefox') {
            steps {
                sh './gradlew runfeatures -DBROWSER=firefox'
            }
        }
        stage('PublishReport') {
            steps {
                publishHTML (target: [
                allowMissing: false,
                alwaysLinkToLastBuild: false,
                keepAll: true,
                reportDir: 'build/cucumber/reports',
                reportFiles: 'overview-features.html',
                reportName: "Automation test Report"
                ])   
            }
        }
    }
}