package com.evfjunior.contactmanager.service;

import com.evfjunior.contactmanager.model.Contact;
import com.evfjunior.contactmanager.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    // Fields
    private final ContactRepository repository;

    // Constructor
    @Autowired // Dependency injection
    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    // Public Methods
    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<Contact> findAllSorted() {
        return repository.findAll(Sort.by("firstName"));
    }

    public Contact findById(String id) {
        return repository.findById(id).get();
    }

    public void save(Contact contact) {
        repository.save(contact);
    }
}
