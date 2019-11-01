package com.evfjunior.contactmanager.controller;

import com.evfjunior.contactmanager.util.MappingName;
import com.evfjunior.contactmanager.util.ViewName;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping(MappingName.MAIN)
    public String showMainPage() {
        return ViewName.MAIN;
    }
}
