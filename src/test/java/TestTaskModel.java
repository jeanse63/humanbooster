import com.humanbooster.todolist.TaskModel;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTaskModel {

    @Test
    public void listeTaskCree() {
        TaskModel list;
        list = new TaskModel();
        int tail = list.getListTask().size();

        assertEquals("Pas d'elements dans la list", 0, tail);
    }
}
