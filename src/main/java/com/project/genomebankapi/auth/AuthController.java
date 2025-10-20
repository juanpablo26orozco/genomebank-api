package com.project.genomebankapi.auth;

import com.project.genomebankapi.entity.Users;
import com.project.genomebankapi.entity.Rol;
import com.project.genomebankapi.repository.UsersRepository;
import com.project.genomebankapi.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Controlador para la autenticación y registro de usuarios.
 * Proporciona endpoints para login y registro.
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final UsersRepository usersRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwt; // Servicio para generar tokens JWT

    /**
     * Endpoint para login de usuarios.
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> req) {
        String email = req.get("email");
        String password = req.get("password");

        authManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

        Users user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        // ✅ Manejo seguro de roles
        List<String> roles = new ArrayList<>();
        if (user.getRol() != null && user.getRol().getNombreRol() != null) {
            roles.add(user.getRol().getNombreRol());
        } else {
            roles.add("USER");
        }

        String token = jwt.generate(user.getEmail(), roles);

        return Map.of(
                "access_token", token,
                "token_type", "Bearer",
                "roles", roles
        );
    }

    /**
     * Endpoint para registrar nuevos usuarios.
     */
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> register(@RequestBody Users req) {
        if (req.getEmail() == null || req.getContraHashed() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Faltan email o contraseña");
        }

        if (usersRepository.findByEmail(req.getEmail()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email ya registrado");
        }

        // Asignar rol por defecto si no tiene
        Rol rolUser = req.getRol();
        if (rolUser == null) {
            rolUser = rolRepository.findByNombreRol("USER")
                    .orElseGet(() -> {
                        Rol newRol = new Rol();
                        newRol.setNombreRol("USER");
                        return rolRepository.save(newRol);
                    });
        }

        Users user = new Users();
        user.setNombre(req.getNombre());
        user.setEmail(req.getEmail());
        user.setContraHashed(passwordEncoder.encode(req.getContraHashed()));
        user.setRol(rolUser);

        usersRepository.save(user);

        // ✅ También manejo seguro aquí
        List<String> roles = new ArrayList<>();
        if (user.getRol() != null && user.getRol().getNombreRol() != null) {
            roles.add(user.getRol().getNombreRol());
        } else {
            roles.add("USER");
        }

        String token = jwt.generate(user.getEmail(), roles);

        return Map.of(
                "access_token", token,
                "token_type", "Bearer",
                "roles", roles
        );
    }

    /**
     * Maneja errores de autenticación devolviendo un mensaje estándar.
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(org.springframework.security.core.AuthenticationException.class)
    public Map<String, String> onAuthError(Exception e) {
        return Map.of("error", "Credenciales incorrectas");
    }
}
