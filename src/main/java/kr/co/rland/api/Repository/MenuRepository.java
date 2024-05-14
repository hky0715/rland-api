package kr.co.rland.api.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.rland.api.entity.Menu;


/* JPA를 사용하려면 JPARepository를 상속해야함!!!!! 
 * interface가 interface를 상속받을 수 있지!!!!! 빚을 떠안자! 
 * JPARepository가 정의해놓은 것을 그대로 써야한다! 
 * 
 * 
 * 얘는 @Mapper 이렇게 안해도 ioc에 자동으로 담긴대! 미쳤나?? 어케 되지??????*/
public interface MenuRepository extends JpaRepository<Menu, Long> {
    // List<Menu> findByEngNameLike(String engName);
    Page<Menu> findByEngNameLike(String engName, Pageable pageable);
}
