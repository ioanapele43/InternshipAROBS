package com.example.musify.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    private Integer id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "stage_name")
    private String stagename;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "activity_start_date")
    private Date activityStartDate;
    @Column(name = "activity_end_date")
    private Date activityEndDate;

    @ManyToMany(mappedBy = "members")
    private Set<Band> bandMembers;
    @OneToMany
    private List<Album> album=new ArrayList<Album>();



   /* @OneToMany(mappedBy = "artistId")
    private List<SongArtist> songArtist;

    @OneToMany(mappedBy = "artistId")
    private List<AlbumArtist> albumArtist;*/

    public Artist(String firstname, String lastname, String stagename, Date birthday, Date startDate, Date endDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.stagename = stagename;
        this.birthday = birthday;
        this.activityStartDate = startDate;
        this.activityEndDate = endDate;
    }

  }
