package Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.management.Cluster;
import com.example.management.ClusterDetails;
import com.example.management.ClusterRepository;
import com.example.management.Hotel;
import com.example.management.HotelDetails;
import com.example.management.HotelRepository;

@Service
public class ClusterService {
	
	@Autowired
	ClusterRepository cr;
	
	@Autowired
	HotelRepository hr;

	
	public List<ClusterDetails> get_clusters() {
		// TODO Auto-generated method stub
		
		List<Cluster> list_c = cr.findAll();
		List<ClusterDetails> list_cd = new ArrayList<>();
		for(Cluster i : list_c) {
			ClusterDetails cd  = new ClusterDetails();
			cd.setClusterId(i.getClusterId());
			cd.setClusterName(i.getClusterName());
			cd.setTotalHotels((long) i.getHotels().size());
			list_cd.add(cd);
		}
		
		return list_cd;
	}


	public List<ClusterDetails> get_clusters_with_hotels() {
		// TODO Auto-generated method stub
		List<Cluster> list_c = cr.findAll();
		List<ClusterDetails> list_cd = new ArrayList<>();
		for(Cluster c : list_c) {
			Long c_id = c.getClusterId();
			
			ClusterDetails cd  = new ClusterDetails();
			cd.setClusterId(c_id);
			cd.setClusterName(c.getClusterName());
			Iterable<Hotel> lis_h = hr.findBycluster(cr.findOne(c_id));
			List<HotelDetails> hd_lis = new ArrayList<>();
			for(Hotel i : lis_h) {
				HotelDetails hd = new HotelDetails(i.getHotelId(), i.getCurrentBookings(), i.getCurrentStaff(), i.getTotalRooms(), i.getRatio(),
						i.getHotelName(), i.getManager().getManagerName());
				hd_lis.add(hd);
			}
			cd.setAllHotels(hd_lis);
			cd.setTotalHotels((long) hd_lis.size());
			list_cd.add(cd);
		}
		
		
		
		return list_cd;
	}

}
