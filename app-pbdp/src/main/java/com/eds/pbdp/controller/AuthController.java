package com.eds.pbdp.controller;

import com.eds.pbdp.dto.AuthRequest;
import com.eds.pbdp.dto.AuthResponse;
import com.eds.pbdp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final AuthService authService;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        logger.info("Login attempt: {}", request.getUsername());
        AuthResponse response = authService.authenticate(request);
        logger.info("Login success: {}", request.getUsername());
        return ResponseEntity.ok(response);
    }
}
