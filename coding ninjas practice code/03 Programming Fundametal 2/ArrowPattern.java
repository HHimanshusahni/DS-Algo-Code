import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class ArrowPattern {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i =1;i<=N;i++){
			if(i<=(N/2)+1){
				//print spaces
				for (int j = 1;j<=i-1;j++){
					System.out.print(" ");
				}
				//print stars
				for(int j = 1;j<=i;j++){
					System.out.print("* ");
				}	

			}else{
				//print spaces
				for (int j = 1;j<=N-i;j++){
					System.out.print(" ");
				}
				//print stars
				for(int j = 1;j<=N-i+1;j++){
					System.out.print("* ");
				}
			}

			System.out.println("");
		}

	}
}