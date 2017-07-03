<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />

<!-- Home-Button -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="./resources/css/Employee.css" rel="stylesheet">

<!-- Clock -->
<script src="./resources/js/main.js"></script>

<!-- DatePicker(jQuery UI) -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>

<!-- FullCalendar(jQuery API) -->
<link href='./resources/fullcalendar/fullcalendar.css' rel='stylesheet' />
		<!-- Drag & Drop Events - Must be loaded before FullCalendar -->
		<script src='./resources/fullcalendar/moment.min.js'></script>
		<script src='./resources/fullcalendar/jquery.min.js'></script>
<!-- FullCalendar(jQuery API) -->
<script src='./resources/fullcalendar/fullcalendar.js'></script>
<link href='./resources/css/main.css' rel='stylesheet' />


<!-- FullCalendar Initialization -->
<script>
	// FullCalendar
	// FullCalendar
	$(document).ready(function() {
		$('#calendar').fullCalendar({
			height: 650,
			editable: true,
			selectable: true,
			events: "json-events.jsp",
			/*eventSources: [
		    {events: [
		        	{title  : "Es funktioniert!",
		            start  : '2017-07-01',
		            end    : '2017-07-07'},
			],
			color: 'orangered',}
			]*/
		});
	});
</script>

<!-- Customize the Calendar -->
<style type="text/css">
#wrap{
	margin: 0 auto;
	padding: 20px;}
.calendar_body{
	max-width: 1800px;
	float: none;
	margin: 20px;
	align-items: center;
	justify-content: center;}
#home {
	border-left: 3px solid orange;
	height: 5%;
	font-size: 30px;}
#calendar .fc-today {
    background: #FFA500 !important;
    font-weight: bold;
    opacity: 0.8 !important;
}
</style>

<title>EmMa - Calendar</title>
</head>
<body onload="startTime()">
<div id="main">
	<div id="clock"></div>
	<div id="home">
		<a href="/EmMa/"><i class="fa fa-home fa-lg"></i></a>
	</div>
	
	<div id="wrap">
		<!-- FullCalendar body -->
		<div class="calendar_body">
			<div id="calendar"></div>
		</div>
	</div>
</div>
</body>
</html>