pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        echo 'pipeline test'
      }
    }

    stage('sonar') {
      steps {
        withSonarQubeEnv 'sonar'
      }
    }

  }
}