package Services;


import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.Hotel;
import com.example.management.HotelRepository;
import com.example.management.ImageRepository;
import com.example.management.Images;
import com.example.management.Manager;
import com.example.management.ManagerRepository;
import com.example.management.Staff;
import com.example.management.StaffRepository;
import com.example.management.User;

@Service
public class GlobalService {

	@Autowired
	StaffRepository sr;
	
	@Autowired
	HotelRepository hr;
	
	@Autowired
	ManagerRepository mr;
	
	@Autowired
	ImageRepository ir;
	
	public HashMap<String, String> get_manager_name(Long manager_id) {
		HashMap<String, String > map = new HashMap<String,String>();
		Manager m = mr.findOne(manager_id);
		Hotel ht = m.getHotel();
		map.put("manager_name", m.getManagerName());
		map.put("hotel_name", ht.getHotelName());
		map.put("cluster_name",ht.getCluster().getClusterName());
		map.put("current_bookings",String.valueOf(ht.getCurrentBookings()));
		List<Images> imgs = ir.findBymanagerId(manager_id);
		
		if(!imgs.isEmpty())
			map.put("image",ir.findOne(manager_id).getUrl());
		else
			map.put("image","https://png.icons8.com/color/260/businessman.png");
		return map;
	}
	
	
	
	
	public HashMap<String,String> login (User user) {
		
		Set<Manager> managers = mr.findByusername(user.getUsername());
		if (managers.isEmpty())
			return null;
			//return "no users found";
		else {
			for(Manager i : managers) {
				HashMap<String, String > map = new HashMap<String,String>();
				if( i.getPassword().contentEquals(user.getPassword()) ) {
					
					map.put("id",i.getManagerId().toString());
					map.put("hotel_id",i.getHotel().getHotelId().toString());
					//map.put("hotel_name",i.getHotel().getHotelName());
					return map;
				}
					//return "Yes";
				else{
					map.put("id","0");
					return map;
				}
					//return "Wrong password";
	
			}
			
		}
return null;
		//return "outside";
	}
	
	
	public String correct_staff() {
		
		Iterable<Hotel> hotels = hr.findAll();				
		for(Hotel i : hotels){
			i.setCurrentStaff(0);
			hr.save(i);
		}
		
		Iterable<Staff> staffs = sr.findAll();
		for(Staff i : staffs) {
			i.getHotel().setCurrentStaff(i.getHotel().getCurrentStaff() + 1);
		}
		
		for(Hotel i : hotels) {
			update_hotel_ratio(i.getHotelId());
			hr.save(i);
		}
		
		
		
		return "CorrectedStaff";				
	}
	
	
	public void update_hotel_ratio(Long hotel_id)
	{
		Hotel ht = hr.findOne(hotel_id);
		ht.setRatio();
		hr.save(ht);
		
	}
	
	
}
