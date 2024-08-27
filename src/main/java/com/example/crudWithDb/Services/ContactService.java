package com.example.crudWithDb.Services;

import com.example.crudWithDb.Entities.Contact;
import java.util.List;

public interface ContactService {
    List<Contact> listContacts(String keyword);
    Contact registerContact(Contact contact);
    Contact searchContactById(Integer id);
    Contact updateContact(Contact contact);
    void deleteContact(Integer id);
}
