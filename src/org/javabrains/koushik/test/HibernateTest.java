package org.javabrains.koushik.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.Address;
import org.javabrains.koushik.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user1 = new UserDetails();
		user1.setUserName("1st User");
		user1.setJoinedDate(new Date());
		user1.setJoinedTime(new Date());
		user1.setDescription("Skilled in Spring and Hibernate");
		user1.setUserType("Permanent");
		// user1.setAddress("Wall Street, California");
		// user1.setAddress(new Address("Long Road", "Bohemia", "Prague", "110181"));
		
		Address user1Addr = new Address();
		user1Addr.setStreet("Sea Rd");
		user1Addr.setCity("Bohemia");
		user1Addr.setState("Prague");
		user1Addr.setPincode("1101");
		
		user1.setAddress(user1Addr);
		
		UserDetails user2 = new UserDetails();
		user2.setUserName("2nd User");
		user2.setJoinedDate(new Date());
		user2.setJoinedTime(new Date());
		user2.setUserType("Contract");
		user2.setDescription("Hands on experience with multiple Javascript frameworks");
		// user2.setAddress("Beijing, China");
		// user2.setAddress(new Address("Race Court Rd", "San Jose", "California", "1022"));
		
		Address user2Addr = new Address();
		user2Addr.setStreet("Race Court Rd");
		user2Addr.setCity("Pennylsvania");
		user2Addr.setState("California");
		user2Addr.setPincode("1022");
		
		user2.setAddress(user2Addr);
		
		UserDetails user3 = new UserDetails();
		user3.setUserName("3rd User");
		user3.setJoinedDate(new Date());
		user3.setDescription("Experienced Frontend developer");
		user3.setAddress(new Address());
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user1);
		session.save(user2);
		session.save(user3);
		session.getTransaction().commit();
		session.clear();
		
		UserDetails retrievedUser = new UserDetails();
		session = factory.openSession();
		session.beginTransaction();
		retrievedUser = session.get(UserDetails.class, user2.getUserId());
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Retried User Object: " + retrievedUser.getAddress());
		
		session.getSessionFactory().close();
		
	}

}

