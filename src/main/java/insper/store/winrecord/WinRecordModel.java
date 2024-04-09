package insper.store.winrecord;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "win_records")
@EqualsAndHashCode(of = "id")
@Builder @Getter @Setter @Accessors(chain = true, fluent = true)
@NoArgsConstructor @AllArgsConstructor
public class WinRecordModel {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_winrecord", updatable = false, nullable = false)
    private String id;

    @Column(name = "player_id", nullable = false)
    private String playerId;

    @Column(name = "win_time", nullable = false)
    private LocalDateTime winTime;

    @Column(name = "win_cards", nullable = false)
    private String winCards;

    @Column(name = "game_type")
    private String gameType;
    
    // O construtor personalizado e o método to() foram removidos, pois a conversão
    // específica não se aplica mais com a atualização dos campos.
}
