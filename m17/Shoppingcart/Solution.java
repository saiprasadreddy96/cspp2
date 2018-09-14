import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;
class Item {
	private String prt;
	private int q;
	private float up;
	public Item(String prt, int q, float up) {
		this.prt = prt;
		this.q = q;
		this.up = up;
	}
	public String getprt() {
		return prt;
	}
	public int getq() {
		return q;
	}
	public float getup() {
		return up;
	}
	public void setprt(String prt) {
		this.prt = prt;
	}
	public void setq(int q) {
		this.q = q;
	}
	public void setup(float up) {
		this.up = up;
	}
	public String toString() {
		return prt + " " + q + " " + up;
	}
}
class ShoppingCart {
	Item items1[], items2[];
	int size1, size2, coupon;
	public ShoppingCart() {
		items1 = new Item[20];
		items2 = new Item[20];
		size1 = 0;
		size2 = 0;
		coupon = 0;
	}
	public void item(Item other) {
		items1[size1++] =  other;
	}
	public void catalog() {
		for (int i = 0; i < size1; i++) {
			System.out.println(items1[i]);
		}
	}
	public void add(Item other) {
		items2[size2++] = other;
	}
	public void show() {
		for (int i = 0; i < size2; i++) {
			System.out.println(items2[i].getprt() + " " + items2[i].getq());
		}
	}
	public void remove(Item other) {
		for (int i = 0; i < size2; i++) {
			if (items2[i].getprt().equals(other.getprt()) && items2[i].getq() >= other.getq()) {
				items2[i].setq(items2[i].getq() - other.getq());
				return;
			}
		}
	}
	public float getup(String prt) {
		for (int i = 0; i < size1; i++) {
			if (items1[i].getprt().equals(prt)) {
				return items1[i].getup();
			}
		}
		return 0;
	}
	public float totalAmount() {
		float amount = 0;
		for (int i = 0; i < size2; i++) {
			amount += items2[i].getq() * getup(items2[i].getprt());
		}
		return amount;
	}
	public void setcoupon(String coupon) {
		int n = Integer.parseInt(coupon.substring(4, coupon.length()));
		if (n == 10 || n == 20 || n == 30 || n ==50) {
			this.coupon = n;
		}
	}
	public int getcoupon() {
		return coupon;
	}
	public float payableAmount() {
		float ta = totalAmount();
		float dis = ta * getcoupon() / 100;
		float pa = ta - dis;
		return pa + (pa * 15 / 100);
	}
	public void print() {
		return;
	}

}




public final class Solution {
	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ShoppingCart sct = new ShoppingCart();
		while (n > 0) {
			String tokens = sc.nextLine();
			String[] tokens1 = tokens.split(" ");
			switch (tokens1[0]) {
				case "item":
					String[] tokens2 = tokens1[1].split(",");
					sct.item(new Item(tokens2[0], Integer.parseInt(tokens2[1]), Float.parseFloat(tokens2[2])));
					break;
				case "catalog":
					sct.catalog();
					break;
				case "add":
					String[] tokens3 = tokens1[1].split(",");
					sct.add(new Item(tokens3[0], Integer.parseInt(tokens3[1]), 0.0f));
					break;
				case "show":
					sct.show();
					break;
				case "totalAmount":
					System.out.println("totalAmount: "+sct.totalAmount());
					break;
				case "remove":
					String[] tokens4 = tokens1[1].split(",");
					sct.remove(new Item(tokens4[0], Integer.parseInt(tokens4[1]), 0.0f));
					break;
				case "payableAmount":
					System.out.println("Payable amount: "+sct.payableAmount());
					break;
				case "print":
					sct.print();
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