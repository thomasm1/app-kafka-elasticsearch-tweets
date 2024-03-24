package app.mapl.webControllers;





import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import app.mapl.dto.LoginDto;
import app.mapl.dto.UserDto;
import app.mapl.service.UsersService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Value("${version}")
    private String ver;



    UsersService usersService;


    IndexController( UsersService usersService ) {

        this.usersService = usersService;
    }

    @GetMapping(value = {"/v1", "/v1/"})
    public String consoleHome(Model model ) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();

        model.addAttribute("versionNumber",ver);

//        // Query database for chain-links
//        List<CoinDto> chains = chainsService.getAllCoins();
//        model.addAttribute("chains", chains);

        List<UserDto> users =  usersService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("map", map);

//        List<CoinDto> dataCat= chainsService.findByName("ethereum");

        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginDto",loginDto);
        // convert chain data object into json
        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonString = objectMapper.writeValueAsString(dataCat);
//        String json = objectMapper.writeValueAsString(data);
//        model.addAttribute("dataCat", jsonString);

        return "index";    // i.e. src/main/resources/templates/index.html
    }
}
