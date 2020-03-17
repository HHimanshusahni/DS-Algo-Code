import java.io.*;
public class AllStringsOfLengthk {
	
	public static String[] allStrings(String charSet, int len){
		lic static String[] allStrings(String charSet, int len){
		//Base Case
		if(len == 0){
			 String[] strArr = new String[1];
             strArr[0] = "";
			 return strArr;
		}
		//Recursive Case
		String[] smallAns = allStrings(charSet,len-1);

		//Small Calculation
		String[] ans = new String[smallAns.length * charSet.length()]; 
		for(int i = 0 ,counter = 0;i<charSet.length();i++)
			for(int j = 0 ;j<smallAns.length;j++)
				ans[counter++] = charSet.charAt(i)+smallAns[j];
			
		return ans;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int len = Integer.parseInt(br.readLine());
		String ans[] = allStrings(s,len);
		for(String a : ans){
			System.out.println(a);
		}
	}

}