pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        echo 'pipeline test'
      }
    }

    stage('Javadoc') {
      steps {
        slackSend()
        slackSend(baseUrl: 'https://app.slack.com/client/TV94AUBK3/C01094355E2', message: 'test')
      }
    }

  }
}