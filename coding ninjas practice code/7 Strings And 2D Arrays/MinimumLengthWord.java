import java.io.*;
public class MinimumLengthWord{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println(minLengthWord_2(str));
	}
	public static String minLengthWord(String input){
		int minCount = Integer.MAX_VALUE;
		int startIndexAns = 0,endIndexAns = 0;
		int tempStartIndex = 0;
		int i ;
		int letterCount;
		for( i = 0;i<input.length();i++){
			if(input.charAt(i)==' '){
			    letterCount= i - tempStartIndex;
				if(letterCount<minCount){
					minCount = letterCount;
					startIndexAns = tempStartIndex;
					endIndexAns = i-1;
				
				}
				tempStartIndex = i+1;
			}
		}
		letterCount = i - tempStartIndex;
		if(letterCount<minCount){
					minCount = letterCount;
					startIndexAns = tempStartIndex;
					endIndexAns = i-1;
		}
		return input.substring(startIndexAns,endIndexAns+1);
	}


		public static String minLengthWord_2(String input){
		int minCount = Integer.MAX_VALUE;
		int startIndexAns = 0,endIndexAns = 0;
		int tempStartIndex = 0;
		for(int i = 0,letterCount = 0;i<input.length();i++){

			if(input.charAt(i)==' '||i==input.length()-1){
				letterCount= i - tempStartIndex;
				if(i==input.length()-1)
					letterCount +=1;
			    
				if(letterCount<minCount){
					minCount = letterCount;
					startIndexAns = tempStartIndex;
					endIndexAns = i-1;
					if(i==input.length()-1)
						endIndexAns =i;
					
				
				}
				tempStartIndex = i+1;
			}
		}
		
		
		return input.substring(startIndexAns,endIndexAns+1);
	}
}