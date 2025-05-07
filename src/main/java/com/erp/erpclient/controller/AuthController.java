package com.erp.erpclient.controller;

import com.erp.erpclient.SessionManager;
import com.erp.erpclient.dto.LoginRequest;
import com.erp.erpclient.service.api.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class AuthController {

    private final LoginService loginService;
    private final SessionManager sessionManager;

    @GetMapping("/")
    public String showLoginForm() {
        return "index";
    }

    @PostMapping("/login")
    public String auth(
            @RequestParam(name = "inp-usr") String usr,
            @RequestParam(name = "inp-pwd") String pwd,
            RedirectAttributes redirectAttributes
    ) {
        LoginRequest req = new LoginRequest(usr, pwd);
        loginService.login(req);

        boolean auth = sessionManager.hasAuthCookie();
        if (auth) {
            return "redirect:/suppliers";
        } else {
            redirectAttributes.addFlashAttribute("err", "Login Failed");
            return "index";
        }
    }
    
    @GetMapping("/logout")
    public String logout(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", "Logout Successful");
        return "redirect:/";
    }
}
