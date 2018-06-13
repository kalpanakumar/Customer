package com.eg;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
import com.google.appengine.labs.repackaged.org.json.JSONArray;
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
	HashMap< String,String> Email = new HashMap< String,String>();
	HashMap< String,String> mobileNumber = new HashMap< String,String>();
	PersistenceManager pm = PMF.get().getPersistenceManager();
	HttpSession session = request.getSession();
	String AccountEmail = (String) session.getAttribute("AccountEmail");
	String name = new JSONObject(data).getString("Name");
	//String mobileNumber = new JSONObject(data).getString("MobileNo");
	JSONArray CustomerMobileArray = new JSONObject(data).getJSONArray("MobileNo");
	JSONArray CustomerMobileLabelArray = new JSONObject(data).getJSONArray("MobileLable");
	JSONArray CustomerEmailArray = new JSONObject(data).getJSONArray("Email");
	JSONArray CustomerLabel =new JSONObject(data).getJSONArray("Label");
	String[] EmailArray = new String[CustomerEmailArray.length()];
	String[] EmailArrayLabel= new String[CustomerLabel.length()];
	String[] MobileArray = new String[CustomerMobileArray.length()];
	String[] MobileArrayLabel= new String[CustomerMobileLabelArray.length()];
	
for(int i=0; i<CustomerEmailArray.length();i++) {
	//System.out.println("email Array");
	Email.put(CustomerEmailArray.optString(i), CustomerLabel.optString(i));
}
for(int i=0; i<CustomerMobileArray.length();i++) {
	mobileNumber.put(CustomerMobileArray.optString(i), CustomerMobileLabelArray.optString(i));
}
System.out.print(CustomerEmailArray);
//Email.values().removeAll(Collections.singleton(""));
for (Map.Entry<String,String> me:Email.entrySet())
{
    System.out.print(me.getKey()+" checkkey ");
    System.out.println(me.getValue());
}
	
	String Address = new JSONObject(data).getString("Address");
	String Id = new JSONObject(data).getString("id");
	CustomerJDO customer = new CustomerJDO();
		customer.setName(name);
		customer.setEmail(Email);
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
//System.out.println(new Gson().toJson(list));
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
	List<CustomerJDO> list= (List<CustomerJDO>) q.execute();
	//CustomerJDO[] listofAllCust = null;
	
	HashMap<Integer, CustomerJDO> outList = new HashMap<>();
	for(Integer i=0 ;i<list.size();i++) {
		CustomerJDO listofAllCust = list.get(i);
		//System.out.println("hell ow");
		System.out.println(new Gson().toJson(listofAllCust.getEmail()));
		System.out.println(new Gson().toJson(listofAllCust.getMobileNumber()));
		outList.put(i, listofAllCust);
	}
	System.out.println(new Gson().toJson(outList));
	return new Gson().toJson(outList);
//	for( int i=0;i<list.size(); i++) {
//	 listofAllCust[i] = list.get(i);
//	}
//	return new Gson().toJson(listofAllCust);

}
@RequestMapping(value="/UpdateCustomerData/*")
void UpdateCustomer(@RequestBody String data, HttpServletResponse response, HttpServletRequest request) throws JSONException {
	HashMap< String,String> Email = new HashMap< String,String>();
	HashMap< String,String> mobileNumber = new HashMap< String,String>();

//	System.out.println("This is in the update function");
	PersistenceManager pm = PMF.get().getPersistenceManager();
	HttpSession session = request.getSession();
	String AccountEmail = (String) session.getAttribute("AccountEmail");
	String name = new JSONObject(data).getString("Name");
	
//	String mobileNumber = new JSONObject(data).getString("MobileNo");
//	String CustomerEmail =new JSONObject(data).getString("Email");
	
	
//	System.out.println("Email is " +  CustomerEmail);
//	String Email1 = new JSONObject(CustomerEmail).getString("Email");
//	System.out.println(Email1);
//	String Label1 = new JSONObject(CustomerEmail).getString("Label");
//	System.out.println(Label1);
//	for(int i=0; i<=Email1.length() ; i++) {
//	}
//	//Map<String, String> days = IntStream.range(0, Email1.length).boxed()
//	//	    .collect(Collectors.toMap(i -> Email1[i], i -> Label1[i]));
	JSONArray CustomerEmailArray = new JSONObject(data).getJSONArray("Email");
	JSONArray CustomerLabel =new JSONObject(data).getJSONArray("Label");
	String[] EmailArray = new String[CustomerEmailArray.length()];
	String[] EmailArrayLabel= new String[CustomerLabel.length()];
	JSONArray CustomerMobileArray = new JSONObject(data).getJSONArray("MobileNo");
	JSONArray CustomerMobileLabelArray = new JSONObject(data).getJSONArray("MobileLable");
	String[] MobileArray = new String[CustomerMobileArray.length()];
	String[] MobileArrayLabel= new String[CustomerMobileLabelArray.length()];
	
//	System.out.println(" first position " + CustomerEmailArray.optString(0));
//System.out.println("full array " + CustomerEmailArray);
for(int i=0; i<CustomerEmailArray.length();i++) {
	Email.put(CustomerEmailArray.optString(i), CustomerLabel.optString(i));
}
for(int i=0; i<CustomerMobileArray.length();i++) {
	mobileNumber.put(CustomerMobileArray.optString(i), CustomerMobileLabelArray.optString(i));
}
//Email.values().removeAll(Collections.singleton(""));
//for (Map.Entry< String,String> me:Email.entrySet())
//{
//   System.out.print(me.getKey()+" check ");
//   System.out.println(me.getValue());
//}
	String Address = new JSONObject(data).getString("Address");
	String Id = new JSONObject(data).getString("id");
	CustomerJDO customer = new CustomerJDO();
	Query q = pm.newQuery(CustomerJDO.class, " AccountEmail== '" + AccountEmail + "' && Id== '" + Id +"'");
	List<CustomerJDO> l1 = (List<CustomerJDO>) q.execute();
	if (!l1.isEmpty()) {
		for (CustomerJDO obj : l1) {
			obj.setName(name);
			obj.setEmail(Email);
			//obj.setEmail(CustomerEmail);
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
