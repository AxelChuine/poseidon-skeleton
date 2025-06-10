package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.dtos.RatingDto;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.services.impl.RatingService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
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
        List<RatingDto> ratings = service.findAll();
        model.addAttribute("ratings", ratings);
        if (Objects.isNull(ratings) || ratings.isEmpty()) {
            model.addAttribute("ratings", new ArrayList<>());
        }
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    @Valid
    public String validate(@Valid RatingDto rating, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            RatingDto dto = this.service.create(rating);
            model.addAttribute("rating", dto);
        }
        return "rating/add";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) throws ParameterNotProvidedException {
        if (Objects.nonNull(id) && id > 0) {
            RatingDto dto = this.service.findById(id);
            model.addAttribute("rating", dto);
        }
        return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    @Valid
    public String updateRating(@PathVariable("id") Integer id, @Valid RatingDto rating,
                             BindingResult result, Model model) {
        if (!result.hasErrors() && Objects.nonNull(id) && id > 0) {
            RatingDto dto = this.service.update(id, rating);
            model.addAttribute("ratings", this.service.findAll());
        }
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) throws ParameterNotProvidedException {
        this.service.deleteById(id);
        model.addAttribute("ratings", this.service.findAll());
        return "redirect:/rating/list";
    }
}
