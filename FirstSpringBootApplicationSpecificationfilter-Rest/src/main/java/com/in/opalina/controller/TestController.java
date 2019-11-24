package com.in.opalina.controller;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.List;
import javax.validation.Valid;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.ws.Response;

import org.apache.tomcat.util.http.ResponseUtil;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.in.opalina.Application;
import com.in.opalina.dao.EmployeeRepository;
import com.in.opalina.model.Employee;
import com.in.opalina.model.User;
import com.in.opalina.services.UserServices;

@Validated
@RestController
public class TestController {

	@Autowired
	private UserServices userService;
	
	
	public MethodValidationPostProcessor methodValidationPostProcessor() {
	     return new MethodValidationPostProcessor();
	}
	

	@RequestMapping(value = "/home")
	public String getMessage() {
		return "SpringBoot is Working";

	}

	@RequestMapping(value = "findbyname/{name}", method = RequestMethod.GET)
	public List<User> findObjectByName(@PathVariable("name") String name) {

		System.out.print("=======>" + name);
		List<User> user = userService.findByUserName(name);
		System.out.print("=======>" + user);
		return user;
	}

	@RequestMapping(value = "findbyemail/{email}", method = RequestMethod.GET)
	public List<User> findObjectByEmial(@PathVariable("email") String email) {

		List<User> user = userService.findByUserEmail(email);
		return user;
	}

	@RequestMapping(value = "findall", method = RequestMethod.GET)
	public Page<User> findObjectAll() {

		Page<User> user = userService.findAllUser();
		return user;
	}

	@RequestMapping(value = "findby/{object}", method = RequestMethod.GET)
	public List<User> findObjectCriteria(@PathVariable("object") String object) {

		List<User> user = userService.findByCriteria(object);
		return user;
	}

	@RequestMapping(value = "fetch", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<User> search(@RequestParam Map<String, String> all) {
		List<User> user = userService.searchUsers(all);
		
	String validationMessage =ValidateKeyAndValue(all);		
		
		//Page<User> user = userService.searchCriteria(all);
		
		return user;
	}
	

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public User createUser() {

		User user = new User();
		user.setFirstName("anu");
		user.setLastName("maurya");
		user.setEmail("anu@gmail.com");
		user.setDesignation("php");
		user.setAge(25);

		User user1 = new User();
		user1.setFirstName("raj");
		user1.setLastName("maurya");
		user1.setEmail("raj@gmail.com");
		user1.setDesignation("java");
		user1.setAge(23);
		
		Employee emp=new Employee();
		emp.setName("Aman");
		emp.setSalary(3847l);
		userService.createEmp(emp);

		userService.createUser(user);
		userService.createUser(user1);
		return user;
	}
	
	public static String ValidateKeyAndValue(Map<String,String> all)
	{
		String status =null;
		for(Map.Entry<String,String> keyVal:all.entrySet())
		{
			if(keyVal.getKey()=="id"==true)
			{
				
			String val=	keyVal.getValue();
			if(val!=null)
			{
				return status = "Valid Key And Value";
			}
				
			}
			else {
			String s=keyVal.getKey();
			return status ="Invalid Key Name"+s;
				
			}
			
			
		}
		return "success";
		
	}
	
	public static <T> String[] getProperties(T entity){
	    String[] properties = null;
	    try {
	    	Field[] fields =entity.getClass().getDeclaredFields();
	       
	        properties = new String[fields.length];
	        for(int i = 0 ; i < fields.length ; i++){
	            Object propertyValue = fields[i].getName();
	            if(propertyValue != null){
	                properties[i] = propertyValue.toString();
	                System.out.println("===||===>"+properties[i].toString());
	            } else {
	                properties[i] = null;
	            }
	        }
	    } catch (Exception e){
	        //Handle your exception here.
	    }
	    return properties;
	}
	public static void main(String str[])
	{
		
	
		Employee emp=new Employee();
			
		 getProperties(emp); 
		
	}

}
