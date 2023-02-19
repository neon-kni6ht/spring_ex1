#Сборка образов
docker build -t demo_ex_image .
docker build -f PostgresDockerfile -t exdb .
#Запуск контейнеров
docker compose up