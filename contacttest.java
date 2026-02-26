package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Contact;

class ContactTest {
	
	private static Contact contact;
	
	@BeforeEach
	void resetContact() {
		contact = new Contact();
	}

	@Test
	void testContactID() {
		Contact contactID = new Contact("165654","John","Smith","address","41874894");
		Assertions.assertTrue(contactID.getContactID().equals("9844981"));
		Assertions.assertTrue(contactID.getAddress().equals("address"));
		Assertions.assertTrue(contactID.getFirstName().equals("John"));
		
		
		
		assertThrows(IllegalArgumentException.class, () -> {
		new Contact("1656541","John","Smith","address","41874894");
		}); 
	}
	
	@Test
	void testSetPhoneNum() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhoneNum("5557779999");
		});
	}
	
	@Test
	void testSetAddress() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("123456789419841");
		});
	}
	
	@Test
	void testSetFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(";zxcvbnm,k");
		});
	}
	
	@Test
	void testSetLastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("asdfghjkl");
		});
	}
}

