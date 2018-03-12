$(document).ready(function() { 
  var logIn = new LogIn();
}); 
var LogIn = Backbone.View.extend({  
	el : "#LogIn",
	events  :  {
     "click #Add" :  "LogIn", 
     "click  #SignUp" : "ShowSignUp",
     "click  #Create"  : "SingUpFunction"
	},
	ShowSignUp : function (){
    var template = _.template($('#TemplateLogIn').html(),{});   
    this.$el.html(template);
    $("#LogInRow").hide();
    $("#title").text("Sign Up");

	},
	SingUpFunction : function (){
		var email = $("#UserName").val();
   var password = $("#Password").val();
if( ($.trim(email).length > 0) && ($.trim(password).length > 0))
   {  var SignIn_details = {
		   Email : email,
		   Password : password
   }
  // console.warn(SignIn_details);
   var signIn = new SignIn_UP(SignIn_details);
   signIn.save(null,{
	   success: function(model, xhr, opts) 
	   { 
		  
		   if(xhr == 200){
				
		        $(location).attr('href','Home.jsp');
			}else {
				alert("email exist");
			}
	   },
  
   });
} else {
	alert("Enter the details correctly");
}
	},
	
	LogIn : function (){
   var Email = $("#UserName").val();
   var Password = $("#Password").val();
   if( ($.trim(Email).length > 0) && ($.trim(Password).length > 0))
   {    var LogIn_details = {
		   Email : Email,
		   Password : Password
   }
   console.log(LogIn_details);
 $.ajax({
  url : '/Login',
  data : JSON.stringify(LogIn_details),
 type: 'post',
 contentType : 'application/json; charset=utf-8',
 success: function(data){
		if(data == 200){	
	        $(location).attr('href','Home.jsp');
		}else {
			alert("Fail... Enter the correct details");
		}
	}	
   });
//   console.log(LogIn_details);
//   var params = _.extend({
//	      type:         'GET',
//	      dataType:     'json',
//	      processData:  false,
//	      contentType : 'application/json; charset=utf-8',
//	    });
//  var LogIn = new SignIn_UP({ data: $.param({ UserName : userName, Email : email}) });
// console.log(LogIn);
//  LogIn.fetch();
    
} else {
	alert("Enter the details correctly");
}
	},
	initialize : function (){
     this.render();
	},
	render : function (){
	var template = _.template($('#TemplateLogIn').html(),{});   
    this.$el.prepend(template);
     $("#SignUpRow").hide();
	}
});