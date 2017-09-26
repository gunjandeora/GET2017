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


	
