package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Formel1Repository;
import at.spengergasse.spring_thymeleaf.entities.Formel1fahrer;
import at.spengergasse.spring_thymeleaf.entities.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Driver;

@Controller
@RequestMapping("/driver")
public class Formula1Controller {
    private final Formel1Repository formel1Repository;

    public Formula1Controller(Formel1Repository formel1Repository) {
        this.formel1Repository = formel1Repository;
    }

    @GetMapping("/list")
    public String patients(Model model) {
        model.addAttribute("Driver", formel1Repository.findAll());
        return "driverlist";
    }

    @GetMapping("/add")
    public String addPatient(Model model) {
        model.addAttribute("Driver", new Formel1fahrer());
        return "add_driver";
    }

    @PostMapping("/add")
    public String addPatient(@ModelAttribute("Driver") Formel1fahrer Driver) {
        formel1Repository.save(Driver);
        return  "redirect:/driver/list";
    }
}
