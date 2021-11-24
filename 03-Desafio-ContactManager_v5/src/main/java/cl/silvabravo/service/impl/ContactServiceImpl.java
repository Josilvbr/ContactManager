package cl.silvabravo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.silvabravo.model.Contact;
import cl.silvabravo.service.IContactService;

@Service("contactService")
public class ContactServiceImpl implements IContactService {

	@Autowired // Inyección de dependencias
	private Contact contact; // Contact contact = new Contact(); <-- esto hace la inyección

	List<Contact> listContact;

	public ContactServiceImpl() { // declaración constructor
		super();
		listContact = new ArrayList<Contact>();
	}

	@Override
	public List<Contact> getContactList() {
//		if (contact.getIdContact() > 0) {
//			listContact.add(contact);
//		}
		return listContact;
	}

	@Override
	public void addContact(Contact contact) {
		
		int idMayor = 0;

		for (Contact contactTemp : listContact) {

			if (contactTemp.getIdContact() > idMayor) {
				idMayor = contactTemp.getIdContact();
			}
		}

		contact.setIdContact(idMayor + 1);
		listContact.add(contact);
	}

	@Override
	public void deleteContact(int idContact) {

		List<Contact> listaTemp = new ArrayList<Contact>();
        listaTemp.addAll(listContact);
        try {
            for (Contact contacto : listaTemp) {
                if (contacto.getIdContact() == idContact) {
                    listContact.remove(contacto);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		

	}

}
