package pl.edu.wszib.jwd.silesianbikeservice.model;

import javax.persistence.*;

@Entity
@Table(name = "serwisanci")
public class Serwisant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String imie;

    @Column(nullable = false, length = 30)
    private String nazwisko;

    @Column(nullable = false, unique = true, length = 100)
    private String login;

    @Column(nullable = false, length = 100)
    private String haslo;

    public Serwisant() {
    }

    public Serwisant(String imie, String nazwisko, String login, String haslo) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.login = login;
        this.haslo = haslo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}
