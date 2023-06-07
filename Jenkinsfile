pipeline {
agent any
stages {
    stage('Initialize'){
        steps {
                def dockerHome = tool 'docker'
                env.PATH = "${dockerHome}/bin:${env.PATH}"                }
        }
    stage('Push to Docker Registry'){
        steps {
            sh 'Dinesh Gaikwad'
            }            
        }  
    }
}}