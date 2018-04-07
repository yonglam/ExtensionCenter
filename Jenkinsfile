def getTitle() {
  return 'Hello World'
}

pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'echo Building...'
        sh 'echo ' + getTitle()
      }
    }
    stage('UITest') {
      parallel {
        stage('UITest') {
          steps {
            sh '''echo UITest...
'''
          }
        }
        stage('UnitTest') {
          steps {
            sh 'echo Unit testing...'
          }
        }
      }
    }
    stage('Deploy') {
      steps {
        sh 'echo deploy...'
      }
    }
  }
}
