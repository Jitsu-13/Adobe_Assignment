package com.adobe.social_media.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor @Getter
@Setter
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;
    @Size(min = 1,max = 3000,message = "Max allowed characters are 300")
    @NotEmpty @NotBlank
    private String content;
    @Column(nullable = false, updatable = false)
    private Instant created_at;
    @Column(nullable = false)
    private Instant updated_at;
    private Integer likes;


}
