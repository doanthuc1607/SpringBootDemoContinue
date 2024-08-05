package com.sample.administration.entity;

import jakarta.persistence.*;

@Entity
@Table(name="urlmapping")
public class UrlMapping {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="original_link")
    private String originalLink;

    @Column(name="short_link")
    private String shortLink;



    // define constructors
    public UrlMapping() {

    }

    public UrlMapping(String originalLink, String shortLink) {
        this.originalLink = originalLink;
        this.shortLink = shortLink;
    }

    // define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }

    public String getOriginalLink() {
        return originalLink;
    }

    public void setOriginalLink(String originalLink) {
        this.originalLink = originalLink;
    }


    // define toString
    @Override
    public String toString() {
        return "UrlMapping{" +
                "id=" + id +
                ", originalLink='" + originalLink + '\'' +
                ", shortLink='" + shortLink + '\'' +
                '}';
    }
}
