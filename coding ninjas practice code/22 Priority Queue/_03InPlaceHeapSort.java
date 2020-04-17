public class _03InPlaceHeapSort{
	//Total time complexity : O(n log n ) with Space : O(1)
	public static void inplaceHeapSort(int arr[]) {
		buildMinHeap(arr);//O(n log n )
		sortMinHeap(arr);// O(nlog n )
	}
	//Time Complexity : O(n log n )
	public static void buildMinHeap(int arr[]){
		for(int i = 1 ;i<arr.length;i++){
			upwardHeapify(i, arr);
		}
	}
	public static void upwardHeapify(int ci , int arr[]){
		int pi = (ci - 1)/2;
		//Note: When we reach the pi = 0 the ci will be calculated as ci = (0-1)/2 = 0
		//The loop breaks as we compare the root element with root element
		while(pi >= 0 && arr[pi] > arr[ci] ){
			//swap
			int temp = arr[pi];
			arr[pi] = arr[ci];
			arr[ci] = temp;

			ci = pi;
			pi = (ci - 1)/2;
		}
	}
	//Time Complexity : O(n log n )
	public static void sortMinHeap(int minHeap[]){
		int heapSize = minHeap.length;
		int lastIndex = minHeap.length - 1;
		while(heapSize != 0){
			int minElement = minHeap[0];
			//Swap
			minHeap[0] = minHeap[lastIndex];
			minHeap[lastIndex] = minElement;
			lastIndex--;
			heapSize--;
			downHeapify(minHeap,heapSize);//Time O(log n)
		}
	}
	public static void  downHeapify(int minHeap[],int heapSize){
		int pi = 0;
		while(true){
			int p = minHeap[pi];
			int lci = 2 * pi + 1;
			int rci = 2 * pi + 2;
			int lc = Integer.MAX_VALUE,rc = Integer.MAX_VALUE;
			if(lci < heapSize)
				lc = minHeap[lci];
			if(rci < heapSize)
				rc = minHeap[rci];
			if( p < lc && p < rc)
				return;
			else if( lc < rc){
				//swap left child  with parent
				minHeap[pi] = lc;
				minHeap[lci] = p;
				pi = lci;
			}else{
				//swap right child with parent
				minHeap[pi] = rc;
				minHeap[rci] = p;
				pi = rci;
			}
		}
	}
	public static void main(String[]args){
		int arr[] = {8,2,9,1,6,4};
		inplaceHeapSort(arr);
		for(int i = 0; i < arr.length ; i++){
			System.out.print(arr[i]+" ");
		}
	}
}