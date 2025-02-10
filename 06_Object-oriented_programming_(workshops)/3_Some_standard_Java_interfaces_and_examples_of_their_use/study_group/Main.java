package study_group;

import study_group.service.Service;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        service.addStudent("Паша", 18);
        service.addStudent("Даша", 19);
        service.addStudent("Маша", 17);
        service.addStudent("Саша", 18);
        service.addStudent("Катя", 19);

        System.out.println(service);
        service.sortByName();
        System.out.println(service);
        service.sortByAge();
        System.out.println(service);
    }
}
