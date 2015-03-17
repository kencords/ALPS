package others;

public class Util {
	public static String toString(char[] sequence){
		String str = "";
		for(char c : sequence)
			str+=c;
		return str;
	}

	public static String insertBackSlash(String str) {
		String result = "";
		for(int i = 0; i < str.length(); result+=str.charAt(i++))
			if(!Character.isLetterOrDigit(str.charAt(i)))	// if the character is not a letter or a number
				result+="\\";
		return result;
	}
}
