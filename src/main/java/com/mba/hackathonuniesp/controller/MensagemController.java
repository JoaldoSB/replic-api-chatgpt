package com.mba.hackathonuniesp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mba.hackathonuniesp.service.MensagemService;

import lombok.Data;

@RestController
@RequestMapping("/api/chatgpt")
@Data
public class MensagemController {
	
    private final MensagemService mensagemService;

    @Autowired
    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @PostMapping("/sendMessage")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        String response = mensagemService.sendMessage(message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
