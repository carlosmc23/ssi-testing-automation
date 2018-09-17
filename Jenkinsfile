pipeline {
    agent any
    stages {
        stage('AutomationTests') {
            parallel {
                stage('Chrome') {
                    steps {
                        sh './gradlew clean runfeatures -Pbrowser=CHROME -Pbaseurl=http://10.20.0.3:4200/login' 
                        archiveArtifacts artifacts: '/Users/Shared/Jenkins/Home/jobs/ssi-testing-automation/branches/automation/builds/lastSuccessfulBuild/htmlreports/Automation-test-Chrome-Report/', fingerprint: true
                        publishHTML (target: [
                            allowMissing: false,
                            alwaysLinkToLastBuild: false,
                            keepAll: true,
                            reportDir: 'build/cucumber/reports',
                            reportFiles: 'overview-features.html',
                            reportName: "Automation-test-Chrome-Report"
                            ])
                    }
                }
                stage('Firefox') {
                    agent { 
                        label 'firefox'
                    }
                    steps {
                        sh './gradlew clean runfeatures -Pbrowser=FIREFOX -Pbaseurl=http://10.20.0.3:4200/login' 
                        archiveArtifacts artifacts: '/Users/Shared/Jenkins/Home/jobs/ssi-testing-automation/branches/automation/builds/lastSuccessfulBuild/htmlreports/Automation-test-Firefox-Report/', fingerprint: true
                        publishHTML (target: [
                            allowMissing: false,
                            alwaysLinkToLastBuild: false,
                            keepAll: true,
                            reportDir: 'build/cucumber/reports',
                            reportFiles: 'overview-features.html',
                            reportName: "Automation-test-Firefox-Report"
                            ])  
                    }
                }
            }
        }
    }
}