package Services;



import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.Cluster;
import com.example.management.Hotel;
import com.example.management.HotelRepository;
import com.example.management.Staff;
import com.example.management.StaffRepository;

@Service
public class StaffService {

	@Autowired
	StaffRepository sr;
	
	@Autowired
	HotelRepository hr;
	
	
	
	public String allocate(Long hotel_id)
	{
		Hotel AllocatedHotel = hr.findOne(hotel_id);
		Cluster c = AllocatedHotel.getCluster();
		Long cluster_id = c.getClusterId();
		Iterable<Hotel> hotels = hr.findBycluster(c); 
		System.out.println(cluster_id);
		System.out.println(AllocatedHotel.getManager().getManagerName());
		
		
		return "allocated";
	}
	
	
}
