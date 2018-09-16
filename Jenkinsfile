pipeline {
    agent any

    stages {
        stage('AutomationTests') {
            parallel {
                stage('Chrome') {
                    steps {
                        sh './gradlew clean runfeatures -Pbrowser=CHROME -Pbaseurl=http://10.20.0.3:4200/login'
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
                stage('Firefox') {
                    steps {
                        sh './gradlew clean runfeatures -Pbrowser=FIREFOX -Pbaseurl=http://10.20.0.3:4200/login' 
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
    }
}