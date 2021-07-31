package pl.edu.wszib.jwd.silesianbikeservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pl.edu.wszib.jwd.silesianbikeservice.SerwisantDetails;
import pl.edu.wszib.jwd.silesianbikeservice.dao.SerwisantDao;
import pl.edu.wszib.jwd.silesianbikeservice.model.Serwisant;

public class SerwisantDetailsService implements UserDetailsService {

    @Autowired
    private SerwisantDao serwisantDao;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Serwisant serwisant = serwisantDao.findByLogin(login);
        if (serwisant == null) {
            throw new UsernameNotFoundException("Użytkownik nie odnaleziony");
        }
        return new SerwisantDetails(serwisant);
    }
}
