package pe.com.jdmm21.reddit.app.redditclone.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import pe.com.jdmm21.reddit.app.redditclone.model.User;
import pe.com.jdmm21.reddit.app.redditclone.repository.UserRepository;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User register(User user){
        return user;
    }

    public User save(User user){
        return userRepository.save(user);
    }
    
}