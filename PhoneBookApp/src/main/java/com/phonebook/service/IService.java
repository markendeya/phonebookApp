package com.phonebook.service;

import java.util.List;

import com.phonebook.model.Contact;

public interface IService {

	public boolean saveContact(Contact c);
	public Contact getContactById(int id);
	public List<Contact> getAllContacts();	
	public boolean updateContact(Contact c);
	public boolean deleteContact(int id);
}
