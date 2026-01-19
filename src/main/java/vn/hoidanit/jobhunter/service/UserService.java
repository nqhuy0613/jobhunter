package vn.hoidanit.jobhunter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleCreateUser(User user) {
        return this.userRepository.save(user);
    }

    public void handleDeleteUser(long id) {
        this.userRepository.deleteById(id);
    }

    public User fetchUserById(long id) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    public List<User> fetchAllUser() {
        List<User> arrUsers = this.userRepository.findAll();
        return arrUsers;
    }

    public User handleUpdateUser(User UserfromPost) {
        User userUpdate = this.fetchUserById(UserfromPost.getId());
        if (userUpdate != null) {
            userUpdate.setEmail(UserfromPost.getEmail());
            userUpdate.setName(UserfromPost.getName());
            userUpdate.setPassword(UserfromPost.getPassword());
            this.userRepository.save(userUpdate);
        }
        return userUpdate;
    }
}
