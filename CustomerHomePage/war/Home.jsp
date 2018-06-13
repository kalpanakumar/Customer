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
input {
border-style: none;
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
 
    padding: 30px 0 20px 0px;
    margin-top: 70px;
    margin-right : -20px;
    width: 300px;
}
.NewLabel{

    cursor: pointer;
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
cursor: pointer;
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
#DetailsTemplate tr td input:hover{
      background: #ccccc ;
}

#DetailsTemplate :hover input {
background: #E1E7EB;
}
#DetailsTemplate input{
    height:30px;
border-radius: 3px;
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


table td {
    padding: 8px;
}
.DetailsLable {
color: #999;
}
.glyphicon-plus-sign {
    color: #27C3BB;
    cursor: pointer;
    font-size: 18px;
     margin:5px;
}
.glyphicon-minus-sign{
   color: #27C3BB;
    cursor: pointer;
    font-size: 18px;
      margin:5px;
}
html { overflow-x: hidden; }
.dropbtn {
    background-color: #4CAF50;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
}

.dropdown {
    position: relative;
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #f1f1f1;
   
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

.dropdown-content a:hover {background-color: #ddd}

.dropdown:hover .dropdown-content {
    display: block;
}

.dropdown:hover .dropbtn {
    background-color: #3e8e41;
}

</style>
   </head>
   
   <body>
   
<div id  = "header" class="well">  <bold> Customers <bold> <div  id ="logOut" class="dropdown">
  <span class="glyphicon glyphicon-user" ></span>
  <div class="dropdown-content" style="margin-left:-60px">
    <a href="Logout" style="text-decoration: none">Logout</a>  
  </div>
</div> </div>
  <div  class="row">
    <div  class="col-md-4">
    <div id="background" >
    <div id = "AddCustomerDiv" > 
    <span id="newCustomer" > + </span>
    </div>
    <hr style="margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid ;"">
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
<table cellspacing="40" style="width:100%; padding: 0;" class="EnterDetails">
   <tr>
    <td class ="inputBox" >Add New Customer </td> 
  </tr>
  <tr>

    <td class ="inputBox"><input style ="width: 78%" type="text" id="Name" placeholder = "Name" /></td> 
  <td></td>
</tr>
  <tr> 

    <td class ="inputBox"><input style ="width: 78%" class="InputextraField" name="InputEmail[]" type="text" id="Email" placeholder = "Email" /><span class="glyphicon glyphicon-plus-sign">  </span></td> 
<td><select name="Myselect" class="myselect">
  <option value="Home">Home</option>
  <option value="Work">Work</option>
  <option id ="Others" value="Other">Other</option>
</select></td>
</tr>
  <tr>
    <td class ="inputBox"><input style ="width: 78%" class="InputextraField" name="InputMobile[]" type="text" id="MobileNo" placeholder = "Mobile No."/><span class="glyphicon glyphicon-plus-sign">  </span></td>
  <td  width="20px"><select name="Myselect" class="myselect">
  <option value="Home">Home</option>
  <option value="Work">Work</option>
  <option value="Other">Other</option>
</select> </td>
</tr>
  <tr>

    <td class ="inputBox"><input style ="width: 78%" type="text" id="Address" placeholder = "Address"/></td>
  <td></td>
</tr>
  <tr>
    <td class ="inputBox"><input  class="btn btn-primary" type="submit" id="Add" value = "Add"/></td>
    <td  ><input  class="btn btn-primary" type="submit" id="Cancel" value = "Cancel"/></td>
  </tr>
</table>

 </script>
 <script type ="text/template" class="Model-list-template">
<table cellspacing="40" style="width:100%; padding: 0;" id ="DetailsTemplate">
 <tr>
    <td class="DetailsLable">Name</td>
    <td><input type="text" id="DetailsName" name="fname" size="28" value = <@= Name @> ></td>
  </tr>
<tr>

<@ if(Label.length == 0) { @>
<td class="DetailsLable">Email<select class="myselect">
  <option value="Home">Home</option>
  <option value="Work">Work</option>
  <option class="Others" value="Other">Other</option>
</select></td>
    <td><input class="extraField" type="text" id="DetailsEmail" name="Email[]" size="28"  ><span class="glyphicon glyphicon-plus-sign">  </span></td>
  </tr>
<@  }else  { @>	
<td class="DetailsLable">Email<select class="myselect">
  <option selected Value=<@=Label[0]@>><@=Label[0]@></option>
  <option value="Home">Home</option>
  <option value="Work">Work</option>
  <option class="Others" value="Other">Other</option>
</select></td>
    <td><input class="extraField" type="text" id="DetailsEmail" name="Email[]" size="28" value = <@= Email[0] @> ><span class="glyphicon glyphicon-plus-sign">  </span></td>
  </tr>
<@ } @>
<@ for(var i=1;i < Email.length; i++ ) { 
if($.trim(Email[i]).length > 0) { @>
  <tr>
  <td class="DetailsLable">Email<select class="myselect">
  <option selected Value=<@=Label[i] @>><@=Label[i] @></option>
  <option value="Home">Home</option>
  <option value="Work">Work</option>
  <option class="Others" value="Other">Other</option>
</select></td>
    <td><input class="extraField" type="text" id="DetailsEmail" name="Email[]" size="28" value = <@= Email[i] @> ><span class="glyphicon glyphicon-minus-sign">  </span></td>
  </tr>
	<@ } }@>
<@if(MobileLable.length == 0) { @>
<tr>
    <td class="DetailsLable">Mobile<select class="myselect">
  <option value="Home">Home</option>
  <option value="Work">Work</option>
  <option class="Others" value="Other">Other</option>
</select></td>
</td>
    <td><input class="extraField" type="text" id="DetailsMobile_No" name="MobileNo[]" size="28"  ><span id ="test" class="glyphicon glyphicon-plus-sign">  </span></td>
  </tr>
  <tr>
<@  }else  { @>
    <td class="DetailsLable">Mobile<select class="myselect">
  <option selected Value=<@=MobileLable[0] @>><@=MobileLable[0] @></option>
  <option value="Home">Home</option>
  <option value="Work">Work</option>
  <option class="Others" value="Other">Other</option>
</select></td>
</td>
    <td><input class="extraField" type="text" id="DetailsMobile_No" name="MobileNo[]" size="28" value = <@= MobileNo[0] @> ><span id ="test" class="glyphicon glyphicon-plus-sign">  </span></td>
  </tr>
<@ } @>
<@ for(var i=1;i < MobileNo.length; i++ ) {
if($.trim(MobileNo[i]).length > 0) {@>
  <tr>
  <td class="DetailsLable">Mobile<select class="myselect">
  <option selected Value=<@=MobileLable[i] @>><@=MobileLable[i] @></option>
  <option value="Home">Home</option>
  <option value="Work">Work</option>
  <option class="Others" value="Other">Other</option>
</select></td>
    <td><input class="extraField" type="text" id="DetailsMobile_No" name="MobileNo[]" size="28" value = <@= MobileNo[i] @> ><span class="glyphicon glyphicon-minus-sign">  </span></td>
  </tr>
	<@  }}@>
  <tr>
    <td class="DetailsLable">Address</td>
    <td><input " type="text" id="DetailsAddress" name="fname" size="28" value = <@= Address @> ></td>
    
  </tr>
  <tr>
    <td><button  class="update  btn-primary"> Update </button></td>
    <td><button   class="delete  btn-primary"> Delete </button></td>
    
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
