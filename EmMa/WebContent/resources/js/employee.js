// validation for employee registration
function validateForm() {
	var fName = document.forms["employeeForm"]["firstName"].value;
	var lName = document.forms["employeeForm"]["lastName"].value;
	var adress = document.forms["employeeForm"]["adress"].value;
	var zip = document.forms["employeeForm"]["zip"].value;
	var city = document.forms["employeeForm"]["city"].value;
	var title = document.forms["employeeForm"]["title"].value;
	var department = document.forms["employeeForm"]["department"].value;
	var salary = document.forms["employeeForm"]["salary"].value;
	var holidays = document.forms["employeeForm"]["holidays"].value;

	var errorToken = 1;

	// array to push error fields
	var errors = [];

	// check for every characteristic

	if (fName == "") {
		errors.push(errorToken);
	}
	if (lName == "") {
		errors.push(errorToken);
	}
	if (adress == "") {
		errors.push(errorToken);
	}
	if (zip == "" || zip <= 0) {
		errors.push(errorToken);
	}
	if (city == "") {
		errors.push(errorToken);
	}
	if (title == "") {
		errors.push(errorToken);
	}
	if (department == "") {
		errors.push(errorToken);
	}
	if (salary == "" || salary <= 0) {
		errors.push(errorToken);
	}
	if (holidays == "" || holidays <= 0) {
		errors.push(errorToken);
	}

	if (errors != "") {
		swal({
			title : "ERROR",
			text : "Can't register a new employee. Please check your input values!",
			confirmButtonColor : "orange",
			type : "warning",
		});
		return false;
	} else {
		return true;

	}
}
function validateEmployee() {
	var empId = document.forms["employeeSelect"]["lastName"].value;

	if (empId == "") {
		swal({
			title : "ERROR",
			text : "Can't delete the employee. Please select a employee!",
			confirmButtonColor : "orange",
			type : "warning",
		});
		return false;
	} else {
		return true;
	}
}

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
