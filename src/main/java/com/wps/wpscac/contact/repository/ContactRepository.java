package com.wps.wpscac.contact.repository;

import com.wps.wpscac.contact.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ContactRepository")
public interface ContactRepository extends CrudRepository<Contact, Integer> {
}
