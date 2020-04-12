public class MapUse{
	public static void main(String[]args){
		Map<Integer,Integer> map = new Map<>();
		int arr[] = {1,2,20,30,40,40,10};
		System.out.println("Before insertion map size"+map.size());
		for(int i = 0; i < arr.length;i++){
			map.insert(arr[i],i);
		}
		System.out.println("after insertion map size"+map.size());
		System.out.println(map.removeKey(10));
		System.out.println(map.removeKey(1));
		for(int i = 0; i < arr.length;i++){
			System.out.println(map.getValue(arr[i]));
		}
		System.out.println(map.removeKey(40));
		System.out.println(map.removeKey(40));

	}
}