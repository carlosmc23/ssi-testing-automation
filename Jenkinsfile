pipeline {
    agent any

    stages {
        stage('AutomationTestChrome') {
            steps {
                sh './gradlew runfeatures -Pbrowser=CHROME -Pbaseurl=http://10.20.0.3:4200/login'
            }
        }
        stage('AutomationTestFirefox') {
            steps {
                sh './gradlew runfeatures -Pbrowser=FIREFOX -Pbaseurl=http://10.20.0.3:4200/login'
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