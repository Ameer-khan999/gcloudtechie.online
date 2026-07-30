package tfTest;
import java.lang.String;

public class IRUtil {
	static String term,doc;
	public static int getFrequencyCount(String term, String doc) {
		System.out.println(term.toLowerCase());
		System.out.println(doc.toLowerCase());
		int frequencyCount=0;
		int index=doc.indexOf(term);
		if(index>=0) {
			frequencyCount++;
		}
		else {
			return frequencyCount;
		}
		
	}

    public static double termFrequency(String term, String doc) {

        double frequencyCount = getFrequencyCount(term, doc);

        double totalTermCount=totalTermCount + frequencyCount; //doc.split(""); 
        //Hint: You can use split() with white-space " " as delimiter
        return frequencyCount / totalTermCount;

        //return frequencyCount / totalTermCount. This is the tf formula.
    }
	public static void main(String[] args) {
		getFrequencyCount("JAVA","Intro to PYTHON");
		
	}
}