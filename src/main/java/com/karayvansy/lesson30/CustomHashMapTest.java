package com.karayvansy.lesson30;

public class CustomHashMapTest {

    public static void main(String[] args) {

        Student student = new Student("John", "Doe", 25);
        Student student1 = new Student("Brus", "Li", 50);
        Student student2 = new Student("Kior", "Oleg", 21);
        Student student3 = new Student("Johny", "Dep", 22);
        Student student4 = new Student("Samuel", "Jackson", 24);

        Grade grade = new Grade(5, "A", "great");
        Grade grade2 = new Grade(3, "C", "not bad");
        Grade grade3 = new Grade(4, "B", "good");

        CustomHashMap customHashMap = new CustomHashMap();
        customHashMap.put(student, grade);
        customHashMap.put(student1, grade2);
        customHashMap.put(student2, grade3);
        customHashMap.put(student3, grade2);
        customHashMap.put(student4, grade);

    }

}


