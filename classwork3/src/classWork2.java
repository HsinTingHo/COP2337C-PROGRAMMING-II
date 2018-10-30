import java.util.Arrays;
public class classWork2 {
	public static void main(String args[]){
		//testing
		stringStats("helllo123");
		System.out.println(checkSubstringV2("helllo123", "l"));
		System.out.println(checkSubstringV3("helllo123", "l"));
	
	
	}
	
	//Make a void method named StringStats(String)
	//print % of digits
	//print % of letters
	//print % of others
	
	public static void stringStats(String str) {
		int len = str.length();
		double digLen = 0.0, letLen = 0.0, othLen = 0.0;
		//int digR = 0, letR = 0, othR = 0;
		String[] strArray = str.split("");
		
		for(String s: strArray) {
			// count digits
			if(s.matches("\\d")) {
				digLen += 1;				
			}
			// count letters
			else if(s.matches("[a-zA-Z]")) {
				letLen += 1;
			}
			// count  others
			else {
				othLen += 1;
			}
		}
		
		String digR = String.format("%.0f", (digLen/len)*100);
		String letR = String.format("%.0f", (letLen/len)*100);
		String othR = String.format("%.0f", (othLen/len)*100);
		System.out.println("% of digits:  "+digR+ "%");
		System.out.println("% of letters: "+letR+ "%");
		System.out.println("% of others:  "+othR+ "%");
	}
	
	//Make a boolean method CheckSubstringV1(string paragraph, string substring)
	//The second string is a word that you should check if exists in the first string 
	//by returning the corresponding Boolean value
	public static boolean checkSubstringV1(String paragraph, String substring) {
		boolean result = false;
		result = paragraph.contains(substring);
		return result;
	}
	
	//int method CheckSubstringV2
	//returns the number of times that the substring exists in the first string.
	public static int checkSubstringV2(String paragraph, String substring) {
		int result = 0;
		String[] arr = paragraph.split(substring);
		result = arr.length -1;
		return result;
	}
	
	//String method CheckSubstringV3
	//returns a copy of the first string with the all the letters capitalized.
	public static String checkSubstringV3(String paragraph, String substring) {
		String result ="";
		result = paragraph.toUpperCase();
		return result;
	}
}
