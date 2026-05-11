package atividadeLuigi.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import atividadeLuigi.api.model.RequisicaoDeLogin;
import atividadeLuigi.api.model.ResponsividadeDoLogin;

import java.util.UUID;

@RestController
public class ControleDeAutenticacao {

    @PostMapping("/login")
    public ResponseEntity<ResponsividadeDoLogin> login(
            @RequestBody RequisicaoDeLogin request
    ) {

        if (
                request.getEmail().equals("usuario@esoft.com")
                        && request.getPassword().equals("Abc123")
        ) {

            String token = UUID.randomUUID().toString();

            return ResponseEntity.ok(
                    new ResponsividadeDoLogin(token)
            );
        }

        return ResponseEntity.status(401).build();
    }
}
