package sectors.task.sectorstaskbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sectors.task.sectorstaskbackend.dto.MainSectorDto;
import sectors.task.sectorstaskbackend.dto.UserSelectionDto;
import sectors.task.sectorstaskbackend.exception.SelectionNotFoundException;
import sectors.task.sectorstaskbackend.service.UserSelectionService;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
@RestController
@RequiredArgsConstructor
public class UserSelectionController {
    private final UserSelectionService userSelectionService;

    @GetMapping("/allUserSelections")
    public List<UserSelectionDto> getAllUserSelections() {
        return userSelectionService.getAllUserSelections();
    }

    @GetMapping("/userSelection/{id}")
    public UserSelectionDto getUserSelectionById(@PathVariable Long id) throws SelectionNotFoundException {
        return userSelectionService.getUserSelectionById(id);
    }

    @GetMapping("/userSelections/{userId}")
    public List<MainSectorDto> getAllSelectionsOfUser(@PathVariable Long userId) throws Exception {
        return userSelectionService.getAllSelectionsOfUser(userId);
    }

    @GetMapping("/enteredName/{userId}")
    public String getUserSelectionEnteredName(@PathVariable Long userId) throws Exception {
        return userSelectionService.getUserSelectionEnteredName(userId);
    }

    @DeleteMapping("/removeSelections/{userId}")
    public String clearUserSelections(@PathVariable Long userId) throws Exception {
        return userSelectionService.clearUserSelections(userId);
    }

    @PostMapping("/addSelection")
    public String addNewUserSelection(@RequestParam String name, @RequestParam String sector, @RequestParam Boolean agreement,
                                      @RequestParam Long userId) throws Exception {
        return userSelectionService.addNewSelection(name, sector, agreement, userId);
    }
}
