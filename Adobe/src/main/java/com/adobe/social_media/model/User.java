package com.adobe.social_media.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer id;
    @Size(min = 1,max = 50,message = "Name should can 1-50 characters")
    @NotEmpty @NotBlank
    private String name;
    @NotEmpty @NotBlank
    @Email(message = "Please enter correct email id")
    private String email;
    @Size(max = 200,message = "Bio should be less than 200 characters")
    private String bio;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<Post> posts;
}