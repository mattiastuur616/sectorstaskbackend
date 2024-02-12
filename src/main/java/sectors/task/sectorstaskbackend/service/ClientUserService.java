package sectors.task.sectorstaskbackend.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sectors.task.sectorstaskbackend.dto.ClientUserDto;
import sectors.task.sectorstaskbackend.mapper.ClientUserMapper;
import sectors.task.sectorstaskbackend.model.ClientUser;
import sectors.task.sectorstaskbackend.repository.ClientUserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientUserService {
    private final ClientUserRepository clientUserRepository;
    private final ClientUserMapper clientUserMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public ClientUserDto getClient(Long id) throws Exception {
        Optional<ClientUser> existingClient = clientUserRepository.findClientUserBySectorUserId(id);
        if (existingClient.isEmpty()) {
            throw new Exception();
        }
        return clientUserMapper.clientUserToClientUserDTO(existingClient.get());
    }

    @Transactional
    public Long getClientId(String email) throws Exception {
        Optional<ClientUser> existingClient = clientUserRepository.findClientUserByEmail(email);
        if (existingClient.isEmpty()) {
            throw new Exception();
        }
        ClientUser actualClient = existingClient.get();
        return actualClient.getSectorUserId();
    }

    @Transactional
    public String addNewUser(ClientUser clientUser) {
        Optional<ClientUser> existingUser = clientUserRepository.findClientUserBySectorUserId(clientUser.getSectorUserId());
        if (existingUser.isEmpty()) {
            clientUser.setPassword(passwordEncoder.encode(clientUser.getPassword()));
            clientUserRepository.save(clientUser);
            return "New client added";
        }
        return "Can't add a new client";
    }

    @Transactional
    public Boolean isValidClient(String email, String password) {
        Optional<ClientUser> existingClient = clientUserRepository.findClientUserByEmail(email);
        return existingClient.filter(clientUser -> passwordEncoder.matches(password, clientUser.getPassword())).isPresent();
    }
}
