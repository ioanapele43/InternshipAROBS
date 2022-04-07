package com.example.musify.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "artist")
@NamedQueries({
        @NamedQuery(name = "findAllArtists", query = "from Artist"),
        @NamedQuery(name = "findArtistById", query = "from Artist where id = :id")
})
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idPerson;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "stage_name")
    private String stagename;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "activity_start_date")
    private Date acritivtyStartDate;
    @Column(name = "activity_end_date")
    private Date activityEndDate;

    @ManyToMany(mappedBy = "members")
    private Set<Band> bandMembers;

    @OneToMany(mappedBy = "artistId")
    private List<SongArtist> songArtist;

    @OneToMany(mappedBy = "artistId")
    private List<AlbumArtist> albumArtist;

    public Artist() {
    }

    public Artist(String firstname, String lastname, String stagename, Date birthday, Date startDate, Date endDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.stagename = stagename;
        this.birthday = birthday;
        this.acritivtyStartDate = startDate;
        this.activityEndDate = endDate;
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

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
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



    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", stagename='" + stagename + '\'' +
                ", birthday=" + birthday +
                ", acritivtyStartDate=" + acritivtyStartDate +
                ", activityEndDate=" + activityEndDate +
                '}';
    }
}
