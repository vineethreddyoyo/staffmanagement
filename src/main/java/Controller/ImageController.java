package Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.management.Images;

import Services.ImageService;

@RestController
@CrossOrigin
public class ImageController {	
	
	
	@Autowired
	ImageService is;
	
	@RequestMapping(method = RequestMethod.POST,value="/store_image")
	public String store_image(@RequestBody Images image) {
		
		is.store_image(image);
		return "created";
	}
	
}
