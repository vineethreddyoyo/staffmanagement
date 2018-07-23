package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Services.NotificationService;

@Controller
@CrossOrigin
public class NotificationController {

	@Autowired
	NotificationService ns;
	
	@RequestMapping("notifications/{hotel_id}")
	public @ResponseBody List<String> get_notifications(@PathVariable("hotel_id") Long hotel_id) {
		
		List<String> lis = ns.get_notifications(hotel_id);
		return lis;
		
	}
	
}
