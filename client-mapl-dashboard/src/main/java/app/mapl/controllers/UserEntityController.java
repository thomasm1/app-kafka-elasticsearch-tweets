package app.mapl.controllers;

import app.mapl.dto.APIResponseDto;
import app.mapl.dto.UserEntityDto;
import app.mapl.service.UserEntityService;
import io.netty.handler.codec.http.HttpResponseStatus;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

import static java.util.Collections.emptyMap;

@RestController
@RequestMapping("api/uerEntitys")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UserEntityController {
    AuthenticationManager authenticationManager;

    private UserEntityService uerEntityService;

    // Build Save Transaction REST APIfw
    @PostMapping
    public ResponseEntity<UserEntityDto> saveUserEntity(@RequestBody @Valid UserEntityDto uerEntityDto, HttpServletRequest request){
        UserEntityDto savedUserEntity = uerEntityService.saveUserEntity(uerEntityDto);
        return ResponseEntity.created(getUri()).body((UserEntityDto) getResponse(request, emptyMap(), "AccountCreated", HttpResponseStatus.OK));
    }

    private Object getResponse(HttpServletRequest request, Map<Object, Object> emptyMap, String accountCreated, HttpResponseStatus ok) {

        return null;
    }

    private URI getUri() {
        return URI.create("http://localhost:8080/api/uerEntitys");
    }

    // Build Get Transaction REST API
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getUserEntity(@PathVariable("id") Long uerEntityId){
        APIResponseDto apiResponseDto = uerEntityService.getUserEntityById(uerEntityId);
        return   ResponseEntity.ok().body(apiResponseDto);
    }

    @GetMapping("verify/account")
    public ResponseEntity<APIResponseDto> verifyAccount(@RequestParam("key") String key, HttpServletRequest request){
        APIResponseDto apiResponseDto = uerEntityService.verifyAccountKey(key);
        return ResponseEntity.ok().body((APIResponseDto) getResponse(request, emptyMap(), "Account Verified.", HttpResponseStatus.OK));

    }
    // DEPRECATE
//    @PostMapping("/login")
//    public ResponseEntity<?> test(@RequestBody UserLogin userLogin ){
//        Authentication authenticate = authenticationManager.authenticate(UsernamePasswordAuthenticationToken.unauthenticated(userLogin.getEmail(), userLogin.getPassword()));
//        return ResponseEntity.ok().body( Map.of("user",authenticate));
//    }
}
