package study_group.service;

import study_group.builder.StudentBuilder;
import study_group.student.Student;
import study_group.study_group.StudyGroup;

public class Service {
    private StudyGroup group;
    private StudentBuilder builder;

    public Service() {
        group = new StudyGroup();
        builder = new StudentBuilder();
    }

    public void addStudent(String name, int age){
        Student student = builder.build(name, age);
        group.addStudent(student);
    }

    public String getStudentListInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список студентов:\n");

//        Iterator<Student> iterator = group.iterator();
//        while (iterator.hasNext()){
//            Student student = iterator.next();
//            stringBuilder.append(student);
//            stringBuilder.append("\n");
//        }

        for (Student student: group){
            stringBuilder.append(student);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        group.sortByName();
    }

    public void sortByAge(){
        group.sortByAge();
    }

    @Override
    public String toString() {
        return getStudentListInfo();
    }
}
