package pl.edu.wszib.jwd.silesianbikeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.jwd.silesianbikeservice.model.Serwisant;

@Repository
public interface SerwisantDao extends JpaRepository<Serwisant, Long> {
    Serwisant findFirstByLogin(String login);
}
