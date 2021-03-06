package cl.silvabravo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.silvabravo.model.Contact;
import cl.silvabravo.service.IContactService;

@Controller
@RequestMapping(value="/contactManager")
public class ContactController {
	@Autowired
	IContactService serviceContact;
	

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getContactList(ModelMap model) {
		
		model.put("listContact", serviceContact.getContactList());
		
		return "contactManager";
	}
	
	@RequestMapping(value="/addContact", method = RequestMethod.POST)
	public String addContact(ModelMap model, @ModelAttribute("contact") Contact contact) {
		
		serviceContact.addContact(contact);
		
		model.put("listContact", serviceContact.getContactList());
		
		return "contactManager";
	}
	
	@RequestMapping(value="/deleteContact", method = RequestMethod.GET)
	public String deleteContact(ModelMap model, @RequestParam("id") int id) {
		
		serviceContact.deleteContact(id);
		
		model.put("listContact", serviceContact.getContactList());
		
		return "contactManager";
	}
	
}
