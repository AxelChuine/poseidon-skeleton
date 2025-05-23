package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.dtos.RatingDto;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.services.RatingService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Objects;


@Controller
public class RatingController {
    private final RatingService service;

    public RatingController(RatingService service) {
        this.service = service;
    }

    @RequestMapping("/rating/list")
    public String home(Model model) {
        model.addAttribute("ratings", service.findAll());
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@Valid RatingDto rating, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Rating list
        List<RatingDto> list = this.service.findAll();
        if (!result.hasErrors()) {
            RatingDto dto = this.service.create(rating);
            list.add(dto);
            model.addAttribute("ratings", list);
        }
        return "rating/add";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) throws ParameterNotProvidedException {
        // TODO: get Rating by Id and to model then show to the form
        if (Objects.nonNull(id) && id > 0) {
            RatingDto dto = this.service.findById(id);
            model.addAttribute("rating", dto);
        }
        return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid RatingDto rating,
                             BindingResult result, Model model) {
        List<RatingDto> list = this.service.findAll();
        if (!result.hasErrors() && Objects.nonNull(id) && id > 0) {
            RatingDto dto = this.service.update(rating);
            list.add(dto);
            model.addAttribute("ratings", list);
        }
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) throws ParameterNotProvidedException {
        // TODO: Find Rating by Id and delete the Rating, return to Rating list
        this.service.deleteById(id);
        List<RatingDto> list = this.service.findAll();
        model.addAttribute("ratings", list);
        return "redirect:/rating/list";
    }
}
