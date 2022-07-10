package testtask.footballmanager.dto.response;

import java.math.BigDecimal;

public class FootballClubResponseDto {
    private Long id;
    private String name;
    private int commissionRate;
    private BigDecimal bankAccountBalance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(int commissionRate) {
        this.commissionRate = commissionRate;
    }

    public BigDecimal getBankAccountBalance() {
        return bankAccountBalance;
    }

    public void setBankAccountBalance(BigDecimal bankAccountBalance) {
        this.bankAccountBalance = bankAccountBalance;
    }

    @Override
    public String toString() {
        return "FootballClubResponseDto{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", commissionRate=" + commissionRate
                + ", bankAccountBalance=" + bankAccountBalance
                + '}';
    }
}
