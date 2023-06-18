package com.example.securityjpa.security;

import com.example.securityjpa.models.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class PersonDetails implements UserDetails {
    private final Person person;

    public PersonDetails(Person person) {
        this.person = person;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
// в return на person можно как угодно получать пароль. Для Spring Security важен стандартный метод public String getPassword() {}
    @Override
    public String getPassword() {
        return this.person.getPassword();
    }
    // в return на person можно вызывать что угодно в частности email first lastname и др
    @Override
    public String getUsername() {
        return this.person.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
//получаем доступ к данным аутентифицированного пользователя
    public  Person getPerson(){
        return this.person;
    }
}
