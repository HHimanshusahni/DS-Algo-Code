import java.util.ArrayList;
public class _02MaxPriorityQueue{
	private ArrayList<Integer> heap;
	public  _02MaxPriorityQueue(){
		heap = new  ArrayList<>();
	}
	//Return no of elements present  in  the priority Queue
	public int getSize(){ 
		return heap.size();
	}
	//Check if the priority queue is empty or not
	public boolean isEmpty(){
		return heap.size() == 0 ;
	}
	//Time Complexity O(log n)
	public  void insert(int element){
		heap.add(element);
		if(heap.size() == 1)
			return;
		int childIndex = heap.size() -1 ;
		int parentIndex  = (childIndex - 1 )/2;
		while(parentIndex >= 0 && heap.get(childIndex) > heap.get(parentIndex)){
			int temp = heap.get(childIndex);
			heap.set(childIndex,heap.get(parentIndex));
			heap.set(parentIndex,temp);
			childIndex = parentIndex;
			parentIndex  = (childIndex - 1 )/2;
		}
	}
	//Returns the maximum element of the priority queue in O(1) time
	public int getMax(){
		if(heap.size() == 0)
			return Integer.MIN_VALUE;
		else
			return heap.get(0);
	}
	//Time Complexity O(log n)
	public int removeMax() {
		if(heap.size() == 0 )
			return Integer.MIN_VALUE;
		int elem  = heap.get(0);
		heap.set(0 , heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		downHeapify(0);
		return elem;
	}
	public void  downHeapify(int parentIndex){
		if(heap.size() == 1)
			return;
		int leftChildIndex , rightChildIndex ;
		int leftChild , rightChild,parentValue;
		while(parentIndex < heap.size()){
			leftChild  = rightChild  = Integer.MIN_VALUE;
			parentValue = heap.get(parentIndex);
		    leftChildIndex = 2 * parentIndex + 1; 
		    rightChildIndex = 2 * parentIndex + 2;
			if(leftChildIndex < heap.size())
				leftChild  = heap.get(leftChildIndex);
			if(rightChildIndex <  heap.size())
				rightChild  = heap.get(rightChildIndex);
			if(parentValue > leftChild && parentValue > rightChild){
				return ;
			}else if(leftChild > rightChild){
				heap.set(leftChildIndex , parentValue);
				heap.set(parentIndex ,leftChild );
				parentIndex = leftChildIndex;
			}else{
				heap.set(rightChildIndex, parentValue);
				heap.set(parentIndex, rightChild);
				parentIndex = rightChildIndex;
			}

		}

	}
	public  static void main(String[]args) {
		_02MaxPriorityQueue pq = new _02MaxPriorityQueue();
		int arr[ ] = { 11 , 2 , 1 , 7,10, 8 ,  9,};
		for(int i = 0 ;i< arr.length;i++){
			pq.insert(arr[i]);
		}
		for(int i : pq.heap)
			System.out.print(i+" ");
		System.out.println();
		while(!pq.isEmpty()){
			System.out.print(pq.removeMax()+" ");
		}
	}
}