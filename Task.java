package com.humanbooster.todolist;

import java.util.Date;

public class Task {
    private int idFather;

    private int id;
    private Date creation;
    private Date fin;
    private String desc;
    private String name;




    public Task(int idFather, int id, Date creation, Date fin, String desc, String name) {
        this.idFather = idFather;
        this.id = id;
        this.creation = creation;
        this.fin = fin;
        this.desc = desc;
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getIdFather() {
        return idFather;
    }

    public void setIdFather(int idFather) {
        this.idFather = idFather;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

}
