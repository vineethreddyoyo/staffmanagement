package Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.management.Cluster;
import com.example.management.ClusterRepository;
import com.example.management.Hotel;
import com.example.management.HotelDetails;
import com.example.management.HotelRepository;

import Services.HotelService;

@RestController
@CrossOrigin
public class HotelController {
@Autowired
HotelRepository hr;
@Autowired
ClusterRepository cr;

@Autowired
HotelService hs;

@RequestMapping("/create_hotel/{id}/{name}/{rooms}")
public String create(@PathVariable("id") int id,@PathVariable("name") String name, @PathVariable("rooms") int rooms)
{
	Hotel ht = new Hotel((long) id,name,0,0,rooms,1.2);
	ht.setRatio();
	Cluster c = cr.findOne((long) 2);
	ht.setCluster(c);
	hr.save(ht);
	return "hotel created";
}

@RequestMapping("/setbookings/{hotel_id}/{bookings}")
public String setBookings(@PathVariable("hotel_id") int hotel_id, @PathVariable("bookings")int bookings) {
	
	return hs.setBookings(hotel_id,bookings);
	
}  



@RequestMapping("/get_hotel/{cluster_id}")
public List<HotelDetails> get_hotel_cluster_id(@PathVariable("cluster_id") Long cluster_id)
{
	return hs.get_hotel_cluster_id(cluster_id);
}

@RequestMapping("/hotel_check")
public String check() {
	
	
	Set<Hotel> ht  = hr.findBytotalRooms(5);
	for(Hotel h : ht) {
		System.out.println(h.getHotelId());
	}
	
	
	return "worked";
	
}

@RequestMapping("/hotel_room_update")
public String update_room_hotel()
{
	int staff = 5;
	
	hs.update_hotel((long) 1, staff);
	
	
return "updated";
}
	
}
