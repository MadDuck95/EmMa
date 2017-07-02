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

function proSelect() {
	var proSel = document.forms["projectSelect"]["pDesc"].value;
	if (proSel == "") {
		swal({
			title : "ERROR",
			text : "Cant't delete the project. Please select a project!",
			confirmButtonColor : "orange",
			type : "warning",
		});
		return false;
	} else {
		return true;
	}
}

function checkProject() {
	var proSel = document.forms["projectSelect"]["pDesc"].value;
	if (proSel == "") {
		swal({
			title : "ERROR",
			text : "Cant't show the project. Please select a project!",
			confirmButtonColor : "orange",
			type : "warning",
		});
		return false;
	} else {
		return true;
	}
}

function validateProject() {

	var proName = document.forms["newProject"]["pDesc"].value;
	var startDate = document.forms["newProject"]["startDate"].value;
	var endDate = document.forms["newProject"]["endDate"].value;

	// check if name
	if (proName == "") {
		swal({
			title : "ERROR",
			text : "Cant't register new project. Please enter a name!",
			confirmButtonColor : "orange",
			type : "warning",
		});
		return false;

	} else if (startDate == "" || endDate == "") {
		swal({
			title : "ERROR",
			text : "Cant't register new project. Please enter a start and end date!",
			confirmButtonColor : "orange",
			type : "warning",
		});
		return false;
	} else {
		return true;
	}
}
