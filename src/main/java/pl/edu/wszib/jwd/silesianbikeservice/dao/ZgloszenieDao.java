package pl.edu.wszib.jwd.silesianbikeservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pl.edu.wszib.jwd.silesianbikeservice.model.Zgloszenie;

@Repository
public interface ZgloszenieDao extends JpaRepository<Zgloszenie, Long> {
    @Query("select k from Zgloszenie k where k.id = ?1")
    Zgloszenie findById(String id);

}
