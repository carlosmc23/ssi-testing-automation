pipeline {
    agent any
    stages {
        stage('SeleniumHub'){
            steps {
                sh 'sudo docker-compose -f docker-compose/docker-compose.yml down'
                echo 'Starting Selenium Hub ...'
                sh 'sudo docker-compose -f docker-compose/docker-compose.yml up -d'
            }
        }
        stage('AutomationTests') {
            parallel {
                stage('Chrome') {
                    steps {
                        sh './gradlew clean runfeatures -Pbrowser=CHROME -Pbaseurl=http://10.20.0.3:4200/login' 
                        archiveArtifacts artifacts: 'build/cucumber/reports/cucumber-html-reports/**/*', fingerprint: true
                        publishHTML (target: [
                            allowMissing: false,
                            alwaysLinkToLastBuild: false,
                            keepAll: true,
                            reportDir: 'build/cucumber/reports/cucumber-html-reports/**/*',
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
                        archiveArtifacts artifacts: 'build/cucumber/reports/cucumber-html-reports/**/*', fingerprint: true
                        publishHTML (target: [
                            allowMissing: false,
                            alwaysLinkToLastBuild: false,
                            keepAll: true,
                            reportDir: 'build/cucumber/reports/cucumber-html-reports/**/*',
                            reportFiles: 'overview-features.html',
                            reportName: "Automation-test-Firefox-Report"
                            ])  
                    }
                }
            }
        }
    }
    post {
        always {
            sh 'sudo docker-compose -f docker-compose/docker-compose.yml down'
        }
    }
}