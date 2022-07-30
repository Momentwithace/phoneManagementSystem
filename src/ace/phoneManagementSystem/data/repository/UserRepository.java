package ace.phoneManagementSystem.data.repository;

import ace.phoneManagementSystem.data.models.User;

import java.util.List;

public interface UserRepository {
    User save(User user);

    User saveNewUser(User newUser);
    void deleteUser(int id);
    void deleteUser(User user);
    List<User> findUserByFirstName(String firstName);
    List<User> findUserByLastName(String lastName);
    User findByUserId(int id);
    List<User> findAllUser();
    User findByEmail(String email);
    int count();

}
