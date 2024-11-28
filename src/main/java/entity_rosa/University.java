package entity_rosa;

/**
 * A University.
 */
public class University {
    private final String university_name;
    private final String country;
    private final String uni_city;
    private final String study_language;
    private final String tuition;
    private final String award;
    private final String school;
    private final String min_GPA;

    public University(String country, String city, String university, String language, String tuition, String award, String school, String min_GPA) {
        this.country = country;
        this.uni_city = city;
        this.study_language = language;
        this.tuition = tuition;
        this.award = award;
        this.min_GPA = min_GPA;
        this.school = school;
        this.university_name = university;
    }
    public String getUniversity_name() {return university_name;}
    public String getCountry() {return country;}
    public String getUni_city() {return uni_city;}
    public String getStudy_language() {return study_language;}
    public String getTuition() {return tuition;}
    public String getAward() {return award;}
    public String getSchool() {return school;}
    public String getMin_GPA() {return min_GPA;}

}
