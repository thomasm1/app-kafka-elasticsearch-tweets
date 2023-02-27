let checkRole = function () {
	let isSuper = getCookie("isSuper");
	let detail = document.getElementById("detail");
	detail.style.display = "none";

	/// SUPERVISOR
	console.log("is Super: "+ isSuper)
	if (isSuper == "true") {
		let role = document.getElementById("role");
		detail.style.display = "block";
		role.style.display = 'block';
		let charges = [];
		role.innerHTML = `*Supervisor Role<br />ID's:<br /> `;
		
//		addSubordinates(); 
		for (i = 0; i < 20; i++) {   // FIX THIS fixed ... TODO
			charges[i] = getCookie("sessOid" + i);
			if (charges[i] !== ("" || null || undefined)) {
			role.innerHTML += `${charges[i]} `; 
//			console.log(charges[i]);
			} 
		}   
		return charges;
	}
	
	/// DHEAD
	if ((adminId == 1) | (adminId == 2) | (adminId == 3) | (adminId == 4)) {

		let role = document.getElementById("role");
		detail.style.display = "block";
		role.style.display = 'block';
		let deptCharges = [];
		role.innerHTML = ` Dept Head Role for ID's:<br /> `;

		for (i = 5; i < 10; i++) {
			detail.style.display = "block";
			deptCharges[i] = getCookie("dsessOid" + i);
			role.innerHTML += `${deptCharges[i]} `;
		}

		console.log("role" + role);
		let departmentHead = getCookie("sessId");
		role.innerHTML += "<br /><strong>Department Head:</strong>40" + departmentHead;
		console.log("deptCharges " + deptCharges);
		return deptCharges;
	}
	///BENCO		
	if ((adminId == 4)) {
		detail.style.display = "block";
		role.style.display = 'block';
		role.innerHTML += "<br /><strong>BENCO STATUS</strong>";
		console.log("benco")
		let benco1 = document.getElementById("benco1");
		benco1.style.display = "block";
		let benco2 = document.getElementById("benco2");
		benco2.style.display = "block";
	}
}



// TABLE LISTS 
let listTask = function () {
	console.log("clicked list");
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {
			let d = JSON.parse(this.responseText);
			console.log(d);
			document.getElementById("table").innerHTML = ""; //erase empty list
			for (i = 0; i < d.length; i++) {
				document.getElementById("table").innerHTML += `
			        <tr>
			            <td><strong>#${d[i].taskId}</strong> &nbsp; Task TimeStamp:</td>
			            <td >${d[i].timeStamp}</td>
			        </tr> 
			        <tr>
			            <td>&nbsp;  &nbsp;  &nbsp; &nbsp;  Changed By:</td>
			            <td>#${d[i].currUserId}</td>
			        </tr>
			        <hr>				      
				`;
			}
		}
	}
	xhttp.open("GET", "listTask.do", true);
	xhttp.send();
}
let listDept = function () {
	console.log("clicked list");
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {
			let d = JSON.parse(this.responseText);
			console.log(d);
			document.getElementById("table").innerHTML = ""; //erase empty list
			for (i = 0; i < d.length; i++) {
				document.getElementById("table").innerHTML += `
			        <tr>
			            <td><strong>#${d[i].deptId}</strong>&nbsp;   &nbsp; Dept Name:</td>
			            <td >${d[i].deptName}</td>
			        </tr> 
			        <tr>
			            <td>&nbsp;&nbsp;  &nbsp;  &nbsp; &nbsp; Dept. Head:</td>
			            <td>#${d[i].deptHeadId}</td>
			        </tr>
			        <hr>				      
				`;
			}
		}
	}
	xhttp.open("GET", "listDept.do", true);
	xhttp.send();
}
let listUser = function () {
	console.log("clicked list");
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {
			let d = JSON.parse(this.responseText);
			console.log(d);
			document.getElementById("table").innerHTML = ""; //erase empty list
			for (i = 0; i < d.length; i++) {
				document.getElementById("table").innerHTML += `
			        <tr>
			            <td><strong>#${d[i].userId}</strong>&nbsp;   &nbsp; Name:</td>
			            <td >${d[i].userName}</td>
			        </tr> 
			        <tr>
			            <td>&nbsp;&nbsp;  &nbsp;  &nbsp; &nbsp; Supervisor ID:</td>
			            <td>#${d[i].superId}</td>
			        </tr>
			        <hr>				      
				`;
			}
		}
	}
	xhttp.open("GET", "listUser.do", true);
	xhttp.send();
}


let listRequestArray = function (arr) { 
	document.getElementById("table").innerHTML = "";
	for (i = 0; i < arr.length; i++) {
		listRequest(false, arr[i]);
	}
}
