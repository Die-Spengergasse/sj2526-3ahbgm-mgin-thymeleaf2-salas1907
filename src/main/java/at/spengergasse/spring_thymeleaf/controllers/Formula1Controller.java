package at.spengergasse.spring_thymeleaf.controllers;

import at.spengergasse.spring_thymeleaf.entities.Formel1Repository;
import at.spengergasse.spring_thymeleaf.entities.Formel1fahrer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/edit/{id}")
    public String editPatient(@PathVariable int id, Model model) {
        model.addAttribute("Driver", formel1Repository.findById(id).orElseThrow());
        return "edit_driver";
    }
    @PostMapping("/edit/{id}")
    public String editPatient(@PathVariable int id, @ModelAttribute("Driver") Formel1fahrer Driver) {
        Driver.setId(id);
        formel1Repository.save(Driver);
        return  "redirect:/driver/list";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable int id) {
        formel1Repository.deleteById(id);
        return  "redirect:/driver/list";
    }

}
