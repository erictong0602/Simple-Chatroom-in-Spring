package com.user.api.userAPi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer room_ID;

    private String room_name;

    private Integer room_limitation;

    public Integer getRoom_ID() {
        return room_ID;
    }

    public void setRoom_ID(Integer room_ID) {
        this.room_ID = room_ID;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public Integer getRoom_limitation() {
        return room_limitation;
    }

    public void setRoom_limitation(Integer room_limitation) {
        this.room_limitation = room_limitation;
    }
}
