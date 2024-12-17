package com.example.backend.entities;

import com.example.backend.enums.TableColNames;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = TableColNames.USER_TABLE)
public class User extends BaseEntity {
    @Column(name = TableColNames.USER_USERNAME, unique = true, nullable = false)
    private String username;

    @Column(name = TableColNames.USER_PASSWORD)
    private String password;

    @Column(name = TableColNames.USER_EMAIL, unique = true, nullable = false)
    private String email;

    @Column(name = TableColNames.USER_FNAME)
    private String fName;

    @Column(name = TableColNames.USER_LNAME)
    private String lName;

    @Column(name = TableColNames.USER_GENDER, nullable = false)
    private boolean gender;

    @Column(name = TableColNames.USER_BIRTHDATE)
    private Date birthDate;

    @Column(name = TableColNames.USER_PICTUREURL)
    private String pictureURL;

    @Column(name = TableColNames.USER_RESET_PASSWORD_OTP)
    private String resetPasswordOtp;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Post> posts;

    @ManyToMany
    @JoinTable(
            name = TableColNames.USER_INTEREST_TABLE,
            joinColumns = @JoinColumn(name = TableColNames.USER_INTEREST_USER_ID),
            inverseJoinColumns = @JoinColumn(name = TableColNames.USER_INTEREST_TOPIC_ID)
    )
    private List<PostType> postTypes;

    @ManyToMany
    @JoinTable(
            name = TableColNames.FOLLOWS_TABLE,
            joinColumns = @JoinColumn(name = TableColNames.FOLLOWS_FOLLOWER_ID),
            inverseJoinColumns = @JoinColumn(name = TableColNames.FOLLOWS_FOLLOWING_ID)
    )
    private List<User> following;

    @ManyToMany(mappedBy = "following")
    @JsonIgnore
    private List<User> followers;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Like> likes;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Repost> reposts;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<ReportPost> reportPosts;

    @OneToMany(mappedBy = "reporter")
    @JsonManagedReference
    private List<ReportUser> reporters;

    @OneToMany(mappedBy = "reported")
    @JsonManagedReference
    private List<ReportUser> reported;

    public User(long id) {
        super(id);
    }

}

    
