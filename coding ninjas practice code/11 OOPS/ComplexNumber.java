import java.io.*;
public class ComplexNumber{
	int R;
	int I;
	ComplexNumber(int R, int I){
		 this.R = R;
	     this.I = I;
	}
	public static void plus(ComplexNumber c1 ,ComplexNumber c2){
		c1.R = c1.R + c2.R;
		c1.I = c1.I + c2.I;

	}
	public static void multiply(ComplexNumber c1 ,ComplexNumber c2){
		int r = (c1.R * c2.R)-(c1.I * c2.I);
		int i = (c1.I * c2.R) +(c1.R * c2.I);
		c1.R = r;
		c1.I = i;
	}
	public static void print(ComplexNumber c1){
		System.out.println(c1.R+" + i"+c1.I);
	}
	public static void main(String[]args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strArr[] = br.readLine().split(" ");
		int r =Integer.parseInt(strArr[0]);
		int i = Integer.parseInt(strArr[1]);
		ComplexNumber c1 = new ComplexNumber(r,i);
		strArr = br.readLine().split(" ");
		r =Integer.parseInt(strArr[0]);
	    i = Integer.parseInt(strArr[1]);
		ComplexNumber c2 = new ComplexNumber(r,i);
		int choice = Integer.parseInt(br.readLine());
		if(choice == 1)
			plus(c1,c2);
		else if(choice == 2)
			multiply(c1,c2);
		print(c1);

	}
}