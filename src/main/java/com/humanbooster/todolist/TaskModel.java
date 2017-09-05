package com.humanbooster.todolist;

import java.util.ArrayList;
import java.util.Date;

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
        String taskHTML ="";
        for (int i=0; i <listTask.size();++i){
            taskHTML+= getTaskBaseHTML(i);
            taskHTML+= "<a href='/ToDoList/deleteTask/" + i + "'> X </a> ";
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
        for(Task t : listTask){
            if ( t.getName().compareTo(name) == 0){
                return t;
            }
        }
        return null;
    }

    public Task getTask(int id) {
        for(Task t : listTask){
            if ( t.getId() == id){
                return t;
            }
        }
        return null;
    }

    public int getTaskId(String name) {
        if( name.compareTo("none") == 0){
            return -1;
        }
        return getTask(name).getId();
    }

    public String addTask(int idFather, Date creation, Date fin, String desc, String name){
        Task t = new Task (idFather,listTask.size(),  creation,  fin,  desc,  name);
        listTask.add(t);
        return "Task Created...";
    }

    public void delTask(int id) {
        //id != idfather
        if (id == -1) {
            for (int i=0; i <listTask.size();++i){
                if ( listTask.get(i).getIdFather() == id){
                    listTask.remove(i);
                }
            }
        } else {
            listTask.remove(id);
        }
    }


    public String getTaskDetailsHTML(int id) {
        Task t = getTask(id);
        if ( t != null) {
            return "<div>Tache -> Id : " + t.getId() + " <br> name  : " + t.getName() + " <br> Description :" + t.getDesc() + "<br> Creation : " + t.getCreation().toString() + "<br> fin : " + t.getFin().toString() + " </div>";
        }
        return "No task Found for this id";

    }


    public String getTaskBaseHTML(int id) {
        Task t = getTask(id);
        if ( t != null) {
            return "<div>Tache -> <a href='/ToDoList/showTask/" + t.getId() + "'> "+ t.getName()+" </a> : " + t.getDesc() + "<br>  </div>";

        }
        return "No task Found for this id";
    }

}
