package Services;
import com.example.management.HotelRepository;
import com.example.management.RequestRepository;
import com.example.management.Request;
import com.example.management.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    HotelRepository hotelRepository;

    //float minRatio = 3;

    
    public  List<Request> incomingRequests(Long hotel_id) {
        Hotel current_hotel = hotelRepository.findOne(hotel_id);
     
        	List<Request> lis = requestRepository.findAll();
        	List<Request> retlis = new ArrayList<>();
        	for(Request i : lis) {
        		Hotel ht = hotelRepository.findOne(i.getHotelId());
        		//System.out.println(ht.getRatio());
        		//System.out.println(current_hotel.getRatio());
        		if( current_hotel.getRatio()<= ht.getRatio() && i.getHotelId()!=hotel_id && current_hotel.getCluster().getClusterId() == ht.getCluster().getClusterId())
        			retlis.add(i);
        			
        	} 
        	
        	return retlis;

    }

    public String requestStaff(int hotel_id,int n_staff){
    	
    	if(n_staff==0)
    		return "Request not Processed, as you have not selected any";
    	
    	List<Request> s = requestRepository.findByhotelId((long) hotel_id);
    	
    	if(!s.isEmpty() && s!=null) { 
    		for(Request i : s) {
    			i.setN_staff(n_staff);
    			requestRepository.save(i);
    			return "Request Updated";
    		}
    		
    		}
        Request r = new Request();
        r.setHotelId((long) hotel_id);
        r.setN_staff(n_staff);        
        requestRepository.save(r);
        return "Request Processed";

    }


}
