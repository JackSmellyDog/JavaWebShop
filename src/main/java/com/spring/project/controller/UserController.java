package com.spring.project.controller;

import com.spring.project.model.Meme;
import com.spring.project.model.User;
import com.spring.project.service.MemeService;
import com.spring.project.service.SecurityService;
import com.spring.project.service.UserService;
import com.spring.project.validator.UserValidator;
import com.sun.javafx.sg.prism.NGShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    // Meme

    private MemeService memeService;

    @Autowired(required = true)
    @Qualifier(value = "memeService")
    public void setMemeService(MemeService memeService) {
        this.memeService = memeService;
    }

    @RequestMapping(value = "memes", method = RequestMethod.GET)
    public String listMemes(Model model){
        model.addAttribute("meme", new Meme());
        model.addAttribute("listMemes", this.memeService.listMemes());

        return "memes";
    }

    @RequestMapping(value = "/memes/add", method = RequestMethod.POST)
    public String addMeme(@ModelAttribute("meme") Meme meme){
        if (meme.getId() == null){
            this.memeService.addMeme(meme);
        } else {
            this.memeService.updateMeme(meme);
        }

        return "redirect:/memes";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeMeme(@PathVariable(value = "id") long id){
        this.memeService.removeMeme(id);

        return "redirect:/memes";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editMeme(@PathVariable(value = "id") long id, Model model){
        model.addAttribute("meme", this.memeService.getMemeById(id));
        model.addAttribute("listMemes", this.memeService.listMemes());

        return "memes";
    }

    @RequestMapping(value = "memedata/{id}")
    public String memeData(@PathVariable(value = "id") long id, Model model){
        model.addAttribute("meme", this.memeService.getMemeById(id));

        return "memedata";
    }


    // End meme

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model){
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()){
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout){
        if (error != null){
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null){
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model){
        return "welcome";
    }

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public String admin(Model model){
        return "admin";
    }

}
