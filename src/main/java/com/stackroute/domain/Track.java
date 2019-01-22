package com.stackroute.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Track {
    @Id
    private int id;

    private String trackname;

    private String comments;

    public Track() {
    }

    public Track(int id, String trackname, String comments) {
        this.id = id;
        this.trackname = trackname;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", trackname='" + trackname + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrackname() {
        return trackname;
    }

    public void setTrackname(String trackname) {
        this.trackname = trackname;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
