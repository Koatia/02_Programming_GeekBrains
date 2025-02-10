// Дана строка sql-запроса: "select * from students where "
// Сформируйте часть WHERE этого запроса, используя StringBuilder. Данные (параметры) для фильтрации приведены в виде json-строки
// в примере ниже. Если значение null, то параметр не должен попадать в запрос.
// Напишите свой код в методе answer класса Answer. Метод answer принимает на вход два параметра:
// String QUERY - начало SQL-запроса String PARAMS - JSON с параметрами
// Пример:
// Строка sql-запроса: select * from students where 
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Результат: select * from students where name='Ivanov' and country='Russia' and city='Moscow'

class Answer {

    public static StringBuilder answer(String QUERY, String PARAMS) {
        StringBuilder answer = new StringBuilder();
        answer.append(QUERY);

        PARAMS = PARAMS.replaceAll("\\s|\\{|\\}|\"", "");

        String[] params = PARAMS.split(",");

        for (int i = 0; i < params.length; i++) {
            String[] par = params[i].split(":");
            // Пропускаем параметры с значением "null"
            if (!"null".equals(par[1])) {
                if (i > 0) {
                    answer.append(" and ");
                }
                answer.append(par[0]).append("='").append(par[1]).append("'");
            }
        }
        return answer;
    }
}

public class HomeWork1 {

    public static void main(String[] args) {

        String QUERY = "";
        String PARAMS = "";

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            QUERY = "select * from students where ";
            PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
        } else {
            QUERY = args[0];
            PARAMS = args[1];
        }

        Answer ans = new Answer();
        System.out.println(ans.answer(QUERY, PARAMS).toString());
    }
}
