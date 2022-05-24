package com.keicloak.exemplo.apiTeste.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/security")
public class SecurityTestController {

    @GetMapping
    public ResponseEntity<Void> NaoNecessarioValidarRole(){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/possui-role")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<Void> precisarTerARoleDeUser(){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public ResponseEntity<Void> precisaTerARoleDeAdmin(){
        return ResponseEntity.ok().build();
    }


}
