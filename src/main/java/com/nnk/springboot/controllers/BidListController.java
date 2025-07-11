package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.dtos.BidListDto;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.services.impl.BidListService;
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


@Controller
public class BidListController {
    private final BidListService service;

    public BidListController(BidListService service) {
        this.service = service;
    }

    @RequestMapping("/bidList/list")
    public String home(Model model) {
        List<BidListDto> list = service.findAll();
        if (list.isEmpty()) {
            model.addAttribute("bidLists", new ArrayList<>());
        }
        model.addAttribute("bidLists", service.findAll());
        return "bidList/list";
    }

    @GetMapping("/bidList/add")
    public String addBidForm(BidList bid) {
        return "bidList/add";
    }

    @PostMapping("/bidList/validate")
    public String validate(@Valid BidListDto bid, BindingResult result, Model model) {
        BidListDto dto = new BidListDto();
        if (!result.hasErrors()) {
            dto = this.service.create(bid);
        }
        model.addAttribute("bidList", dto);
        return "redirect:/bidList/list";
    }

    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("bidList", this.service.findById(id));
        return "bidList/update";
    }

    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid BidListDto bidList,
                             BindingResult result, Model model) throws ParameterNotProvidedException {
        BidListDto dto = new BidListDto();
        if (!result.hasErrors()) {
            dto = this.service.update(id, bidList);
        }
        model.addAttribute("bidList", dto);
        return "redirect:/bidList/list";
    }

    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) throws ParameterNotProvidedException {
        this.service.deleteById(id);
        return "redirect:/bidList/list";
    }
}
