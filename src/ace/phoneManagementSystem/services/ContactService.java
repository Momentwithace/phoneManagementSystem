package ace.phoneManagementSystem.services;

import ace.phoneManagementSystem.data.models.Contact;

public interface ContactService {
    Contact saveContact(Contact contact);

    int getNumberOfContacts();
}
