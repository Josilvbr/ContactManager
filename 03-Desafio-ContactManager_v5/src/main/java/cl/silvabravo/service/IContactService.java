package cl.silvabravo.service;

import java.util.List;

import cl.silvabravo.model.Contact;

public interface IContactService {
	
	List<Contact> getContactList();
	
	void addContact(Contact contact);
	
	void deleteContact(int idContact);
}
