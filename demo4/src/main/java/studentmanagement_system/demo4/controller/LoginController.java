package studentmanagement_system.demo4.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
//import jakarta.servlet.ServletException;
import studentmanagement_system.demo4.entity.Login;
import studentmanagement_system.demo4.service.LoginService;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public String Validate(@RequestBody Login user)
    {
        String jwtToken = "";

        if(user.getUserName() == null || user.getPassword() == null)
        {
            //throw new ServletException("Please fill the userName and the password");
        }

        String userName = user.getUserName();
        String password = user.getPassword();

        user = loginService.loginUser(userName, password);

        jwtToken = Jwts.builder().setSubject(userName).claim("role", "user").setIssuedAt(new Date())
         .signWith(SignatureAlgorithm.HS256, "secretkey").compact();

         return jwtToken;

    }
    
}
