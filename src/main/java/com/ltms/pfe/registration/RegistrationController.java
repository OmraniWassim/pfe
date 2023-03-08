package com.ltms.pfe.registration;

import com.ltms.pfe.app.user.AppUser;
import com.ltms.pfe.app.user.AppUserDTO;
import com.ltms.pfe.app.user.AppUserDTOMapper;
import com.ltms.pfe.app.user.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/registration")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
    private RegistrationService registrationService;
    private final AppUserRepository appUserRepository;
    private AppUserDTOMapper appUserDTOMapper;


    @GetMapping("/all")
    public ResponseEntity<List<AppUserDTO>> getAllAppUsers () {
        List<AppUserDTO> appUsers=registrationService.findAllAppUsers();
        return new ResponseEntity<>(appUsers, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<String> register(@RequestBody RegistrationRequest request){
        if(appUserRepository.findByEmail(request.getEmail()).isPresent()) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);

        }else{
            return new ResponseEntity<>(registrationService.register(request), HttpStatus.OK);
        }

    }

    @PostMapping("/login")
    public ResponseEntity<HashMap<String,String>> login(@RequestBody LoginRequest loginRequest) {
        HashMap<String, String> map = new HashMap<String, String>();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<AppUser> appUser = appUserRepository.findByEmail(loginRequest.getEmail());
        String role=appUser.get().getAppUserRole().toString();

        if (encoder.matches(loginRequest.getPassword(),appUser.get().getPassword())==false) {
            map.put("reponse", "password");
            return new ResponseEntity<>(map, HttpStatus.OK);


        } else if ((appUser.get().isEnabled()) &&
        encoder.matches(loginRequest.getPassword(),appUser.get().getPassword())==true) {
            map.put("reponse", role);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else if (appUser.get().isEnabled()==false) {
            map.put("reponse", "disabled");
            return new ResponseEntity<>(map, HttpStatus.OK);
        }


        return null;
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Optional<AppUserDTO>> getAppUserById (@PathVariable("id") Long id) {
        Optional<AppUserDTO> appUser = registrationService.findById(id);
        return new ResponseEntity<>(appUser, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id,@RequestBody RegistrationRequest request) {
        registrationService.updateAppUser(request,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAppUser(@PathVariable("id") Long id) {
        registrationService.deleteAppUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
