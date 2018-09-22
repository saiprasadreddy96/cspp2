import java.util.Scanner;
import java.util.Arrays;
/**.
 * Class for task.
 */
class Task {
	/**.
	 * { item_description }
	 */
	private String title, assignedTo, status;
	/**.
	 * { item_description }
	 */
	private boolean important, urgent;
	/**.
	 * { var_description }
	 */
	private int timeToComplete;
	/**.
	 * Constructs the object.
	 *
	 * @param      title           The title
	 * @param      assignedTo      The assigned to
	 * @param      timeToComplete  The time to complete
	 * @param      important       The important
	 * @param      urgent          The urgent
	 * @param      status          The status
	 */
	public Task(final String title, final String assignedTo, final int timeToComplete, final boolean important, final boolean urgent, final String status) throws Exception {
		if (title == null || title.length() <= 0) 
			throw new Exception("Title not provided");
		if (timeToComplete <= 0)
			throw new Exception("Invalid timeToComplete " + timeToComplete);
		if (!(status.equals("todo") || status.equals("done")))
			throw new Exception("Invalid status dud");
		this.title = title;
		this.assignedTo = assignedTo;
		this.timeToComplete = timeToComplete;
		this.important = important;
		this.urgent = urgent;
		this.status = status;
	}
	/**.
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		/**.
		 * { var_description }
		 */
		String str = "";
		str += title + ", " + assignedTo + ", " + timeToComplete + ", ";
		if (important) {
			str += "Important, ";
		} else {
			str += "Not Important, ";
		}
		if (urgent) {
			str += "Urgent, ";
		} else {
			str += "Not Urgent, ";
		}
		str += status;
		return str;
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String getassignedTo() {
		return assignedTo;
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String getstatus() {
		return status;
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean getimportant() {
		return important;
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean geturgent() {
		return urgent;
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int gettimeToComplete() {
		return timeToComplete;
	}
}
/**.
 * Class for todoist.
 */
class Todoist {
	/**
	 * { var_description }
	 */
	private Task[] tasks;
	/**.
	 * { item_description }
	 */
	private int size, resize = 10;
	/**.
	 * Constructs the object.
	 */
	public Todoist() {
		tasks = new Task[10];
		size = 0;
	}
	/**.
	 * { function_description }
	 */
	public void resize() {
		resize = size * 2;
		Task[] tasks1 = new Task[resize];
		for (int i = 0; i < size; i++) {
			tasks1[i] = tasks[i];
		}
		tasks = tasks1;
	}
	/**.
	 * Adds a task.
	 *
	 * @param      task1  The task 1
	 */
	public void addTask(final Task task1) {
		if (size == resize) {
			resize();
		}
		tasks[size++] = task1;
	}
	/**.
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		int i = 0;
		String str = "";
		for (i = 0; i < size - 1; i++) {
			str += tasks[i] + "\n";
		}
		str += tasks[i];
		return str;
	}
	/**.
	 * Gets the next task.
	 *
	 * @param      assignedTo  The assigned to
	 *
	 * @return     The next task.
	 */
	public Task getNextTask(final String assignedTo) {
		for (int i = 0; i < size; i++) {
			if (tasks[i].getassignedTo().equals(assignedTo) && tasks[i].getstatus().equals("todo") && tasks[i].getimportant() && (!tasks[i].geturgent())) {
				return tasks[i];
			}
		}
		return null;
	}
	/**.
	 * Gets the next task.
	 *
	 * @param      assignedTo  The assigned to
	 * @param      count       The count
	 *
	 * @return     The next task.
	 */
	public Task[] getNextTask(final String assignedTo, final int count) {
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
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
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
	/**.
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
