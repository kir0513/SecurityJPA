package com.example.securityjpa.service;

import com.example.securityjpa.models.Person;
import com.example.securityjpa.repository.PeopleRepository;
import com.example.securityjpa.security.PersonDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    //
    private final PeopleRepository peopleRepository;

    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByUsername(s);
        if(person.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        } else {
            return new PersonDetails(person.get());
        }
    }
}
