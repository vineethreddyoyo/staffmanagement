package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.management.Cluster;
import com.example.management.ClusterDetails;
import com.example.management.ClusterRepository;

import Services.ClusterService;

@RestController
@CrossOrigin
public class ClusterController {

	
	@Autowired
	ClusterRepository cr;
	
	@Autowired
	ClusterService cs;
	
	@RequestMapping("/create_cluster")
	public String create() {
		
		Cluster c = new Cluster(2,"kondapur");
		cr.save(c);
		return "cluster created";
	}
	
	
	@RequestMapping("/get_clusters_with_hotels")
	public List<ClusterDetails> get_clusters() {
		
		return cs.get_clusters_with_hotels();
	}
	
	
	
}
