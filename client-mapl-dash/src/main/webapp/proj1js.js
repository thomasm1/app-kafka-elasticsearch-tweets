
/////////////////////////////
// proj1js.js
/////////////////////////////
// METHODS FOR ALL 
let varFullAddress = "http://localhost:8080/listRequestServlet";
let varAddress = "listRequestServlet";
//let updateReq = new Function();

let sessdata;
let sessDataArray1;
// pass in my employee's requests as an array optionals[];

// atstart:false=; true-
// oId: param->userId(7777=wipe table)
const listRequest = function (atstart, oId) {

	console.log("clicked list");
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {

			let d = JSON.parse(this.responseText);
			sessdata = this.responseText;
			console.log("sessdata--------");
			console.log(sessdata);
			console.log("d-------------");
			console.log(d);
			if (atstart == true) {
				document.getElementById("table").innerHTML = ""
			}; //erase empty list

			if (d == "undefined" || d.length == 0 || !d || d == null) {
				document.getElementById("table").innerHTML += `
			<h6>No Reimbursements have been requested.</h6>
			`;
			} else {
				for (i = 0; i < d.length; i++) {
					let status = statusCase(d[i].stage);
					let adjusted = adjustedReq(d[i].reqAmt, d[i].reqType);

					//myBalance(d[i].reqAmt);

					document.getElementById("table").innerHTML += `
	        <tr>
			            <td><strong>#${d[i].reqId}</strong>&nbsp;   &nbsp; Request:</td>
			            <td >${d[i].reqName}</td>
				        </tr> 
				       	<tr>
			            <td>&nbsp;&nbsp;  &nbsp;  &nbsp; &nbsp; Status:</td>
			            <td><strong>${status}</strong></td>
			        	</tr>
			        	
			        	 <tr>
			            <td>&nbsp;&nbsp;  &nbsp;  &nbsp; &nbsp; Requested Amount:</td>
			            <td>$${d[i].reqAmt}</td>
			        	</tr>
			        	 <tr>
			            <td>&nbsp;&nbsp;  &nbsp;  &nbsp; &nbsp; Adjusted Amount:</td>
			            <td><u><em>$${adjusted}</em></u></td>
			        	</tr>
		        	  
			        	
				        <tr>
			            <td>&nbsp;&nbsp;  &nbsp;  &nbsp; &nbsp; Request Type:</td>
			            <td>${d[i].reqType}</td>
				        </tr>
				        <tr>
				        <td>&nbsp;&nbsp;  &nbsp;  &nbsp; &nbsp; Date Requested:</td>
				        <td>${d[i].reqDatetime}</td>
			        	</tr>
				     
		        	
				        <hr>				      
				`;

				}
			}
		}
	}
	let getall = 8888;
	let myId = getCookie("sessId");
	oId = (oId != 8888) ? oId : getall;  // OTHERS if oID !=8888; GET ALL REQUESTS
	oId = (oId != 0) ? oId : myId;  //GET OTHERS if oId !=0;  GET myId if 0
	console.log("collecting request for: " + oId)
	xhttp.open("GET", `${varAddress}?userId=` + oId, true);
	xhttp.setRequestHeader('Access-Control-Allow-Origin', '*');  // http://mydomain.com
	xhttp.setRequestHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, OPTIONS');
	xhttp.send();

}
//let myBalance = function(adj) { 
//		let bal = document.getElementById("bal");
//		 
//		let balance = 1000; 
// 
//		let adjusted = parseInt(adj,10);
//		let s  = parseInt(spent += adjusted)
//	 
//		let available = balance - s;
//	    bal.innerHTML = ` Total balance `;
//		bal.innerHTML += `<br /> (Available: ${available}) `;
//		
//		console.log("bal"+balance); 
//		 
//}

