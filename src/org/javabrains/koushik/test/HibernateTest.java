package org.javabrains.koushik.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.UserDetails;
import org.javabrains.koushik.dto.Vehicle;
import org.javabrains.koushik.valueobjects.Credentials;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails user1 = new UserDetails();
		
		Credentials user1Credentials = new Credentials();
		user1Credentials.setLoginId("raj44");
		user1Credentials.setLoginPassword("rajsekhar");
		
		user1.setCredentials(user1Credentials);
		user1.setUserName("1st User");
		user1.setJoinedDate(new Date());
		user1.setJoinedTime(new Date());
		user1.setDescription("Skilled in Spring and Hibernate");
		user1.setUserType("Permanent");
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Jumbo Jet");
		
		Vehicle anotherVehicle = new Vehicle();
		anotherVehicle.setVehicleName("Flying Saucer");
		
		/*user1.getVehicles().add(vehicle);
		user1.getVehicles().add(anotherVehicle);
		vehicle.setUser(user1);
		anotherVehicle.setUser(user1);*/
		
		user1.assignVehicle(vehicle);
		user1.assignVehicle(anotherVehicle);
		
		UserDetails user2 = new UserDetails();
		
		Credentials user2Credentials = new Credentials();
		user2Credentials.setLoginId("loginId");
		user2Credentials.setLoginPassword("loginPassword");
		
		user2.setCredentials(user2Credentials);
		user2.setUserName("2nd User");
		user2.setJoinedDate(new Date());
		user2.setJoinedTime(new Date());
		user2.setUserType("Contract");
		user2.setDescription("Hands on experience with multiple Javascript frameworks");
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user1);
		session.save(vehicle);
		session.save(anotherVehicle);
		session.save(user2);
		session.getTransaction().commit();
		
		/*session.clear();
		
		UserDetails retrievedUser = new UserDetails();
		session = factory.openSession();
		session.beginTransaction();
		retrievedUser = session.get(UserDetails.class, user2.getCredentials());

		session.getTransaction().commit();
		
		System.out.println("Retrieved User object: " + retrievedUser);*/

		session.close();		
		
		session.getSessionFactory().close();
		
	}

}

