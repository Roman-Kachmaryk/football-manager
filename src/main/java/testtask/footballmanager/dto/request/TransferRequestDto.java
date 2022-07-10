package testtask.footballmanager.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class TransferRequestDto {
    @NotNull
    @Positive
    private Long footballPlayerId;
    @NotNull
    @Positive
    private Long fromFootballClubId;
    @NotNull
    @Positive
    private Long toFootballClubId;

    public TransferRequestDto(Long footballPlayerId, Long fromFootballClubId,
                              Long toFootballClubId) {
        this.footballPlayerId = footballPlayerId;
        this.fromFootballClubId = fromFootballClubId;
        this.toFootballClubId = toFootballClubId;
    }

    public Long getFootballPlayerId() {
        return footballPlayerId;
    }

    public Long getFromFootballClubId() {
        return fromFootballClubId;
    }

    public Long getToFootballClubId() {
        return toFootballClubId;
    }
}
