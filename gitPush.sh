#!/bin/bash

# Добавление удаленных репозиториев
git remote add origin git@github.com:Koatia/02_Programming_GeekBrains.git;
git remote add mirror ssh://git@gitverse.ru:2222/Kostia/02_Programming_GeekBrains.git

# Пуш изменений в оба репозитория
git push origin master; git push mirror master

echo '--------'
echo '--------'
git status
echo "Обновление завершено, нажмите ENTER"
read tem
