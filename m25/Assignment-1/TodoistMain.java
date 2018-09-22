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
	 * @param      title1           The title 1
	 * @param      assignedTo1      The assigned to 1
	 * @param      timeToComplete1  The time to complete 1
	 * @param      important1       The important 1
	 * @param      urgent1          The urgent 1
	 * @param      status1          The status 1
	 */
	protected Task(final String title1, final String assignedTo1,
		final int timeToComplete1, final boolean important1,
		final boolean urgent1, final String status1)
		throws Exception {
		if (title1 == null || title1.length() <= 0) {
			throw new Exception("Title not provided");
		}
		if (timeToComplete1 <= 0) {
			throw new Exception("Invalid timeToComplete -1");
		}
		if (!(status1.equals("todo") || status1.equals("done"))) {
			throw new Exception("Invalid status dud");
		}
		this.title = title1;
		this.assignedTo = assignedTo1;
		this.timeToComplete = timeToComplete1;
		this.important = important1;
		this.urgent = urgent1;
		this.status = status1;
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
	final private int ten = 10;
	/**.
	 * Constructs the object.
	 */
	public Todoist() {
		tasks = new Task[ten];
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
			if (j >= count) {
				break;
			}
			if (tasks[i].getassignedTo().equals(assignedTo)
				&& tasks[i].getstatus().equals("todo")
				&& tasks[i].getimportant()
				&& (!tasks[i].geturgent())) {
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
	 * Constructs the object.
	 */
	protected TodoistMain() {
	}
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
    	final int THREE = 3, FOUR = 4, FIVE = 5, SIX = 6;
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[THREE]);
        boolean important = tokens[FOUR].equals("y");
        boolean urgent = tokens[FIVE].equals("y");
        String status = tokens[SIX];
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



