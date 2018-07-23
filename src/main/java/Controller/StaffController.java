package Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.management.Allocation;
import com.example.management.Details;
import com.example.management.HotelRepository;
import com.example.management.RequestDetails;
import com.example.management.Staff;
import com.example.management.StaffRepository;
import com.example.management.Staffdetails;

import Services.StaffService;

@RestController
@CrossOrigin
public class StaffController {

@Autowired
StaffRepository sr;
@Autowired
HotelRepository hr;

@Autowired
StaffService ss;


@RequestMapping(value = "/add_staff/{hotel_id}/{staffName}/{salary}/{phone}")
public String addStaff(@PathVariable("hotel_id") int hotel_id,@PathVariable("staffName") String staffName,@PathVariable("salary") int salary, @PathVariable("phone") String phone)
{

	return ss.addStaff((long) hotel_id,staffName,salary,phone);

	
}

@RequestMapping("/get_staff/{manager_id}")
public List<Details> getStaff(@PathVariable("manager_id") int manager_id) {

	
	return ss.getStaff((long)manager_id);
}

@RequestMapping("get_staff_info/{staff_id}")
public Staffdetails getStaffinfo(@PathVariable("staff_id") int staff_id) {
	
return ss.getStaffinfo((long) staff_id);
}



@RequestMapping("get_staff_cluster")
public String getStaff_Cluster()
{
	
return sr.getOne((long) 1).getHotel().getCluster().getClusterName();
}



@RequestMapping("/allocate/{staff_id}")
public int allocate(@PathVariable("staff_id") Long staff_id) {
	
	return ss.allocate((long) 2,(long)1,staff_id);
}

@RequestMapping("/{staff_id}/login")
public String staff_login(@PathVariable("staff_id") Long staff_id) {
	
	if(sr.findOne(staff_id)!= null) return "Yes";
	else return "No";
}

@RequestMapping(method = RequestMethod.POST,value="/allocate_temp")
public RequestDetails allocate_temp(@RequestBody Allocation alloc) {
	
	return ss.allocate_temp(alloc);
}
	

@RequestMapping("/temp")
public Allocation temp() {
	Allocation a = new Allocation();
	List<Long> ar =new ArrayList<>();
	ar.add((long) 1);
	ar.add((long) 2);
	a.setManagerId((long) 1);
	a.setTo_hotel_id((long) 2);
	a.setS_ids(ar);
	return a;
}


/*
@RequestMapping("/findbyid")
public String check()
{
	Set<Staff> staffs = hr.findByTotal_rooms((long) 1);
	for (Iterator<Staff> it = staffs.iterator(); it.hasNext(); ) {
        Staff f = it.next();
        System.out.println(f.getName());
    }
	return "Staff allocated";
}
*/
	
}
