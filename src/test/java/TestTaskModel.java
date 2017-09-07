import com.humanbooster.todolist.TaskModel;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestTaskModel {

    @Test
    public void listeTaskCree() {
        TaskModel list;
        list = new TaskModel();
        int tail = list.getListTask().size();

        assertEquals("Pas d'elements dans la list", 0, tail);
    }

    @Test
    public void testerCreatTask() {
        TaskModel list;
        list = new TaskModel();

        Date dateCrea = new Date();
        Date dateFin = new Date();

        String result = list.addTask("none", dateCrea, dateFin, "Pour tests", "Testeur");

        assertEquals("Creation d'une task - ok", "Task Created...", result);
    }

    @Test
    public void testerCascadeTask() {
        TaskModel list;
        list = new TaskModel();

        Date dateCrea = new Date();
        Date dateFin = new Date();

        String result = list.addTask("none", dateCrea, dateFin, "Pour tests", "Testeur");
        String result1 = list.addTask("Testeur", dateCrea, dateFin, "Pour tests", "Testeur1");
        String result2 = list.addTask("Testeur1", dateCrea, dateFin, "Pour tests", "Testeur2");

        assertEquals("Creation d'une task fille dans une task fille", "there was a problem", result2);
    }
}
