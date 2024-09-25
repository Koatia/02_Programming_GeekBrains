package study_group.study_group;

import study_group.student.comparators.StudentComparatorByAge;
import study_group.student.comparators.StudentComparatorByName;
import study_group.student.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudyGroup implements Iterable<Student> {
    private List<Student> studentList;

    public StudyGroup() {
        studentList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void sortByName() {
        studentList.sort(new StudentComparatorByName());
    }

    public void sortByAge() {
        studentList.sort(new StudentComparatorByAge());
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentIterator(studentList);
    }
}