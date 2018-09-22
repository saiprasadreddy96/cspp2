import java.util.Scanner;
import java.util.Arrays;
/**
  * write your code below this comment
  */
class Task {
	private String title, assignedTo, status;
	private boolean important, urgent;
	private int timeToComplete;
	public Task(final String title, final String assignedTo, final int timeToComplete, final boolean important, final boolean urgent, final String status) throws Exception {
		if (title == null) 
			throw new Exception("Title not provided");
		if (timeToComplete <= 0)
			throw new Exception("Time required to complete the task should be non negative value ");
		if (!(status.equals("todo") || status.equals("done")))
			throw new Exception("Task status should be either todo or done and can’t have any other value");
		this.title = title;
		this.assignedTo = assignedTo;
		this.timeToComplete = timeToComplete;
		this.important = important;
		this.urgent = urgent;
		this.status = status;
	}
	public String toString() {
		String str = "";
		str += title + ", " + assignedTo + ", " + timeToComplete + ", " + important + ", " + urgent + ", " + status;
		return str;
	}
	public String getassignedTo() {
		return assignedTo;
	}
	public String getstatus() {
		return status;
	}
	public boolean getimportant() {
		return important;
	}
	public boolean geturgent() {
		return urgent;
	}
	public int gettimeToComplete() {
		return timeToComplete;
	}
}
class Todoist {
	private Task[] tasks;
	private int size, resize = 10;
	public Todoist() {
		tasks = new Task[10];
		size = 0;
	}
	public void resize() {
		resize = size * 2;
		Task[] tasks1 = new Task[resize];
		for (int i = 0; i < size; i++) {
			tasks1[i] = tasks[i];
		}
		tasks = tasks1;
	}
	public void addTask(Task task1) {
		if (size == resize) {
			resize();
		}
		tasks[size++] = task1;
	}
	public String toString() {
		int i = 0;
		String str = "";
		for (i = 0; i < size - 1; i++) {
			str += tasks[i] + "\n";
		}
		str += tasks[i];
		return str;
	}
	public Task getNextTask(String assignedTo) {
		for (int i = 0; i < size; i++) {
			if (tasks[i].getassignedTo().equals(assignedTo) && tasks[i].getstatus().equals("todo") && tasks[i].getimportant() && (!tasks[i].geturgent())) {
				return tasks[i];
			}
		}
		return null;
	}
	public Task[] getNextTask(String assignedTo, int count) {
		Task[] tasks2 = new Task[count];
		int j = 0;
		for (int i = 0; i < size; i++) {
			if (j >= count) break;
			if (tasks[i].getassignedTo().equals(assignedTo) && tasks[i].getstatus().equals("todo") && tasks[i].getimportant() && (!tasks[i].geturgent())) {
				tasks2[j] = tasks[i];
				j++;
			}
		}
		return tasks2;
	}
	public int totalTime4Completion() {
		int totaltime = 0;
		for (int i = 0; i < size; i++) {
			if (tasks[i].getstatus().equals("todo")) {
				totaltime += tasks[i].gettimeToComplete();
			}
		}
		return totaltime;
	}
 }
/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    System.out.println(todo);
                break;
                case "get-next":
                    System.out.println(todo.getNextTask(tokens[1]));
                break;
                case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    Task[] tasks = todo.getNextTask(tokens[1], n);
                    System.out.println(Arrays.deepToString(tasks));
                break;
                case "total-time":
                    System.out.println(todo.totalTime4Completion());
                break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
