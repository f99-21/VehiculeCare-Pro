package com.vehiculecarepro;

import com.vehiculecarepro.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.vehiculecarepro.model.User;
import com.vehiculecarepro.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;

import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class VehiculeCareProApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehiculeCareProApplication.class, args);

    }
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            userRepository.save(new User("userdb", passwordEncoder.encode("dbpass"), "USER"));
            userRepository.save(new User("admindb", passwordEncoder.encode("dbadminpass"), "ADMIN"));
        };
    }

}
