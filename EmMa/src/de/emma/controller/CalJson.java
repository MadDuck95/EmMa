package de.emma.controller;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class CalJson implements JSONAware {
	private String title;
	private String start;
	private String end;
	
	public CalJson(String title, String date, String end){
		this.title=title;
		this.start=date;
		this.end=end;
	}
	
	@Override
	public String toJSONString(){
	    JSONObject obj = new JSONObject();
	    obj.put("title", title);
	    obj.put("start", start);
	    obj.put("end", end);
	    return obj.toString();
	  }
}
