package com.eg;
import java.io.IOException;




import java.io.PrintWriter;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.data.CustomerJDO;
import com.data.LogInJDO;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gson.Gson;

@Controller
public class ControllerClass {
	
@RequestMapping("/")
String Home() {
	return "Home";
}	
@RequestMapping("/HomePage")
String Customer() {
	return "HomePage";
}	
@RequestMapping(value="/SaveCustomerData/*")
void SaveCustomer(@RequestBody String data,HttpServletResponse response, HttpServletRequest request) throws IOException, JSONException {	
	System.out.println("save customer");
	//System.out.println(data);
	PersistenceManager pm = PMF.get().getPersistenceManager();
	HttpSession session = request.getSession();
	String AccountEmail = (String) session.getAttribute("AccountEmail");
	String name = new JSONObject(data).getString("Name");
	String mobileNumber = new JSONObject(data).getString("MobileNo");
	String CustomerEmail =new JSONObject(data).getString("Email");
	String Address = new JSONObject(data).getString("Address");
	String Id = new JSONObject(data).getString("id");
	CustomerJDO customer = new CustomerJDO();
		customer.setName(name);
		customer.setEmail(CustomerEmail);
		customer.setAddress(Address);
		customer.setMobileNumber(mobileNumber);
		customer.setId(Id);
		customer.setAccountEmail(AccountEmail);
		try {
			pm.makePersistent(customer);	
		} finally {
			pm.close();
		}
}
@RequestMapping(value="/SaveCustomerData/{id}", method = RequestMethod.GET)
void fetchCustomer(@PathVariable ("id") String id,HttpServletResponse response, HttpServletRequest request) throws IOException, JSONException {
System.out.println("fetch data");
PrintWriter out = response.getWriter();

//System.out.println(id);
PersistenceManager pm = PMF.get().getPersistenceManager();
HttpSession session = request.getSession();
String AccountEmail = (String) session.getAttribute("AccountEmail");
//System.out.println(AccountEmail);
Query q = pm.newQuery(CustomerJDO.class, " AccountEmail== '" + AccountEmail + "' && Id== '" + id +"'");
//System.out.println(q);
List<CustomerJDO> list= (List<CustomerJDO>) q.execute();
//System.out.println(list);
System.out.println(new Gson().toJson(list));
out.println(new Gson().toJson(list));
//return new Gson().toJson(list);
}

@RequestMapping(value="/SaveCustomerData/{id}", method = RequestMethod.DELETE)
void Delete(@PathVariable ("id") String id,HttpServletResponse response, HttpServletRequest request) throws IOException, JSONException{
	
	PersistenceManager pm = PMF.get().getPersistenceManager();
	HttpSession session = request.getSession();
	String AccountEmail = (String) session.getAttribute("AccountEmail");
	Query q = pm.newQuery(CustomerJDO.class, " AccountEmail== '" + AccountEmail + "' && Id== '" + id +"'");
	List<CustomerJDO> l1 = (List<CustomerJDO>) q.execute();
	if (!l1.isEmpty()) {
		for (CustomerJDO obj : l1) {
			pm.deletePersistent(obj);		
		}
	}
}

@RequestMapping(value="/Fetchall2")
@ResponseBody
public String LogInFetch(@RequestBody String data,HttpServletResponse response, HttpServletRequest request) throws IOException, JSONException {
	PersistenceManager pm = PMF.get().getPersistenceManager();
	//PrintWriter out = response.getWriter();
	HttpSession session = request.getSession();
	String LoginEmail = String.valueOf(session.getAttribute("AccountEmail"));
	Query q = pm.newQuery(CustomerJDO.class);
	q.setFilter("AccountEmail == '"+LoginEmail+"'");
	//System.out.println(q);
	List<CustomerJDO> list= (List<CustomerJDO>) q.execute();
	System.out.println(new Gson().toJson(list));
	//out.println(new Gson().toJson(list));
return new Gson().toJson(list);
}
@RequestMapping(value="/UpdateCustomerData/*")
void UpdateCustomer(@RequestBody String data, HttpServletResponse response, HttpServletRequest request) throws JSONException {
	System.out.println("This is in the update function");
	PersistenceManager pm = PMF.get().getPersistenceManager();
	HttpSession session = request.getSession();
	String AccountEmail = (String) session.getAttribute("AccountEmail");
	String name = new JSONObject(data).getString("Name");
	String mobileNumber = new JSONObject(data).getString("MobileNo");
	String CustomerEmail =new JSONObject(data).getString("Email");
	String Address = new JSONObject(data).getString("Address");
	String Id = new JSONObject(data).getString("id");
	CustomerJDO customer = new CustomerJDO();
	Query q = pm.newQuery(CustomerJDO.class, " AccountEmail== '" + AccountEmail + "' && Id== '" + Id +"'");
	List<CustomerJDO> l1 = (List<CustomerJDO>) q.execute();
	if (!l1.isEmpty()) {
		for (CustomerJDO obj : l1) {
			obj.setName(name);
			obj.setEmail(CustomerEmail);
			obj.setAddress(Address);
			obj.setMobileNumber(mobileNumber);
			obj.setId(Id);
			obj.setAccountEmail(AccountEmail);
			try {
				pm.makePersistent(obj);	
			} finally {
				pm.close();
			}	
		}
	}
		
}
}
