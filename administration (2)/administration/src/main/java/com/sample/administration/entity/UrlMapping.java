package com.sample.administration.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
