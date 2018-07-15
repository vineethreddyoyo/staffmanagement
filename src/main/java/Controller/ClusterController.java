package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.management.Cluster;
import com.example.management.ClusterRepository;

@RestController
public class ClusterController {

	@Autowired
	ClusterRepository cr;
	@RequestMapping("/create_cluster")
	public String create() {
		
		Cluster c = new Cluster(2,"kondapur");
		cr.save(c);
		
		return "cluster created";
	}
	
}
