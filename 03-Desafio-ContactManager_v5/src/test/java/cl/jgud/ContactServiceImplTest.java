package cl.jgud;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import cl.silvabravo.model.Contact;
import cl.silvabravo.service.IContactService;
import cl.silvabravo.service.impl.ContactServiceImpl;

public class ContactServiceImplTest {
	
	private static Contact contact;
	private static IContactService contactService;
	
	@BeforeAll
	public static void setup() {
		contact = new Contact();
		contactService = new ContactServiceImpl();
	};
	
	@Test
	void getContactList() {
		assertEquals(1, contactService.getContactList().size());
		//assertEquals(new ArrayList<Contact>(), contactService.getContactList());
	};
	
	
	@Test
	 void addContact() {
		contact.setIdContact(1);
		contact.setNombre("Pepe");
		contact.setApellidoPaterno("Perez");
		contact.setApellidoMaterno("Perez");
		contact.setDireccion("Casa de Pepe");
		contact.setTelefono(123546);
		contactService.addContact(contact);
		System.out.println(contactService.getContactList());
		assertTrue(contactService.getContactList().get(0).getNombre().equals("Pepe"));
	}
}
