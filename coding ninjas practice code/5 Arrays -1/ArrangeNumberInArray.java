import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class ArrangeNumberInArray{
	public static void main(String[] args )throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Solver solver = new Solver();
		int arr[] = solver.solve(N);
		for(int i = 0;i<N;i++)
			System.out.print(arr[i]+" ");
	}

}
class Solver{
	public static int[] solve(int N){
		final int arr[] = new int[N];
		int i = 0,j = N-1,value = 1;
		boolean flag = true;
		while(value<=N){
			if(flag)
			   arr[i++] =value;
			else
			   arr[j--] =value;
			flag = !flag;
			value++;
		}
		return arr;


	}
}