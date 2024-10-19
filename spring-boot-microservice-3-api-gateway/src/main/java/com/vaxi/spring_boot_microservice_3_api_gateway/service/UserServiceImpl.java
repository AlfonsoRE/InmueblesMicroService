package com.vaxi.spring_boot_microservice_3_api_gateway.service;

import com.vaxi.spring_boot_microservice_3_api_gateway.model.Role;
import com.vaxi.spring_boot_microservice_3_api_gateway.model.User;
import com.vaxi.spring_boot_microservice_3_api_gateway.repository.UserRepository;
import com.vaxi.spring_boot_microservice_3_api_gateway.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User saverUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRol(Role.USER);
        user.setFechaCreacion(LocalDateTime.now());
        User userCreated = userRepository.save(user);
        String jwt = jwtProvider.generateToken(userCreated);
        userCreated.setToken(jwt);
        return userRepository.save(userCreated);
    }

    @Override
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findByAll(){
        return userRepository.findAll();
    }

    @Transactional
    @Override
    public void changeUserRole(String username, Role newRole){
        userRepository.updateUserRole(username,newRole);
    }

}
