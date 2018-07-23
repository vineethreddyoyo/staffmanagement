package Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.HotelRepository;
import com.example.management.Notification;
import com.example.management.NotificationRepository;
import com.example.management.StaffRepository;

@Service
public class NotificationService {

	@Autowired
	NotificationRepository nr;
	
	@Autowired
	HotelRepository hr;
	
	@Autowired
	StaffRepository sr;
	
	public List<String> get_notifications(Long hotel_id) {
		// TODO Auto-generated method stub
		
		List<String> lis = new ArrayList<>();
		Set<Notification> n_lis = nr.findBytohotelId(hotel_id);
		//nr.delete(n_lis);
		for(Notification i : n_lis) {
		String s = String.format("Staff Id : %d with name %s has assigned to your hotel from hotel %s",i.getStaffId(),sr.findOne(i.getStaffId()).getStaffName(),hr.findOne(i.getFromHotelId()).getHotelName());
		lis.add(s);
		}
	
	//	System.out.println(lis);
		
		return lis;	
		
	}

	public void store_notification(Long to_hotel_id, Long from_hotel_id, Long i) {
		// TODO Auto-generated method stub
		
		
		Set<Notification> lis = nr.findBystaffId(i);
		Notification n = new Notification();
		if(lis.isEmpty() || lis==null)
		{
		n.setFromHotelId(from_hotel_id);
		n.setStaffId(i);
		n.setTohotelId(to_hotel_id);
		
		}
		else
		{
			for(Notification loop : lis) {
				n=loop;
				break;
			}
		n.setFromHotelId(from_hotel_id);
		n.setTohotelId(to_hotel_id);
		
		}
		nr.save(n);
	}

}
