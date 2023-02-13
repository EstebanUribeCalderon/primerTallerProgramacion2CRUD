package co.edu.unbosque.view;

import java.util.Scanner;

public class View {
	
private Scanner reader;
	
	public View() {
		reader = new Scanner(System.in);
	}
	
	public String readInfo(String message) {
		String info = "";
		System.out.println(message);
		info = reader.nextLine();
		return info;
	}
	/*public int readInt() {
		int info = 0;
		info = reader.nextInt();
		reader.nextLine();
		return info;
	}
	
	public int readInt(String message) {
		System.out.println(message);
		int info = 0;
		info = reader.nextInt();
		reader.nextLine();
		return info;
	} */
	public void showMessage(String message) {
		System.out.println(message);
	}
	
	
}
