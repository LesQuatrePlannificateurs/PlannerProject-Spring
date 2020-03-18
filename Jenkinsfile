pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        echo 'pipeline test'
      }
    }

    stage('testsonar') {
      steps {
        withSonarQubeEnv 'sonar'
      }
    }

  }
}