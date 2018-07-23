package Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.management.ImageRepository;
import com.example.management.Images;

@Service
public class ImageService {

	
	@Autowired
	ImageRepository ir;
	
	
	public void store_image(Images image) {
		// TODO Auto-generated method stub
		ir.save(image);
	}

	
	
	
}
