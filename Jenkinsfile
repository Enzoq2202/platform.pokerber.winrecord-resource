pipeline {
    agent any
    stages {
        stage('Build WinRecord') {
            steps {
                build job: 'store.winrecord', wait: true
            }
        }
        stage('Build') { 
            steps {
                sh 'mvn clean package'
            }
        }      
        stage('Build Image') {
            steps {
                script {
                    winrecord = docker.build("enzoq2202/winrecord:${env.BUILD_ID}", "-f Dockerfile .")
                }
            }
        }
        stage('Push Image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-credentials') {
                        winrecord.push("${env.BUILD_ID}")
                        winrecord.push("latest")
                    }
                }
            }
        }
    }
}
