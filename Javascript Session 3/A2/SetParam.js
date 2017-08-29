alert("Hello! ");
function setPara(){
	// get link for contact page display.
	var contact = document.getElementById("contact_display"); //Get span
	a_contact = document.createElement('a');
	a_contact.href =  'ContactUs.html'; 
	a_contact.textContent = 'Contact Us'; // <a>INNER_TEXT</a>
	contact.appendChild(a_contact); // Append the link to the span
	// get link for home page display.
	var home = document.getElementById("home_display");
	a_home = document.createElement('a');
	a_home.href =  'index.html'; 
	a_home.textContent = 'Home'; // <a>INNER_TEXT</a>
	home.appendChild(a_home); // Append the link to the span
}
function getLocalStorage(){	
	alert("retrieving local storage");
	document.getElementById("NAME").value = localStorage.getItem("name");
	document.getElementById("EMAIL").value = localStorage.getItem("email");
	document.getElementById("CITY").value = localStorage.getItem("city");
	document.getElementById("ORGANIZATION").value = localStorage.getItem("organization");
	document.getElementById("CONTACT").value = localStorage.getItem("contact");
	document.getElementById("MESSAGE").value = localStorage.getItem("message");
}

function setLocalStorage() {
	alert("saving data");
	if (typeof(Storage) !== "undefined") {
	// Storing data
	localStorage.setItem("name", document.getElementById("NAME").value);
	localStorage.setItem("email", document.getElementById("EMAIL").value);
	//localStorage.setItem("city", document.getElementById("CITY").value);					
	var city = document.getElementById("CITY");
	var option = city.options[city.selectedIndex].value;
	localStorage['city'] = option;					
	localStorage.setItem("organization", document.getElementById("ORGANIZATION").value);
	localStorage.setItem("contact", document.getElementById("CONTACT").value);
	localStorage.setItem("message", document.getElementById("MESSAGE").value);
	}
}
function clearLocalStorage(){
	alert("local storage data cleared ");
	window.localStorage.clear();
	//document.getElementById("result").innerHTML = localStorage.getItem("name");
}

function clearTextFields(){	
alert("clear boxes ");
document.getElementById('NAME').value = "";
document.getElementById('EMAIL').value = "";
document.getElementById('CITY').value = "";
document.getElementById('ORGANIZATION').value = "";
document.getElementById('CONTACT').value = "";
document.getElementById('MESSAGE').value = "";
document.getElementById('city_description').value = "";
}

	
