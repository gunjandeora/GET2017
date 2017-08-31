function saveIt(){
	var checkErrorsInForm = validate_form();
	if(checkErrorsInForm){
		setLocalStorage();
		clearTextFields();
	}
	else{
		alert("please resolve errors in form first");
		stopLoadingPage();
	}
	
}

function stopLoadingPage(){
	$( "a" ).click(function( event ) {
  event.preventDefault();
});
}
function validate_form(){
	var list_of_errors = [];
	var count = 0;	
	var name = document.contact_form.person_name.value;
	var email = document.contact_form.Email.value;
	var phone = document.contact_form.contact_Number.value;
	var organization = document.contact_form.organization_name.value;
	var city_option = document.contact_form.select_city.value;
	//name validation
	if(name==null || name==""){
		list_of_errors[count++] = 'Error '+(count)+' :Name Field is empty.';
		document.contact_form.person_name.focus();
		//alert("Name is invalid..");
		//alert('Name Field is empty.');
		//return false;
	}
	// check length of name
	if(name.length > 20 ){
	//alert("Name field cannot extend 20 characters");
	list_of_errors[count++] = 'Error '+(count)+' :Name cannot have more than 20 characters';
	document.contact_form.person_name.focus();
	}

	var re_for_name = /^[A-Za-z ]+$/;
	if(!re_for_name.test(name)) {
		list_of_errors[count++] = 'Error '+(count)+' :Name contains invalid characters!';
		document.contact_form.person_name.focus();
		//alert("Error: Name contains invalid characters!");
		//document.getElementById('person_name').focus();
		//alert('Error: Name contains invalid characters!');
		//return false;
	}

	//email validation
	var atposition=email.indexOf("@");  
	var dotposition=email.lastIndexOf(".");  
	if (atposition<1 || dotposition<atposition+2 || dotposition+2>=email.length){
		list_of_errors[count++] = 'Error '+(count)+' :Enter a valid e-mail address.';
		document.contact_form.Email.focus();
		//alert("Please enter a valid e-mail address \n atpostion:"+atposition+"\n dotposition:"+dotposition);    
	} 

	//organization validation
	var re_for_org = /^[a-zA-Z ]+$/;
	if(!re_for_org.test(organization) || organization =="" || organization == null){
		list_of_errors[count++] = 'Error '+(count)+' :Organization name should be in character format only.';	
		document.contact_form.organization_name.focus();
	}
	
	//contact number validation
	var re_for_number = /^\d{10}$/;	
	if(!re_for_number.test(phone) || phone =="" || phone == null){
		list_of_errors[count++] = 'Error '+(count)+' :Contact Number should be valid.';
		document.contact_form.contact_Number.focus();	
	}
	
	if (list_of_errors.length != 0) {
		var str = 'Total Errors: '+list_of_errors.length+'\n';
		for (i = 0; i < list_of_errors.length; i++) { 
			str += list_of_errors[i] + '\n';
		}
		alert(str);
		return false;
	}
	else{
	return true;
	}	
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
	clearTextFields();
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

function limitText(ref,iLength) {
	if(ref.value.length > iLength) {
		alert("Text length cannot be greater than " + iLength + " characters\
			Current length is: " + ref.value.length);
		ref.focus();
		return false;
  }
}

function display(){
	var text = document.contact_form.select_city.value;
	var textarea = document.getElementById('city_description');
	if(text!="--Select--"){
		textarea.style.display = 'block';
		textarea.value = 'You have chosen: '+ text;
	}else{
		textarea.style.display = 'none';
	}
}
