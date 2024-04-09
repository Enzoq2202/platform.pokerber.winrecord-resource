package insper.store.winrecord;

import java.time.LocalDateTime;

public class WinRecordParser {

    // Converte WinRecordIn (DTO de entrada) para WinRecordModel (Entidade)
    public static WinRecordModel toModel(WinRecordIn in) {
        return WinRecordModel.builder()
            .playerId(in.playerId())
            .winTime(LocalDateTime.now()) // Supondo que a vitória seja registrada no momento atual
            .winCards(in.winCards())
            .gameType(in.gameType())
            .build();
    }

    // Converte WinRecordModel (Entidade) para WinRecordOut (DTO de saída)
    public static WinRecordOut toOut(WinRecordModel model) {
        return WinRecordOut.builder()
            .id(model.id())
            .playerId(model.playerId())
            .winTime(model.winTime())
            .winCards(model.winCards())
            .gameType(model.gameType())
            .build();
    }
}
