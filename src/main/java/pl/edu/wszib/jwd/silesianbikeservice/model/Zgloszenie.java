package pl.edu.wszib.jwd.silesianbikeservice.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "zgloszenia")
public class Zgloszenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String imieKlienta;

    @Column(nullable = false, length = 30)
    private String nazwiskoKlienta;

    @Column(nullable = false, length = 10000)
    private String trescZgloszenia;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataZgloszenia;

    @Column(nullable = true, length = 100)
    private String statusZgloszenia;

    @PrePersist
    private void onCreate() {
        dataZgloszenia = new Date();
    }


    public Zgloszenie() {
    }

    public Zgloszenie(Long id, String imieKlienta, String nazwiskoKlienta, String trescZgloszenia,Date dataZgloszenia, String statusZgloszenia) {
        this.id = id;
        this.imieKlienta = imieKlienta;
        this.nazwiskoKlienta = nazwiskoKlienta;
        this.trescZgloszenia = trescZgloszenia;
        this.dataZgloszenia = dataZgloszenia;
        this.statusZgloszenia = statusZgloszenia;
    }

    public String getStatusZgloszenia() {
        return statusZgloszenia;
    }

    public void setStatusZgloszenia(String statusZgloszenia) {
        this.statusZgloszenia = statusZgloszenia;
    }

    public Date getDataZgloszenia() {
        return dataZgloszenia;
    }

    public void setDataZgloszenia(Date dataZgloszenia) {
        this.dataZgloszenia = dataZgloszenia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImieKlienta() {
        return imieKlienta;
    }

    public void setImieKlienta(String imieKlienta) {
        this.imieKlienta = imieKlienta;
    }

    public String getNazwiskoKlienta() {
        return nazwiskoKlienta;
    }

    public void setNazwiskoKlienta(String nazwiskoKlienta) {
        this.nazwiskoKlienta = nazwiskoKlienta;
    }

    public String getTrescZgloszenia() {
        return trescZgloszenia;
    }

    public void setTrescZgloszenia(String trescZgloszenia) {
        this.trescZgloszenia = trescZgloszenia;
    }

    @Override
    public String toString() {
        return "Zgloszenie{" +
                "id=" + id +
                ", imieKlienta='" + imieKlienta + '\'' +
                ", nazwiskoKlienta='" + nazwiskoKlienta + '\'' +
                ", trescZgloszenia='" + trescZgloszenia + '\'' +
                ", statusZgloszenia='" + statusZgloszenia + '\'' +
                '}';
    }
}
