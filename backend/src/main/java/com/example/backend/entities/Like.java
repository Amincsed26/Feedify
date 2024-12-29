package com.example.backend.entities;

import com.example.backend.enums.TableColNames;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
@Table(name = TableColNames.LIKE_TABLE)
public class Like extends BaseEntity {
    @Column(name = TableColNames.LIKE_DATE)
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = TableColNames.LIKE_USER_ID, nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = TableColNames.LIKE_POST_ID, nullable = false)
    private Post post;

    @PrePersist
    public void prePersist() {
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }
}
