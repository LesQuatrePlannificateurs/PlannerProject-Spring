pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        echo 'pipeline test'
      }
    }

    stage('') {
      steps {
        withSonarQubeEnv 'sonartest'
      }
    }

  }
}