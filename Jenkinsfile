pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        build 'SpringProject'
        slackSend(message: 'testestes', channel: '#build')
      }
    }

  }
}