// INITIAL USER DATA
const sessionInfo = function () {
	// collect my subordinates

	//	const findSessOids3 = function () {
	//
	//		var str =  /sessOid\d+/ 
	//			
	//			let i = 10;
	//			let sessArray = []
	//			do {
	//			 sessArray[i] = getCookie(str);
	//			 i--
	//			 
	//			} while (i>0)
	//			return sessArray;
	//	}			
	//	findSessOids3();

	sessUser = getCookie("sessUser");
	sessId = getCookie("sessId");
	sessSuper = getCookie("sessSuper");
	sessDept = getCookie("sessDept");
	killCookie("username");
	document.cookie = `username=${sessUser}`;
	killCookie("userid");
	document.cookie = `userid=${sessId}`;
	killCookie("usersuper");
	document.cookie = `usersuper=${sessSuper}`;
	killCookie("userdept");
	document.cookie = `userdept=${sessDept}`;
	let username = getCookie("username");
	let headerName = document.getElementById("headerId");
	headerName.innerHTML = ` ${username}`;

	let userid = getCookie("userid");
	let id = document.getElementById("userId");
	id.innerHTML = ` ${userid}`;

	let usersuper = getCookie("usersuper");
	let superid = document.getElementById("userSuper");
	superid.innerHTML = ` ${usersuper}`;

	let userdept = getCookie("userdept");
	let deptid = document.getElementById("userDept");
	deptid.innerHTML = ` ${userdept}`;

}


let username;  // just declare

let adminEntry = function () {
	let sessUser = 'Cyndi'; //getCookie("sessUser");
	let sessId = 4; //getCookie("sessId");
	let sessSuper = 52; //getCookie("sessSuper");
	let sessDept = 404; //getCookie("sessDept");

	console.log("sessDept: " + sessDept + ",sessUser:" + sessUser + " logged in as admin");
	killCookie("username");
	document.cookie = `username=${sessUser}`;
	document.cookie = `sessUser=${sessUser}`;
	killCookie("userid");
	document.cookie = `userid=${sessId}`;
	document.cookie = `sessId=${sessId}`;
	killCookie("usersuper");
	document.cookie = `usersuper=${sessSuper}`;
	document.cookie = `sessSuper=${sessSuper}`;
	killCookie("userdept");
	document.cookie = `userdept=${sessDept}`;
	document.cookie = `sessDept=${sessDept}`;
	window.location.href = "index.html";
}

let login = function () {

	let u = document.getElementById("username");
	let username = u.value; // overwrite

	let p = document.getElementById("password");
	let password;
	password = p.value;

	let xhttp = new XMLHttpRequest();

	xhttp.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {
			console.log("readyState: " + this.readyState + ", status: " + this.status);
		}
	}
	xhttp.open("GET", "login.do?username=" + username + "&password=" + password, true);
	//        xhttp.open("POST", "login2.do", true);

	xhttp.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
	//	xhttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	xhttp.setRequestHeader('Access-Control-Allow-Origin', '*');  // http://mydomain.com
	xhttp.setRequestHeader('Access-Control-Allow-Methods', 'GET, POST, PUT, OPTIONS');

	xhttp.send();
	console.log(" submitted by: *" + username + ", password *" + password);

	redirect(username);


}
//  LOGOUT
let logout = function () {
	killCookie("username");
	killCookie("userid");
	killCookie("usersuper");
	killCookie("userdept");

	killCookie("sessUser");
	killCookie("sessId");
	killCookie("sessSuper");
	killCookie("sessDept");
	killCookie("sessdata");
	killCookie("isSuper");
	killCookiePattern("sessOid"); // kill subs
	killCookiePattern("dsessOid"); // kill depts
	sessUser = "";
	sessUser = "";
	sessId = "";
	sessSuper = "";
	sessDept = "";
	sessdata = "";
	dListReq = null;
	//	for (let i=0; i<arr.length;i++) {
	//		
	//	}
}

//GLOBS

let sesso = new Object;

// VALIDATION
let redirect = function (u) {
	sesso = {
		sessUser: getCookie("sessUser"),
		sessId: getCookie("sessId"),
		sessSuper: getCookie("sessSuper"),
		sessDept: getCookie("sessDept"),

		sessUser: this.sessUser,
		sessId: this.sessId,
		sessSuper: this.sessSuper,
		sessDept: this.sessDept,
	}

	let sessUser = getCookie("sessUser");
	let sessId = getCookie("sessId");
	let sessSuper = getCookie("sessSuper");
	let sessDept = getCookie("sessDept");

	let spinner = document.getElementById("spinner");
	spinner.style.display = "block";

	certifiedUser = getCookie("sessUser")
	setTimeout(function () {

		if ((u == getCookie("sessUser")) || (u == certifiedUser)) {

			console.log("sessDept: " + sessDept + ",sessUser:" + sessUser + " logged in as " + u);
			killCookie("username");
			document.cookie = `username=${u}`;
			killCookie("userid");
			document.cookie = `userid=${sessId}`;
			killCookie("usersuper");
			document.cookie = `usersuper=${sessSuper}`;
			killCookie("userdept");
			document.cookie = `userdept=${sessDept}`;
			window.location.href = "index.html";
		} else {
			alert("please try again! you entered " + u + " and not found!");
			window.location.href = "login.html";
		}
		spinner.style.display = "none";

	}, 3000);
}


