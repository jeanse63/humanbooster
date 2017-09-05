package com.humanboster.todolist;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Path("/")
@Produces(MediaType.TEXT_HTML)

public class HelloWorldResource {

    private List<Task> tasks = new ArrayList<Task>();

    @GET
    public String sayHello() {
        String taskHTML = "";
        int i = 0;
        String formulaire = "<form action='/' method='POST'>"+
                "Ajouter un Todo : <input type='text' name='tasktitle' /><br> "+
                "Date de fin : <input type='text' name='dateFin' /> "+
                "Date de début : <input type='text' name='dateDebut' /> "+
                "<input type='submit' />"+
                "</form>";

        for (Task task : tasks){
            taskHTML += "<div> <a href='/view/"+i+"' title='voir "+task.getTitle()+" ?'>"+task.getTitle()+
                    "</a> -- <a href='/delete/"+i+"' title='Supprimer "+task.getTitle()+" ?'>x</a></div><br>";
            i++;
        }
        return taskHTML+formulaire;
    }

    @GET
    @Path("/view/{id}")
    public String delete(@PathParam("id") int id){
        Task taskToDisplay = tasks.get(id);
        URI redirect = UriBuilder.fromUri("/").build();
        return "<b>Todo :</b> "+taskToDisplay.getTitle()+" <br>date de fin : "+taskToDisplay.getDateFin()+"<br><br><a href='/'>Retour</a>";
    }


    @POST
    public Response createTask(@FormParam("tasktitle") String tasktitle,
                               @FormParam("dateFin") String dateFin,
                               @FormParam("dateDebut") String dateDebut){
        tasks.add(new Task(tasktitle, dateDebut, dateFin));
        URI redirect = UriBuilder.fromUri("/").build();
        return Response.seeOther(redirect).build();
    }
}


