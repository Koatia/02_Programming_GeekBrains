#!/bin/bash

# Проверка, передан ли путь к директории
if [ -z "$1" ]; then
  echo "Ошибка: Не указан путь к директории."
  exit 1
fi

# Путь к директории
DIR_PATH=$1

# Проверка существования директории
if [ ! -d "$DIR_PATH" ]; then
  echo "Ошибка: Директория '$DIR_PATH' не существует."
  exit 1
fi

# Обработка файлов в директории
find "$DIR_PATH" -maxdepth 1 -type f | while read -r file; do
  # Получение имени владельца файла
  owner=$(stat -c '%U' "$file")

  # Создание директории с именем владельца, если она не существует
  mkdir -p "$DIR_PATH/$owner"

  # Копирование файла в директорию владельца
  cp "$file" "$DIR_PATH/$owner/"
done

echo "Файлы скопированы в директории, названные по имени владельца."