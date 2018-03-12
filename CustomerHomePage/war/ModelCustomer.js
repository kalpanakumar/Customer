 /*
  
CustomerModel = Backbone.Model.extend({
	//urlRoot : '/SaveCustomerData',
default: {
Name: "",
Email :"",
MobileNo: "",
Address: ""
}
});

var CustomerCollection = Backbone.Collection.extend({
model : CustomerModel,
url : '/SaveCustomerData'
});
var customerCollection = new CustomerCollection();
*/

var CustomerModel = Backbone.Model.extend({
	urlRoot : '/SaveCustomerData',
default: {
Name: "",
Email :"",
MobileNo: "",
Address: "",
id : ""
}
});
var UpdateCustomerModel = Backbone.Model.extend({
	urlRoot : '/UpdateCustomerData',
default: {
Name: "",
Email :"",
MobileNo: "",
Address: "",
id : ""
}
});

var CustomerCollection = Backbone.Collection.extend({
	url : '/fetchCustomerData',
		model : CustomerModel
});
var customerCollection = new CustomerCollection();