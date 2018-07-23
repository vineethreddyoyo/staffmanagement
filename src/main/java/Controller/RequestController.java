package Controller;

import Services.RequestService;
import Services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.management.Request;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class RequestController {

    @Autowired
    RequestService requestService;

    
    @RequestMapping("/incoming_requests/{hotel_id}")
    public List<Request> incomingRequests(@PathVariable  Long hotel_id){

        return requestService.incomingRequests(hotel_id);
    	//return null;

    }

    @RequestMapping("/request_staff/{hotel_id}/{n_staff}")
    public String requestStaff(@PathVariable("hotel_id") int hotel_id, @PathVariable("n_staff") int n_staff){        
        
    	return requestService.requestStaff(hotel_id,n_staff);
    	//return "ok";
      
    }

}
