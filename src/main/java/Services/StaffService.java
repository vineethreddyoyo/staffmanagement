package Services;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.management.Allocation;
import com.example.management.Details;
import com.example.management.Hotel;
import com.example.management.HotelRepository;
import com.example.management.ImageRepository;
import com.example.management.ManagerRepository;
import com.example.management.NotificationRepository;
import com.example.management.Request;
import com.example.management.RequestDetails;
import com.example.management.RequestRepository;
import com.example.management.Staff;
import com.example.management.StaffRepository;
import com.example.management.Staffdetails;

@Service
public class StaffService {

	@Autowired
	StaffRepository sr;
	
	@Autowired
	HotelRepository hr;
	
	@Autowired
	ManagerRepository mr;
	
	@Autowired
	RequestRepository rr;
	
	@Autowired
	ImageRepository ir;
	
	@Autowired
	NotificationRepository nr;
	
	@Autowired
	HotelService hs;
	
	@Autowired
	NotificationService ns;
	
	
	@Autowired
	RequestService rss;

	public int allocate(Long to_hotel_id, Long from_hotel_id, Long i)
	{
		Hotel to = hr.findOne(to_hotel_id);
		Hotel from = hr.findOne(from_hotel_id);
		Staff s = sr.findOne(i);
		if(s.getHotel().getHotelId() == to_hotel_id)
			return 0;
		else
		{
		if(from.getCurrentStaff()<=1) return 0;
		to.setCurrentStaff(to.getCurrentStaff()+1);
		from.setCurrentStaff(from.getCurrentStaff()-1);
		s.setHotel(to);
		to.setRatio();
		from.setRatio();
		sr.save(s);
		hr.save(to);
		hr.save(from);
		}
		return 1;
	}



	public List<Details> getStaff(Long manager_id) {
		
		List<Details> details = new ArrayList<>();
		Set<Staff> staffs =mr.findOne(manager_id).getHotel().getStaffs();
		for(Staff i : staffs)
			details.add(new Details(i.getStaffId(),i.getStaffName(),i.getPhone()));	
		
		return details;
	}


	public Staffdetails getStaffinfo(Long staff_id) {
		// TODO Auto-generated method stub
		Staffdetails sd = new Staffdetails();
		Staff s = sr.findOne(staff_id);
		Hotel h = s.getHotel();
		sd.setHotel_id(h.getHotelId());
		sd.setStaff_id(staff_id);
		sd.setStaff_name(s.getStaffName());
		sd.setHotelName(h.getHotelName());
		sd.setPhone(s.getPhone());
		if(!ir.findBymanagerId(staff_id).isEmpty())	
			sd.setImage(ir.getOne(staff_id).getUrl());
		else
			sd.setImage("https://cdn4.iconfinder.com/data/icons/business-conceptual-part3/513/star-employee2-512.png");
		System.out.println(sd);
		
		return sd;
	}

	@Transactional
	public RequestDetails allocate_temp(Allocation alloc) {
		// TODO Auto-generated method stub
		Long to_hotel_id = alloc.getTo_hotel_id();
		Long from_hotel_id = mr.findOne(alloc.getManagerId()).getHotel().getHotelId();
		//System.out.println(to_hotel_id);
		//System.out.println(from_hotel_id);
		
		RequestDetails rd = new RequestDetails();
		
		 
		List<Long> s_ids= alloc.getS_ids();
		
		
		List<Request> rs = rr.findByhotelId(to_hotel_id);
		
		System.out.println(rs);
		Request request = null;
		for(Request i : rs) {
			request = i;
			break;
		}
		
		int r_count= request.getN_staff();
		int yes=-1;
		for(Long i : s_ids) {
			yes=allocate(to_hotel_id,from_hotel_id,i);
			if(yes==0)
				break;
			ns.store_notification(to_hotel_id,from_hotel_id,i);
			r_count--;
			if(r_count==0)		
				break;
		}
		
		
		if(r_count==0) {
			yes=1;
			rr.delete(request);
		}
		else {
			request.setN_staff(r_count);
			rr.save(request);
		}
		
		if(yes==0)
		{
			rd.setInfo("Number of staff left is only 1 and remaining selected are allocated");
			rd.setReq_lis(rss.incomingRequests(from_hotel_id));
			return rd ;
		}
		else if(yes==-1)
		{
			return rd;
		}
		else 
		{
			rd.setInfo("Selected staff have been allocated");
			rd.setReq_lis(rss.incomingRequests(from_hotel_id));
			return rd;
		}
	}


	public String addStaff(Long hotel_id, String staffName, int salary, String phone) {
		// TODO Auto-generated method stub
		Staff s = new Staff(staffName,salary,phone);
		s.setHotel(hr.findOne(hotel_id));
		sr.save(s);
		return "staff added";
	}
	
}
