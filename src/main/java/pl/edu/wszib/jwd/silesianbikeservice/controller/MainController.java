package pl.edu.wszib.jwd.silesianbikeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.jwd.silesianbikeservice.dao.SerwisantDao;
import pl.edu.wszib.jwd.silesianbikeservice.model.Serwisant;

@Controller
public class MainController {

    @Autowired
    SerwisantDao serwisantDao;

    private String currSerwisantLogin;

    @GetMapping("")
    public String viewHomePage() {
        return "main";
    }

    @GetMapping("/register")
    public String showSignUpFrom(Model model) {
        model.addAttribute("serwisant", new Serwisant());
        return "rejestracja";
    }
    @PostMapping("/process_register")
    public String processRegistration(Serwisant serwisant) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(serwisant.getHaslo());
        serwisant.setHaslo(encodedPassword);

        Serwisant userById = serwisantDao.findByLogin(serwisant.getLogin());
        if (userById == null) {
            serwisantDao.save(serwisant);
            return "udana_rejestracja";
        } else {
            return "nieudana_rejestracja";
        }
    }
    @GetMapping("/")
    public String get(Model model) {
        if (currSerwisantLogin != null) {
            Serwisant serwisant = serwisantDao.findByLogin(currSerwisantLogin);
        }
        return "main";
    }
}
