package com.friendsofgroot.app.controllers.consoles;





import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.models.dto.ChainDto;
import com.friendsofgroot.app.models.dto.LoginDto;
import com.friendsofgroot.app.models.dto.RegisterDto;
import com.friendsofgroot.app.models.dto.UserDto;
import com.friendsofgroot.app.service.ChainsService;
import com.friendsofgroot.app.service.UsersService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Value("${app.version}")
    private String ver;


    ChainsService chainsService;


    UsersService usersService;


    IndexController( ChainsService chainsService, UsersService usersService ) {
        this.chainsService = chainsService;
        this.usersService = usersService;
    }

    // handler method to handle login request
    @GetMapping("/v1/login")
    public String login(){

        log.info(" login ===============================  " );
        return "login";
    }
    @GetMapping("/v1/register")
    public String showRegistrationForm(Model model){

        log.info(" showRegistrationForm ===============================model {} ", model );
        // create model object to store form data
        RegisterDto user = new RegisterDto();
        model.addAttribute("user", user);
        return "register";
    }
    @PostMapping("/v1/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){

        log.info(" v1/register/save =================== userDto {}  result{}, model {}============  ",   userDto,
                result, model );
        UserDto existingUser = usersService.getUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/api/register";
        }

        usersService.registerUser(userDto);
        return "redirect:/api/register?success";
    }
    @GetMapping(value = {"/v1", "/v1/", "/v1/index"})
    public String consoleHome(Model model) throws JsonProcessingException {
        log.info("consoleHome ===================   model {}============  ",   model );

        Map<String, Object> map = new HashMap<>();
        model.addAttribute("versionNumber",ver);

        List<ChainDto> chains;
        List<UserDto> users;
        List<ChainDto> dataCat;
        if(model.getAttribute("authenticated") == "true") {
            // Query database for chain-links
            chains = chainsService.getAllChains();
            model.addAttribute("chains", chains);

            users = usersService.getUsers();
            model.addAttribute("users", users);
            model.addAttribute("map", map);

            dataCat = chainsService.findByName("ethereum");

            LoginDto loginDto = new LoginDto();
            model.addAttribute("loginDto",loginDto);
            // convert chain data object into json
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(dataCat);
//        String json = objectMapper.writeValueAsString(data);
            model.addAttribute("dataCat", jsonString);

            // query for users
//        List<ChainUsers> userChainCnt = usersService.getUserChains();
//        model.addAttribute("userChainCnt", userChainCnt);
            // query for users
//        List<UserChain> userChainCnt = usersService.getUserChains();
//        model.addAttribute("userChainCnt", userChainCnt);
        }

        // i.e. src/main/resources/templates/index.html
        return "index";
    }
    @GetMapping("/users")
    public String users(Model model){
        log.info("==============/users    model {} ", model);
        List<UserDto> users = usersService.getUsers();
        model.addAttribute("users", users);
        return "users";
    }
}

//
//		model.addAttribute("projectStatusCnt", jsonString);
//
//                // we are querying the database for employees
//                List<EmployeeProject> employeesProjectCnt = empService.employeeProjects();
//        model.addAttribute("employeesListProjectsCnt", employeesProjectCnt);
