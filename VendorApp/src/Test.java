

import org.codehaus.jackson.map.ObjectMapper;

import com.app.model.Location;


public class Test {

	public static void main1(String[] args) {
		
		Location loc=new Location();
		loc.setLocId(100);
		loc.setLocName("AA");
		loc.setLocType("Urban");
		
		try {
			//create obj to ObjectMapper
			ObjectMapper om=new ObjectMapper();
			
			//Obj->JSON
			String json=om.writeValueAsString(loc);
			System.out.println(json);
		} catch (Exception e) {
		}
		
		
	}
	
	
	public static void main(String[] args) {
		String json="{\"locId\":55,\"locName\":\"AA\",\"locType\":\"Rural\"}";
		
		try {
			ObjectMapper om=new ObjectMapper();
			
			Location loc=om.readValue(json, Location.class);
			System.out.println(loc);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
