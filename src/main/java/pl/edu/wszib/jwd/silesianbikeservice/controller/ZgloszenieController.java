package pl.edu.wszib.jwd.silesianbikeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.jwd.silesianbikeservice.dao.ZgloszenieDao;
import pl.edu.wszib.jwd.silesianbikeservice.model.Zgloszenie;

import java.util.List;
import java.util.Optional;

@Controller
public class ZgloszenieController {

    @Autowired
    ZgloszenieDao zgloszenieDao;

    Zgloszenie zgloszenieX = new Zgloszenie();

    @GetMapping("/wszystkie_zgloszenia")
    public String viewAllZgloszenia(Model model) {
        List<Zgloszenie> zglosze = zgloszenieDao.findAll();
        model.addAttribute("zgloszenia", zglosze);

        return "wszystkie_zgloszenia";
    }

    @PostMapping("/dodaj_zgloszenie")
    public String dodajZgloszenie(@ModelAttribute Zgloszenie zgloszenie) {
        zgloszenie.setStatusZgloszenia("Service request has been accepted");
        zgloszenieDao.save(zgloszenie);

        return "strona_uzytkownika";
    }

    @PostMapping("/aktualizuj_zgloszenie")
    public String aktualizujZgloszenie(@ModelAttribute Zgloszenie zgloszenie) {
        System.out.println(zgloszenie);
        zgloszenieX.setStatusZgloszenia(zgloszenie.getStatusZgloszenia());
        zgloszenieX.setImieKlienta(zgloszenie.getImieKlienta());
        zgloszenieX.setNazwiskoKlienta(zgloszenie.getNazwiskoKlienta());
        zgloszenieX.setTrescZgloszenia(zgloszenie.getTrescZgloszenia());
        zgloszenieDao.save(zgloszenieX);

        return "redirect:/wszystkie_zgloszenia";
    }

    @PostMapping("/edycja_zgloszenia")
    public String edytujZgloszenie(@ModelAttribute Zgloszenie zgloszenie, Model model) {


        Optional<Zgloszenie> byId = zgloszenieDao.findById(zgloszenie.getId());
        if (byId.isPresent()) {
            zgloszenieX = byId.get();
            System.out.println("udało się");
            System.out.println(zgloszenieX);
        }

        model.addAttribute("zgloszenie2",zgloszenieX);
        return "edycja_zgloszenia";
    }


}
