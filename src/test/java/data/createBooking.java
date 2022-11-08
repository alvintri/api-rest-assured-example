package data;

import org.json.simple.JSONObject;

import java.util.Random;

public class createBooking {

    Random rand = new Random();

    public JSONObject bookingPayload(){
        JSONObject bookingsdates = new JSONObject();

        bookingsdates.put("checkin","2022-09-10");
        bookingsdates.put("checkout","2022-10-10");

        JSONObject data = new JSONObject();
        data.put("firstname", "Sally");
        data.put("lastname", "Brown");
        data.put("totalprice", rand.nextInt(100000));
        data.put("depositpaid",true);
        data.put("bookingdates",bookingsdates);
        data.put("additionalneeds","Breakfast");

        return data;
    }
}
