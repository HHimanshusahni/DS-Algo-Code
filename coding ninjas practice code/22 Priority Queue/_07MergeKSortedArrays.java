import java.util.*;
class Triplet{
	Integer value;
	int arrayListNo;
	int index;
	Triplet(int value,int arrayListNo,int index){
		this.value = value;
		this.arrayListNo = arrayListNo;
		this.index = index;
	}
}
class MyComparator implements Comparator{
	public  int compare(Object obj1 , Object obj2){
		Triplet t1 = (Triplet)obj1;
		Triplet t2 = (Triplet)obj2;
		Integer value1 = t1.value;
		Integer value2 = t2.value;
		return value1.compareTo(value2);
	}
}
public class _07MergeKSortedArrays{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {
		ArrayList<Integer> ans = new ArrayList<>();
		MyComparator comparator = new MyComparator();
		PriorityQueue<Triplet> pq = new PriorityQueue<>(comparator);
		for(int i = 0 ; i<input.size() ;i++){
			Triplet t = new Triplet(input.get(i).get(0),i,0);
			pq.offer(t);
		}
		while(!pq.isEmpty()) {
			Triplet t = pq.poll();
			int listNo = t.arrayListNo;
			int index = t.index;
			if( index +1 < input.get(listNo).size()){
				Triplet t1= new Triplet(input.get(t.arrayListNo).get(index + 1),
										listNo,
										index +1);
				pq.offer(t1);
			}
			ans.add(t.value);
		}
		return ans;
	}

	public static void main(String[]args){
		Scanner s = new Scanner(System.in);
		int K = s.nextInt();
		ArrayList< ArrayList<Integer> > input = new ArrayList<>(K);
		for(int i = 0 ;i<K ;i++){
			int n  =  s.nextInt();
			ArrayList<Integer> list = new ArrayList<>(n);
			for(int j = 0;j<n;j++)
				list.add(s.nextInt());
			input.add(list);
		}
		ArrayList<Integer> ans = mergeKSortedArrays(input);
		for(int a : ans)
			System.out.print(a+" ");
	}
}