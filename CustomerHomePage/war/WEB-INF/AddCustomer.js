/*
 $(document).ready(function() {
	var  count = 0;
$('#AddCustomer').click(function (){
	var getName = $('#Name').val();
	var getEmail = $('#Email').val();
	var getMobileNo = $('#MobileNo').val();
	var getAddress= $('#Address').val();
	var Cust = {
		Name : getName,
		Email : getEmail,
		MobileNo: getMobileNo,
		Address : getAddress
	}
	var customer = new CustomerModel(Cust);
	
	 customerCollection.add(Cust);
	
	 var allCustomer = new AllCustomer({model : customer});
});

});
	


$(document).ready(function() {
	var  count = 0;
	$('#newCustomer').click(function (){
		$(".popUp").show();
	});
	$('#Cancel').click(function (){
		$(".popUp").hide();
	});

$('#Add').click(function (){
	var getName = $('#Name').val();
	var getEmail = $('#Email').val();
	var getMobileNo = $('#MobileNo').val();
	var getAddress= $('#Address').val();
	var Cust = {
		Name : getName,
		Email : getEmail,
		MobileNo: getMobileNo,
		Address : getAddress
	}
	if($.trim(getName).length > 0){
		//console.log("check length " + getName.length);
	var customer = new CustomerModel(Cust);
	 customerCollection.add(Cust);
$(".popUp").hide();
	 var allCustomer = new AllCustomer({model : customerCollection});
	} else {
		alert("Please enter customer name");
	}
});

});
*/