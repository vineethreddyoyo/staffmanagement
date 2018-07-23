package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.management.Hotel;
import com.example.management.HotelRepository;
import com.example.management.Manager;
import com.example.management.ManagerRepository;

@RestController
@CrossOrigin
public class ManagerController {

	@Autowired
	HotelRepository hr;
	
	@Autowired
	ManagerRepository mr;
	
	
	@RequestMapping("/create_manager/{hotel_id}/{id}/{name}")
	public String create_manager(@PathVariable("hotel_id") int hotel_id,@PathVariable("id") int id,@PathVariable("name") String name ) {
		
		Hotel ht  = hr.findOne((long) hotel_id);
		Manager m = new Manager((long) id,name,"k","pass");
		m.setHotel(ht);
		mr.save(m);		
		return "manager created";
	}
	
	@RequestMapping("/check")
	public String find()
	{
	
		
		return "Yes";
	}
	
}
