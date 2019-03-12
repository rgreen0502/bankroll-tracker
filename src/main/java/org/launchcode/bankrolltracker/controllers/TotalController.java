package org.launchcode.bankrolltracker.controllers;

import org.launchcode.bankrolltracker.models.Total;
import org.launchcode.bankrolltracker.models.data.TotalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("total")
public class TotalController {

    @Autowired
    private TotalDao totalDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("totals", totalDao.findAll());
        model.addAttribute("title", "My Total");

        return "total/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddTotalform(Model model) {
        model.addAttribute("title", "Add Total");
        model.addAttribute(new Total());
        return "total/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddTotalForm(@ModelAttribute @Valid Total newTotal,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Total");
            model.addAttribute("total", totalDao.findAll());
            return "total/add";
        }
        totalDao.save(newTotal);
        return "redirect:";
    }
}
