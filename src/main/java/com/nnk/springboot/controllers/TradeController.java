package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.dtos.TradeDto;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.services.impl.TradeService;
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
public class TradeController {

    private final TradeService service;

    public TradeController(TradeService service) {
        this.service = service;
    }

    @RequestMapping("/trade/list")
    public String home(Model model)
    {
        model.addAttribute("trades", this.service.findAll());
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(Trade bid) {
        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@Valid TradeDto trade, BindingResult result, Model model) throws ParameterNotProvidedException {
        List<TradeDto> list = this.service.findAll();
        if (!result.hasErrors()) {
            list.add(this.service.create(trade));
            model.addAttribute("trades", list);
        }
        return "trade/add";
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) throws ParameterNotProvidedException {
        model.addAttribute("trade", this.service.findById(id));
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid TradeDto trade,
                             BindingResult result, Model model) throws ParameterNotProvidedException {
        List<TradeDto> list = this.service.findAll();
        if (!result.hasErrors() && Objects.nonNull(id)) {
            list.add(this.service.update(id, trade));
            model.addAttribute("trades", list);
        }
        return "redirect:/trade/list";
    }

    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) throws ParameterNotProvidedException {
        this.service.deleteById(id);
        model.addAttribute("trades", this.service.findAll());
        return "redirect:/trade/list";
    }
}
