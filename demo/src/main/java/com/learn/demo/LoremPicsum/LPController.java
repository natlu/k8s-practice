package com.learn.demo.LoremPicsum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Controller
public class LPController {
    private final LPService lpService;

    @Autowired
    public LPController(LPService lpService) {
        this.lpService = lpService;
    }

    @GetMapping("/lp")
    public String getLP(Model model) {
        lpService.getLP();
        model.addAttribute("imageDir", "/uploads/image.jpg");
        model.addAttribute("mylist", lpService.getTodo());
        return "lp";
    }

    @PostMapping("/todo")
    public String addTodo(@RequestParam String todoItem) {
        lpService.postTodo(todoItem);
        return "redirect:/lp";
    }

    //@RequestMapping(path = "lp")
    @GetMapping(value="demo/test")
    @ResponseBody
    public List<String> getTodo() {
        return lpService.getTodo();
    }
}

