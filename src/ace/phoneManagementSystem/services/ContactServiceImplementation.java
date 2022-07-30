package ace.phoneManagementSystem.services;

import ace.phoneManagementSystem.data.models.Contact;
import ace.phoneManagementSystem.data.repository.ContactRepository;
import ace.phoneManagementSystem.utils.Mapper;

public class ContactServiceImplementation implements ContactService{
    ContactRepository contactRepository;

    public ContactServiceImplementation(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }
    @Override
    public Contact saveContact(Contact contact) {
        Contact addNewContact = new Contact();
        Mapper.map(contact, addNewContact);
        contactRepository.save(addNewContact);
        return addNewContact;
    }

    @Override
    public int getNumberOfContacts() {
        return contactRepository.count();
    }
}
