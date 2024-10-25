package polsl.pl.model.TaskList;

public class Task {

    private static int idCounter = 0;
    private final int id;
    private String name;
    private String description;
    private Priority priority;
    private boolean isDone;

    public Task() {
        this.id = idCounter++;
    }

    public Task(String name, String description, Priority priority, boolean isDone) {
        this.id = idCounter++;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Priority getPriority() {
        return priority;
    }
    public boolean getIsDone() {
        return isDone;
    }
    public void setDone(boolean done) {
        isDone = done;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Task"+"[" + id + "]" +"{\n" +  name + "description = " + description +
                " priority = " + priority + ", isDone = " + isDone + " }";
    }
 
    
}
