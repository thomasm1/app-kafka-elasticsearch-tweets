package app.mapl.webControllers;





import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import app.mapl.dto.RegisterDto;
import app.mapl.dto.UserDto;
import app.mapl.mapper.UserMapper;
import app.mapl.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
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


    UserMapper userMapper;
//    @Autowired


    public UserDashController( UsersService usersService ) {
        this.usersService = usersService;

    }


    @GetMapping("/v1/register")
    public String register(Model model) {
        RegisterDto userAccount = new RegisterDto();
        model.addAttribute("registerDto", userAccount);

        return "security/register";
    }

    @PostMapping("/v1/register/save")
    public String saveUser(Model model, RegisterDto user) {
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
      try {
          usersService.registerUser(user);
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


        List<UserDto> users =  usersService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("map", map);

        return "users";
    }
}
