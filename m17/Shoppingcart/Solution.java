import java.util.Scanner;
//import java.io.BufferedInputStream;
import java.util.Arrays;
/**.
 * Class for item.
 */
class Item {
	/**.
	 * { var_description }
	 */
    private String prt;
    /**.
     * { var_description }
     */
	private int q;
	/**.
	 * { var_description }
	 */
	private float up;
	/**.
	 * Constructs the object.
	 *
	 * @param      prt   The prt
	 * @param      q     The quarter
	 * @param      up    { parameter_description }
	 */
	public Item(final String prt1, final int q1, final float up1) {
		this.prt = prt1;
		this.q = q1;
		this.up = up1;
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String getprt() {
		return prt;
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int getq() {
		return q;
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public float getup() {
		return up;
	}
	/**.
	 * { function_description }
	 *
	 * @param      prt   The prt
	 */
	public void setprt(final String prt) {
		this.prt = prt;
	}
	/**.
	 * { function_description }
	 *
	 * @param      q     The quarter
	 */
	public void setq(final int q) {
		this.q = q;
	}
	/**.
	 * { function_description }
	 *
	 * @param      up    { parameter_description }
	 */
	public void setup(final float up) {
		this.up = up;
	}
	/**.
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		return prt + " " + q + " " + up;
	}
}
/**.
 * Class for shopping cartesian.
 */
class ShoppingCart {
	private Item items1[], items2[];
	private int size1, size2, coupon, flag = 0;
	/**.
	 * Constructs the object.
	 */
	public ShoppingCart() {
		final int m1 = 20;
		items1 = new Item[m1];
		items2 = new Item[m1];
		size1 = 0;
		size2 = 0;
		coupon = 0;
	}
	/**.
	 * { function_description }
	 *
	 * @param      other  The other
	 */
	public void item(final Item other) {
		items1[size1++] =  other;
	}
	/**.
	 * { function_description }
	 */
	public void catalog() {
		for (int i = 0; i < size1; i++) {
			System.out.println
			(items1[i].getprt() + " " + items1[i].getq() + 
				" " + items1[i].getup());
		}
	}
	/**.
	 * { function_description }
	 *
	 * @param      other  The other
	 */
	public void add(final Item other) {
		for (int i = 0; i < size2; i++) {
			if (items2[i].getprt().equals(other.getprt())) {
				items2[i].setq(items2[i].getq() + other.getq());
				return;
			}
		}
		items2[size2++] = other;
	}
	/**.
	 * { function_description }
	 */
	public void show() {
		for (int i = 0; i < size2; i++) {
			if (items2[i].getq() > 0) {
				System.out.println
				(items2[i].getprt() + " " + items2[i].getq());
			}
		}
	}
	/**.
	 * { function_description }
	 *
	 * @param      other  The other
	 */
	public void remove(final Item other) {
		for (int i = 0; i < size2; i++) {
			if (items2[i].getprt().equals(other.getprt()) && 
				items2[i].getq() >= other.getq()) {
				items2[i].setq(items2[i].getq() - other.getq());
				return;
			}
		}
	}
	/**.
	 * { function_description }
	 *
	 * @param      prt   The prt
	 *
	 * @return     { description_of_the_return_value }
	 */
	public float getup(final String prt) {
		for (int i = 0; i < size1; i++) {
			if (items1[i].getprt().equals(prt)) {
				return items1[i].getup();
			}
		}
		return 0;
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public float totalAmount() {
		float amount = 0;
		for (int i = 0; i < size2; i++) {
			amount += items2[i].getq() * getup(items2[i].getprt());
		}
		return amount;
	}
	/**.
	 * { function_description }
	 *
	 * @param      coupon  The coupon
	 */
	public void setcoupon(final String coupon) {
		int n = Integer.parseInt(coupon.substring(3, 5));
		if (flag == 1) {
			return;
		}
		final int m3 = 10, m4 = 20, m5 = 30, m6 = 50;
		if (n == m3 || n == m4 || n == m5 || n == m6) {
			this.coupon = n;
			flag = 1;
		} else {
			System.out.println("Invalid coupon");
			this.coupon = 0;
		}
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int getcoupon() {
		return this.coupon;
	}
	/**.
	 * { function_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public float payableAmount() {
		float ta = totalAmount();
		System.out.println(getcoupon());
		float dis = ta * getcoupon() / 100;
		System.out.println(dis);
		float pa = ta - dis;
		float tax = pa * 15 / 100;
		pa = pa + tax;
		return pa;
	}
	/**.
	 * { function_description }
	 */
	public void printall() {
		System.out.println("Name   quantity   Price");
		for (int i = 0; i < size1; i++) {
			for (int j = 0; j < size2; j++) {
				if (items1[i].getprt().equals(items2[j].getprt()) && 
					items2[j].getq() != 0){
					System.out.println(items1[i].getprt() + " " + 
						items2[j].getq() + " " + items1[i].getup());
					break;
				}
			}
		}
		float ta = totalAmount();
		float dis = ta * getcoupon() / 100;
		float pa = ta - dis;
		float tax = pa * 15 / 100;
		pa = pa + tax;
		System.out.println("totalAmount: " + ta + "\nTotal:" + ta +
			"\nDisc%:" + dis + "\nTax:" + tax + "\nPayable amount: " + pa);
		return;
	}

}
/**.
 * { item_description }
 */
public final class Solution {
	/**.
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ShoppingCart sct = new ShoppingCart();
		while (n >= 0) {
			String tokens = sc.nextLine();
			String[] tokens1 = tokens.split(" ");
			switch (tokens1[0]) {
				case "Item":
					String[] tokens2 = tokens1[1].split(",");
					sct.item(new Item(tokens2[0], 
						Integer.parseInt(tokens2[1]), 
						Float.parseFloat(tokens2[2])));
					break;
				case "catalog":
					sct.catalog();
					break;
				case "add":
					String[] tokens3 = tokens1[1].split(",");
					sct.add(new Item(tokens3[0], 
						Integer.parseInt(tokens3[1]), 0.0f));
					break;
				case "show":
					sct.show();
					break;
				case "totalAmount":
					System.out.println("totalAmount: " + 
						sct.totalAmount());
					break;
				case "remove":
					String[] tokens4 = tokens1[1].split(",");
					sct.remove(new Item(tokens4[0], 
						Integer.parseInt(tokens4[1]), 0.0f));
					break;
				case "payableAmount":
					System.out.println("Payable amount: " + 
						sct.payableAmount());
					break;
				case "print":
					sct.printall();
					break;
				case "coupon":
					sct.setcoupon(tokens1[1]);
					break;
				default:
					break;
			}
			n--;
		}
	}
}