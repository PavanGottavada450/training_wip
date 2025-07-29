package Day8;

import java.util.HashMap;
import java.util.Map;
public class Collection_map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> mapData = new HashMap<String, Integer>();
		
		mapData.put("A", 68);
		mapData.put("B", 69);
		mapData.put("C", 65);
		mapData.put("D", 66);
		
		System.out.println(mapData.keySet());
		System.out.println(mapData.values());
		
		System.out.println(mapData);

		
		for(String i:mapData.keySet()) {
			System.out.println(i + ":" + mapData.get(i));
		}
		
	}

}