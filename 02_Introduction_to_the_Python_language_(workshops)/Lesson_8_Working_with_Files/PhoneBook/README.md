

[main.py](main.py) - этот файл является точкой входа в приложение Телефонного справочника

[GUI_version.py](GUI_version.py) - отвечает за графический интерфейс пользователя (GUI), предоставляя визуальное представление данных и интерактивные элементы для работы с телефонным справочником.
## Проект "Телефонный справочник" на Python с GUI, реализованный в файлах GUI_version.py и main.py, включает в себя следующий функционал:

### Графический Интерфейс Пользователя (GUI)
Интерактивное окно приложения, созданное с использованием библиотеки Tkinter.
Окно содержит различные виджеты для взаимодействия с пользователем: текстовые поля для ввода данных, кнопки для выполнения действий и метки для отображения информации.

Добавление контактов через диалоговое окно с формой, где пользователь может ввести данные нового контакта (Фамилия, Имя, Телефон, Описание) и сохранить их в справочник.

Редактирование контактов позволяет изменять информацию о существующих контактах. Реализовано через отдельное диалоговое окно, которое открывается для выбранного контакта и позволяет редактировать его данные.

Удаление контактов осуществляется по ID, выбранному пользователем. Удаляемый контакт убирается из списка контактов в интерфейсе и файле данных.

Поиск контактов по заданным критериям (Фамилия, Имя, Телефон, Описание) с возможностью последующего редактирования или удаления найденных записей.

### Работа с данными

Чтение и запись данных из файла (phonebook.txt). Программа поддерживает загрузку существующих контактов из файла при запуске и сохранение всех изменений обратно в файл.

Для выбранной записи:

- Изменение значений полей записи

- Экспорт (копирование) в отдельный файл phonebook.csv (с заголовками)

- Удаление записи


Форматирование данных при сохранении осуществляется с соблюдением структуры файла: каждый контакт записывается в отдельную строку, а данные внутри строки разделены запятыми.

Сортировка контактов перед сохранением выполняется по Фамилии и Имени, что облегчает последующий поиск и организацию данных.

### Дополнительные функции

Обработка ошибок, включая отсутствие файла данных или ошибки ввода-вывода, с информированием пользователя через диалоговые окна.

**В целом, проект представляет собой многофункциональное приложение для управления контактами с простым и интуитивно понятным интерфейсом. Он демонстрирует глубокое использование возможностей Tkinter для создания графического интерфейса, а также эффективную работу с файловой системой для хранения и обработки данных.**