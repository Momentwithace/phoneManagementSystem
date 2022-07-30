package ace.phoneManagementSystem.data.repository;

import ace.phoneManagementSystem.data.models.Contact;

import java.util.List;

public interface ContactRepository {

    Contact save(Contact newContact);
    void deleteContact(int id);
    void deleteContact(Contact newContact);
    List<Contact> findByContactFirstName(String firstName);
    List<Contact> findByContactLastName(String lastName);
    Contact findContactById(int id);
    List<Contact> findAllContact();
    Contact update(Contact newContact);
    Contact findByEmail(String email);
    int count();

}
