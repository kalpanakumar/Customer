package com.eg;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.data.LogInJDO;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gson.Gson;

@Controller
public class LogInSignUp {
	
	 @RequestMapping(method=RequestMethod.POST, value="/Login")
	    public void LogIn(HttpServletRequest request,HttpServletResponse resp, @RequestBody String data, HttpSession session) throws IOException, JSONException {  	
		JSONObject JSON = null;	
		PrintWriter out = resp.getWriter();
			PersistenceManager pm = PMF.get().getPersistenceManager();
			JSON = new JSONObject(data);
			String email = JSON.getString("Email");
			String password = JSON.getString("Password");
			HttpSession Session = request.getSession();
		//	Session.setAttribute("AccountEmail", email);
			Query q = pm.newQuery(LogInJDO.class, "Email == '" + email + "' && Password== '" + password + "'");
			List<LogInJDO> ReqEmail = (List<LogInJDO>) q.execute();
			if (!ReqEmail.isEmpty()) {		
				out.println(200);
				Session.setAttribute("AccountEmail", email);
			} else {
				out.println(400);
			}
	}
	 @RequestMapping(value = "/SaveLogin", method=RequestMethod.POST)
public void SignUp (@RequestBody String data,HttpServletResponse response, HttpServletRequest request) throws IOException, JSONException {	
		 
		 PrintWriter out = response.getWriter();
			PersistenceManager pm = PMF.get().getPersistenceManager();
			//System.out.println(data);
			String Email = new JSONObject(data).getString("Email");
			HttpSession session = request.getSession();
			session.setAttribute("AccountEmail", Email);
			String Password = new JSONObject(data).getString("Password");
			LogInJDO Signin = new LogInJDO();
			Signin.setEmail(Email);
			Signin.setPassword(Password);	
			Query q = pm.newQuery(LogInJDO.class, "Email== '" + Email + "'");
			List<LogInJDO> ReqEmail = (List<LogInJDO>) q.execute();
			if (!ReqEmail.isEmpty()) {
				out.println(400);		
			} else {
			
				try {
					pm.makePersistent(Signin);
				} finally {
					pm.close();
				}
				out.println(200);
			}
			
			
		}
	 @RequestMapping(value="/Logout", method=RequestMethod.GET)
	
	 void WelcomePage (HttpServletRequest request,HttpServletResponse response) throws IOException {
		
	 	request.getSession().invalidate();
	 	response.sendRedirect("/HomePage");
	 }
	 
}
