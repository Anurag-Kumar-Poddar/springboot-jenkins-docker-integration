pipeline {
    agent any

     tools {
        jdk "JAVA_HOME"
        maven "3.9.9" // Jenkins me configure kiya hua Maven ka naam
    }

    environment {
        DOCKER_HUB_USER = 'anuragkumarpoddar'
        IMAGE_NAME = 'docker-jenkins'
        IMAGE_TAG = 'v1'
        CONTAINER_NAME = "docker-jenkins"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/Anurag-Kumar-Poddar/springboot-jenkins-docker-integration.git'
            }
        }

    stage('Maven Build') {
        steps {
             bat "mvn clean package -DskipTests"
            }
        }


        stage('Build Docker Image') {
            steps {
                bat "docker build -t $DOCKER_HUB_USER/$IMAGE_NAME:$IMAGE_TAG ."
            }
        }

        stage('Push to Docker Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'Docker', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    bat "echo $PASS | docker login -u $USER --password-stdin"
                    bat "docker push $DOCKER_HUB_USER/$IMAGE_NAME:$IMAGE_TAG"
                }
            }
        }

        stage('Deploy') {
            steps {
            bat "docker rm -f $CONTAINER_NAME || echo No old container"
            bat "docker-compose pull"
            bat "docker-compose up -d"
            }
        }
    }
    post {
        always {
            bat 'docker image prune -f'
        }
    }
}