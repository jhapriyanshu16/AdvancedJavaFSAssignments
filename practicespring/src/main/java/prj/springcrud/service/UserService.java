package prj.springcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prj.springcrud.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String userName){
        userRepository.save(userName);
    }

    public List<String> getAllUsers(){
        return userRepository.findAll();
    }
}
