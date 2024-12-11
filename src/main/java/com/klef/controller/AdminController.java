package com.klef.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.klef.model.Admin;
import com.klef.service.AdminService;

@Controller
@CrossOrigin(origins = "http://localhost:3000") 
public class AdminController {
	@Autowired
	  private AdminService adminservice;
	 
	  
	  @GetMapping("/adminhome")
	  public String home()
	  {
	    return "Property Management";
	  }
	  @PostMapping("adminlogin")
	    @ResponseBody 
	    public String adminLogin(@RequestBody Admin a)
	    {
	      String uname=a.getUsername();
	      String pwd=a.getPassword();
	      System.out.println(uname);
	      System.out.println(pwd);
	      Admin ad= adminservice.checkAdminLogin(uname, pwd);
	      if(ad!=null)
	        return "Login Successful";
	      else
	        return "Login fail";
	     
	    }

}
