package pl.edu.wszib.jwd.silesianbikeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.jwd.silesianbikeservice.dao.SerwisantDao;
import pl.edu.wszib.jwd.silesianbikeservice.model.Serwisant;

@Controller
public class NewSerwisantController {
    @Autowired
    SerwisantDao serwisantDao;

    @GetMapping("/newSerwisant")
    public String get(Model model) {
        model.addAttribute("newSerwisant", new Serwisant());
        return "newSerwisant";
    }

    @PostMapping("/add-serwisant")
    public String addSerwisant(@ModelAttribute Serwisant serwisant) {
        serwisantDao.save(serwisant);
        return "redirect:/";
    }
}
