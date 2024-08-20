# Урок 6. Семинар: Права доступа и безопасность
# Создать два произвольных файла
mkdir ~/lesson6
cd lesson6
touch file1
printf "New file" > file2

# Присвоить права на чтение и запись для владельца и группы, только на чтение — для всех для первого файла
# Численный вид:
chmod 664 file1

# Символьный вид:
chmod u=rw,g=rw,o=r file1

# Присвоить права на чтение и запись только для владельца для второго файла
# Численный вид:
chmod 600 file2

#Символьный вид:
chmod u=rw,g=,o= file2

# Назначить новых владельца и группу для директории целиком
sudo chown new_owner:new_group directory_name -R

# Управление пользователями
# Создать пользователя, используя утилиту `useradd` и `adduser`
sudo useradd -s /bin/bash -d /home/newuser -m newuser
sudo passwd newuser

sudo adduser newuser2

# Удалить пользователя, используя утилиту `userdel`
sudo userdel -r newuser
sudo userdel -r newuser2

# Управление группами
# Создать группу с использованием утилит `groupadd` и `addgroup`
sudo groupadd newgroup
sudo addgroup newgroup2

# Попрактиковаться в смене групп у пользователей
sudo usermod -g newgroup newuser2

# Добавить пользователя в группу, не меняя основной
sudo usermod -aG newgroup newuser2

# Создать пользователя с правами суперпользователя
sudo adduser sudo_user
sudo usermod -aG sudo sudo_user

# Сделать так, чтобы `sudo` не требовал пароль для выполнения команд
# Редактируйте файл `/etc/sudoers` с помощью `visudo`:
sudo visudo

# Добавьте следующую строку:
# sudo_user ALL=(ALL) NOPASSWD:ALL


# Дополнительные задания
# Выдать одному из созданных пользователей право на выполнение ряда команд, требующих прав суперпользователя
# Редактируйте файл `/etc/sudoers` с помощью `visudo`:
sudo visudo

# Добавьте строки:
# specific_user ALL=(ALL) NOPASSWD:/usr/bin/apt,/usr/bin/systemctl


# Создать группу `developer` и нескольких пользователей, входящих в неё
sudo groupadd developer
sudo useradd -m -G developer devuser1
sudo useradd -m -G developer devuser2
sudo useradd -m -G developer devuser3

# Создать директорию для совместной работы и настроить права
sudo mkdir /shared_dir
sudo chown :developer /shared_dir
sudo chmod 2775 /shared_dir

# Создать поддиректорию для обмена файлами, но чтобы удалять файлы могли только их создатели
sudo mkdir /shared_dir/exchange
sudo chown :developer /shared_dir/exchange
sudo chmod 3770 /shared_dir/exchange

# Создать директорию, в которой есть несколько файлов, и настроить права
sudo mkdir /private_dir
sudo chown :developer /private_dir
sudo chmod 770 /private_dir

# Создать несколько файлов в этой директории:
sudo touch /private_dir/file1 /private_dir/file2 /private_dir/file3

# Сделать так, чтобы открыть файлы можно было, только зная имя файла:
sudo chmod 600 /private_dir/*

# Настроить права на директорию, чтобы скрыть список файлов:
sudo chmod 700 /private_dir

# Теперь в директории `/private_dir` файлы можно открыть только зная их имя, а через `ls` список файлов посмотреть нельзя.
