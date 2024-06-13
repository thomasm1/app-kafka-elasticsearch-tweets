package app.mapl.controllers;





import app.mapl.mapper.UserMapper;
import app.mapl.models.auth.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import app.mapl.models.auth.UserResponse;
import app.mapl.service.UsersService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserDashController {

    @Value("${version}")
    private String ver;

    final
    UsersService usersService;

//    @Autowired
    BCryptPasswordEncoder bCryptEncoder;

//    @Autowired
    UserMapper userMapper;


    public UserDashController( UsersService usersService ) {
        this.usersService = usersService;

    }


    @GetMapping("/v1/register")
    public String register(Model model) {
        UserRequest userAccount = new UserRequest();
        model.addAttribute("registerDto", userAccount);

        return "security/register";
    }

    @PostMapping("/v1/register/save")
    public String saveUser(Model model, UserRequest user) {
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
      try {
          usersService.createUser(user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword());
          return "redirect:/v1/";
      } catch (Exception e) {
          String errorMessage = "Error: " + e.getMessage();
          model.addAttribute("errorMessage", errorMessage);
          return "security/register";
      }
    }
    @GetMapping(value = {"/v1/users", "/v1/users/"})
    public String consoleHome(Model model ) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        model.addAttribute("versionNumber",ver);


        List<UserResponse> users =  usersService.getUsersResponse();
        model.addAttribute("users", users);
        model.addAttribute("map", map);

        return "users";
    }
}
