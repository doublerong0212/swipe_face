package com.example.kl.home.Model;

import java.util.Date;

public class Leave extends LeaveId {

    String student_name;
    String leave_reason;
    String leave_check;
    String class_name;
    Date leave_uploaddate;
    String leave_content;
    String leave_date;
    String leave_photoUrl;
    String class_id;
    String student_id;
    String teacher_email;
    String checkWay;//確認修改假單後導向

    public String getLeave_photoUrl() {
        return leave_photoUrl;
    }

    public void setLeave_photoUrl(String leave_photoUrl) {
        this.leave_photoUrl = leave_photoUrl;
    }

    public Leave() {
    }

    public Leave(String student_name, String leave_reason, String leave_check, String class_name, String leave_date, Date leave_uploaddate,
                 String leave_content, String leave_photoUrl, String class_id, String student_id, String teacher_email, String checkWay) {
        this.student_name = student_name;
        this.leave_reason = leave_reason;
        this.leave_check = leave_check;
        this.leave_date = leave_date;
        this.class_name = class_name;
        this.leave_uploaddate = leave_uploaddate;
        this.leave_content = leave_content;
        this.leave_photoUrl = leave_photoUrl;
        this.class_id = class_id;
        this.student_id = student_id;
        this.teacher_email = teacher_email;
        this.checkWay = checkWay;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getLeave_reason() {
        return leave_reason;
    }

    public void setLeave_reason(String leave_reason) {
        this.leave_reason = leave_reason;
    }

    public String getLeave_check() {
        return leave_check;
    }

    public void setLeave_check(String leave_check) {
        this.leave_check = leave_check;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Date getLeave_uploaddate() {
        return leave_uploaddate;
    }

    public void setLeave_uploaddate(Date leave_uploaddate) {
        this.leave_uploaddate = leave_uploaddate;
    }

    public String getLeave_content() {
        return leave_content;
    }

    public void setLeave_content(String leave_content) {
        this.leave_content = leave_content;
    }

    public String getLeave_date() {
        return leave_date;
    }

    public void setLeave_date(String leave_date) {
        this.leave_date = leave_date;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }
    public String getTeacher_email() {
        return teacher_email;
    }

    public void setTeacher_email(String teacher_email) {
        this.teacher_email = teacher_email;
    }

    public String getCheckWay() {
        return checkWay;
    }

    public void setCheckWay(String checkWay) {
        this.checkWay = checkWay;
    }
}