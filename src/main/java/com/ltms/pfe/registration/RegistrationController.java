package com.ltms.pfe.registration;

import com.ltms.pfe.app.user.AppUser;
import com.ltms.pfe.app.user.AppUserDTO;
import com.ltms.pfe.app.user.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/registration")
@AllArgsConstructor
public class RegistrationController {
    private RegistrationService registrationService;
    private final AppUserRepository appUserRepository;


    @GetMapping("/all")
    public ResponseEntity<List<AppUserDTO>> getAllAppUsers () {
        List<AppUserDTO> appUsers=registrationService.findAllAppUsers();
        return new ResponseEntity<>(appUsers, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<String> register(@RequestBody RegistrationRequest request){
        return new ResponseEntity<>(registrationService.register(request), HttpStatus.OK);
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
