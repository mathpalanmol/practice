package writerReader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteRead {
    
	public static void main(String[] args) throws IOException {
		String fileName = "/home/anmol/test";
		write(fileName);
		read(fileName);

	}

	private static void read(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}

	private static void write(String fileName) throws IOException {
		FileWriter writer = new FileWriter(fileName);
		BufferedWriter bwriter = new BufferedWriter(writer);
		bwriter.write("HI, welcome to hello world. ");
		bwriter.write("Please read below content.");
		bwriter.newLine();
		bwriter.write("hello");
		bwriter.flush();
		writer.close();
		
	}
	

}
