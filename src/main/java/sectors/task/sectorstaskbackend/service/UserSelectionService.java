package sectors.task.sectorstaskbackend.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sectors.task.sectorstaskbackend.dto.MainSectorDto;
import sectors.task.sectorstaskbackend.dto.UserSelectionDto;
import sectors.task.sectorstaskbackend.exception.SelectionNotFoundException;
import sectors.task.sectorstaskbackend.mapper.UserSelectionMapper;
import sectors.task.sectorstaskbackend.model.UserSelection;
import sectors.task.sectorstaskbackend.repository.ClientUserRepository;
import sectors.task.sectorstaskbackend.repository.UserSelectionRepository;
import sectors.task.sectorstaskbackend.model.ClientUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSelectionService {
    private final UserSelectionRepository userSelectionRepository;
    private final UserSelectionMapper userSelectionMapper;
    private final ClientUserRepository clientUserRepository;

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
    public String getUserSelectionEnteredName(Long id) throws Exception {
        Optional<ClientUser> existingClient = clientUserRepository.findClientUserBySectorUserId(id);
        if (existingClient.isEmpty()) {
            throw new Exception();
        }
        List<UserSelection> userSelection = userSelectionRepository.findUserSelectionsByClientUser(existingClient.get());
        if (userSelection.isEmpty()) {
            return "";
        }
        return userSelection.get(0).getUserName();
    }

    @Transactional
    public List<MainSectorDto> getAllSelectionsOfUser(Long id) throws Exception {
        List<MainSectorDto> allSelectedSectors = new ArrayList<>();
        Optional<ClientUser> existingUser = clientUserRepository.findClientUserBySectorUserId(id);
        if (existingUser.isEmpty()) {
            throw new Exception();
        }
        List<UserSelection> userSelections = userSelectionRepository.findUserSelectionsByClientUser(existingUser.get());
        for (UserSelection userSelection : userSelections) {
            allSelectedSectors.add(new MainSectorDto(userSelection.getSelectionId(), userSelection.getSelectedSector()));
        }
        return allSelectedSectors;
    }

    @Transactional
    public String clearUserSelections(Long id) throws Exception {
        Optional<ClientUser> existingClient = clientUserRepository.findClientUserBySectorUserId(id);
        if (existingClient.isEmpty()) {
            throw new Exception();
        }
        List<UserSelection> userSelections = userSelectionRepository.findUserSelectionsByClientUser(existingClient.get());
        userSelectionRepository.deleteAll(userSelections);
        return "Old selections removed";
    }

    @Transactional
    public String addNewSelection(String name, String sector, Boolean agreement, Long userId) throws Exception {
        Optional<ClientUser> existingUser = clientUserRepository.findClientUserBySectorUserId(userId);
        if (existingUser.isEmpty()) {
            throw new Exception();
        }
        UserSelection selection = new UserSelection();
        selection.setUserName(name);
        selection.setSelectedSector(sector);
        selection.setAgreeToTerms(agreement);
        selection.setClientUser(existingUser.get());
        Optional<UserSelection> existingUserSelection = userSelectionRepository.findBySelectionId(selection.getSelectionId());
        if (existingUserSelection.isEmpty()) {
            userSelectionRepository.save(selection);
            return "New selection was added";
        }
        return "No selection was added";
    }
}
