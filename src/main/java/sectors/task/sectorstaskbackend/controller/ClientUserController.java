package sectors.task.sectorstaskbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sectors.task.sectorstaskbackend.dto.ClientUserDto;
import sectors.task.sectorstaskbackend.model.ClientUser;
import sectors.task.sectorstaskbackend.service.ClientUserService;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
@RestController
@RequiredArgsConstructor
public class ClientUserController {
    private final ClientUserService clientUserService;

    @GetMapping("/client/{id}")
    public ClientUserDto getClient(@PathVariable Long id) throws Exception {
        return clientUserService.getClient(id);
    }

    @GetMapping("/getClientId")
    public Long getClientId(@RequestParam String email) throws Exception {
        return clientUserService.getClientId(email);
    }

    @PostMapping("/addClient")
    public String addNewUser(@RequestBody ClientUser clientUser) {
        return clientUserService.addNewUser(clientUser);
    }

    @GetMapping("/isValidClient")
    public Boolean isValidClient(@RequestParam String email,@RequestParam String password) {
        return clientUserService.isValidClient(email, password);
    }
}
