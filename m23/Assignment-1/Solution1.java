import java.util.Scanner;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.util.Arrays;
class Document {
	private ArrayList<String> words;
	private Hashtable<String, Integer> ht;
	private String docname;
	public Document() {
		words = new ArrayList<String>();
		ht = new Hashtable<String, Integer>();
		docname = "";
	}
	public  String getdocname() {
		return docname;
	}
	public void storeindoc(String foldername, String filename) {
		try {
		
		//sc = new FileInputStream("foldername/filename");
		docname = filename;
		FileInputStream fis = new FileInputStream(foldername + "/" + filename);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String str = br.readLine();
		while (str != null) {
			String[] str1 = str.toLowerCase().replaceAll("[^a-z_0-9 ]", "").trim().split(" ");
			ArrayList<String> line = new ArrayList<String>();
			for (String word: str1) {
				if (word.length() >= 1) {
					line.add(word);
				}
				//System.out.println(word);
			}
			words.addAll(line);
			str = br.readLine();
		}
		//System.out.println(words);
		} catch (Exception e) {
			System.out.println("in store in doc");
		}
	}
	public void cleandoc() {
		try {
		FileInputStream fis = new FileInputStream("F:/recyle bin/MSIT/cspp1/sai/cspp1-practice/m16/CodeCampDocumentDistance/stopwords.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		String str = br.readLine();
		while (str != null) {
			if (words.contains(str)) {
				words.remove(words.indexOf(str));
			}
			str = br.readLine();
		}
		} catch (Exception e) {
			System.out.println("in clean doc");
		}

	}
	public void calculatefreq() {
		for (String str : words) {
			if (ht.containsKey(str)) {
				ht.put(str, ht.get(str) + 1);
			} else {
				ht.put(str, 1);
			}
		}
		//System.out.println(ht.toString());
	}
	public Double denominator() {
		Enumeration <String> keys = ht.keys();
		int denom = 0, d;
		while (keys.hasMoreElements()) {
			d = ht.get(keys.nextElement());
			denom += d * d;
		}
		return Math.sqrt(denom);
	}
	public void result(Document other) {
		int num = 0;
		Enumeration <String> keys = ht.keys();
		while (keys.hasMoreElements()) {
			String str = keys.nextElement();
			if (other.ht.containsKey(str)) {
				num += (this.ht.get(str)) * (other.ht.get(str));
			}
		}
		System.out.print(Math.round((num / (this.denominator() * other.denominator())) * 100));
	}
}
public class Solution {
	ArrayList<Document> docs;
	private Solution() {
		docs = new ArrayList<Document>();
	}
	private void add(Document d) {
		docs.add(d);
	}
	private int size() {
		return docs.size();
	}
	private Document get(int index) {
		return docs.get(index);
	}
	public static void main(String[] args) {
		Solution pg = new Solution();
		Scanner sc = new Scanner(System.in);
		try {
		File foldername = new File(sc.nextLine());
		File[] files = foldername.listFiles();
		//System.out.print("      		");
		String filenames = "";
		for (File file : files) {
			if (file.isFile()) {
				Document d = new Document();
				d.storeindoc(foldername.getName(), file.getName());
				//d.cleandoc();
				d.calculatefreq();
				pg.add(d);
				filenames += file.getName() + "	";
			}
		}
		System.out.println("      		" + filenames.trim());
		for (int i = 0; i < pg.size(); i++) {
			System.out.print(pg.get(i).getdocname() + "	");
			for (int j = 0; j < pg.size(); j++) {
				Document d1 = pg.get(i);
				Document d2 = pg.get(j);
				d1.result(d2);
				System.out.print("		");
			}
			System.out.println();
		}
	} catch (Exception e) {
		System.out.println();
		
	}
	}
}