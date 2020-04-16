import java.util.ArrayList;
class PriorityQueueException extends Exception{
	
}
public class _00MinPriorityQueue{
	 ArrayList<Integer> heap;
	
	public _00MinPriorityQueue(){
		heap = new ArrayList<>();
	}
	public boolean isEmpty(){
		return heap.size() == 0;	
	}
	public void insert(int element){ //Time Complexity = O(log(n))
		heap.add(element);
		if(heap.size() == 1) // As the single element always forms the heap
			return;

		int  Ci = heap.size() - 1;
		int Pi = (Ci - 1)/2;
		while((Pi >= 0) && (heap.get(Pi) > heap.get(Ci)) ){
			//Swap elements
			int temp = heap.get(Pi);
			heap.set(Pi,heap.get(Ci));
			heap.set(Ci,temp);
			Ci = Pi;
			Pi = (Ci - 1)/2;
		}
		
	}
	public int getMin() throws PriorityQueueException{ // Time complexity: O(1)
		if(heap.size() == 0)
			throw new PriorityQueueException();
		return heap.get(0);
	}
	public int removeMin() throws PriorityQueueException{ //Time Complexity : O(log n )
		if(heap.size() == 0)
			throw new PriorityQueueException();
		int minElement = heap.get(0);
		int  lastElementIndex = heap.size() -1;
		if(heap.size() == 1){
			heap.remove(lastElementIndex);
			return minElement;
		}
		heap.set(0,heap.get(lastElementIndex));
		heap.remove(lastElementIndex);
		downHeapify_Iterative();
		return 	minElement;
	}
	public void downHeapify(int Pi){ //Time Complexity : O (log (n)) Recursive Appraoch
		//Base Case 
 		int leftChildIndex = (2* Pi) + 1;
 		int rightChildIndex = (2* Pi )+ 2;
 		int leftValue = Integer.MAX_VALUE,rightValue = Integer.MAX_VALUE, parentValue = heap.get(Pi);
 		if(leftChildIndex < heap.size())
 			leftValue  = heap.get(leftChildIndex);
 		if(rightChildIndex < heap.size())
 			rightValue = heap.get(rightChildIndex);

 		if(parentValue < leftValue && parentValue < rightValue )
 			return;
 		else if(leftValue < rightValue){
 			heap.set(Pi,leftValue);
 			heap.set(leftChildIndex,parentValue);
 			downHeapify(leftChildIndex);
 		}else{
 			heap.set(Pi,rightValue);
 			heap.set(rightChildIndex,parentValue);
 			downHeapify(rightChildIndex);
 		}
 		return;
	}
	public void downHeapify_Iterative(){ //Time Complexity : O (log (n)) 
		//Base Case 
		int Pi = 0;
		while(true){
			int leftChildIndex = (2* Pi) + 1;
	 		int rightChildIndex = (2* Pi )+ 2;
	 		int leftValue = Integer.MAX_VALUE,rightValue = Integer.MAX_VALUE, parentValue = heap.get(Pi);
	 		if(leftChildIndex < heap.size())
	 			leftValue  = heap.get(leftChildIndex);
	 		if(rightChildIndex < heap.size())
	 			rightValue = heap.get(rightChildIndex);

	 		if(parentValue < leftValue && parentValue < rightValue )
	 			return;
	 		else if(leftValue < rightValue){
	 			heap.set(Pi,leftValue);
	 			heap.set(leftChildIndex,parentValue);
	 			Pi = leftChildIndex;
	 		}else{
	 			heap.set(Pi,rightValue);
	 			heap.set(rightChildIndex,parentValue);
	 			Pi = rightChildIndex;
	 		}
 		}
 		
	}
	public int size(){
		return  heap.size();
	}

	public static void main(String[]args)  throws PriorityQueueException{
		_00MinPriorityQueue minQ = new _00MinPriorityQueue();
		int arr[ ] = { 11 , 2 , 1 , 7,10, 8 ,  9,};
		for(int i = 0 ;i< arr.length;i++){
			minQ.insert(arr[i]);
		}
		for(int i : minQ.heap)
			System.out.print(i+" ");
		System.out.println();
		while(!minQ.isEmpty()){
			System.out.print(minQ.removeMin()+" ");
		}
	}
}