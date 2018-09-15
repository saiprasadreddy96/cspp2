import java.util.Scanner;
class Quiz {
	private int qt, nc, mm, p, cc, uc;
	public Quiz(final int qt1, final int nc1, final int cc1, final int mm1, final int p1) {
		this.qt = qt1;
		this.nc = nc1;
		this.cc = cc1;
		this.mm = mm1;
		this.p = p1;
		this.uc = 0;
	}
	public void setuc(final int uc1) {
		this.uc = uc1;
	}
	public int getnc() {
		return this.nc;
	}
	public int getuc() {
		return this.uc;
	}
	public int getcc() {
		return this.cc;
	}
	public int getmm() {
		return this.mm;
	}
	public int getp() {
		return this.p;
	}
 }
/**
 * Solution class for code-eval.
 */
public final class Solution {
     /**
     * Constructs the object.
     */
     Quiz[] q;
     int size;
     static int n = 0;
    private Solution() {
        // leave this blank
    	q = new Quiz[10];
    	size = 0;
    	//n = 0;
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
         // instantiate this Quiz
        Solution sol = new Solution(); 
         // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
             // split the line using space
            String[] tokens = line.split(" ");
              // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                //n = 0;
                n = Integer.parseInt(tokens[1]);
                if (n > 0) {
                	for (int i = 0; i < n; i++) {
                		String question = s.nextLine();
                		String[] parts = question.split(":");
                		//System.out.println(parts[0]);
                		if (parts.length < 5) {
                			n = 0;
                			System.out.println("Error! Malformed question");
                			break;
                		}
                		String[] choice = parts[1].split(",");
                		int len = choice.length;
                		if (len <= 1) {
                			n = 0;
                			System.out.println(parts[0] + " does not have enough answer choices");
                			break;
                		}
                		if (Integer.parseInt(parts[2]) > len) {
                			n = 0;
                			System.out.println("Error! Correct answer choice number is out of range " + parts[0]);
                			break;
                		}
                		if (Integer.parseInt(parts[3]) <= 0) {
                			n = 0;
                			System.out.println("Invalid max marks for " + parts[0]);
                			break;
                		}
                		if (Integer.parseInt(parts[4]) > 0) {
                			n = 0;
                			System.out.println("Invalid penalty for " + parts[0]);
                			break;
                		}
                		Quiz q1 = new Quiz(i + 1, len, Integer.parseInt(parts[2]), Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                		sol.loadQuestions(q1);

                	}
                	if (n != 0) {
                		System.out.println(n + " are added to the quiz");
                	}
            	} else {
            		System.out.println("Quiz does not have questions");
            	}
                break;
                case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                if (n > 0) {
                	sol.startQuiz(s, Integer.parseInt(tokens[1]));
                }
                break;
                case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                if (n > 0) {
             	   sol.displayScore();
            	}
                break;
                default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public void loadQuestions(final Quiz quiz1) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        q[size++] = quiz1;
        
    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public void startQuiz(final Scanner s, final int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        for (int i = 0; i < answerCount; i++) {
        	String[] line = s.nextLine().split(" ");
        	q[i].setuc(Integer.parseInt(line[1]));

        }
        for (int i = 0; i < size; i++) {
        	System.out.println("question text " + (i + 1) + "(" + q[i].getmm() + ")");
        	int j = 0;
        	for (j = 0; j < q[i].getnc() - 1; j++) {
        		System.out.print("choice " + (j + 1) + "\t");
        	}
        	System.out.println("choice " + (j + 1));
        	System.out.println();
        }
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public void displayScore() {
        // write your code here to display the score report
        int score = 0;
        for (int i = 0; i < size; i++) {
        	System.out.println("question text " + (i + 1));
        	if (q[i].getcc() == q[i].getuc()) {
        		System.out.println(" Correct Answer! - Marks Awarded: " + q[i].getmm());
        		score += q[i].getmm();
        	} else {
        		System.out.println(" Wrong Answer! - Penalty: " + q[i].getp());
        		score += q[i].getp();
        	}
        }
        System.out.println("Total Score: " + score);
    }
}
