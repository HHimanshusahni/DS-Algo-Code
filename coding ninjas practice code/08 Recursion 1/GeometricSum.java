import java.io.*;
public class GeometricSum{
	public static double findGeometricSum(int k){

		return k==0 ? 1 : (1/Math.pow(2,k))+findGeometricSum(k-1);
	}
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		System.out.println(findGeometricSum(k));
	}
}