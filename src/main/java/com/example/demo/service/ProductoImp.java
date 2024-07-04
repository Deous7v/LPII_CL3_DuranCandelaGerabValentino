package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Producto;
import com.example.demo.repositorio.IProductoRepositorio;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class ProductoImp implements IProductoServicio{
	//aplicamos la inyeccion de dependencia 
	@Autowired
	private IProductoRepositorio iproductorepository;

	@Override
	public List<Producto> ListaProductos() {
		// Devuelve Listado de Productos 
		return (List<Producto>)iproductorepository.findAll();
	}

	@Override
	public void RegistrarProducto(Producto producto) {
		// Registra Productos
		iproductorepository.save(producto);
		
	}

	@Override
	public Producto BuscarporId(Integer id) {
		// Buscar por cod
		return iproductorepository.findById(id).orElse(null);
	}

	@Override
	public void Eliminar(Integer id) {
		// Elimina por Cod
		iproductorepository.deleteById(id);	
		
	}


} //fin de la clase
