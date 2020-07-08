package com.phonebook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.Dao.ContactRepository;
import com.phonebook.entity.ContactEntity;
import com.phonebook.model.Contact;

@Service
public class ServiceImpl implements IService {

	@Autowired
	private ContactRepository contactRepo;
	
	
	@Override
	public boolean saveContact(Contact c) {
		ContactEntity entity=new ContactEntity();
		BeanUtils.copyProperties(c, entity);
		ContactEntity save = contactRepo.save(entity);
		System.out.println("contactID"+" "+ save.getContactId());
		if(save.getContactId()>0) {
			return true;
		}
		return false;
	}

	@Override
	public Contact getContactById(int id) {
		Optional<ContactEntity> contactEntity = contactRepo.findById(id);
		Contact contact =new Contact();
		ContactEntity entity=null;
		if(contactEntity.isPresent()) {
		 entity=contactEntity.get();
		}
		BeanUtils.copyProperties(entity, contact);
		return contact;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactEntity> contactEntities = contactRepo.findAll();
		List<Contact> contactList=new ArrayList<Contact>();
		/*
		 * for(ContactEntity entity:contactEntities) { Contact contact=new Contact();
		 * BeanUtils.copyProperties(entity, contact); contactList.add(contact); }
		 */
		contactList=	contactEntities.stream().map(entity->{
			Contact contact=new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());
		return contactList;
	}

	@Override
	public boolean updateContact(Contact c) {
		return false;
	}

	@Override
	public boolean deleteContact(int id) {
		contactRepo.deleteById(id);
		return true;
	}





}
