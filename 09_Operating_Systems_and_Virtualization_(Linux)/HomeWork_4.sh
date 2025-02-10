# 1. Подключить дополнительный репозиторий и установить любой пакет из этого репозитория
# Установить необходимый пакет для добавления репозиториев
sudo apt-get update
sudo apt-get install software-properties-common
# Добавьть репозиторий Nginx в APT источники
sudo add-apt-repository ppa:nginx/stable
# Обновить индекс пакетов и установить Nginx
sudo apt-get update
sudo apt-get install nginx

# 2. Установить и удалить deb-пакет с помощью dpkg
# Скачать deb-пакет Google Chrome
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
# Установить пакет с помощью dpkg
sudo dpkg -i google-chrome-stable_current_amd64.deb
# Устранить зависимости, если dpkg сообщил о проблемах
sudo apt-get install -f
# Удалить установленный пакет
sudo dpkg -r google-chrome-stable

# 3. Установить и удалить snap-пакет
# Установить snap пакет vlc
sudo snap install vlc
# Удалить snap пакет vlc
sudo snap remove vlc

# 4. Добавить задачу для выполнения каждые 3 минуты (создание директории, запись в файл)
# Редактируем crontab для текущего пользователя:
crontab -e
# Добавить следующую строку:
*/3 * * * * mkdir -p ~/test_directory && echo "Test file created at $(date)" >> ~/test_directory/test_file.txt

# 5. Подключить PPA-репозиторий, установить из него пакет и удалить PPA из системы
# Добавить PPA репозиторий graphics-drivers:
sudo add-apt-repository ppa:graphics-drivers/ppa
# Обновить индекс пакетов и установить пакет, например, nvidia-driver-460
sudo apt-get update
sudo apt-get install nvidia-driver-460
# Удалить PPA репозиторий
sudo add-apt-repository --remove ppa:graphics-drivers/ppa

# 6. Создать задачу резервного копирования (tar) домашнего каталога пользователя
# Редактируем crontab для текущего пользователя:
crontab -e
# Добавить следующую строку для ежедневного резервного копирования в 2:00 ночи:
0 2 * * * tar -czf ~/backup/home_backup_$(date +\%F).tar.gz ~/
