pipeline {
    agent any
    stage('Chrome') {
        steps {
            sh './gradlew clean runfeatures -Pbrowser=CHROME -Pbaseurl=http://10.20.0.3:4200/login'
        }
    }
}