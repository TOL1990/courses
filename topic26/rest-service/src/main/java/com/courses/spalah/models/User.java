package com.courses.spalah.models;

import java.util.Date;
import java.util.Set;

/**
 * Created by Тарас on 29.05.2016.
 */
public class User {
    Long id;
    String name;
    String nickName;
    Date startDate;
    Date endDate;
    Set<Game> games;
    public User(){}

    public User(Long id, String name, String nickName, Date startDate, Date endDate, Set<Game> games) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.games = games;
    }

    public User(String name, String nickName, Date startDate, Date endDate, Set<Game> games) {
        this.name = name;
        this.nickName = nickName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.games = games;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
