pipeline {
    agent any

    stages {
        stage('AutomationTests') {
            parallel {
                stage('Chrome') {
                    steps {
                        sh './gradlew clean runfeatures -Pbrowser=CHROME -Pbaseurl=http://10.20.0.3:4200/login -Pselenium_hub_url=http://10.20.0.7:4444/wd/hub'
                    }
                }
                stage('Firefox') {
                    steps {
                        sh './gradlew clean runfeatures -Pbrowser=FIREFOX -Pbaseurl=http://10.20.0.3:4200/login -Pselenium_hub_url=http://10.20.0.7:4444/wd/hub'
                    }
                }
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