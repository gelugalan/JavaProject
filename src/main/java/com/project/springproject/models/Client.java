package com.project.springproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="client",schema="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true,length = 40)
    private String email;
    @Column(nullable = false,length = 64)
    private String password;
    @Column(nullable = false,length = 20)
    private String firstName;
    @Column(nullable = false,length = 20)
    private String lastName;


    public int compareTo(Client u) {
        if (getFirstName() == null || u.getFirstName() == null) {
            return 0;
        }
        return getFirstName().compareTo(u.getFirstName());
    }
}
