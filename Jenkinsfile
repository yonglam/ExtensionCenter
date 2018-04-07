pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'echo Building...'
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