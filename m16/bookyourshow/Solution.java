import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for show.
 * @author     ritesh.
 */
class BookYourShow {
    /**
     * Patron object.
     */
    private Patron[] patrons;
    /**.
     * Show class Object
     */
    private Show[] shows;
    /**
     * patrons size.
     */
    private int pSize;
    /**
     * show size.
     */
    private int sSize;
    /**
     * integer variable.
    */
    private static final int TEN = 10;
    /**
     * Constructs the object.
     */
    protected BookYourShow() {
        this.shows = new Show[TEN];
        this.patrons = new Patron[TEN];
        this.pSize = 0;
        this.sSize = 0;
    }

    /**.
     * { function_description }.
     */
    public void showResize() {
        shows = Arrays.copyOf(shows, shows.length * 2);
        // patrons = Arrays.copyOf(patrons, patrons.length * 2);
    }
    /**
     * resize function for patrons.
     */
    public void patronResize() {
        // shows = Arrays.copyOf(shows, shows.length * 2);
        patrons = Arrays.copyOf(patrons, patrons.length * 2);
    }

    /**
     * Adds a show.
     *
     * @param      show1  The new show
     */
    public void addAShow(final Show show1) {
        if (sSize == shows.length) {
            showResize();
        }
        shows[sSize++] = show1;
    }
    /**
     * Adds a patron.
     *
     * @param      patron1  The newpatron
     */
    public void addAPatron(final Patron patron1) {
        if (pSize > patrons.length) {
            patronResize();
        }
        patrons[pSize++] = patron1;
    }

    /**
     * Gets a show.
     *
     * @param      moviename  The moviname
     * @param      movietime  The datetime
     *
     * @return     A show.
     */
    public Show getAShow(final String moviename, final String movietime) {
        for (int i = 0; i < sSize; i++) {
            if (shows[i].getMovieName().equals(moviename)
                && shows[i].getDate().equals(movietime)) {
                    return shows[i];
            }
        }
        return null;
    }

    /**
     * to book a show.
     *
     * @param      moviename  The moviename
     * @param      movietime   The datetime
     * @param      p          { parameter_description }
     */
    public void bookAShow(final String moviename,
        final String movietime, final Patron p) {
        addAPatron(p);
        Show avaiableShow = getAShow(moviename, movietime);
        if (avaiableShow != null) {
            String[] seats = avaiableShow.getSeats();
            String[] bookedSeats = p.getBSeats();
            for (int i = 0; i < seats.length; i++) {
                for (int j = 0; j < bookedSeats.length; j++) {
                    if (seats[i].equals(bookedSeats[j])
                        && !seats[i].equals("N/A")) {
                        seats[i] = "N/A";
                    }
                }
            }
        } else {
            System.out.println("No show");
        }
    }
    /**
     * Shows all.
     */
    public void showAll() {
        for (int i = 0; i < sSize; i++) {
            System.out.println(shows[i]);
        }
    }
    /**.
     * { function_description }
     *
     * @param      moviename     The moviename
     * @param      movietime      The datetime
     * @param      mblnumber  The mobilenumber
     */
    public void printTicket(final String moviename,
        final String movietime, final String mblnumber) {
        Show show = getAShow(moviename, movietime);
        if (show != null) {
            for (int i = 0; i < pSize; i++) {
                if (patrons[i].getNum().equals(mblnumber)) {
                    System.out.println(mblnumber + " "
                        + moviename + " " + movietime);
                    return;
                }
            }
            System.out.println("Invalid");
        } else {
            System.out.println("Invalid");
        }
    }
}

/**
 * Class for show.
 */
class Show {
    /**
     * { var_description }.
     */
    private String moviename;
    /**
     * { var_description }.
     */
    private String movietime;
    /**
     * { var_description }.
     */
    private String[] seatnumbers;
    /**
     * Constructs the object.
     *
     * @param      moviename1    The moviename 1
     * @param      movietime1    The movietime 1
     * @param      seatnumbers1  The seatnumbers 1
     */
    Show(final String moviename1, final String movietime1,
        final String[] seatnumbers1) {
        // final int num = 20;
        // seat_numbers = new int[num];
        // size = 0;
        this.moviename = moviename1;
        this.movietime = movietime1;
        this.seatnumbers = seatnumbers1;
    }
    /**
     * Gets the movie name.
     *
     * @return     The movie name.
     */
    public String getMovieName() {
        return this.moviename;
    }
    /**
     * Gets the date.
     *
     * @return     The date.
     */
    public String getDate() {
        return this.movietime;
    }
    /**
     * Gets the seats.
     *
     * @return     The seats.
     */
    public String[] getSeats() {
        return this.seatnumbers;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public String excepttickets() {
        String s = "";
        s += moviename + "," + movietime;
        return s;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        s += moviename + "," + movietime + ",";
        s += Arrays.toString(seatnumbers).replace(", ", ",");
        return s;
    }
}

/**
 * Class for patron.
 */
class Patron {
    /**
     * { var_description }.
     */
    private String personname;
    /**
     * { var_description }.
     */
    private String mblnumber;
    /**
     * { var_description }.
     */
    private String[] bookedseats;
    /**
     * Constructs the object.
     *
     * @param      personname1   The personname
     * @param      mblnumber1    The mblnumber
     * @param      bookedseats1  The bookedseats
     */
    Patron(final String personname1, final String mblnumber1,
        final String[] bookedseats1) {
        this.personname = personname1;
        this.mblnumber = mblnumber1;
        this.bookedseats = bookedseats1;

    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        return s;
    }
    /**
     * Gets the p name.
     *
     * @return     The p name.
     */
    public String getPName() {
        return this.personname;
    }
    /**
     * Gets the number.
     *
     * @return     The number.
     */
    public String getNum() {
        return this.mblnumber;
    }
    /**
     * Gets the b seats.
     *
     * @return     The b seats.
     */
    public String[] getBSeats() {
        return this.bookedseats;
    }


}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
                case "add":
                    int k = 2;
                    String[] seats = new String[tokens.length - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

                case "book":
                    k = 2 + 2;
                    seats = new String[tokens.length - 2 - 2];
                    for (int j = 0; j < seats.length; j++) {
                        seats[j] = tokens[k++];
                    }
                    bys.bookAShow(check[1], tokens[1],
                        new Patron(tokens[2], tokens[2 + 1], seats));
                break;

                case "get":
                    Show show = bys.getAShow(check[1], tokens[1]);
                    if (show != null) {
                       System.out.println(show.excepttickets());
                    } else {
                        System.out.println("No show");
                    }
                break;

                case "print":
                    bys.printTicket(check[1], tokens[1], tokens[2]);
                break;

                case "showAll":
                    bys.showAll();
                break;

                default:
                break;
            }
        }
    }
}