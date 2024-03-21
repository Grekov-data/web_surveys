package web.pet.web_surveys.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.pet.web_surveys.entity.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

}
