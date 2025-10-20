package com.project.genomebankapi.auth;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.project.genomebankapi.entity.Users;
import com.project.genomebankapi.repository.UsersRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
@Primary
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return User.builder()
                .username(user.getEmail())
                .password(user.getContraHashed())
                .roles(user.getRol() != null ? user.getRol().getNombreRol() : "USER")
                .build();
    }
}
