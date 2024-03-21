package web.pet.web_surveys.service;

import org.springframework.stereotype.Service;
import web.pet.web_surveys.entity.Client;

import java.util.Optional;

@Service
public interface ClientService {
    Iterable<Client> findAllClients();

    Client addNewClient(String name, Boolean gender);

    Optional<Client> findById(Integer clientId);

    void updateClient(Integer clientId, String name, Boolean gender);

    void deleteClient(Integer clientId);
}
