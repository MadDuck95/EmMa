<%@page import="de.emma.controller.CalJson"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="de.emma.model.Calendar"%>
<%@page import="java.util.List"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
de.emma.controller.Calendar cal = new de.emma.controller.Calendar();
List<Calendar> callist = cal.getCal();
JSONArray ja = new JSONArray();
for(int i=0;i<callist.size();i++){
	Calendar calbean = callist.get(i);
	System.out.println(calbean.getCalId());
	ja.add(new CalJson(calbean.getCalTitle(),calbean.getStartDate(),calbean.getEndDate()));
}
out.println(ja);
%>	