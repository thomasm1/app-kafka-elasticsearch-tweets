package service; 
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import db.DB;
import models.Groot;

public class GrootService {
	
	public static Groot getGroot(int id) {
		return DB.team.get(id);
	}
	
	public static void addGroot(Groot g) {
		DB.team.put(g.getId(), g);
	}
	
	public static List<Groot> getAllGroot() {
		
		Set<Integer> keys = DB.team.keySet();
		List<Groot> grootList = new ArrayList<Groot>();
		
		for(Integer key : keys) {
			grootList.add(DB.team.get(key));
		}
		
		return grootList;		
	}

}
