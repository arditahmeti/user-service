package org.springframework.userservice.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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
    @NotBlank
    @Column(name = "`FirstName`")
    private String firstName;
    @NotBlank
    @Column(name = "`LastName`")
    private String lastName;
    @NotBlank
    @Email
    @Column(name = "`Email`", unique = true)
    private String email;
    @NotBlank
    @Column(name = "`Password`")
    private String password;
}
