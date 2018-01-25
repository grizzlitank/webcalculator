package com.example.webcalculator.controller;


import com.example.webcalculator.services.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/calculator")
public class NumberController {

    @Autowired
    NumberService numberService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String listAuthors(Model model){
        model.addAttribute("numbers", numberService.getAnswer());
        return "calculator/list";
    }

    @RequestMapping(value = "/addition", method = RequestMethod.POST)
    public ModelAndView addition() {
        numberService.additionNumbers();
        return new ModelAndView("redirect:/calculator");
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("id") int id) {
        numberService.concat(id);
        return new ModelAndView("redirect:/calculator");
    }
}
