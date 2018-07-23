package Controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.management.User;

import Services.GlobalService;

@RestController
@CrossOrigin
public class GlobalController {

	
	@Autowired
	GlobalService gs;
	
	@RequestMapping("/insert_staff")
	public String  correct_staff() {
		
		return gs.correct_staff();
	}
	
	@RequestMapping("/get_info/{manager_id}")
	public HashMap<String,String> get_manager_name(@PathVariable("manager_id") int manager_id) {
		
		
		return gs.get_manager_name((long) manager_id);
	
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public HashMap<String,String> login(@RequestBody User user) {
		
		//return "tes";
		return gs.login(user);		
		
	}
	
	
	
}
