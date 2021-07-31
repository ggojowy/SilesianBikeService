package pl.edu.wszib.jwd.silesianbikeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.jwd.silesianbikeservice.model.Serwisant;

@Repository
public interface SerwisantDao extends JpaRepository<Serwisant, Long> {
    @Query("select u from Serwisant u where u.login = ?1")
    Serwisant findByLogin(String login);
}
