package com.jsp.shopping.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jsp.shopping.dto.Staff;
import com.jsp.shopping.helper.ConfigClass;



@Repository
public class StaffDao {

	public List<Staff> getStaff() {
		// TODO Auto-generated method stub
		SessionFactory factory = ConfigClass.getSession();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		List<Staff> list = criteria.list();
		System.out.println("In dao");
		session.close();
		return list;
		
	}

	public static List<Staff> getStaffById(int id) {
		// TODO Auto-generated method stub
		SessionFactory factory = ConfigClass.getSession();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("id", id));
		List<Staff> list = criteria.list();
		return list;
	}
	
	public static String insert(Staff staff)
	{
		Staff s = new Staff();
		s.setId(staff.getId());
		s.setName(staff.getName());
		s.setLocation(staff.getLocation());
		s.setMobile(staff.getMobile());
		SessionFactory factory = ConfigClass.getSession();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(s);
		tr.commit();
		
		return "Data inserted";
	}

}
