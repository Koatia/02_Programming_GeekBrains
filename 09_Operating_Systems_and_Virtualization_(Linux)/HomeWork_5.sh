# 1. Настроить статическую конфигурацию в Ubuntu через ip и netplan
# Настройка через ip
sudo ip addr add 192.168.1.82/24 broadcast 192.168.1.255 dev enp0s3

# Настройка Netplan
sudo nano /etc/netplan/01-network-manager-all.yaml

# Содержимое /etc/netplan/01-network-manager-all.yaml
network:
  version: 2
  renderer: networkd
  ethernets:
    enp0s3:
      dhcp4: no
      addresses: [192.168.1.82/24]
      routes:
        - to: default
          via 192.168.1.1
      nameservers:
        addresses:
          - 1.1.1.1
          - 8.8.8.8

# Применение конфигурации Netplan
sudo netplan try

# Проверка работоспособности сети
ping -c 4 1.1.1.1
ping -c 4 8.8.8.8

# 2. Настройка правил iptables для доступности сервисов на TCP-портах 22, 80 и 443
# Сбрасываем все текущие правила firewall
# If you need to disable the firewall temporarily, you can flush all the rules using
sudo iptables -P INPUT ACCEPT
sudo iptables -P OUTPUT ACCEPT
sudo iptables -P FORWARD ACCEPT
sudo iptables -F
# Разрешаем входящие соединения на порты 22 (SSH), 80 (HTTP) и 443 (HTTPS)
sudo iptables -A INPUT -p tcp --dport 22 -j ACCEPT
sudo iptables -A INPUT -p tcp --dport 80 -j ACCEPT
sudo iptables -A INPUT -p tcp --dport 443 -j ACCEPT
# Разрешаем установку исходящих подключений для обновлений
sudo iptables -A OUTPUT -p tcp --dport 80 -j ACCEPT
sudo iptables -A OUTPUT -p tcp --dport 443 -j ACCEPT
# Запрещаем все остальные входящие соединения
sudo iptables -P INPUT DROP
sudo iptables -P FORWARD DROP
# Разрешаем исходящие соединения
sudo iptables -P OUTPUT ACCEPT
# Сохраняем правила
sudo iptables-save | sudo tee /etc/iptables/rules.v4

# 3. Запретить любой входящий трафик с IP 3.4.5.6
sudo iptables -A INPUT -s 3.4.5.6 -j DROP

# 4. Перенаправление запросов с порта 8090 на порт 80
# Разрешаем форвардинг пакетов
sudo sysctl -w net.ipv4.ip_forward=1
# Перенаправляем трафик с порта 8090 на порт 80
sudo iptables -t nat -A PREROUTING -p tcp --dport 8090 -j REDIRECT --to-port 80
# Сохраняем правила
sudo iptables-save | sudo tee /etc/iptables/rules.v4

# 5. Разрешить подключение по SSH только из сети 192.168.0.0/24
# Удаляем ранее добавленное правило для SSH
sudo iptables -D INPUT -p tcp --dport 22 -j ACCEPT
# Разрешаем подключение по SSH только из сети 192.168.0.0/24
sudo iptables -A INPUT -p tcp --dport 22 -s 192.168.0.0/24 -j ACCEPT
# Сохраняем правила
sudo iptables-save | sudo tee /etc/iptables/rules.v4
