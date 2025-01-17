package stepDefinations;
import java.io.IOException;

import io.cucumber.java.Before;
import resources.utils;

public class Hooks  {
	@Before("@DeletePlaceAPI")
	public void beforeScenarios() throws IOException
	{
		
		stepDefinations sd=new stepDefinations();
		if(stepDefinations.place_id==null) {
		sd.add_place_payload("Name", "Address", "Language");
		sd.when_user_calls_with_http_request("AddPlaceAPI", "POST");
		sd.validate_after_user_calls_http_request_is_correct("Name", "GetPlaceAPI");
		}
		
	}

}
