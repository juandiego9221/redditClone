package pe.com.jdmm21.reddit.app.redditclone.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.com.jdmm21.reddit.app.redditclone.model.User;
import pe.com.jdmm21.reddit.app.redditclone.repository.UserRepository;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final RoleService roleService;

    public UserService(UserRepository userRepository, RoleService roleService){
        this.userRepository = userRepository;
        this.roleService = roleService;
        encoder = new BCryptPasswordEncoder();
    }

    public User register(User user){
        String secret = "{bcrypt}" + encoder.encode(user.getPassword());
        user.setPassword(secret);
        user.addRole(roleService.findByName("ROLE_USER"));
        save(user);
        sendActivationEmail(user);
        return user;
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public void sendActivationEmail(User user){

    }
    
}