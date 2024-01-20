package sectors.task.sectorstaskbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sectors.task.sectorstaskbackend.dto.UserSelectionDto;
import sectors.task.sectorstaskbackend.exception.SelectionNotFoundException;
import sectors.task.sectorstaskbackend.model.UserSelection;
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

    @PostMapping("/addSelection")
    public String addNewUserSelection(@RequestBody UserSelection userSelection) {
        return userSelectionService.addNewSelection(userSelection);
    }
}
