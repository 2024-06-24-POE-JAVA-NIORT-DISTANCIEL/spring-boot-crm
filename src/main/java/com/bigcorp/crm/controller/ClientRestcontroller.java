package com.bigcorp.crm.controller;

import com.bigcorp.crm.controller.dto.ClientDto;
import com.bigcorp.crm.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientRestcontroller {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClientWithPathVariable(@PathVariable("id") Long id) {

        ClientDto clientFound = clientService.findById(id);
        if(clientFound == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientFound);
    }

    @PostMapping
    public ClientDto save(@RequestBody ClientDto clientDto) {
        return clientService.save(clientDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> save(@PathVariable("id") Long id, @RequestBody ClientDto clientDto) {
        ClientDto savedClient = clientService.update(id, clientDto);
        if(savedClient == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(savedClient);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        clientService.delete(id);
    }

}