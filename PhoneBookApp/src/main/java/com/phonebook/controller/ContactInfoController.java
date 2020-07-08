package com.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phonebook.model.Contact;
import com.phonebook.service.ServiceImpl;

@Controller
public class ContactInfoController {
	
	@Autowired
	private ServiceImpl service;
	
	
	@RequestMapping("/showForm")
	public String LoadForm(Model model) {
		model.addAttribute("contact", new Contact());
		return "contactInfo";
	}
	
	
	@RequestMapping("/processForm")
	public String handleSubmitButton(Model model,@ModelAttribute("contact") Contact c) {
		boolean isSaved=service.saveContact(c);
		if(isSaved) {
		model.addAttribute("sucess", "Contact saved Sucessfully");
		}
		return "contactInfo";
	}
	
	
	@RequestMapping("/showContact")
	public String handleViewContactLink(Model model) {
		
		List<Contact> allContacts = service.getAllContacts();
		for(int i=0;i<allContacts.size();i++) {
	System.out.println(allContacts.get(i));
		}
		model.addAttribute("contactList", allContacts);
		return "viewContact";
	}

}
