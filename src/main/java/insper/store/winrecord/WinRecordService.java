package insper.store.winrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WinRecordService {

    @Autowired
    private WinRecordRepository winRecordRepository;

    // Cria um novo registro de vitória
    public WinRecordModel createWinRecord(WinRecordIn winRecordIn) {
        WinRecordModel winRecordModel = WinRecordParser.toModel(winRecordIn);
        return winRecordRepository.save(winRecordModel);
    }

    // Busca registros de vitória por ID do jogador
    public List<WinRecordModel> findWinRecordsByPlayerId(String playerId) {
        return winRecordRepository.findByPlayerId(playerId);
    }

}
