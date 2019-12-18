package com.example.mediapp.Notification;

import com.example.mediapp.Notification.Service.MobileNotificationService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;



@RestController
@CrossOrigin(origins="*",allowedHeaders="*")
public class NotificationController {
	//private final String TOPIC = ;

	  @Autowired
	  MobileNotificationService mobileNotificationService;
	  
	  @RequestMapping(value = "/send", method = RequestMethod.GET, produces = "application/json")
	  public ResponseEntity<String> sendUpcomingEvent(String targetAudi,String eventName,String eventVenue,LocalDate weekDate){
		  System.out.println("notification json");
	    JSONObject body = new JSONObject();
	    System.out.println("notification json");
	    JSONObject notification = new JSONObject();
	    System.out.println("notification json");
	    JSONObject data = new JSONObject();
	    System.out.println("notification try eliye");
	    try {
	   System.out.println("notification try");
			body.put("to", "/topics/" + targetAudi);
			if(weekDate != LocalDate.now().plusDays(1)) {
				notification.put("body", "You have "+eventName+" clinical event at "+eventVenue+" on tomorrow");
			}else {
			notification.put("body", "You have "+eventName+" clinical event at "+eventVenue+" on "+weekDate.toString());}
			data.put("click_action", "FLUTTER_NOTIFICATION_CLICK");
			body.put("notification", notification);
			body.put("data", data);
			notification.put("title","Upcomming Clinical Event");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
	   HttpEntity<String> request = new HttpEntity<>(body.toString());
	 
	    CompletableFuture<String> pushNotification = mobileNotificationService.send(request);
	    CompletableFuture.allOf(pushNotification).join();
	 
	    try {
	      String firebaseResponse = pushNotification.get();
	      
	      return new ResponseEntity<>(firebaseResponse, HttpStatus.OK);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    } catch (ExecutionException e) {
	      e.printStackTrace();
	    }
	 
	    return new ResponseEntity<>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
	  }
}

