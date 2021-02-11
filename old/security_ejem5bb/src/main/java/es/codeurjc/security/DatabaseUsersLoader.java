package es.codeurjc.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUsersLoader {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void initDatabase() {
    	
    	userRepository.save(new User("user", "pass", "USER"));
		userRepository.save(new User("admin", "adminpass", "USER", "ADMIN"));
    }

}
