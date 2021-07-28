package com.wps.wpscac.contact;

import com.wps.wpscac.contact.entity.Contact;
import com.wps.wpscac.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("contacts")
public class ContactController {
    private final ContactRepository contactRepository;

    @Autowired
    public ContactController(final ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @GetMapping
    public Iterable<Contact> getAll() {
        return contactRepository.findAll();
    }

    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Contact c) {
        contactRepository.save(c);
    }
}
