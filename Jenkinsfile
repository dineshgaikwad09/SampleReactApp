pipeline {
    agent { 
        kubernetes{
            label 'jenkins-slave'
        }
        
    }
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
				apt-get -y update; 
				apt-get install -y sudo; 
				apt-get install -y git wget 
				echo "Jenkins ALL=NOPASSWD: ALL" >> /etc/sudoers 
				wget http://get.docker.com/builds/Linux/x86_64/docker-latest.tgz 
				tar -xvzf docker-latest.tgz 
				mv docker/* /home/jenkins/agent/
            }
        }
        stage('Build Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'DINESH_DOCKER_CREDENTIALS', passwordVariable: 'DINESH_DOCKER_PASSWORD', usernameVariable: 'DINESH_DOCKER_USERNAME')]) {
                    sh 'docker build -t dineshgaikwad09/SampleReactApp .'
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh 'docker push dineshgaikwad09/SampleReactApp'
                }
            
            }
        }
        stage ('Deploy') {
            steps {
                echo 'Deploying the application'
                
            }
        }
    }
}                                                                                                                                                                                                        