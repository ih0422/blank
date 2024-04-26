package com.ih.blank.user.model;

import com.ih.blank.user.model.enums.SocialType;
import com.ih.blank.user.model.enums.UserRoleType;
import com.ih.blank.user.model.enums.UserStatusType;
import com.ih.blank.utils.HashingUtil;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @CreationTimestamp
    @Column(name = "join_date", nullable = false)
    private LocalDate joinDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private UserStatusType status = UserStatusType.ACTIVE;

    @Enumerated(EnumType.STRING)
    @Column(name = "social")
    private SocialType social;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private UserRoleType role = UserRoleType.STANDARD;

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    public boolean isSamePassword(String password) {
        return hashPassword(password).equals(this.password);
    }

    private String hashPassword(String password) {
        return HashingUtil.sha256(password);
    }
}
