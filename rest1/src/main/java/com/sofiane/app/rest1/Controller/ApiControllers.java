package com.sofiane.app.rest1.Controller;
import com.sofiane.app.rest1.Models.Product;
import com.sofiane.app.rest1.Repo.ProRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private ProRepo proRepo;
    @GetMapping(value = "/")
    public String getpage(){
        return "welcome";
    }

    @GetMapping(value = "/products")
    public List<Product> getProduct(){
        return proRepo.findAll();
    }
    @PostMapping(value = "/save")
    public String savePro(@RequestBody Product product){
        proRepo.save(product);
        return "saved";
    }
    @PutMapping(value = "update/{id}")
    public String updatePro( @PathVariable long id , @RequestBody Product prodct ){
        Product upadtePro=proRepo.findById(id).get();
    upadtePro.setName(prodct.getName());
    upadtePro.setCategory(prodct.getCategory());
    proRepo.save(upadtePro);
    return "saved";
    }

    @DeleteMapping(value = "delete/{id}")
    public String deletePro( @PathVariable long id){
        Product deletePro=proRepo.findById(id).get();
        proRepo.save(deletePro);
        return "delete product with id"+id;
    }
}
