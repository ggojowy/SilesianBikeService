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

@Controller
public class ZgloszenieController {

    @Autowired
    ZgloszenieDao zgloszenieDao;

    @GetMapping("/wszystkie_zgloszenia")
    public String viewAllZgloszenia(Model model) {
        List<Zgloszenie> zglosze = zgloszenieDao.findAll();
        model.addAttribute("zgloszenia", zglosze);
        return "wszystkie_zgloszenia";
    }
    @PostMapping("/dodaj_zgloszenie")
    public String dodajZgloszenie(@ModelAttribute Zgloszenie zgloszenie) {

        zgloszenieDao.save(zgloszenie);

        return "strona_uzytkownika";
    }
}
