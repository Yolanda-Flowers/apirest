package com.yolacode.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yolacode.apirest.apirest.Entities.Producto;

public interface ProductRepository extends JpaRepository<Producto, Long> {
    

}
