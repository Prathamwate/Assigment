package com.visitor.visitorCount;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class VisitorService {
	
	
	HashMap<String  ,Integer> hm=new HashMap<>();
	
	
//	public int Count() {
//		return count++;
//	}
	int count=1;
	public Visitor fetchName(String username) {
		count=hm.getOrDefault(username, 0)+1;
	    hm.put(username, count);
	    Visitor v=new Visitor(username,count);
	    return  v;
	}
}
