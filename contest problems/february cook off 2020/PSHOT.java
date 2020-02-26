import java.io.*;
public class PSHOT{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int i = 0;i<testCase;i++){
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			String strArr[] = str.split("");
			int input[] = new int[2*N];
			for(int j=0;j<2*N;j++)
				input[j] = Integer.parseInt(strArr[j]);
			int s = findWinningShot(N,input);
			System.out.println(s);
		}
	}
	static int findWinningShot(int N ,int input[]){	
			
		    int WinA=0 ,WinB=0;
			for(int i=0;i<2*N;i++){
				if(i%2==0){
					if(input[i]==1)
						WinA++;
					int diffA = WinA-WinB;
					int turnsRemainingA = (2*N-i)/2;
					if(diffA>turnsRemainingA){
						return i+1;
				    }
				}else{
					if(input[i]==1)
						WinB++;
					int diffB = WinB-WinA;
					int turnsRemainingB = (2*N-i)/2;
					if(diffB>turnsRemainingB){
						return i+1;
				    }
				}
				
				
			}
			return 2*N-1;
		
	}
}