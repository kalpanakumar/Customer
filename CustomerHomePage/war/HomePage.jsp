<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%
	response.setHeader( "Pragma", "no-cache" );
	response.setHeader( "Cache-Control", "private, no-cache, no-store, must-revalidate proxy-revalidate" );
	response.setDateHeader( "Expires", 0 );
	String UserKey = (String) session.getAttribute("AccountEmail");
	System.out.println(UserKey);
	if(UserKey != null){
		response.sendRedirect("/");
	}
%> 



<!DOCTYPE html>
<html>

<body>

<div id="Outer"> 

<div id="LogIn">
New User <button class="btn btn-primary" id ="SignUp"> Sign Up </button>
</div>
</div>

</body>
<script type ="text/template"  id="TemplateLogIn"> 
<h1 id="title">Log In</h1>

<table cellpadding="10" style="width:100%" id="Content" >
   
  <tr>
  <td>UserName</td>
     <td class ="inputBox"><input type="text" id="UserName" placeholder = "UseName" /></td> 
  </tr>
  <tr>
   <td>Password</td>  
    <td  class ="inputBox"><input type="text" id="Password" placeholder = "Password"/></td>
  </tr>
  
  <tr  id ="LogInRow">
  <td></td>
    <td class ="inputBox"><input class="btn btn-primary" type="submit" id="Add" value = "Log In"/></td>
  </tr>
  <tr  id ="SignUpRow">
  <td></td>
    <td class ="inputBox"><input class="btn btn-primary" type="submit" id="Create" value = "Sign Up"/></td>
  </tr>
</table>
</script>

<script src = "https://code.jquery.com/jquery-2.1.3.min.js"
         type = "text/javascript"></script>
      
      <script src = "https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.2/underscore-min.js" 
         type = "text/javascript"></script>
      
      <script src = "https://cdnjs.cloudflare.com/ajax/libs/backbone.js/1.1.2/backbone-min.js"
         type = "text/javascript"></script>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src= "ModelHomePage.js" ></script>
<script src= "ViewHomePage.js" ></script>
<style>
body{
  background-color: #27c3bb;
}
#Outer{
  display: block;
  margin: 150px auto ;
  height:340px;
  width: 350px;
   box-shadow: 0px 2px 15px #888888;  
   background-color: white;
   text-align: center;

}
#LogIn{
  padding-top: 25px ;
}
tr td {
  padding: 10px;
}
</style>
</html>