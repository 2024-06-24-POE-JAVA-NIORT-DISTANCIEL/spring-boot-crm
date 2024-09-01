package com.bigcorp.crm.service;

import com.bigcorp.crm.controller.dto.ClientDto;
import com.bigcorp.crm.dao.ClientDao;
import com.bigcorp.crm.dao.ClientDao;
import com.bigcorp.crm.model.Client;
import com.bigcorp.crm.model.Client;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Contient l'intelligence fonctionnelle des Clients
 */
@Service
public class ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    private ClientDao clientDao;

    @Transactional
    public ClientDto save(ClientDto clientDto) {
        LOGGER.info("Saving : {}", clientDto);
        Client client = toEntity(clientDto);
        Client savedClient = this.clientDao.save(client);
        return toDto(savedClient);
    }

    public ClientDto findById(Long id) {
        LOGGER.info("Finding client with id : {}", id);
        Optional<Client> optionalClient = this.clientDao.findById(id);
        if (optionalClient.isEmpty()) {
            LOGGER.info("Found nothing");
            return null;
        }
        //else...
        Client clientFound = optionalClient.get();
        LOGGER.info("Found : {}", clientFound);
        return toDto(clientFound);
    }

    @Transactional
    public void delete(Long id) {
        LOGGER.info("Deleting client with id : {}", id);
        clientDao.deleteById(id);
    }


    @Transactional
    public ClientDto update(Long id, ClientDto clientDto) {
        LOGGER.info("Updating client : {} , with id : {}", clientDto, id);
        Optional<Client> optionalClient = this.clientDao.findById(id);
        if (optionalClient.isEmpty()) {
            return null;
        }
        //else...
        Client client = toEntity(clientDto);
        client.setId(id);
        client = this.clientDao.save(client);
        return toDto(client);
    }


    private ClientDto toDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setId(client.getId());
        clientDto.setAddress(client.getAddress());
        clientDto.setCity(client.getCity());
        clientDto.setEmail(client.getEmail());
        clientDto.setCountry(client.getCountry());
        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        clientDto.setCompanyName(client.getCompanyName());
        clientDto.setPhoneNumber(client.getPhoneNumber());
        clientDto.setState(client.getState());
        clientDto.setZipCode(client.getZipCode());
        return clientDto;
    }

    private Client toEntity(ClientDto clientDto) {
        Client client = new Client();
        client.setId(clientDto.getId());
        client.setAddress(clientDto.getAddress());
        client.setCity(clientDto.getCity());
        client.setEmail(clientDto.getEmail());
        client.setCountry(clientDto.getCountry());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setCompanyName(clientDto.getCompanyName());
        client.setPhoneNumber(clientDto.getPhoneNumber());
        client.setState(clientDto.getState());
        client.setZipCode(clientDto.getZipCode());
        return client;
    }
}
