package Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.Cluster;
import com.example.management.Hotel;
import com.example.management.HotelRepository;
import com.example.management.StaffRepository;

@Service
public class StaffService {

	@Autowired
	StaffRepository sr;
	
	@Autowired
	HotelRepository hr;
	
	
	
	public String allocate(Long hotel_id)
	{
		double maxi = 100;
		Hotel AllocatedHotel = hr.findOne(hotel_id);
		Cluster c = AllocatedHotel.getCluster();
		Iterable<Hotel> hotels = hr.findBycluster(c); 
		Hotel currentHotel = null;
		//System.out.println(cluster_id);
		//System.out.println(AllocatedHotel.getManager().getManagerName());
		for(Hotel i : hotels){

				System.out.println(i.getHotelId());
	            if((i.getHotelId() != AllocatedHotel.getHotelId()) && ( i.getRatio() < maxi)){

	                currentHotel = i;
	                maxi = i.getRatio();

	            }
	        }
		
		int c_staff= currentHotel.getCurrentStaff();
		currentHotel.setCurrentStaff(c_staff-1);
		hr.save(currentHotel);
		AllocatedHotel.setCurrentStaff(AllocatedHotel.getCurrentStaff()+1);
		hr.save(AllocatedHotel);
		
		
		return "allocated";
	}
	
	//yes
}
