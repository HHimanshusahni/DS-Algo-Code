import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.String;
public class ReplaceCharacter{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char c1 = br.readLine().charAt(0);
		char c2= br.readLine().charAt(0);
		Solver solver = new Solver();
	    // System.out.println(solver.replaceCharacter(str,c1,c2));
		// System.out.println(solver.replaceCharacterBetter(str,c1,c2));
		System.out.println(solver.replaceCharacterBest(str,c1,c2));
		br.close();
	}

}
class Solver{
	String replaceCharacter(String input,char c1,char c2){
		for(int i =0;i<input.length();i++){
			int c = input.charAt(i);
			if(c==c1){
				input = input.substring(0,i)+c2+input.substring(i+1);// important point this will  not give index out of bound
			}														 // bcoz if beginindex ==String.length() then it returns
																	// empty string 
		}
		return input;
	}
	String replaceCharacterBetter(String input,char c1,char c2){
		String str = "";
		for(int i = 0;i<input.length();i++){
			char c = input.charAt(i);
			if(c==c1)
				str = str+c2;
			else
				str = str+c;
		}
		return str;
	}
	//inBuiltMethod Approach
	String replaceCharacterBest(String input,char c1,char c2){
		return input.replace(c1,c2);
	}
}