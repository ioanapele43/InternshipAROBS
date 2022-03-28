package com.example.musify.model;

import java.sql.Date;

public class Person extends Artist {
    private String firstname;
    private String lastname;
    private String stagename;
    private Date birthday;

    public Person(String firstname, String lastname, String stagename, Date birthday, Date startDate, Date endDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.stagename = stagename;
        this.birthday = birthday;
        super.setStartDate(startDate);
        super.setEndDate(endDate);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStagename() {
        return stagename;
    }

    public void setStagename(String stagename) {
        this.stagename = stagename;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
