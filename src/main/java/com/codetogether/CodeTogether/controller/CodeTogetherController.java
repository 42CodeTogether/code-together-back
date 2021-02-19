package com.codetogether.CodeTogether.controller;

import com.codetogether.CodeTogether.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CodeTogetherController {

    @GetMapping("code2token")
    public String code2token(Model model, @RequestParam("code") String code) {
        String loginId = AuthService.code2token(code);
        model.addAttribute("result", loginId);
        return "code2token";
    }
}

