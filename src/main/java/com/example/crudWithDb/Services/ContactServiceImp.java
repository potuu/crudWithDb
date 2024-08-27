package com.example.crudWithDb.Services;

import com.example.crudWithDb.Entities.Contact;
import com.example.crudWithDb.Repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImp implements ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> listContacts(String keyword) {
        if (keyword != null && !keyword.trim().isEmpty()) {
            return contactRepository.findAll(keyword);
        }
        return contactRepository.findAll();
    }

    @Override
    public Contact registerContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact searchContactById(Integer id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContact(Integer id) {
        contactRepository.deleteById(id);
    }
}
