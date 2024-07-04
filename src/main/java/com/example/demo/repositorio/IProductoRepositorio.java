package com.example.demo.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Producto;




public interface IProductoRepositorio extends CrudRepository<Producto,Integer>{
		
}
