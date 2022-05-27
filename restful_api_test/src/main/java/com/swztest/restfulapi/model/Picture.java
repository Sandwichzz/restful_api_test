package com.swztest.restfulapi.model;

import javax.persistence.*;

@Entity
@Table(name = "picture")
public class Picture{
    private int id;
    private String title;
    private String description;

    public Picture() {
    		
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
