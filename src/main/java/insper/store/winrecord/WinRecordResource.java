package insper.store.winrecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/win-records") // Define o caminho base para este controlador
public class WinRecordResource {

    @Autowired
    private WinRecordService winRecordService;

    // Endpoint para registrar uma nova vitória
    @PostMapping
    public ResponseEntity<WinRecordOut> createWinRecord(@RequestBody WinRecordIn winRecordIn) {
        WinRecordModel winRecordModel = winRecordService.createWinRecord(winRecordIn);
        WinRecordOut winRecordOut = WinRecordParser.toOut(winRecordModel);
        return ResponseEntity.ok(winRecordOut);
    }

    // Endpoint para buscar todos os registros de vitória de um jogador específico
    @GetMapping("/{playerId}")
    public ResponseEntity<List<WinRecordOut>> getWinRecordsByPlayerId(@PathVariable String playerId) {
        List<WinRecordModel> winRecords = winRecordService.findWinRecordsByPlayerId(playerId);
        List<WinRecordOut> winRecordsOut = winRecords.stream().map(WinRecordParser::toOut).collect(Collectors.toList());
        return ResponseEntity.ok(winRecordsOut);
    }
}
