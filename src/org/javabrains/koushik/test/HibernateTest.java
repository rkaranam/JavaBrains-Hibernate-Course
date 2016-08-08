package org.javabrains.koushik.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.UserDetails;
import org.javabrains.koushik.valueobjects.Address;
import org.javabrains.koushik.valueobjects.Credentials;
import org.javabrains.koushik.valueobjects.Phone;

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
		// user1.setAddress("Wall Street, California");
		// user1.setAddress(new Address("Long Road", "Bohemia", "Prague", "110181"));
		
		Set<Phone> phonesAvailable = new HashSet<Phone>();
		phonesAvailable.add(new Phone("789789", "Rotocar", "Blackwood County", "Home"));
		phonesAvailable.add(new Phone("123456", "Verysol", "Malthora", "Work"));
		user1.setPhoneNumbers(phonesAvailable);
		
		Address user1HomeAddr = new Address();
		user1HomeAddr.setStreet("Sea Rd");
		user1HomeAddr.setCity("Bohemia");
		user1HomeAddr.setState("Prague");
		user1HomeAddr.setPincode("1101");
		
		user1.setHomeAddress(user1HomeAddr);
		
		Address user1OfficeAddr = new Address();
		user1OfficeAddr.setStreet("Authur Rd");
		user1OfficeAddr.setCity("Bohemia");
		user1OfficeAddr.setState("Prague");
		user1OfficeAddr.setPincode("1106");
		
		user1.setOfficeAddress(user1OfficeAddr);
		
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
		// user2.setAddress("Beijing, China");
		// user2.setAddress(new Address("Race Court Rd", "San Jose", "California", "1022"));
		
		phonesAvailable = null;
		phonesAvailable = new HashSet<Phone>();
		phonesAvailable.add(new Phone("110234", "Vodafone", "San Jose", "Home"));
		phonesAvailable.add(new Phone("234566", "Verizon", "Oakmont", "Work"));
		user2.setPhoneNumbers(phonesAvailable);
		
		Address user2HomeAddr = new Address();
		user2HomeAddr.setStreet("Race Court Rd");
		user2HomeAddr.setCity("Pennylsvania");
		user2HomeAddr.setState("California");
		user2HomeAddr.setPincode("1022");
		
		user2.setHomeAddress(user2HomeAddr);
		
		Address user2OfficeAddr = new Address();
		user2OfficeAddr.setStreet("Cotton Rd");
		user2OfficeAddr.setCity("Oak City");
		user2OfficeAddr.setState("Yorkshire");
		user2OfficeAddr.setPincode("1044");
		
		user2.setOfficeAddress(user2OfficeAddr);
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(user1);
		session.save(user2);
		session.getTransaction().commit();
		session.clear();
		
		UserDetails retrievedUser = new UserDetails();
		session = factory.openSession();
		session.beginTransaction();
		retrievedUser = session.get(UserDetails.class, user2.getCredentials());
		session.getTransaction().commit();
		session.close();
		
		System.out.println("Retried User addresses: Home Address = " + retrievedUser.getHomeAddress() +
							"and Office Address = " + retrievedUser.getOfficeAddress());
		
		session.getSessionFactory().close();
		
	}

}

