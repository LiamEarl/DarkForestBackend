package com.liame.darkforest.service;
import com.liame.darkforest.model.UserPrincipal;
import com.liame.darkforest.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.liame.darkforest.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DarkForestUserDetailsService implements UserDetailsService {

    private UserRepository repo;
    public DarkForestUserDetailsService(UserRepository repo) {
        this.repo = repo;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByUsername(username);
        if(user == null) {
            System.out.println("User not found peepee");

            throw new UsernameNotFoundException("User " + username + " not found");
        }
        return new UserPrincipal(user);
    }
}
