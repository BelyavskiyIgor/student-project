package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.Adult;
import edu.javacourse.studentorder.domain.Child;
import edu.javacourse.studentorder.domain.StudentOrder;

import java.time.LocalDate;

public class SaveStudentOrder {


    public static void main(String[] args) {

        StudentOrder so;
        so = new StudentOrder();


        long ans = saveStudentOrder(so);
        System.out.println(ans);

    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 199;
        System.out.println("saveStudentOrder " );
        return answer;
    }

    static StudentOrder buildStudentOrder(long id ){
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);

        Adult husband = new Adult("Васильев", "Андрей", "Петрович", null);

        //Жена
        Adult wife = new Adult();


        // Ребенок
        Child child1 = new Child("Петрова", "Ирина", "Викторовна", LocalDate.of(2018, 6, 29));
        child1.setCertificateNumber("" + (3000 + id));
        child1.setIssueDate(LocalDate.of(2018, 7, 19));
        child1.setIssueDepartment("Отдел ЗАГС № " + id);
//        child1.setAddress(address);

        // Ребенок
        Child child2 = new Child("Петров", "Евгений", "Викторовна", LocalDate.of(2018, 6, 29));
        child2.setCertificateNumber("" + (4000 + id));
        child2.setIssueDate(LocalDate.of(2018, 7, 19));
        child2.setIssueDepartment("Отдел ЗАГС № " + id);
//        child2.setAddress(address);


        so.setHusband(husband);
//        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);
        return so;

    }

}
