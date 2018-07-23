package Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.ClusterRepository;
import com.example.management.Hotel;
import com.example.management.HotelDetails;
import com.example.management.HotelRepository;


@Service
public class HotelService {

	@Autowired
	HotelRepository hr;
	
	@Autowired
	ClusterRepository cr;
	
	
	public String insert_hotel() {
		
		//Hotel ht = new Hotel((long) 3, 0, 0, 10, 1);
		//ht.setRatio();	
		
		return "hotel inserted";
	}
	
	
	public void update_hotel(Long hotel_id, int staff) {
		
		Hotel ht = hr.getOne((long) 1);
		//System.out.println(ht.getRatio());
		ht.setRatio();
		//ht.setCurrentStaff(staff);
		//hr.save(ht);
			
	
	}



	public List<HotelDetails> get_hotel_cluster_id(Long cluster_id) {
		
		Iterable<Hotel> lis_h = hr.findBycluster(cr.findOne(cluster_id));
		List<HotelDetails> hd_lis = new ArrayList<>();
		for(Hotel i : lis_h) {
			HotelDetails hd = new HotelDetails(i.getHotelId(), i.getCurrentBookings(), i.getCurrentStaff(), i.getTotalRooms(), i.getRatio(),
					i.getHotelName(), i.getManager().getManagerName());
			hd_lis.add(hd);
		}
		
		return hd_lis;
	}


	public String setBookings(int hotel_id, int bookings) {
		// TODO Auto-generated method stub
		
		Hotel ht = hr.findOne((long) hotel_id);
		int rooms = ht.getTotalRooms();
		if(rooms<bookings)
			return "Bookings no. is greater than total rooms";
		ht.setCurrentBookings(bookings);
		ht.setRatio();
		hr.save(ht);
		return "Bookings set";
	}
	
	
}
