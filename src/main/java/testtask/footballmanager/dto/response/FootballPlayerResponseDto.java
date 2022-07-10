package testtask.footballmanager.dto.response;

public class FootballPlayerResponseDto {
    private Long id;
    private String name;
    private int age;
    private int experienceInMonths;
    private Long footballClubId;

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

    public Long getFootballClubId() {
        return footballClubId;
    }

    public void setFootballClubId(Long footballClubId) {
        this.footballClubId = footballClubId;
    }

    @Override
    public String toString() {
        return "FootballPlayerResponseDto{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", age=" + age
                + ", experienceInMonths=" + experienceInMonths
                + ", footballClubId=" + footballClubId
                + '}';
    }
}
