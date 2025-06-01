package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.dtos.CurvePointDto;
import com.nnk.springboot.exceptions.CurvePointIsNullException;
import com.nnk.springboot.exceptions.CurvePointNotFoundException;
import com.nnk.springboot.exceptions.ParameterNotProvidedException;
import com.nnk.springboot.services.impl.CurvePointService;
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
public class CurvePointController {
    private final CurvePointService service;

    public CurvePointController(CurvePointService service) {
        this.service = service;
    }


    @RequestMapping("/curvePoint/list")
    public String home(Model model) throws CurvePointNotFoundException {
        List<CurvePointDto> list = this.service.findAll();
        model.addAttribute("curvePoints", list);
        if (Objects.isNull(list) || list.isEmpty()) {
            model.addAttribute("curvePoints", new ArrayList<>());
        }
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(CurvePoint bid) {
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@Valid CurvePointDto curvePoint, BindingResult result, Model model) throws CurvePointNotFoundException, CurvePointIsNullException {
        if (!result.hasErrors()) {
            CurvePointDto dto = this.service.create(curvePoint);
            model.addAttribute("curvePoint", dto);
        }
        return "curvePoint/add";
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) throws ParameterNotProvidedException {
        model.addAttribute("curve", this.service.findById(id));
        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid CurvePointDto curvePoint,
                             BindingResult result, Model model) throws CurvePointNotFoundException, ParameterNotProvidedException {
        if (!result.hasErrors() && Objects.nonNull(id)) {
            this.service.update(id, curvePoint);
        }
        model.addAttribute("curvePoints", this.service.findAll());
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) throws ParameterNotProvidedException, CurvePointNotFoundException {
        // TODO: Find Curve by Id and delete the Curve, return to Curve list
        this.service.deleteById(id);
        model.addAttribute("curvePoints", this.service.findAll());
        return "redirect:/curvePoint/list";
    }
}
