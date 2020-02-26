import java.io.*;
public class TaxSlab{
	public static void main(String [] args)throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++){
			int totalIncome = Integer.parseInt(br.readLine());
			int netIncome = incomeCalc(totalIncome);
			
			System.out.println(netIncome);
		}
	}
	static int incomeCalc(int totalIncome){
			int tax = 0;
			 if(totalIncome>=250001 ){
			 	if(totalIncome>=500001)
				 tax = (int)(0.05 *(500000-250000));
				else
				 tax = (int )(0.05*(totalIncome-250000));
			}
			if(totalIncome>=500001){
			 	if(totalIncome>=750001)
				 tax += (int)(0.10* (750000-500000));
				else
				 tax += (int )(0.10*(totalIncome-500000));
				
			}
			 if(totalIncome>=750001){
			 	if(totalIncome>=1000001)
				 tax += (int)(0.15*(1000000-750000));
				else
				  tax += (int )(0.15*(totalIncome-750000));
			}
			 if(totalIncome>=1000001 ){
			 	if(totalIncome>=1250001)
			 	 tax += (int)(0.20*(1250000-1000000));
			 	else
				 tax += (int)(0.20*( totalIncome-1000000));
			} if(totalIncome>=1250000 ){
			 	if(totalIncome>=1500001)
			 	 tax += (int)(0.25*(1500000-1250000));
			 	else
				 tax += (int)(0.25* (totalIncome-1250000));
			}
			if(totalIncome>=1500001 ){
			 	
				 tax += (int)(0.30* (totalIncome-1500000));
			}
			
			
			int netIncome = totalIncome - tax;
			return netIncome;
	}
}