package kr.co.rland.api.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.rland.api.Repository.MenuRepository;
import kr.co.rland.api.entity.Menu;

@RestController
@RequestMapping("menus")
public class MenuController {
    
    /* api의 업무로직은 어디에 있을까? api는 업무를 갖고있는게 아님. api는 그냥 정보를 던져줄뿐! 
       즉, 로직은 client에 있음. 사용자의 행위를 담당하는 부분에서 로직을 담당해야함!
       로직이 너무 복잡하다면 backend 쓰세용..
    */
    @Autowired
    private MenuRepository repository;
    
    @GetMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public List<Menu> list(@RequestParam(name = "p", required = false, defaultValue = "0") Integer page  // null을 담아야하니까 Integer 써야함
                        , @RequestParam(name = "s", required = false, defaultValue = "6") Integer size) {

        
        Pageable pageable = PageRequest.of(page, size, Sort.by("engName").descending().and(Sort.by("regDate").descending()));       // 페이징을 할 수 있는 객체를 만들어서! regDate는 entity의 속성인가?
        
        Page<Menu> menuPage = repository.findAll(pageable);                                     // pageable객체의 사이즈만큼만 들어있는 메뉴 페이지를 반환받아서
        List<Menu> list = menuPage.getContent();                                                // 메뉴 페이지의 컨텐츠를 리스트에 넣어!
        

        // Page<Menu> menuPage = repository.findByEngNameLike("%a%", pageable);
        // List<Menu> list = menuPage.getContent();      

        return list;
    }

    // menus/2
    @GetMapping("{id}")
    public Optional<Menu> item(@PathVariable Long id) {
        Optional<Menu> menu = repository.findById(id);
        return menu;
    }
    

    @PutMapping
    public String save() {
        return "";
    }
}


