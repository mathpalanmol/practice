package ds.tree.sufix;


public class Demo
{
	public static void main(String [] args)
	{
		SuffixTree meinBaum = new SuffixTree();
		meinBaum.insert("anmol$");
		
		// for graphviz
		meinBaum.printDotCode ();
		System.out.println();
		
		meinBaum.minimalUniqueSubstring ();
		System.out.println();
		
//		meinBaum.maximalRepeats("anmol$");
	}
}