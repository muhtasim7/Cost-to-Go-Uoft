package entities;

public class University {
    String Country;
    String City;
    String UniversityName;
    String Language_of_study;
    String Tuition;
    String Award;
    String Minimum_GPA;

    public University(String country, String city, String universityName, String language_of_study, String tuition, String award, String minimum_gpa) {
        this.Country = country;
        this.City = city;
        this.UniversityName = universityName;
        this.Language_of_study = language_of_study;
        this.Tuition = tuition;
        this.Award = award;
        this.Minimum_GPA = minimum_gpa;
    }
    public String getCountry() {return Country;}
    public String getCity() {return City;}
    public String getUniversityName() {return UniversityName;}
    public String getLanguage_of_study() {return Language_of_study;}
    public String getTuition() {return Tuition;}
    public String getAward() {return Award;}
    public String getMinimum_gpa() {return Minimum_GPA;
    }

    @Override
    public String toString() {
        return "University{" + "Country='" + Country + '\'' + ", City='" + City + '\'' + ", UniversityName='"
                + UniversityName + '\'' + ", Language_of_study='" + Language_of_study + '\''
                + ", Tuition='" + Tuition + '\'' + ", Award='" + Award + '\'' + ", Minimum_GPA='"
                + Minimum_GPA + '\'' + '}';
    }
}
