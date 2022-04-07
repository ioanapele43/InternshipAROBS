package com.example.musify.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "band")
public class Band {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "band_name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "activity_start_date")
    private String activityStartDate;
    @Column(name = "activity_end_date")
    private String activityEndDate;

    @ManyToMany(mappedBy = "bands")
    private Set<Artist> artists = new HashSet<>();

    //, fetch = FetchType.LAZY
    public Band() {
    }

    public Band(int id, String name, String location, String activityStartDate, String activityEndDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.activityStartDate = activityStartDate;
        this.activityEndDate = activityEndDate;
    }

    public Band(int id, String name, String location, String activityStartDate, String activityEndDate, Set<Artist> artists) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.activityStartDate = activityStartDate;
        this.activityEndDate = activityEndDate;
        this.artists = artists;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getActivityStartDate() {
        return activityStartDate;
    }

    public void setActivityStartDate(String activityStartDate) {
        this.activityStartDate = activityStartDate;
    }

    public String getActivityEndDate() {
        return activityEndDate;
    }

    public void setActivityEndDate(String activityEndDate) {
        this.activityEndDate = activityEndDate;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }

    @Override
    public String toString() {
        List<Artist> artistsToString = new ArrayList<>();
        artists.forEach(x -> {
            artistsToString.add(new Artist(x.getId(), x.getFirstName(), x.getLastName(),
                    x.getStageName(), x.getBirthday(), x.getActivityStartDate(), x.getActivityEndDate(), x.getType()));
        });
        return "Band{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", activityStartDate='" + activityStartDate + '\'' +
                ", activityEndDate='" + activityEndDate + '\'' +
                ", artists=" + artistsToString +
                '}';
    }
}