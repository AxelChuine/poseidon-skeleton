package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.dtos.UserDto;
import com.nnk.springboot.exceptions.IncorrectPasswordException;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.exceptions.UserListIsEmptyException;
import com.nnk.springboot.services.impl.UserService;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping("/user/list")
    public String home(Model model) throws UserListIsEmptyException {
        List<UserDto> list = this.service.findAll();
        model.addAttribute("users", list);
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
    @Valid
    public String validate(@Valid UserDto user, BindingResult result, Model model) throws ParameterNotProvidedException, UserListIsEmptyException, IncorrectPasswordException {
        try {
            UserDto dto = null;
            if (!result.hasErrors()) {
                dto = service.create(user);
            }
            model.addAttribute("user", dto);
            return "redirect:/user/list";
        } catch (IncorrectPasswordException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("user", new UserDto());
            return "user/add";
        }
    }


    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        UserDto user = service.findById(id);
        model.addAttribute("user", user);
        return "user/update";
    }

    @PostMapping("/user/update/{id}")
    @Valid
    public String updateUser(@PathVariable("id") Integer id, @Valid UserDto user,
                             BindingResult result, Model model) throws ParameterNotProvidedException, UserListIsEmptyException {
        if (result.hasErrors()) {
            return "redirect:/user/list";
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setId(id);
        UserDto dto = service.save(id, user);
        model.addAttribute("user", dto);
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
