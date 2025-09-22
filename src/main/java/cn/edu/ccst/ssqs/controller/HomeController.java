package cn.edu.ccst.ssqs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // 重定向到index.html
        return "redirect:/index.html";

        // 或者直接forward（不会改变URL）
        // return "forward:/index.html";
    }
}