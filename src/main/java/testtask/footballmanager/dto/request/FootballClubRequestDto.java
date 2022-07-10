package testtask.footballmanager.dto.request;

import java.math.BigDecimal;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FootballClubRequestDto {
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @Min(value = 0)
    @Max(value = 10)
    private int commissionRate;
    @NotNull
    private BigDecimal bankAccountBalance;

    public String getName() {
        return name;
    }

    public int getCommissionRate() {
        return commissionRate;
    }

    public BigDecimal getBankAccountBalance() {
        return bankAccountBalance;
    }

    @Override
    public String toString() {
        return "FootballClubRequestDto{"
                + "name='" + name + '\''
                + ", commissionRate=" + commissionRate
                + ", bankAccountBalance=" + bankAccountBalance
                + '}';
    }
}
