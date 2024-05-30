package kr.co.rland.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.rland.api.Repository.MemberRepository;
import kr.co.rland.api.Repository.MemberRoleRepository;
import kr.co.rland.api.entity.Member;
import kr.co.rland.api.entity.MemberRole;
import kr.co.rland.api.entity.MemberRoleId;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    
    @Autowired
    private MemberRepository repository;

    @Autowired
    private MemberRoleRepository memberRoleRepository;
    /*
     * api/members?email=newlec@....
     * api/member/2
     */

     // /api/members/email/newlec@newlecture.com
    @GetMapping("email/{email}")
    public ResponseEntity<Member> getByEmail(@PathVariable String email) {

        Member member = repository.findByEmail(email);

        if (member != null)
            return ResponseEntity.ok(member);

        // https://codingnomads.com/spring-responseentity
        return ResponseEntity.notFound().build();       
    }

    public List<MemberRole> getRolesById(Long memberId, Long roleId) {
        // MemberRoleId memberRoleId = MemberRoleId.builder()
        //                             .id(roleId)
        //                             .memberId(memberId)
        //                             .build();

        List<MemberRole> roles = memberRoleRepository.findAllByMemberId(memberId);
        
        return roles;
    }
}

