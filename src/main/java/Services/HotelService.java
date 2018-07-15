package Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.Hotel;
import com.example.management.HotelRepository;

@Service
public class HotelService {

	@Autowired
	HotelRepository hr;
	
	
	
	public void update_hotel(Long hotel_id, int staff) {
		
		Hotel ht = hr.getOne((long) 1);
		System.out.println(ht.getRatio());
		ht.setCurrentStaff(staff);
		hr.save(ht);
			
	
	}
	
	
}
