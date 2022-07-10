package testtask.footballmanager.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "football_players")
public class FootballPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    @Column(name = "experience_months")
    private int experienceInMonths;

    @ManyToOne
    @JoinColumn(name = "football_club_id")
    private FootballClub footballClub;

    public FootballPlayer(String name, int experienceInMonths, FootballClub footballClub) {
        this.name = name;
        this.experienceInMonths = experienceInMonths;
        this.footballClub = footballClub;
    }

    public FootballPlayer() {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperienceInMonths() {
        return experienceInMonths;
    }

    public void setExperienceInMonths(int experienceInMonths) {
        this.experienceInMonths = experienceInMonths;
    }

    public FootballClub getFootballClub() {
        return footballClub;
    }

    public void setFootballClub(FootballClub footballClub) {
        this.footballClub = footballClub;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FootballPlayer that = (FootballPlayer) o;
        return age == that.age
                && experienceInMonths == that.experienceInMonths
                && Objects.equals(id, that.id)
                && Objects.equals(name, that.name)
                && Objects.equals(footballClub, that.footballClub);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, experienceInMonths, footballClub);
    }

    @Override
    public String toString() {
        return "FootballPlayer{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", age=" + age
                + ", experienceInMonths=" + experienceInMonths
                + ", footballClub=" + footballClub
                + '}';
    }
}
