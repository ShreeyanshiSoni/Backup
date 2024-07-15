package resources;

import java.util.ArrayList;
import java.util.List;

import POJO.Google_Maps_Add;
import POJO.location;

public class TestDataBuild {
	
	public Google_Maps_Add add_place_payload(String Name,String Address,String Language) {
		Google_Maps_Add gma=new Google_Maps_Add();
		
		//setting value to all variable using that object
		gma.setAccuracy(50);
		gma.setName(Name);
		gma.setPhone_number("(+91)9838933937");
		gma.setAddress(Address);
		gma.setWebsite("http://google.com");
		gma.setLanguage(Language);
		
		//setting value to a list type variable
		List<String> l=new ArrayList<String>();
		l.add("shoe park");
		l.add("shop");
		gma.setTypes(l);
		
		//setting values to variable having sub JSON
		location lo=new location();
		lo.setLat("67");
		lo.setLng("88");
		gma.setLocation(lo);
		return gma;

	}
	public String deleteAPI_payload(String place_id) {
		
		return "{\r\n    \"place_id\": \""+place_id+"\"\r\n}";
		
	}
	

}


