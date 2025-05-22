package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.dtos.UserDto;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.exceptions.UserListIsEmptyException;
import com.nnk.springboot.services.UserService;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping("/user/list")
    public String home(Model model) throws UserListIsEmptyException {
        model.addAttribute("users", service.findAll());
        return "user/list";
    }

    @GetMapping("/user/add")
    public String addUser(User bid) {
        return "user/add";
    }


    /**
     * A la création de l'utilisateur, le mot de passe est chiffré avec BCrypt avvant d'être enregistré en BDD.
     * @param user
     * @param result
     * @param model
     * @return
     * @throws ParameterNotProvidedException
     * @throws UserListIsEmptyException
     */
    @PostMapping("/user/validate")
    public String validate(@Valid UserDto user, BindingResult result, Model model) throws ParameterNotProvidedException, UserListIsEmptyException {
        if (!result.hasErrors()) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            service.save(user);
            model.addAttribute("users", service.findAll());
            return "redirect:/user/list";
        }
        return "user/add";
    }

    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        UserDto user = service.findById(id);
        user.setPassword("");
        model.addAttribute("user", user);
        return "user/update";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid UserDto user,
                             BindingResult result, Model model) throws ParameterNotProvidedException, UserListIsEmptyException {
        if (result.hasErrors()) {
            return "user/update";
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setId(id);
        service.save(user);
        model.addAttribute("users", service.findAll());
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) throws UserListIsEmptyException {
        UserDto user = service.findById(id);
        service.delete(user.getId());
        model.addAttribute("users", service.findAll());
        return "redirect:/user/list";
    }
}
