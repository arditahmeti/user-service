package org.springframework.userservice.model;

import lombok.Data;

import javax.persistence.*;

/**
 * User model
 *
 */
@Data
@Entity
@Table(name = "`StoreUsers`")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "`ID`")
    private Integer ID;
    @Column(name = "`FirstName`")
    private String firstName;
    @Column(name = "`LastName`")
    private String lastName;
    @Column(name = "`Email`", unique = true)
    private String email;
    @Column(name = "`Password`")
    private String password;
}
