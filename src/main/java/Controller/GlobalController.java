package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Services.GlobalService;

@RestController
public class GlobalController {

	
	@Autowired
	GlobalService gs;
	
	@RequestMapping("/insert_staff")
	public String  correct_staff() {
		
		return gs.correct_staff();
	}
	
	
	
	
}
