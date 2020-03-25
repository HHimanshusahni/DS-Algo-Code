//Reverse Queue Without using any queue or stack
//Using the _03QueueUsingLinkedList methods

public class _05ReverseQueue{
	public static void reverseQueue(Queue<Integer> q) throws Exception{
		//Base case 
		if(q.size() <= 1)
			return;
		int element = q.dequeue();
		//Recursive Case
		reverseQueue(q);

		//Small Calculation
		q.enqueue(element);

	}
	public static void main(String[] args) throws Exception{
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		reverseQueue(q);
		System.out.println(q.size());
		while(!q.isEmpty()){
			System.out.print(q.dequeue());
		}
	}
}