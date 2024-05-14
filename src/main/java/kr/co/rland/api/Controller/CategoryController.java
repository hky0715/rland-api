package kr.co.rland.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.rland.api.entity.Category;

@RestController
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    private ListCrudRepository<Category, Long> repository;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public List<Category> list() {
        System.out.println(repository.findAll());
        return repository.findAll();
    }
    
}
