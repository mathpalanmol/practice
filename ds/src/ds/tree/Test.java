package ds.tree;

import java.io.IOException;
import java.io.PrintWriter;

public class Test {

	public static void main(String[] args) throws IOException {
		int[] ary = { 1, 2, 3, 4, 5 };
		
//		new FileOutputStream("/home/anmol/Desktop/dummy","UTF-8");
		PrintWriter fw =new java.io.PrintWriter(new java.io.File("/home/anmol/Desktop/dummy"), "UTF-8");
        fw.write(new Integer(1).toString());
        fw.write(new Integer(2).toString());
        fw.close();
	}

}
