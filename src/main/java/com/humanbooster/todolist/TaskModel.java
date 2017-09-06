package com.humanbooster.todolist;

import java.util.ArrayList;
import java.util.Date;
//import java.io.Console;

public class TaskModel {
    private ArrayList<Task> listTask;

    public TaskModel() {
        listTask = new ArrayList<Task>();
    }

    public ArrayList<Task> getListTask() {
        return listTask;
    }

    public String getListTaskHTML() {
        //TODO affichage pere en cascade
        String taskHTML = "";
        if (listTask.size() != 0) {
            for (int i = 0; i < listTask.size(); ++i) {
                taskHTML += getTaskBaseHTML(i);
                taskHTML += "<a href='/ToDoList/deleteTask/" + i + "'> X </a> ";
            }
        } else {
            taskHTML += "No tasks in database";
        }
        taskHTML += "<form action ='/ToDoList' method='POST'> Add Task : <br> Name : <br><input type ='text' name='taskTitle' /><br>" +
                "Description : <br> <input type ='text' name='taskDesc' /><br>" +
                "Date Fin : <br><input type ='text' name='taskFin' /><br>" +
                "Depends de ? <br><input  value='none' type ='text' name='fatherName' /><br>" +
                "<input type='submit'/><br>" +
                "</form>";
        return taskHTML;
    }

    public Task getTask(String name) {
        for (Task t : listTask) {
            if (t.getName().compareTo(name) == 0) {
                return t;
            }
        }
        return null;
    }

    public Task getTask(int id) {
        for (Task t : listTask) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public int getTaskId(String name) {
        if (name.compareTo("none") == 0) {
            return -1;
        }
        return getTask(name).getId();
    }

    public String addTask(String nameFather, Date creation, Date fin, String desc, String name) {
        if(getTaskId(nameFather) == -1 ){
        Task t = new Task(-1, listTask.size(), creation, fin, desc, name);
            listTask.add(t);
            return "Task Created...";
        } else {
            Task father = getTask(nameFather);
            if ( father.getFin().compareTo(fin) >= 0){
                Task t = new Task(-1, listTask.size(), creation, fin, desc, name);
            listTask.add(t);
            return "Task Created...";}

        }
        return "there was a problem";
    }

    public void delTask(int id) {
        if (getTask(id).getIdFather() == -1) {
            for (int i = 0; i < listTask.size(); ++i) {
                if (listTask.get(i).getIdFather() == id) {
                    listTask.remove(i);
                }
            }
        }
        listTask.remove(id);
    }

    public String getTaskDetailsHTML(int id) {

        Task t = getTask(id);
        if ( t != null) {
            String infoFather = "";
            int idFath = t.getIdFather();

            if (idFath != -1) {
                Task tFather = getTask(idFath);
                infoFather += "<br> Parent task : " + tFather.getName();
            }
            return "<div>Tache -> Id : " + t.getId() + " <br> name  : " + t.getName() + " <br> Description :" + t.getDesc()
                    + "<br> Creation : " + t.getCreation().toString() + "<br> fin : " + t.getFin().toString() + infoFather + " </div>";

        }
        return "No task details Found for this id";
    }

    public String getTaskBaseHTML(int id) {
        Task t = getTask(id);
        if (t != null) {
            String infoFather = "";
            int idFath = t.getIdFather();
           
            if (idFath != -1) {
                Task tFather = getTask(idFath);
                infoFather += "<br> Parent task : " + tFather.getName();
            }
            return "<div>Tache -> <a href='/ToDoList/showTask/" + t.getId() + "'> " + t.getName() + " </a> : " + t.getDesc() + infoFather + "<br>  </div>";

        }
        return "No task base Found for this id";
    }
}
