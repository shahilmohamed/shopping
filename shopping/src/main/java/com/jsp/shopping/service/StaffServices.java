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
	public static List<Staff> getStaffById(int id) {
		// TODO Auto-generated method stub
		List<Staff> list = StaffDao.getStaffById(id);
		return list;
	}
	public static String insert(Staff staff)
	{
		String res = StaffDao.insert(staff);
		return res;
	}
	

}
