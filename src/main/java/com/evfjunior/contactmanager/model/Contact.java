package com.evfjunior.contactmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor
@Setter
public class Contact {
    // Fields
    @Id
    private String id;

    private String email;
    private String firstName;
    private String lastName;
    private String phone;
}
