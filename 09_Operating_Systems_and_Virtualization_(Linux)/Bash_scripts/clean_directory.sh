#!/bin/bash

# Проверка, передан ли путь к директории
if [ -z "$1" ]; then
  echo "Ошибка: Не указан путь к директории."
  exit 1
fi

# Путь к директории
DIR_PATH=$1

# Проверка существования директории
if [ -d "$DIR_PATH" ]; then
  # Удаление файлов с расширениями .bak, .tmp и .backup
  find "$DIR_PATH" -type f \( -name "*.bak" -o -name "*.tmp" -o -name "*.backup" \) -exec rm -f {} \;
  # find "$DIR_PATH" -name "*.bak" | xargs rm
  # find "$DIR_PATH" -name "*.tmp" | xargs rm
  # find "$DIR_PATH" -name "*.backup" | xargs rm

  # Проверка статуса последней команды
  if [ $? -eq 0 ]; then
    echo "Директория очищена от файлов с расширениями .bak, .tmp и .backup."
  else
    echo "Произошла ошибка при удалении файлов в директории '$DIR_PATH'."
    exit 1
  fi
else
  echo "Ошибка: Директория '$DIR_PATH' не существует."
  exit 1
fi
