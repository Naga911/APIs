package Resources;

import io.restassured.RestAssured;
import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public AddPlace addPlacePayload()
    {

        AddPlace place = new AddPlace();
        place.setAccuracy(50);
        place.setAddress("KS Town");
        place.setLanguage("Kannada");
        place.setPhone_number("9986558118");
        place.setWebsite("https://Rahulshettyacademy.com");
        place.setName("nagaraj");
        List<String> mylist = new ArrayList<>();
        mylist.add("shoe park");
        mylist.add("shop");

        place.setTypes(mylist);
        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        place.setLocation(location);
        return place;
    }
}
