package com.humanboster.todolist;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Changement de Gilles */
public class Task{
    // Proprietes	
    private String title;
    private String dateDebut;
    private String dateFin;
    private List<Task> sousTache = new ArrayList<Task>();

    // Constructeur
    public Task(String title, String dateDebut, String dateFin) {
        this.title = title;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }
}
