pipeline {
    agent any

    stages {
        stage('AutomationTests') {
                stage('Chrome') {
                    steps {
                        sh './gradlew clean runfeatures -Pbrowser=CHROME -Pbaseurl=http://10.20.0.3:4200/login'
                    }
                }
                stage('Firefox') {
                    steps {
                        sh './gradlew clean runfeatures -Pbrowser=FIREFOX -Pbaseurl=http://10.20.0.3:4200/login' 
                    }
                }
            }
        }
    }
}