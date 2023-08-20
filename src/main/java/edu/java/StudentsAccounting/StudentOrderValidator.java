package edu.java.StudentsAccounting;

import edu.java.StudentsAccounting.domain.*;
import edu.java.StudentsAccounting.domain.register.AnswerCityRegister;
import edu.java.StudentsAccounting.mail.MailSender;
import edu.java.StudentsAccounting.validator.*;

import java.util.LinkedList;
import java.util.List;

public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;
    private MailSender mailSender;

    public StudentOrderValidator() {
        cityRegisterVal = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        childrenVal = new ChildrenValidator();
        studentVal = new StudentValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {

        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }

    public void checkAll() {
        List<StudentOrder> soList = readStudentOrders();

        for (StudentOrder so : soList) {
            checkOneOrder(so);
        }
    }

    public List<StudentOrder> readStudentOrders() {
        List<StudentOrder> soList = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            StudentOrder so = SaveStudentOrder.buildStudentOrder(i);
            soList.add(so);
        }

        return soList;
    }

    public void checkOneOrder(StudentOrder so) {
//        AnswerCityRegister cityAnswer = checkCityRegister(so);
//        AnswerWedding wedAnswer = checkWedding(so);
//        AnswerChildren childAnswer = checkChildren(so);
//        AnswerStudent studentAnswer = checkStudent(so);
//        sendMail(so);
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        return cityRegisterVal.checkCityRegister(so);
    }

    public AnswerWedding checkWedding(StudentOrder so) {
        return weddingVal.checkWedding(so);
    }

    public AnswerChildren checkChildren(StudentOrder so) {
        return childrenVal.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so) {
        return studentVal.checkStudent(so);
    }

    public void sendMail(StudentOrder so) {
        mailSender.sendMail(so);

    }
}
