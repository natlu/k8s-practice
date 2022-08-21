package com.example.demo.LoremPicsum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LPController {
    private final LPService lpService;

    @Autowired
    public LPController(LPService lpService) {
        this.lpService = lpService;
    }

    @GetMapping("/lp")
    public String getLP(Model model) {
        model.addAttribute("imageDir", "image.jpg");
        //lpService.getLP();
        return "lp";
    }


    //@RequestMapping(path = "lp")
    @GetMapping(value="/test")
    @ResponseBody
    public String foo() {
        return lpService.foo();
    }
}

