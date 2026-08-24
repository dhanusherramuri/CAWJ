package Lab4;

public class Author {
    private String name;
    private String email;
    private char gender;

    Author(String name, String email, char gender){
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String toString(){
        return "Author name : "+name+"\t Email : "+email+"\t Gender : "+gender;
    }
}
