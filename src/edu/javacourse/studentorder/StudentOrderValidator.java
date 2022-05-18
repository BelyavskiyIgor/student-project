package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.domain.register.AnswerCityRegister;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildrenValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.StudentValidator;
import edu.javacourse.studentorder.validator.WeddingValidator;

import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;
    private MailSender mailSender;

    public StudentOrderValidator() {
        this.cityRegisterVal = new CityRegisterValidator();
        this.weddingVal = new WeddingValidator();
        this.childrenVal = new ChildrenValidator();
        this.mailSender = new MailSender();
    }

    public static void main(String[] args) {


        StudentOrderValidator sov = new StudentOrderValidator();

        sov.checkAll();
    }

    public void checkAll(){
           List<StudentOrder> soList = readStudentOrders();
//            for(int i = 0; i< soArray.length; i++){
//                System.out.println("");
//                checkOneOrder(soArray[i]);
//            }

        for (StudentOrder so: soList) {
            System.out.println();
            checkOneOrder(so);

        }

    }

    private void checkOneOrder(StudentOrder so) {
        AnswerCityRegister cityRegister = checkCityRegister(so);
//        AnswerWedding wedAnswer = checkWedding(so);
//        AnswerChildren childAnswer = checkChildren(so);
//        AnswerStudent studentAnswer = checkStudent(so);

//        sendMail(so);
    }

    /*

     */
    public List<StudentOrder> readStudentOrders(){
        List<StudentOrder> soList = new LinkedList<>();
        for(int i = 0; i < 5; i++){
           StudentOrder so = SaveStudentOrder.buildStudentOrder(i);
           soList.add(so);
        }
        return soList;
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so){

        return cityRegisterVal.checkCityRegister(so);
    }

    public AnswerWedding checkWedding(StudentOrder so){

       return weddingVal.checkWedding(so);

    }

    public AnswerChildren checkChildren(StudentOrder so){


        return childrenVal.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so){


        return studentVal.checkStudent(so);
    }

    public void sendMail(StudentOrder so){
       mailSender.sendMail(so);

    }

}
