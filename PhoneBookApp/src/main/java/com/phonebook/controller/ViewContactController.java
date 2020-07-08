package com.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.phonebook.model.Contact;
import com.phonebook.service.ServiceImpl;

@Controller
public class ViewContactController {
    
	@Autowired
	private ServiceImpl service;
	
	@RequestMapping(value="/editForm", method=RequestMethod.GET)
	public String editContact(@RequestParam("id") Integer id,Model model) {
	      Contact contactById = service.getContactById(id);
	      model.addAttribute("contact", contactById);
		return "contactInfo";
	}
	public String updateContact(Model model,Contact c) {
		
		return "contactInfo";
	}
	@RequestMapping(value="/deleteForm",method=RequestMethod.GET)
	public String deleteContact(@RequestParam("id") Integer Id,Model model) {
		service.deleteContact(Id);
	       List<Contact> contactList = service.getAllContacts();
	     model.addAttribute("contactList", contactList);
		model.addAttribute("success", "Contact Deleted Successly");
		return "viewContact";
	}

}
