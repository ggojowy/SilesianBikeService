package pl.edu.wszib.jwd.silesianbikeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.jwd.silesianbikeservice.dao.SerwisantDao;
import pl.edu.wszib.jwd.silesianbikeservice.model.Serwisant;

@Controller
public class MainController {
    @Autowired
    SerwisantDao serwisantDao;

    private String currSerwisantLogin;
    @GetMapping("/")
    public String get(Model model) {
        if (currSerwisantLogin != null) {
            Serwisant serwisant = serwisantDao.findFirstByLogin(currSerwisantLogin);
        }
        return "main";
    }
}
