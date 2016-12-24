import Map.*;
public class Main {

	public static void main(String[] args) {
		IterableMap map= new IterableMap();
		map.put("test1", "git");
		map.put("test2", "good");
		map.put("test3", "or");
		map.put("test4", "git");
		map.put("test5", "rekt");
		map.put("test2", "gud");
		map.goToFirst();
		System.out.println("Map values:");
		do {
			System.out.println((String)map.get());
		} while (map.next());
		System.out.println();
		
		map.goToLast();
		System.out.println("Reversed Map:");
		do {
			System.out.println((String)map.get());
		} while (map.previous());
	}

}
