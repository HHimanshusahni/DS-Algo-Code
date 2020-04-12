import java.util.ArrayList;
public class Map<K,V>{
	ArrayList<MapNode<K,V>> buckets;
	int size;
	int numBuckets;
	public Map(){ //Constructor
		numBuckets = 20;
		buckets = new ArrayList<>();
		for(int i = 0;i<20;i++){
			buckets.add(null);
		}
	}
	private int getBucketIndex(K key){
		int hashCode = key.hashCode(); // Object class has it's hashcode implementation
		return hashCode % numBuckets;
	}
	public void insert(K key, V value){
		int bucketIndex = getBucketIndex(key);
		MapNode<K,V> head = buckets.get(bucketIndex);
		while(head != null){ // It is checking wheather the key is already present
			if(head.key.equals(key)){
				head.value = value;
				return;
			}
			head = head.next;
		}
		//Now head is pointing to null update it
		head = buckets.get(bucketIndex);
		MapNode<K,V> newElementNode = new MapNode<K,V>(key,value);
		size++;
		newElementNode.next = head;
		buckets.set(bucketIndex,newElementNode);
	}
	public int size(){
		return size;
	}
	public V removeKey( K key){
		int bucketIndex = getBucketIndex(key);
		MapNode<K,V> head = buckets.get(bucketIndex);
		MapNode<K,V> prev = null;
		while(head != null){
			if(head.key.equals(key)){
				size--;
				if(prev == null){
					buckets.set(bucketIndex,head.next); //If only one node is present
				}else{
					prev.next = head.next;
				}
				return head.value;
			}
			prev = head;
			head = head.next;
		}
		return null;// as element is not present
	}
	public V getValue(K key){
		int bucketIndex = getBucketIndex(key);
		MapNode<K,V> head = buckets.get(bucketIndex);
		while(head != null){
			if(head.key.equals(key)){
				return head.value;
			}
			 head = head.next;
		}
		return null;
	}
}