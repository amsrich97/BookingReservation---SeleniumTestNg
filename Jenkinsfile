pipeline {
  agent any
  stages {
    stage('build') {
      parallel {
        stage('build') {
          steps {
            echo 'Building selenium TestNg - Booking'
          }
        }

        stage('Test') {
          steps {
            echo 'Testing app'
          }
        }

      }
    }

    stage('Deploy') {
      steps {
        echo 'Deploying testng'
        input(message: 'Do you want to deploy?', id: 'ok')
      }
    }

  }
}