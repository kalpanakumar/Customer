
/*
 var customerDetails = Backbone.View.extend
({
	el : '#details',
	render : function (m){	
	var template = _.template($('.Model-list-template').html(),{}); 	
    $('#details').html(template(m.toJSON()));
     IdModel = m;    
},
events 	:   {
    					"click .delete"    :  "delete",	
    					"click .update"	   : "Update"
    			},

delete :  function ()
{
	    alert("this is delete funcion ");
        console.log(IdModel);
         console.log(customerCollection);
         var a=customerCollection.at(0);
         console.log(a);
	    customerCollection.remove(IdModel);  
	    console.log(customerCollection);
	    
	
},
Update : function (){
                         alert ("this is update");      
    				},
});

var Details = new customerDetails();


var CustomerName = Backbone.View.extend 
({  
          events :   {
    					"click .item"    :  "onEdit",		
    				},
    				onEdit : function () {			
                  Details.render(this.model);
                  this.$el.attr("id", this.model.cid);
                  ListItemId = this.model.cid;
    				},		
          render: function() {	
              this.$el.html("<span class= 'item'>" + this.model.get("Name")+" </span> ");
              this.model.save();
               Details.render(this.model);
              return this;
            }
});

var AllCustomer = Backbone.View.extend({
	tagName : 'li',	
	initialize: function() 
	         {
	            $("#list").append(this.render().$el) ; 
	            
	         },
     render : function (){	
	           var self  = this;
                var custName = new CustomerName({model : this.model});
               self.$el.html(custName.render().$el);	
               return this;
             }

});
 
var customerDetails = Backbone.View.extend
({ 
  el : '#details',
  render : function (m){  
    if (m != undefined){
  var template = _.template($('.Model-list-template').html(),{});   
    $('#details').html(template(m.toJSON()));
    //console.log(m);
     IdModel = m;   
   }
     else {
      this.$el.remove();
      // $("#" + DeleteList).remove();
     } 
},
events  :   {
              "click .delete"    :  "delete", 
              "click .update"    : "Update"
          },

delete :  function ()
{
      alert("this is delete funcion ");
       // console.log(IdModel);
        // console.log(customerCollection);
      customerCollection.remove([IdModel]);  
      //console.log(customerCollection);
     // if (IdModel != undefined){
   //  DeleteList =  customerCollection.at(0);
  // check =   DeleteList.cid;
  // console.log(DeleteList);
        this.render(customerCollection.at(0));
    //LIid = IdModel.cid;
    //console.log(LIid);
    //console.log(ListItemId);
    $("#" + ListItemId).remove();
     // }
     // else {
       // this.$el.remove();
      //}
     
      //this.$el.remove();
      //this.$el.remove(IdModel);
      return this;
  
},
Update : function (){
                      alert ("this is update"); 
                     IdModel.set('Name', $('#DetailsName').val());
                     IdModel.set('Email', $('#DetailsEmail').val());
                     IdModel.set('MobileNo', $('#DetailsMobile_No').val());
                     IdModel.set('Address', $('#DetailsAddress').val());
                    // console.log(customerCollection);
                     var Name = $('#DetailsName').val();
                     console.log("The name is " + Name);
                     //$("#" + ListItemId).remove();
                    $("#" + ListItemId).text(Name);

                     //this.model.on('change', this.render , this);
                    },
});
var Details = new customerDetails();


var CustomerName = Backbone.View.extend 
({  tagName : 'li', 
          events :   {
              "click .item"    :  "onEdit",   
            },
            onEdit : function () {      
                  Details.render(this.model);
                  this.$el.attr("id", this.model.cid);
                  ListItemId = this.model.cid;
                  //console.log(ListItemId);
            },    
          render: function() {  
              this.$el.html("<span class= 'item'>" + this.model.get("Name")+" </span> ");
              this.model.save();
               Details.render(this.model);
               this.$el.attr("id", this.model.cid);
                  listId = this.model.cid;
               //$('#Name').text(" ");
               //var Name =  $('#Name').val();  
            // console.log("clear name "  + Name);
            // Name = "";  
              return this;
            }
});

var AllCustomer = Backbone.View.extend({
	
	initialize: function() 
	         {
	            $("#list").append(this.render().$el); 
              $('#Name').val("");
              $('#Email').val("");
              $('#MobileNo').val("");
              $('#Address').val("");
            },
     render : function (){	
	           var self  = this;
this.model.each(function(CustModel)
            {
             var custName = new CustomerName({model : CustModel});
              self.$el.html(custName.render().el);  
 } );          
return this;
}
});
 

$(document).ready(function() { 
  $('#newCustomer').click(function (){
  var EnterDetails = new EnterCustomerDetails();
});
}); 
var Details = Backbone.View.extend({
	el : ".container-fluid",
render : function (customer){   
if (customer != undefined){ 
    GlobalCustomer = customer;
    var template = _.template($('.Model-list-template').html(),{});   
    $('#details').html(template(customer.toJSON()));
  } else {
    $("#DetailsTemplate").remove();
   // $("#list").append("<li class= 'item'>" + customer.get("Name") +" </li> ");
  }
},
events  :   {      
              "click .delete"    :  "delete", 
              "click .update"    : "Update",
              "click .item"      :  "list",   
          },
          list : function (e){
        //var x = e.currentTarget.id;
        //customerCollection.get(x);
       // console.log(customerCollection.get(x));
       CustomerDetails.render(customerCollection.get(e.currentTarget.id));

          },
          delete : function (){
         //alert("this is delete");
         $("#" + customerCollection.get(GlobalCustomer).cid).remove();
         customerCollection.remove([GlobalCustomer]);  
         //console.log(customerCollection);
        CustomerDetails.render(customerCollection.at(0));

          },
          Update : function (){
          //alert("this is update");       
            customerCollection.get(GlobalCustomer).set('Name', $('#DetailsName').val());
            customerCollection.get(GlobalCustomer).set('Email', $('#DetailsEmail').val());
            customerCollection.get(GlobalCustomer).set('MobileNo', $('#DetailsMobile_No').val());
            customerCollection.get(GlobalCustomer).set('Address', $('#DetailsAddress').val());
            $("#" + customerCollection.get(GlobalCustomer).cid).html("<li class ='item' id = '" + customerCollection.get(GlobalCustomer).cid  +  "'>" + $('#DetailsName').val() +" </li> ");
            //console.log(customerCollection);
          }
          
});
var CustomerDetails =  new Details();
var EnterCustomerDetails = Backbone.View.extend({ 
//el : "#test",
//events : {
        //      "click .item"    :  "onEdit",   
        //   },
//onEdit : function(e){
//var x = $(e.currentTarget).text();
//alert(x);
 
   // },
	initialize : function(){
		var template = _.template($('.PopUp_Template').html(),{});   
    $('.popUp').html(template);
    this.render();
	},  
	render : function (){
		$('#Add').click(function (){
	var getName = $('#Name').val();
	var getEmail = $('#Email').val();
	var getMobileNo = $('#MobileNo').val();
	var getAddress= $('#Address').val();
	var Customer = {
    Name : getName,
		Email : getEmail,
		MobileNo: getMobileNo,
		Address : getAddress
	}
	
	if($.trim(getName).length > 0){
	var customer = new CustomerModel(Customer);
	customer.save();
	//console.log(customer);
	customerCollection.add(customer);

	$("#list").append("<li class ='item' id = '" + customer.cid  +  "'>" + customer.get("Name") +" </li> ");
    $(".EnterDetails").remove();
    CustomerDetails.render(customer);
}else {
	alert("Enter the customer's Name");
}
	});
$("#Cancel").click(function(){
$(".EnterDetails").remove();
});

	}

});


$(document).ready(function() {
//count = 0; 
var customerDetails = new CustomerDetails();
$("#logOut").click(function(){
	$(location).attr('href','HomePage.jsp');
});
}); 
var Details = Backbone.View.extend({
el : "#details",
render :  function (customer){
	
if (customer != undefined){
	var fetchCusotmer = new CustomerModel({
        id: customer.get("Email")
    });
	fetchCusotmer.fetch(null, {
        success: function(fetchCusotmer) {
            alert("in the fetch function");
            }
    });
GlobalCustomer = customer;
console.log("golbalcustomer "+ GlobalCustomer );
console.log("customer "+ customer);
 var template = _.template($('.Model-list-template').html(),{});   
 $('#details').html(template(customer.toJSON()));
}else{ 
 $("#DetailsTemplate").remove();
}
},
events : {
 "click .delete"  : "DeleteCustomer",
 "click .update"  : "UpdateCustomer"
},
DeleteCustomer : function(){
	var DeleteCusotmer = new CustomerModel({
        id: customerCollection.get(GlobalCustomer).Email
    });
	console.log("delete " + customerCollection.get(GlobalCustomer).Email);
	DeleteCusotmer.destroy();
 $("#" + customerCollection.get(GlobalCustomer).id).remove();
   customerCollection.remove([GlobalCustomer]);  
   details.render(customerCollection.at(0));
},
UpdateCustomer : function(){
  alert("this is update function");
  customerCollection.get(GlobalCustomer).set('Name', $('#DetailsName').val());
  customerCollection.get(GlobalCustomer).set('Email', $('#DetailsEmail').val());
  customerCollection.get(GlobalCustomer).set('MobileNo', $('#DetailsMobile_No').val());
  customerCollection.get(GlobalCustomer).set('Address', $('#DetailsAddress').val());
  $("#" + customerCollection.get(GlobalCustomer).id).html("<li class ='item' id = '" + customerCollection.get(GlobalCustomer).id  +  "'>" + $('#DetailsName').val() +" </li> ");          
}
});
var details =  new Details();
var CustomerDetails =  Backbone.View.extend({
  el : "#background",
  events : {
    "click #newCustomer" : "ShowPopUp",
    "click #Cancel"      : "HidePopUp",
    "click #Add"         : "AddNewCustomer",
    "click .item"        :  "ShowCustomerDetails"
  },
  ShowPopUp: function(){
var template = _.template($('.PopUp_Template').html(),{});   
    $('.popUp').html(template);
  },
  HidePopUp : function(){   
$(".EnterDetails").remove();
  },
  AddNewCustomer: function(){
count = Math.random();
var getName = $('#Name').val();
  var getEmail = $('#Email').val();
  var getMobileNo = $('#MobileNo').val();
  var getAddress= $('#Address').val();
  var Customer = {
    Name : getName,
    Email : getEmail,
    MobileNo: getMobileNo,
    Address : getAddress,
    id : count
  } 
  if($.trim(getName).length > 0){
  var customer = new CustomerModel(Customer);
  customerCollection.add(customer);
 $("#list").append("<li class ='item' id = '" + count  +  "'>" + customer.get("Name") +" </li> ");
    $(".EnterDetails").remove();
    console.log("check customer "+ customer);
     details.render(customer);
     customer.save();
//     $.ajax({
//    	  'url' : '/SaveCustomerData',
//    	'data' : JSON.stringify(Customer),
//    	  'type': 'POST',
//    	  contentType : 'application/json; charset=utf-8',
//    	   });
}else{
  alert("Enter the customer's Name");
}
  },
ShowCustomerDetails : function(e){
 details.render(customerCollection.get(e.currentTarget.id));
}
}); */
$(document).ready(function() {
count = 0; 
//var CollectionModel = new CustomerCollection();
//CollectionModel.fetch({
//	success: function(model, xhr, opts){
//		console.log("in fetch all function");
//		},
//		error: function (){
//			console.log("in the error function of fetch all funcation ")
//		}
//});
$.ajax({
	url: 'Fetchall2',
	type:'get',
	contentType : 'application/json; charset=utf-8',
		success : function(data) {
				console.log("In the success function of fetch all");
				 
				var obj = JSON.parse(data);
				for(var i=0;i<obj.length;i++){
					
					var FetchedCustomer= {
						    Name : obj[i].Name,
						    Email : obj[i].email,
						    MobileNo: obj[i].mobileNumber,
						    Address : obj[i].Address,
						    id : obj[i].Id
						  } 
					customerCollection.add(FetchedCustomer);
					 $("#list").append("<li class ='item' id = '" + obj[i].Id  +  "'>" + obj[i].Name +" </li> ");
					 var FetchCust = new CustomerModel(FetchedCustomer);
					 details.render(FetchCust)
				}
				}
				
	});
$("#logOut").click(function(){ 
	$.ajax({
		url: 'Logout',
		type:'get',
			success : function(data) {
					console.log(data)
					}
		});
});
  var customerDetails = new CustomerDetails();
}); 
var Details = Backbone.View.extend({
el : "#details",
render :  function (customer){
	console.log(customer);
if (customer != undefined){
	var fetchCusotmer = new CustomerModel({
        id: customer.get("id")
    });
	fetchCusotmer.fetch({
//        success: function(model, xhr, opts) {
//            console.log("In fetch funcation");
//            console.log(xhr);
//            },
//            error : function(){
//            	console.log("In error function");
//            }
    });
GlobalCustomer = customer;
 var template = _.template($('.Model-list-template').html(),{});   
    $('#details').html(template(customer.toJSON()));
}else{ 
 $("#DetailsTemplate").remove();
}
},
events : {
 "click .delete"  : "DeleteCustomer",
 "click .update"  : "UpdateCustomer"
},
DeleteCustomer : function(){
	var Deletecustomer = new CustomerModel({ id: customerCollection.get(GlobalCustomer).id});
	   Deletecustomer.destroy({success: function(model, xhr, opts){
		 
	   },
	   error: function(){
		   
	   }}); 
 $("#" + customerCollection.get(GlobalCustomer).id).remove();
   customerCollection.remove([GlobalCustomer]);  
   details.render(customerCollection.at(0));
     
},
UpdateCustomer : function(){
  
  customerCollection.get(GlobalCustomer).set('Name', $('#DetailsName').val());
  customerCollection.get(GlobalCustomer).set('Email', $('#DetailsEmail').val());
  customerCollection.get(GlobalCustomer).set('MobileNo', $('#DetailsMobile_No').val());
  customerCollection.get(GlobalCustomer).set('Address', $('#DetailsAddress').val());
  $("#" + customerCollection.get(GlobalCustomer).id).html("<li class ='item' id = '" + customerCollection.get(GlobalCustomer).id  +  "'>" + $('#DetailsName').val() +" </li> ");          

var UpdateCustomer = new UpdateCustomerModel(customerCollection.get(GlobalCustomer));
console.log(customerCollection.get(GlobalCustomer));
UpdateCustomer.save();
}
});
var details =  new Details();
var CustomerDetails =  Backbone.View.extend({
  el : "#background",
  events : {
    "click #newCustomer" : "ShowPopUp",
    "click #Cancel"      : "HidePopUp",
    "click #Add"         : "AddNewCustomer",
    "click .item"        :  "ShowCustomerDetails"
  },
  ShowPopUp: function(){
var template = _.template($('.PopUp_Template').html(),{});   
    $('.popUp').html(template);
  },
  HidePopUp : function(){   
$(".EnterDetails").remove();
  },
  AddNewCustomer: function(){
count = Math.floor(Math.random() * 26);
var getName = $('#Name').val();
  var getEmail = $('#Email').val();
  var getMobileNo = $('#MobileNo').val();
  var getAddress= $('#Address').val();
  var Customer = {
    Name : getName,
    Email : getEmail,
    MobileNo: getMobileNo,
    Address : getAddress,
    id : count
  } 
  if($.trim(getName).length > 0){
  var customer = new CustomerModel(Customer);
  customerCollection.add(customer);
 $("#list").append("<li class ='item' id = '" + count  +  "'>" + customer.get("Name") +" </li> ");
    $(".EnterDetails").remove();
    customer.save();
     details.render(customer);
     
}else{
  alert("Enter the customer's Name");
}
  },
ShowCustomerDetails : function(e){
 details.render(customerCollection.get(e.currentTarget.id));
}
});       