package kr.co.rland.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(MemberRoleId.class)
public class MemberRole {
    @Id
    private Long id;
    @Id
    private Long memberId;
    private String roleName;
}
