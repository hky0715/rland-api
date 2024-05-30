package kr.co.rland.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.rland.api.entity.Member;


public interface MemberRepository extends JpaRepository<Member, Long>{
    Member findByEmail(String email);
    
}
