package duke;
import java.util.ArrayList;

/**
 * Stores the list of tasks in an array list. This list can then be altered based on the user's inputs
 */
public class TaskList {
    public ArrayList<Task> tasks;
    public int count;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
        this.count = 0;
    }
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
        this.count = tasks.size();
    }

    /**
     * Marks a task in the tasklist as done
     * @param i Takes in an integer to find the correct string placement
     */
    public void doTask(int i) {
        if (i > tasks.size()) {
            System.out.println("Invalid Input for done command");
        } else if (!tasks.get(i - 1).isDone) {
            System.out.println("Nice! I've marked this task as done:");
            tasks.get(i - 1).markAsDone();
            System.out.println(tasks.get(i - 1));
        } else {
            System.out.println("This task is already marked as done");
        }
    }

    /**
     * Adds an event task to the tasklist
     * @param in Provides the string input for the event task
     * @param i Takes in an integer to find the correct string placement in the string input
     */
    public void addEventTask(String in, int i) {
        System.out.println("Got it. I've added this task:");
        tasks.add(new EventTask(in.substring(6, i), in.substring(i + 1)));
        System.out.println(tasks.get(tasks.size()-1));
        if (tasks.size() == 1) {
            System.out.println("Now you have " + tasks.size() + " task in the list.");
        } else {
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        }
    }

    /**
     * Adds a deadline task to the task list
     * @param in Provides the string input for the deadline task
     * @param i Takes in an integer to find the correct string placement in the string input
     */
    public void addDeadlineTask(String in, int i) {
        System.out.println("Got it. I've added this task:");
        tasks.add(new DeadlineTask(in.substring(9, i), in.substring(i + 1)));
        System.out.println(tasks.get(tasks.size()-1));
        if (tasks.size() == 1) {
            System.out.println("Now you have " + tasks.size() + " task in the list.");
        } else {
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        }
    }

    /**
     * Adds a todo task to the task list
     * @param in Provides the string input for the todo task
     */
    public void addToDoTask(String in) {
        System.out.println("Got it. I've added this task:");
        tasks.add(new ToDoTask(in.substring(5)));
        System.out.println(tasks.get(tasks.size()-1));
        if (tasks.size() == 1) {
            System.out.println("Now you have " + tasks.size() + " task in the list.");
        } else {
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        }
    }

    /**
     * Displays the tasklist
     */
    public void showList() {
        int counter = 1;
        System.out.println(" Here are the tasks in your list:");
        for (Task item: tasks) {
            if(item != null) {
                System.out.println(counter + ". " + item.toString());
                counter++;
            }

        }
    }

    /**
     * Delets a task from the tasklist
     * @param i
     */
    public void deleteTask(int i) {
        if (tasks.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            if (i > 100) {
                System.out.println("Invalid Input for delete command");
            } else if (i > tasks.size()) {
                System.out.println("Invalid Input for delete command");
            } else {
                System.out.println("Noted. I've removed this task:");
                System.out.println(tasks.get(i - 1));
                tasks.remove(i - 1);
            }
        }
    }

    public String toString() {
        if (tasks.isEmpty()) {
            return "No tasks";
        } else {
            String result = "";
            for (Task item : tasks) {
                result += item.toString();
                result += " ";
            }
            return result;
        }
    }
}
