package testtask.footballmanager.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "football_clubs")
public class FootballClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "commission_rate")
    private int commissionRate;
    @Column(name = "account_balance")
    private BigDecimal bankAccountBalance;

    public FootballClub() {
    }

    public FootballClub(String name, int commissionRate, BigDecimal bankAccountBalance) {
        this.name = name;
        this.commissionRate = commissionRate;
        this.bankAccountBalance = bankAccountBalance;
    }

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FootballClub that = (FootballClub) o;
        return commissionRate == that.commissionRate
                && Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(bankAccountBalance, that.bankAccountBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, commissionRate, bankAccountBalance);
    }

    @Override
    public String toString() {
        return "FootballClub{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", commissionRate=" + commissionRate
                + ", bankAccountBalance=" + bankAccountBalance
                + '}';
    }
}
