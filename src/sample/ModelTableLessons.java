package sample;

public class ModelTableLessons {
    private String id;
    private String teachers;
    private String course;
    private String room;
    private String data;

    public ModelTableLessons (String id, String teachers, String Course, String room, String Data){
        this.id = id;
        this.teachers = teachers;
        this.course = Course;
        this.room = room;
        this.data = Data;
    }

    public String getCourse() {
        return course;
    }

    public String getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getRoom() {
        return room;
    }

    public String getTeachers() {
        return teachers;
    }
}
