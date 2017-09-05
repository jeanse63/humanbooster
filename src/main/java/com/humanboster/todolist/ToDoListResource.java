package com.humanbooster.todolist;


import org.joda.time.LocalDateTime;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("/ToDoList")
@Produces(MediaType.TEXT_HTML)
public class ToDoListResource {
    private TaskModel list;

    @GET
    public String sayHello() {
        return list.getInstance().getListTaskHTML();

    }

    @POST
    public String createTask(@FormParam("taskTitle") String taskTitle, @FormParam("taskDesc") String taskDesc, @FormParam("taskFin") String taskFin, @FormParam("fatherName") String fatherName) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Date date = null;
        try {
            date = df.parse(taskFin);

        } catch (ParseException e) {

            e.printStackTrace();
        }
        URI redirect = UriBuilder.fromUri("/ToDoList").build();
        return  list.getInstance().addTask(list.getInstance().getTaskId(fatherName) , LocalDateTime.now().toDate() , date, taskDesc, taskTitle) + list.getInstance().getListTaskHTML();

    }

    @GET
    @Path("/deleteTask/{id}")
    public String deleteTask(@PathParam("id") int id) {
        list.getInstance().delTask(id);
        URI redirect = UriBuilder.fromUri("/ToDoList").build();
        return "task deleted..." + list.getInstance().getListTaskHTML();

    }


    @GET
    @Path("/showTask/{id}")
    public String showTask(@PathParam("id") int id) {
        return list.getInstance().getTaskDetailsHTML(id);


    }


}
