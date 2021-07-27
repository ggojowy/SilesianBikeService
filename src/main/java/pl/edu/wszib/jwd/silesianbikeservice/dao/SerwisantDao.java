package pl.edu.wszib.jwd.silesianbikeservice.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.jwd.silesianbikeservice.model.Serwisant;

@Repository
public interface SerwisantDao extends CrudRepository<Serwisant, Long>{
    Serwisant findFirstByLogin(String serwisantName);
}
