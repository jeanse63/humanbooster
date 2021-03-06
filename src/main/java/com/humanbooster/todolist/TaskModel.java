package com.humanbooster.todolist;

import com.google.common.io.Resources;

import java.nio.file.Paths;
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
        taskHTML += "<form action ='/ToDoList' method='POST'> Add Task : <br> Name : <br><input id='taskName' type ='text' name='taskTitle' /><br>" +
                "Description : <br> <input id='taskDesc'  type ='text' name='taskDesc' /><br>" +
                "Date Fin : <br><input  id='taskDate' type ='text' name='taskFin' /><br>" +
                "Depends de ? <br><input  id='taskFather'  value='none' type ='text' name='fatherName' /><br>" +
                "<input  id='submitButton'  type='submit'/><br>" +
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
        Task father = getTask(nameFather);
        if (father != null) {

            if (father.getIdFather() != -1) {
                if (father.getFin().compareTo(fin) >= 0) {
                    Task t = new Task(father.getId(), listTask.size(), creation, fin, desc, name);
                    listTask.add(t);
                    return "Task Created...";
                }
                return "beeeeeeep you die after you father idiot";
            }
            return "no grand daughters you bitch";
        }
        Task t = new Task(-1, listTask.size(), creation, fin, desc, name);
        listTask.add(t);
        return "Task Created...";
    }

    public int getNumberTasks() {
        return listTask.size();
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
        if (t != null) {
            String infoFather = "";
            int idFath = t.getIdFather();

            if (idFath != -1) {
                Task tFather = getTask(idFath);
                infoFather += "<br> Parent task : " + tFather.getName();
            }
            return "<div id='task-detail'>Tache -> Id : " + t.getId() + " <br> name  : " + t.getName() + " <br> Description :" + t.getDesc()
                    + "<br> Creation : " + t.getCreation().toString() + "<br> fin : " + t.getFin().toString() + infoFather + " </div>"
                    + "<br><div><a href='/ToDoList'>retour</a></div>";
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
                infoFather += " - Parent task : " + tFather.getName();
            }
            return "<div>Tache -> <a id='task-"+ t.getId() + "' href='/ToDoList/showTask/" + t.getId() + "'> " + t.getName() + " </a> : " + t.getDesc() + infoFather + "<br>  </div>";

        }
        return "No task base Found for this id";
    }
}
