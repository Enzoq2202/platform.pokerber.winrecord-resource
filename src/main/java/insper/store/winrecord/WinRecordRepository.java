package insper.store.winrecord;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WinRecordRepository extends CrudRepository<WinRecordModel, String> {

    // Busca todos os registros de vitória associados a um playerId específico
    List<WinRecordModel> findByPlayerId(String playerId);
    
    
    
    
}
