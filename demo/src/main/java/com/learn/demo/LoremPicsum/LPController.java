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

    private List<String> dummyList() {
        List<String> llist=new LinkedList<>();
        llist.add("a");
        llist.add("b");
        llist.add("c");
        return llist;
    }

    @Autowired
    public LPController(LPService lpService) {
        this.lpService = lpService;
    }

    @GetMapping("/lp")
    public String getLP(Model model) {
        lpService.getLP();
        model.addAttribute("imageDir", "/uploads/image.jpg");
        model.addAttribute("mylist", dummyList());
        return "lp";
    }


    //@RequestMapping(path = "lp")
    @GetMapping(value="/test")
    @ResponseBody
    public String foo() {
        return lpService.foo();
    }
}

