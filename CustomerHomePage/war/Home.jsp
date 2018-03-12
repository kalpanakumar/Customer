<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

 <%
	response.setHeader( "Pragma", "no-cache" );
	response.setHeader( "Cache-Control", "private, no-cache, no-store, must-revalidate proxy-revalidate" );
	response.setDateHeader( "Expires", 0 );
	String UserKey = (String) session.getAttribute("AccountEmail");
	System.out.println(UserKey);
	if(UserKey == null){
		response.sendRedirect("/HomePage");
	}
%> 
<!DOCTYPE html>
<html>
   <head>
      <style>
  #header{
  background:#24afa9; 
}
.well{
  background-color: #45494a;
  font-size: 22px;
  color: white;
position:relative;
z-index: 1;
  }

  #background {
   position: fixed;
    top: 0px;
    left: 0px;
    width: 350px;
    height: 100%;
    background-color: #F5F5F5;    
}


#AddCustomerDiv{
  border-bottom: 1px solid  #696969;
    padding: 30px 0 20px 0px;
    margin-top: 70px;
    margin-right : -20px;
    width: 300px;
}
#newCustomer {
    border-radius: 3px;
    font-weight: bold;
    font-size: 20px;
    line-height: 28px;
    height: 35px;
    width: 30px;
    padding: 0px;
    float: right;
    border: solid 1px #D7D7D7;
    background: #FFF;
    text-decoration: none;
    color: #000;
    text-indent: 0px;
    text-align: center;
    margin-top: -20px;
    margin-right: -20px;
    cursor: pointer;
    }
    ul div div{
  width: 95%;
  height:35px;
  background-color : white;
  padding-top : 4.5px;
  padding-left : 12px;
  margin-left : -10px;
}
#logOut{
float : right;
}
ul {
  list-style-type: none;
}
ul li{
  height : 40px;
  border-radius : 5px;
  margin-right: 30px;

}
ul li:hover{
      background: #E1E7EB;
}
.popUp {
  position:absolute;
    top: 120px;
    left: 100px;
    z-index: 2;
    max-width: 700px;
    padding: 1px;
    text-align: left;
    background-color: #ffffff;
    background-clip: padding-box;
    border: 1px solid #ccc;
    border: 1px solid rgba(0, 0, 0, 0.2);
    border-radius: 6px;
    box-shadow: 0 5px 10px rgba(0, 0, 0, 0.2);
    white-space: normal;
}

.inputBox {
  padding: 8px;
}


</style>
   </head>
   
   <body>
   <div class="container-fluid">
<div id  = "header" class="well">  <bold> Customers <bold> <button   id="logOut" type="button"><a href="/Logout" >Log Out</a></button> </div>
  <div  class="row">
    <div  class="col-md-4">
    <div id="background" >
    <div id = "AddCustomerDiv" > 
    <span id="newCustomer" > + </span>
    </div>
      <div class="popUp">
      </div>
      <div id ="test">
      <ul id = "list"> </ul> 
      </div>
</div>
</div>
    
    <div id="details" class="col-md-4">
     
    </div>
    <div class="col-md-4">
     <h4> Appointments </h4>
    </div>
  </div>
</div>

   </body>
   </script>
      <script src = "https://code.jquery.com/jquery-2.1.3.min.js"
         type = "text/javascript"></script>
      
      <script src = "https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.2/underscore-min.js" 
         type = "text/javascript"></script>
      
      <script src = "https://cdnjs.cloudflare.com/ajax/libs/backbone.js/1.1.2/backbone-min.js"
         type = "text/javascript"></script>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<script type ="text/template"  class="PopUp_Template">
<table style="width:100%" class="EnterDetails">
   <tr >
    <td class ="inputBox" >Add New Customer </td> 
  </tr>
  <tr>
    <td class ="inputBox"><input type="text" id="Name" placeholder = "Name" /></td> 
  </tr>
  <tr>  
    <td  class ="inputBox"><input type="text" id="Email" placeholder = "Email"/></td>
  </tr>
  <tr>
    <td class ="inputBox"><input type="text" id="MobileNo" placeholder = "Mobile No."/></td>
  </tr>
  <tr>
   
    <td class ="inputBox"><input type="text" id="Address" placeholder = "Address"/></td>
    
  </tr>
  <tr>
    <td class ="inputBox"><input  class="btn btn-primary" type="submit" id="Add" value = "Add Customer"/></td>
    <td  ><input  class="btn btn-primary" type="submit" id="Cancel" value = "Cancel"/></td>
  </tr>
</table>

 </script>
 <script type ="text/template" class="Model-list-template">
<table style="width:100%" id ="DetailsTemplate">
  
  <tr>
    <td>Name</td>
    <td><input type="text" id="DetailsName" name="fname" value = <@= Name @> ></td>
    
  </tr>
  <tr>
    <td>Email</td>
    <td><input type="text" id="DetailsEmail" name="fname" value = <@= Email @> ></td>
    
  </tr>
  <tr>
    <td>Mobile No.</td>
    <td><input type="text" id="DetailsMobile_No" name="fname" value = <@= MobileNo @> ></td>
    
  </tr>
  <tr>
    <td>Address</td>
    <td><input type="text" id="DetailsAddress" name="fname" value = <@= Address @> ></td>
    
  </tr>
  <tr>
    <td><button  class="update  btn-primary"> Update </button></td>
    <td><button  class="delete  btn-primary"> Delete </button></td>
    
  </tr>
</table>

      </script>
      <script>
	 	_.templateSettings = {
	 		    interpolate: /\<\@\=(.+?)\@\>/gim,
	 		    evaluate: /\<\@([\s\S]+?)\@\>/gim,
	 		    escape: /\<\@\-(.+?)\@\>/gim
	 		};
			
		</script>
      
<script src= "ModelCustomer.js" ></script>
<script src= "View.js" ></script>

   </html>
