pipeline {
    agent any
    tools {
        nodejs 'NodeJs'
    }
    parameters {
        choice(name:'VERSION', choices:['1.0', '1.1', '1.2'], description:'Choose the version of the project')

        booleanParam(name :'executeTests', description:'Execute the tests', defaultValue:false)
    }

    stages {
        stage('Build') {
            steps {
                sh 'npm install'
                sh 'npm run build'
            }
        }
        stage('Test') {
            steps {
                // sh 'npm run test'
                echo 'run tests here'
            }
        }
        stage('Build Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'DINESH_DOCKER_PASSWORD', usernameVariable: 'DINESH_DOCKER_USERNAME')]) {
                    sh 'docker build -t dineshgaikwad09/SampleReactApp .'
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh 'docker push dineshgaikwad09/SampleReactApp'
                }
            }
        }
        stage ('Deploy') {
            script {
                    def dockerCmd = 'docker run  -p 3000:3000 -d dineshgaikwad09/SampleReactApp:latest'
                    sshagent(['ec2-server-key']) {
                        sh "ssh -o StrictHostKeyChecking=no ubuntu@54.152.95.30 ${dockerCmd}"
                    }
                }
        }
    }
}                                                                                                                                                                                                        