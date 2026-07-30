package tfTest;

public class iRUtil {
	public static int getFrequencyCount(String term, String doc) {
		term=term.toLowewrCase();
		doc=doc.toLowerCase();
	}
	public static void main(String[] args) {
		getFrequencyCount("JAVA","PYTHON");
		System.out.println(term);
		
	}
}