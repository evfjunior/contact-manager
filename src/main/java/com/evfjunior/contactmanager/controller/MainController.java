package com.evfjunior.contactmanager.controller;

import com.evfjunior.contactmanager.model.Contact;
import com.evfjunior.contactmanager.service.ContactService;
import com.evfjunior.contactmanager.util.MappingName;
import com.evfjunior.contactmanager.util.ViewName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
public class MainController {
    // Fields
    private final ContactService service;

    // Constructor
    @Autowired // Dependency injection
    public MainController(ContactService service) {
        this.service = service;
    }

    // Request Methods

    // Main Page
    @RequestMapping(MappingName.MAIN)
    public String showMainPage(Model model) {
        List<Contact> contacts = service.findAllSorted();
        model.addAttribute("contacts", contacts);

        return ViewName.MAIN;
    }

    // New Contact
    @GetMapping(MappingName.NEW)
    public String addContact(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);

        return ViewName.NEW;
    }

    @PostMapping(MappingName.SAVE)
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        String id = Objects.toString(UUID.randomUUID());
        contact.setId(id);
        service.save(contact);

        return ViewName.REDIRECT_MAIN;
    }

    // Contact Details
    @RequestMapping(MappingName.DETAILS)
    public String showDetails(@PathVariable("id") String id, Model model) {
        Contact contact = service.findById(id);
        model.addAttribute("contact", contact);

        return ViewName.DETAILS;
    }

    // Delete Contact
    @RequestMapping(MappingName.DELETE)
    public String deleteContact(@PathVariable("id") String id) {
        service.delete(id);

        return ViewName.REDIRECT_MAIN;
    }

    // Edit Contact
    @RequestMapping(MappingName.EDIT)
    public ModelAndView showEditForm(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        Contact contact = service.findById(id);
        modelAndView.addObject("contact", contact);

        return modelAndView;
    }

    @PostMapping(MappingName.UPDATE)
    public String updateContact(@ModelAttribute("contact") Contact contact) {
        service.save(contact);

        return ViewName.REDIRECT_MAIN;
    }
}
