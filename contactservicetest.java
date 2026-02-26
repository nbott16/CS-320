package test;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Contact;
import main.ContactService;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {
	private static ContactService contactService;
	
	@BeforeEach
	void setUpContactService() {
		contactService = new ContactService();
		contactService.addContact(new Contact("9874563121","John","Smith","999 Road Street","7418529631"));
	}

    @Test
    void updateFirstName(){

        Contact c = new Contact("9874563121","John","Smith","999 Road Street","7418529631");
        ContactService cs = new ContactService();
        cs.addContact(new Contact("74185263","John","Reed","999 Road Street","7418529631"));
        cs.updateLastName("74185263","Smith");
        Assert.assertEquals(c.getLastName(),cs.getContact("74185263").getLastName());
    }
    
    @Test
    void addContactFailsTest() {
    	contactService.addContact(new Contact("74185263","Test","Smith","999 Road Street","7418529631"));
    	Assertions.assertFalse(contactService.getContact("74185263").getFirstName().equals("Test"));

    };
    
    @Test
    void deleteContactSucceedsTest() {
    	Assertions.assertTrue(contactService.deleteContact("74185263"));
    }
    
    @Test
    void updateAddress() {
    	contactService.updateAddress("74185263", "new Address");
    	Assertions.assertEquals(contactService.getContact("74185263").getAddress(), "new Address");
    }
}