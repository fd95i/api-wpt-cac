package com.wps.wpscac.contact;

import com.wps.wpscac.contact.entity.Contact;
import com.wps.wpscac.contact.exception.ContactNotFoundException;
import com.wps.wpscac.contact.repository.ContactRepository;
import com.wps.wpscac.utils.SendContactMail;
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

    @GetMapping("{id}")
    public Contact get(@PathVariable("id") Integer id) {
        return contactRepository
                .findById(id)
                .orElseThrow(ContactNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Contact c) {
        contactRepository.save(c);
//        SendContactMail.dispatch(c);
    }

    @PutMapping
    public void update(@RequestBody Contact c) {
        contactRepository.save(c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        contactRepository.delete(contactRepository
                .findById(id)
                .orElseThrow(ContactNotFoundException::new));
    }

}
