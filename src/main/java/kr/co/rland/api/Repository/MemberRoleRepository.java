package kr.co.rland.api.Repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.rland.api.entity.MemberRole;
import kr.co.rland.api.entity.MemberRoleId;


public interface MemberRoleRepository extends JpaRepository<MemberRole, MemberRoleId>{

    List<MemberRole> findAllByMemberId(Long memberId);
    // List<MemberRole> findById(Long roleId, Long memberId);
}
