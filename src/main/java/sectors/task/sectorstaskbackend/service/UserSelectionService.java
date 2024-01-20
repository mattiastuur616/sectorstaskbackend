package sectors.task.sectorstaskbackend.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sectors.task.sectorstaskbackend.dto.UserSelectionDto;
import sectors.task.sectorstaskbackend.exception.SelectionNotFoundException;
import sectors.task.sectorstaskbackend.mapper.UserSelectionMapper;
import sectors.task.sectorstaskbackend.model.UserSelection;
import sectors.task.sectorstaskbackend.repository.UserSelectionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSelectionService {
    private final UserSelectionRepository userSelectionRepository;
    private final UserSelectionMapper userSelectionMapper;

    @Transactional
    public List<UserSelectionDto> getAllUserSelections() {
        List<UserSelectionDto> userSelectionDtoList = new ArrayList<>();
        for (UserSelection userSelection : userSelectionRepository.findAll()) {
            userSelectionDtoList.add(userSelectionMapper.userSelectionToUserSelectionDto(userSelection));
        }
        return userSelectionDtoList;
    }

    @Transactional
    public UserSelectionDto getUserSelectionById(Long id) throws SelectionNotFoundException {
        Optional<UserSelection> existingUserSelection = userSelectionRepository.findById(id);
        if (existingUserSelection.isPresent()) {
            return userSelectionMapper.userSelectionToUserSelectionDto(existingUserSelection.get());
        }
        throw new SelectionNotFoundException("Selection was not found");
    }

    @Transactional
    public String addNewSelection(UserSelection userSelection) {
        Optional<UserSelection> existingUserSelection = userSelectionRepository.findBySelectionId(userSelection.getSelectionId());
        if (existingUserSelection.isEmpty()) {
            userSelectionRepository.save(userSelection);
            return "New selection was added";
        }
        return "No selection was added";
    }
}
