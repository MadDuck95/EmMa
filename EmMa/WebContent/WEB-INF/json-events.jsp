<%@page import="de.emma.controller.CalJson"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="de.emma.model.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="de.emma.controller.CalDAO"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
CalDAO calserv = new CalDAO();
List<Calendar> callist = calserv.getCal();

System.out.println(callist);

//JSONArray ja = new JSONArray();
//for(int i=0;i<callist.size();i++){
//	Calendar cal = callist.get(i);
// 	System.out.println(calbean.getId());
//	ja.add(new CalJson(cal.getCalTitle(),cal.getStartDate(),cal.getEndDate()));
//}

Gson gson = new Gson();
String jsonAppointment = gson.toJson(callist);

System.out.println(jsonAppointment);

//Printout the JSON
//resp.setContentType("application/json");
//resp.setCharacterEncoding("UTF-8");

//System.out.println(ja);

//out.println(ja);
%>	