/////// KILL COOKIES
let killCookie = function (cname) {

	document.cookie = cname +
		'=; expires=Thu, 01-Jan-70 00:00:01 GMT;';
}

/////// KILL COOKIES 2 ( matching pattern...)
//DESTROY ALL COOKIS MATCHING PATTERN >>>> myCookieName1, myCookieName2
// Get an array of cookies
let killCookiePattern = function (c_pattern) {
	var arrSplit = document.cookie.split(";");

	for(var i = 0; i < arrSplit.length; i++)
	{
	    var cookie = arrSplit[i].trim();
	    var cookieName = cookie.split("=")[0];

	    // If the prefix of the cookie's name matches the one specified, remove it
	    if(cookieName.indexOf(c_pattern) === 0) {

	        // Remove the cookie
	        document.cookie = cookieName + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
	    }
	} 
}

/////// GET COOKIES
let getCookie = function (cname) {
	var name = cname + "=";
	var decodedCookie = decodeURIComponent(document.cookie);
	var ca = decodedCookie.split(';');
	for (var i = 0; i < ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ') {
			c = c.substring(1);
		}
		if (c.indexOf(name) == 0) {
			return c.substring(name.length, c.length);
		}
	}
	return "";
}

///  REQUEST ADJUSTMENTS
const adjustedReq = function (reqAmt, reqType) {
	let adjusted;
	switch (reqType) {
		case "course":
			adjusted = reqAmt * .8;
			// Awaiting Supervisor
			break;
		case "seminar":
			adjusted = reqAmt * .6;
			// Awaiting Supervisor
			break;
		case "certprep":
			adjusted = reqAmt * .75;
			// Awaiting 
			break;
		case "cert":
			adjusted = reqAmt;
			// Awaiting 
			break;
		case "techtrain":
			adjusted = reqAmt * .9;
			//   ---->send reason to requestor
			break;
		case "other":
			adjusted = reqAmt * .3;
			// Awaiting 
			break

		default:
			adjusted = "not adjusted";
			break;
	}
	let adjustedAmt = adjusted;
	return adjustedAmt;
}


////    STATUS CASE
const statusCase = function (code) {
	let stage;
	switch (code) {
		case 0:
			stage = "Request Submitted; <br />Awaiting Supervisor";
			// Awaiting Supervisor
			break;
		case 99:
			stage = "Request Submitted";
			// Awaiting Supervisor
			break;
		case 1:
			stage = "Approved by Supervisor";
			// Awaiting 
			break;
		case 2:
			stage = "Auto-Approved (Supervisor)";
			// Awaiting 
			break;
		case 3:
			stage = "Denied by Supervisor";
			//   ---->send reason to requestor
			break;
		case 4:
			stage = "Approved by Dept. Head;<br />Awaiting Benco";
			// Awaiting 
			break;
		case 5:
			stage = "Pending Doc Request (Dept.)";
			// Awaiting --->need docs from requestor
			break;
		case 6:
			stage = "Denied by Dept. Head";
			// Awaiting 
			break
		case 7:
			stage = "Pending Doc Request (Dept.)";
			//
			break;
		case 8:
			stage = "Approved, Request amount increased";
			//--->reason for exceeding available
			break;
		case 9:
			stage = "Approved, amount lowered (pending requestor)";
			// -->need final approve from requestor
			break;
		case 10:
			stage = "Awaiting Benco (Timeout alert sent to Supervisor)";
			//    ---> letter to supervisor
			break;
		case 11:
			stage = "Denied by Benco  ";
			// 
			break;
		default:
			stage = "Status not found!";
			break;
	}
	let status = stage;
	return status;
} 