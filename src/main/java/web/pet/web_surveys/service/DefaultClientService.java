package web.pet.web_surveys.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.pet.web_surveys.entity.Client;
import web.pet.web_surveys.repository.ClientRepository;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultClientService implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Iterable<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client addNewClient(String name, Boolean gender) {
        return clientRepository.save(new Client(null, name, gender, new Date()));
    }

    @Override
    public Optional<Client> findById(Integer clientId) {
        return clientRepository.findById(clientId);
    }

    @Override
    public void updateClient(Integer clientId, String name, Boolean gender) {
        clientRepository.findById(clientId)
                .ifPresentOrElse(client -> {
                    client.setName(name);
                    client.setGender(gender);
                    clientRepository.save(client);
                }, () -> {
                    throw new NoSuchElementException();
                });
    }

    @Override
    public void deleteClient(Integer clientId) {
        clientRepository.findById(clientId)
                .ifPresentOrElse(client -> {
                    clientRepository.deleteById(clientId);
                }, () -> {
                    throw new NoSuchElementException();
                });
    }
}
