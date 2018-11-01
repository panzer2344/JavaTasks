package com.podval;

public class Author {
    private String name;
    private  String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Author[" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ']';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        Author author = (Author) obj;

        return author.email.equals(email) &&
                author.gender == gender &&
                author.name.equals(name);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (int)gender;
        result = 31 * result + email.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }


}
