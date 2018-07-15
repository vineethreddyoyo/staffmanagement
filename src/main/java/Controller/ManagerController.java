package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.management.Hotel;
import com.example.management.HotelRepository;
import com.example.management.Manager;
import com.example.management.ManagerRepository;

@RestController
public class ManagerController {

	@Autowired
	HotelRepository hr;
	
	@Autowired
	ManagerRepository mr;
	
	
	@RequestMapping("/create_manager")
	public String create_manager() {
		
		Hotel ht  = hr.findOne((long) 2);
		Manager m = new Manager((long) 2,"queen","k","pass");
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
