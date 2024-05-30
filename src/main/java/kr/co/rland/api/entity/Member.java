package kr.co.rland.api.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
    @Id
    private Long id;
    private String username;
    private String pwd;
    private String email;
    private Date regDate;
    
    @OneToMany
    private List<MemberRole> roles;
}
