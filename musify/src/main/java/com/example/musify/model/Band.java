package com.example.musify.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="band")
public class Band  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int idBand;
    @Column(name="band_name")
    private String bandname;
    @Column(name="location")
    private String location;
    @Column(name="activity_start_date")
    private Date acritivtyStartDate;
    @Column(name="activity_end_date")
    private Date activityEndDate;

    @ManyToMany
    @JoinTable(
            name="members",
            joinColumns = @JoinColumn(name="band_id"),
            inverseJoinColumns = @JoinColumn(name="person_id")
    )
    private Set<Person> members;

    public Band() {
    }

    public Band(int idBand, String bandname, String location, Date startDate, Date endDate) {
        this.idBand = idBand;
        this.bandname = bandname;
        this.location = location;
        this.acritivtyStartDate=startDate;
        this.activityEndDate=endDate;
    }

    public int getIdBand() {
        return idBand;
    }

    public void setIdBand(int idBand) {
        this.idBand = idBand;
    }

    public String getBandname() {
        return bandname;
    }

    public void setBandname(String bandname) {
        this.bandname = bandname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getAcritivtyStartDate() {
        return acritivtyStartDate;
    }

    public void setAcritivtyStartDate(Date acritivtyStartDate) {
        this.acritivtyStartDate = acritivtyStartDate;
    }

    public Date getActivityEndDate() {
        return activityEndDate;
    }

    public void setActivityEndDate(Date activityEndDate) {
        this.activityEndDate = activityEndDate;
    }

    public Set<Person> getMembers() {
        return members;
    }

    public void setMembers(Set<Person> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Band{" +
                "idBand=" + idBand +
                ", bandname='" + bandname + '\'' +
                ", location='" + location + '\'' +
                ", acritivtyStartDate=" + acritivtyStartDate +
                ", activityEndDate=" + activityEndDate +
                '}';
    }
}
