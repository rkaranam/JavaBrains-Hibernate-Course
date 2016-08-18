package org.javabrains.koushik.test;

import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.UserDetails;
import org.javabrains.koushik.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user1 = new UserDetails();
		
		user1.setUserName("1st User");
		user1.setJoinedDate(new Date());
		user1.setJoinedTime(new Date());
		user1.setDescription("Skilled in Spring and Hibernate");
		user1.setUserType("Permanent");
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Jumbo Jet");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Flying Saucer");
		
		user1.assignVehicle(vehicle1);
		user1.assignVehicle(vehicle2);
		
		UserDetails user2 = new UserDetails();
		
		user2.setUserName("2nd User");
		user2.setJoinedDate(new Date());
		user2.setJoinedTime(new Date());
		user2.setUserType("Contract");
		user2.setDescription("Hands on experience with multiple Javascript frameworks");

		Vehicle vehicle3 = new Vehicle();
		vehicle3.setVehicleName("512m Gaint Wheel");
		
		user2.assignVehicle(vehicle3);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user1);
		session.save(vehicle1);
		session.save(vehicle2);
		session.save(user2);
		session.save(vehicle3);
		session.getTransaction().commit();
		
		session.clear();
		
		UserDetails retrievedUser = new UserDetails();
		session = factory.openSession();
		session.beginTransaction();
		retrievedUser = session.get(UserDetails.class, user1.getUserId());

		session.getTransaction().commit();
		
		System.out.println("Retrieved User object: " + retrievedUser);
		
		Collection<Vehicle> vehicles = retrievedUser.getVehicles();
		
		for(Vehicle vehicle : vehicles) {
			System.out.println("Retrieved user vehicles: " + vehicle);
		}

		session.close();		
		
		session.getSessionFactory().close();
		
	}

}

