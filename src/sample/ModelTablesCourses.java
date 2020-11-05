package sample;

public class ModelTablesCourses {
    private String id;
    private String title;
    private String lenght;
    private String description;

    public ModelTablesCourses (String id, String title, String lenght, String description){
        this.id = id;
        this.title = title;
        this.lenght = lenght;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLenght() {
        return lenght;
    }

    public String getDescription() {
        return description;
    }
}
