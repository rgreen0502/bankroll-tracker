package org.launchcode.bankrolltracker.controllers;


import org.launchcode.bankrolltracker.models.Newgame;
import org.launchcode.bankrolltracker.models.data.NewgameDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("newgame")
public class NewgameController {

    @Autowired
    private NewgameDao newgameDao;

    @RequestMapping(value="")
    public String index(Model model){
        model.addAttribute("newgames", newgameDao.findAll());
        model.addAttribute("title", "My Newgames");

        return "newgame/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddNewgameform(Model model) {
        model.addAttribute("title", "Add Newgame");
        model.addAttribute(new Newgame());

        return "newgame/add";
    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddNewgameForm(@ModelAttribute @Valid Newgame newNewgame,
                                        Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Newgame");
            model.addAttribute("newgame", newgameDao.findAll());
            return "newgame/add";
        }
        newgameDao.save(newNewgame);
        return "redirect:";
    }
}
