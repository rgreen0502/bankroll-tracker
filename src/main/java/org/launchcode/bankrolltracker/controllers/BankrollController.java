package org.launchcode.bankrolltracker.controllers;

import org.launchcode.bankrolltracker.models.Bankroll;
import org.launchcode.bankrolltracker.models.data.BankrollDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("bankroll")
public class BankrollController {

    @Autowired
    private BankrollDao bankrollDao;

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("bankrolls", bankrollDao.findAll());
        model.addAttribute("title", "My Goals");

        return "bankroll/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddBankrollform(Model model) {
        model.addAttribute("title", "Add to Goals");
        model.addAttribute(new Bankroll());

        return "bankroll/add";
    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddBankrollForm(@ModelAttribute @Valid Bankroll newBankroll,
                                        Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Bankroll");
            model.addAttribute("bankroll", bankrollDao.findAll());
            return "bankroll/add";
        }
        bankrollDao.save(newBankroll);
        return "redirect:";
    }
}
