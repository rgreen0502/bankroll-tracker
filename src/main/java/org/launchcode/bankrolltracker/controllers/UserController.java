package org.launchcode.bankrolltracker.controllers;

import org.launchcode.bankrolltracker.models.User;
import org.launchcode.bankrolltracker.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("title", "Users");

        return "user/index";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        model.addAttribute("users", userDao.findAll());
        return "user/add";
    }
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddUserForm(@ModelAttribute @Valid User newUser,
                                       Errors errors, Model model){

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User");
            model.addAttribute("users", userDao.findAll());
            return "user/add";
        }

        userDao.save(newUser);
        return "redirect:";
    }
}