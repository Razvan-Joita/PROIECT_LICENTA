package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NamedQuery;


@NamedQuery(name="Users.findByEmail", query = "SELECT user FROM Users user WHERE user.email = :email")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "users")
public class Users {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_Number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="status")
    private String status;

    @Column(name = "roles")
    private String roles;


}
