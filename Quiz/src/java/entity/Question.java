/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;
import utils.NewsFormat;

/**
 *
 * @author quang
 */
public class Question {
    private int id;
    private String question;
    private String o1;
    private String o2;
    private String o3;
    private String o4;
    private String answer;
    private Date createdDate;
    private int teacherId;

    public Question() {
    }

    public Question(int id, String question, String o1, String o2, String o3, String o4, String answer, Date createdDate, int teacherId) {
        this.id = id;
        this.question = question;
        this.o1 = o1;
        this.o2 = o2;
        this.o3 = o3;
        this.o4 = o4;
        this.answer = answer;
        this.createdDate = createdDate;
        this.teacherId = teacherId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getO1() {
        return o1;
    }

    public void setO1(String o1) {
        this.o1 = o1;
    }

    public String getO2() {
        return o2;
    }

    public void setO2(String o2) {
        this.o2 = o2;
    }

    public String getO3() {
        return o3;
    }

    public void setO3(String o3) {
        this.o3 = o3;
    }

    public String getO4() {
        return o4;
    }

    public void setO4(String o4) {
        this.o4 = o4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCreatedDate() {
        return NewsFormat.formatDateToString(createdDate);
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Question{" + "id=" + id + ", question=" + question + ", o1=" + o1 + ", o2=" + o2 + ", o3=" + o3 + ", o4=" + o4 + ", answer=" + answer + ", createdDate=" + createdDate + ", teacherId=" + teacherId + '}';
    }
    
}
