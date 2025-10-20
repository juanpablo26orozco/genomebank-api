package com.project.genomebankapi.auth;

import com.project.genomebankapi.repository.UsersRepository;
import com.project.genomebankapi.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Configuración de autenticación y seguridad para la aplicación.
 * Define beans para la codificación de contraseñas y la carga de detalles de usuario.
 * Utiliza BCrypt para la seguridad de contraseñas y conecta el repositorio de usuarios para la autenticación.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class AuthConfig {

    private final UsersRepository usersRepository;

    /**
     * Bean para la codificación de contraseñas usando BCrypt.
     * @return PasswordEncoder seguro para almacenar contraseñas
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Bean para cargar los detalles de usuario desde la base de datos.
     * Utilizado por Spring Security para autenticar usuarios.
     * @return UserDetailsService que busca usuarios por email
     */
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Users user = usersRepository.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
            // Convertimos la entidad Users a UserDetails de Spring Security
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getEmail())
                    .password(user.getContraHashed())
                    .roles(user.getRol() != null ? user.getRol().getNombreRol() : "USER")
                    .build();
        };
    }
}
