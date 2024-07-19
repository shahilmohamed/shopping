package com.jsp.shopping.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Query;
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

	public List<Staff> getStaffById(int id) {
		// TODO Auto-generated method stub
		SessionFactory factory = ConfigClass.getSession();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("id", id));
		List<Staff> list = criteria.list();
		return list;
	}
	
	public List<Staff> getStaffByName(String name) {
		// TODO Auto-generated method stub
		SessionFactory factory = ConfigClass.getSession();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("name", name));
		List<Staff> list = criteria.list();
		return list;
	}
	
	public String insert(Staff staff)
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

	public String delete(int id) {
		SessionFactory factory = ConfigClass.getSession();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery("delete from Staff where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		tr.commit();
		session.close();
		return "Deleted";
	}

	public List<Staff> getSortedStaff() {
		// TODO Auto-generated method stub
		SessionFactory factory = ConfigClass.getSession();
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Staff.class);
		List<Staff> list = criteria.list();
		List<Staff> list2 = list.stream().sorted().collect(Collectors.toList());
		return list2;
	}

}
