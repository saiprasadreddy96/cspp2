import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedInputStream;
class Show {
	private String showname, datetime;
	private String[] seats;
	public Show(String showname, String datetime, String[] seats) {
		this.showname = showname;
		this.datetime = datetime;
		this.seats = seats; 
	}
	public String getshowname() {
		return this.showname;
	}
	public String getdatetime() {
		return this.datetime;
	}
	public String[] getseats() {
		return this.seats;
	}
 	
}
class BookYourShow {
	Show shows[] = new Show[10];
	int size = 0;
	static String[] bookedlist = new String[10];
	static int bls = 0;
	public void addAshow(String showname, String datetime, String[] seats) {
		shows[size++] = (new Show(showname, datetime, seats));
	}
	public int getAshow(String showname, String datetime) {
		int flag = 0;
		for (int i = 0; i < size; i++) {
			if (shows[i].getshowname().equals(showname) && shows[i].getdatetime().equals(datetime)) {
				System.out.println(showname+datetime);
				flag = 1;
			}
		}
		return flag;
	}
	public void bookAshow(String showname, String datetime, String username, String mobileno, String[] seats) {
		if (getAshow(showname, datetime) == 1) {
			for (int i = 0; i < size; i++) {
				if (shows[i].getshowname().equals(showname) && shows[i].getdatetime().equals(datetime)) {
					String[] str = shows[i].getseats();
					for (int j = 0; j < seats.length; j++) {
						for (int k = 0; k < str.length; k++) {
							if (seats[j].equals(str[k])) {
								str[k] = "*";
							}
						}

					}
				}
			}
			bookedlist[bls] = mobileno + " " + username + " " + datetime;
			bls++;
		} else {
			System.out.println("Invalid");
		}
	}

	public void print(String name, String datetime, String mobileno) {
		String str = mobileno + " " + name + " " + datetime;
		for (int i = 0; i < bls; i++) {
			if (str.equals(bookedlist[i])) {
				System.out.println(str);
				return;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));
		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] tokens = line.split(" ",2);
			switch (tokens[0]) {
				case "add":
					String[] tokens1 = tokens[1].split(",", 3);
					String tokens2 = tokens1[2];
					String tokens3 = tokens2.substring(1, tokens2.length() - 1);
					String[] tokens4 = tokens3.split(",");
					BookYourShow bys1 = new BookYourShow();
					bys1.addAshow(tokens1[0], tokens1[1], tokens4);
					break;
				case "get":
					BookYourShow bys2 = new BookYourShow();
					String[] tokens5 = tokens[1].split(",");
					if (bys2.getAshow(tokens5[0], tokens5[1]) == 0) {
						System.out.println("No show");
					}
					break;
				case "book":
					BookYourShow bys3 = new BookYourShow();
					String[] tokens6 = tokens[1].split(",",5);
					String s1 = tokens6[4];
					s1 = s1.substring(1, s1.length() - 1);
					String[] tokens7 = s1.split(",");
					bys3.bookAshow(tokens6[0], tokens6[1], tokens6[2], tokens6[3], tokens7);
					break;
				case "print":
					String[] tokens8 = tokens[1].split(",");
					BookYourShow bys4 = new BookYourShow();
					bys4.print(tokens8[0], tokens8[1], tokens8[2]);
					break;
				case "showAll":
					break;
				default:
					break;
			}


		}
	}
}