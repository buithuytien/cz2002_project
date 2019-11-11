package util;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TextDB {
	public static final String PATH="./db/";
	public static final String SEPERATOR="|";
	public static final String INDENT="\t\t\t";
	
	public static ArrayList read(String filePath) throws IOException {
		ArrayList<String> data = new ArrayList();
		Scanner scanner = new Scanner(new FileInputStream(PATH+filePath));
		
		try {
			while (scanner.hasNextLine()) {
				data.add(scanner.nextLine());
			}
		} finally {
			scanner.close();
		}
		
		return data;
	}
	
	public static void write(String filePath, ArrayList data) throws IOException {
		PrintWriter out = new PrintWriter(new FileWriter(PATH+filePath));
		
		try {
			for (int i=0; i < data.size(); i++) {
				out.println((String)data.get(i));
			}
		} finally {
			out.close();
		}
	}
}
