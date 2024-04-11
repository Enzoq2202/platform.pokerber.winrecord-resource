package insper.store.winrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WinRecordService {

    @Autowired
    private WinRecordRepository winRecordRepository;

    @Autowired
    private WinRecordClient winRecordClient;

    public WinRecordModel createWinRecord(WinRecordIn winRecordIn) {
        ResponseEntity<Void> response = winRecordClient.checkAccountExists(winRecordIn.playerId());

        if (!response.getStatusCode().is2xxSuccessful()) {
            // Se o usuário não existe, lança uma exceção
            throw new RuntimeException("Player ID does not exist.");
        }
        // Se o usuário existe, procede com a criação do registro
        WinRecordModel winRecordModel = WinRecordParser.toModel(winRecordIn);
        return winRecordRepository.save(winRecordModel);
    }

    public List<WinRecordModel> findWinRecordsByPlayerId(String playerId) {
        // A verificação do playerId pode ser omitida aqui se a funcionalidade desejada é apenas recuperar os registros
        return winRecordRepository.findByPlayerId(playerId);
    }
}
