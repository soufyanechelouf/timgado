package com.sofiane.app.rest1.Repo;

import com.sofiane.app.rest1.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProRepo extends JpaRepository<Product,Long> {

}
