import java.io.*;
public class TowerOfHanoi{
	public static void towerOfHanoi(int disks,char source, char auxiliary,char destination){
		// base case
		if(disks==0)
			return;
		// recursive step
		towerOfHanoi(disks-1,source,destination,auxiliary);

		// our work
		System.out.println(source+" "+destination);

		//recursive step
		towerOfHanoi(disks-1,auxiliary,source,destination);
	}
	public static void main(String[]args) throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		towerOfHanoi(Integer.parseInt(br.readLine()),'a','b','c');
	}
}