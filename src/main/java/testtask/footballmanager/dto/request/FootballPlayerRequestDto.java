package testtask.footballmanager.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class FootballPlayerRequestDto {
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    private int age;
    @NotNull
    @Min(value = 0)
    private int experienceInMonths;
    @NotNull
    @Positive
    private Long footballClubId;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getExperienceInMonths() {
        return experienceInMonths;
    }

    public Long getFootballClubId() {
        return footballClubId;
    }
}
