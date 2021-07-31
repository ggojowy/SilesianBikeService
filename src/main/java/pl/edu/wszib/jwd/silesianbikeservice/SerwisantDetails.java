package pl.edu.wszib.jwd.silesianbikeservice;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import pl.edu.wszib.jwd.silesianbikeservice.model.Serwisant;

import java.util.Collection;

public class SerwisantDetails implements UserDetails {

    private Serwisant serwisant;

    public SerwisantDetails(Serwisant serwisant) {
        this.serwisant = serwisant;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return serwisant.getHaslo();
    }

    @Override
    public String getUsername() {
        return serwisant.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true ;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public String getLogin() {
        return serwisant.getLogin();
    }

}
