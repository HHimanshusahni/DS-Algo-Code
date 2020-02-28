import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class LastIndexOfNumberInArray{
	
	public static int lastIndex(int input[], int x) {
		return lastIndex(input,x,input.length-1);
	}
	public static int lastIndex(int input[],int x, int index){
		if(index<0)
			return -1;
		return input[index] == x ? index : lastIndex(input,x,index-1); 
	}

	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		int input[] = new int[n];
		String arr[] = br.readLine().split(" ");
		int i = 0;
		for(String str : arr){
			input[i] = Integer.parseInt(str);
			i++;
		}
		int x = Integer.parseInt(br.readLine());
		System.out.println(lastIndex(input,x));
	}
}