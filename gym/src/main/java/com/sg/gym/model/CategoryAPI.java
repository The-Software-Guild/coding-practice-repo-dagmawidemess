/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.gym.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author farhanshahbaz
 */
public class CategoryAPI {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;

//    public CategoryAPI(String id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
