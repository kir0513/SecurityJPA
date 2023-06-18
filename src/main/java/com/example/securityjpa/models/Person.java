package com.example.securityjpa.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
    private Long id;

@Column(name = "Username")
@NotEmpty(message = "Имя не должно быть пустым")
@Size(min=2, max=100,message = "Имя должно содеожать от 2 до 100 символов")
private String username;

@Column(name = "year_of_birth")
@Min(value = 1900, message = "Год рождения должен быть больше 1900")
private String year_of_birth;

@Column(name = "password")
@NotEmpty(message = "Введите пароль")
private  String password;

    public Person(){}

    public Person(Long id, String username, String year_of_birth, String password) {
        this.id = id;
        this.username = username;
        this.year_of_birth = year_of_birth;
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(String year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", year_of_birth='" + year_of_birth + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
