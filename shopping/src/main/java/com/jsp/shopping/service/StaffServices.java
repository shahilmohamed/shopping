package com.jsp.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.shopping.dao.StaffDao;
import com.jsp.shopping.dto.Staff;

@Service
public class StaffServices {


	@Autowired
	StaffDao staffDao;
	public List<Staff> getStaff() {
		System.out.println("In service");
		List<Staff> list = staffDao.getStaff();
		return list;
	}
	public List<Staff> getStaffById(int id) {
		// TODO Auto-generated method stub
		List<Staff> list = staffDao.getStaffById(id);
		return list;
	}
	public List<Staff> getStaffByName(String name) {
		// TODO Auto-generated method stub
		List<Staff> list = staffDao.getStaffByName(name);
		return list;
	}
	public String insert(Staff staff)
	{
		String res = staffDao.insert(staff);
		return res;
	}
	public String delete(int id) {
		String res = staffDao.delete(id);
		return res;
	}
	public List<Staff> getSortedStaff() {
		List<Staff> list = staffDao.getSortedStaff();
		return list;
	}
	

}
