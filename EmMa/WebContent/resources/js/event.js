function startTime() {
	var today = new Date();
	var h = today.getHours();
	var m = today.getMinutes();
	var s = today.getSeconds();
	m = checkTime(m);
	s = checkTime(s);
	document.getElementById('clock').innerHTML = h + ":" + m + ":" + s;
	var t = setTimeout(startTime, 500);
}
function checkTime(i) {
	if (i < 10) {
		i = "0" + i
	}
	; // add zero in front of numbers < 10
	return i;
}

function eveSelect() {
	var eveSel = document.forms["eventSelect"]["calTitle"].value;
	if (eveSel == "") {
		swal({
			title : "ERROR",
			text : "Cant't delete the event. Please select a event!",
			confirmButtonColor : "orange",
			type : "warning",
		});
		return false;
	} else {
		return true;
	}
}

function validateEvent() {

	var calTitle = document.forms["eventForm"]["calTitle"].value;
	var startDate = document.forms["eventForm"]["startDate"].value;
	var endDate = document.forms["eventForm"]["endDate"].value;

	// check if name
	if (calTitle == "") {
		swal({
			title : "ERROR",
			text : "Cant't register new event. Please enter a name!",
			confirmButtonColor : "orange",
			type : "warning",
		});
		return false;

	} else if (startDate == "" || endDate == "") {
		swal({
			title : "ERROR",
			text : "Cant't register new event. Please enter a start and end date!",
			confirmButtonColor : "orange",
			type : "warning",
		});
		return false;
	} else {
		return true;
	}
}