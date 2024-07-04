package com.jsp.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.shopping.dao.StaffDao;
import com.jsp.shopping.dto.Staff;
import com.jsp.shopping.service.StaffServices;

@RestController
public class SpringController {

	@Autowired
	StaffServices springservices;
	@Autowired
	StaffDao dao;
	@RequestMapping("check")
	public String check()
	{
		return "0k";
	}
	
	@GetMapping("getstaffdata")
	public List<Staff> getStaff()
	{
		System.out.println("In controller");
		List<Staff> list = springservices.getStaff();
		return list;
	}
	
	@GetMapping("getstaffbyid/{id}")
	public List<Staff> getStaffById(@PathVariable int id)
	{
		List<Staff> list = StaffServices.getStaffById(id);
		return list;
	}
	@PostMapping("insertstaff")
	public static String insert(@RequestBody Staff staff)
	{
		String res = StaffServices.insert(staff);
		return res;
	}
	
}
