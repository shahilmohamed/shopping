package com.jsp.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	StaffServices staffservices;
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
		List<Staff> list = staffservices.getStaff();
		return list;
	}
	
	@GetMapping("getsortedstaff")
	public List<Staff> getSortedStaff()
	{
		List<Staff> list = staffservices.getSortedStaff();
		return list;
	}
	
	@GetMapping("getstaffbyid/{id}")
	public List<Staff> getStaffById(@PathVariable int id)
	{
		List<Staff> list = staffservices.getStaffById(id);
		return list;
	}
	@GetMapping("getstaffbyname/{name}")
	public List<Staff> getStaffByName(@PathVariable String name)
	{
		List<Staff> list = staffservices.getStaffByName(name);
		return list;
	}
	@PostMapping("insertstaff")
	public String insert(@RequestBody Staff staff)
	{
		String res = staffservices.insert(staff);
		return res;
	}
	@DeleteMapping("deletestaff/{id}")
	public String delete(@PathVariable int id)
	{
		String res = staffservices.delete(id);
		return res;
	}
	
}
