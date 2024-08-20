# Урок 4. Семинар: Работа с файлами и ссылками

mkdir ~/lesson2
cd ~/lesson2

# 1. Используя команду `cat`, создать два файла с данными
cat > file1.txt
cat > file2.txt

# 2. Объединить их и просмотреть содержимое созданного файла
cat file1.txt file2.txt > combined.txt
cat combined.txt

# 3. Переименовать файл, дав ему новое имя
mv combined.txt renamed_combined.txt

# 4. Создать несколько файлов
touch file3.txt file4.txt file5.txt

# 5. Создать директорию, переместить файл туда
mkdir my_directory
mv renamed_combined.txt my_directory/

# 6. Удалить все созданные в этом и предыдущем заданиях директории и файлы
rm file1.txt file2.txt file3.txt file4.txt file5.txt
rm -r my_directory

# 7. Создать файл `file1` и наполнить его произвольным содержимым
echo "This is some content for file1" > file1

# 8. Скопировать его в `file2`
cp file1 file2

# 9. Создать символическую ссылку `file3` на `file1`
ln -s ~/lesson2/file1 file3

# 10. Создать жесткую ссылку `file4` на `file1`
ln file1 file4

# 11. Посмотреть, какие иноды у файлов
ls -ali

# 12. Удалить `file1`
rm file1

# 13. Что стало с остальными созданными файлами? Попробовать вывести их на экран
cat file2
cat file3
cat file4

# Объяснение:
# - `file2` останется неизменным, так как это обычная копия.
# - `file3` (символическая ссылка) перестанет работать, так как оригинальный файл удален.
# - `file4` (жесткая ссылка) будет продолжать работать, так как жесткая ссылка сохраняет данные независимо от удаления оригинального файла.

# 14. Дать созданным файлам другие, произвольные имена
mv file2 new_file2 && mv file3 new_file3 && mv file4 new_file4

# 15. Создать новую символическую ссылку
ln -s new_file2 new_link

# 16. Переместить ссылки в другую директорию
mkdir new_directory
mv new_link new_file3 new_directory/

rm -r ~/lesson2
