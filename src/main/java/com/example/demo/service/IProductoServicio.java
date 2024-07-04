package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Producto;



public interface IProductoServicio {
	
	public List<Producto>ListaProductos();
	public void RegistrarProducto(Producto producto);	
	public Producto BuscarporId(Integer id);
	public void Eliminar(Integer id);

}