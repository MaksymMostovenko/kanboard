pipeline {
    agent any
    environment {
        // Встановлюємо змінну зі шляхом до Maven, якщо він не знаходиться в змінних середовища
        MAVEN_HOME = tool 'Maven'
    }
    stages {
        stage('Checkout') {
            steps {
                // Крок для вибору вихідного коду проекту (зазвичай з репозиторію)
                // Наприклад: git clone, svn checkout і т.д.
                // Ви можете використовувати різні SCM системи залежно від вашого проекту.
                // Наприклад, для Git:
                git branch: 'Capstone', url: 'https://github.com/MaksymMostovenko/CapStoneProject.git'
            }
        }
        stage('Build') {
            steps {
                // Крок для компіляції проекту
                sh "${MAVEN_HOME}/bin/mvn clean compile"
            }
        }
        stage('Test') {
            steps {
                // Крок для виконання тестів
                sh "${MAVEN_HOME}/bin/mvn test"
            }
        }
    }
    post {
        // Пост-операції, що виконуються після завершення всіх стадій
        // Наприклад, відправлення повідомлення або розсилка результатів
        always {
            // Прибираємо за собою: видаляємо створений директорій target
            deleteDir()
        }
        success {
            // Якщо збірка завершилася успішно, робимо щось...
            echo "Build successful! Congrats!"
        }
        failure {
            // Якщо збірка не пройшла успішно, робимо щось...
            echo "Build failed. Please check the logs."
        }
    }
}
