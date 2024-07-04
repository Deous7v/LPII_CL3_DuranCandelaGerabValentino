package com.example.demo.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Producto;
import com.example.demo.service.IProductoServicio;



import org.springframework.ui.Model;
@Controller
@RequestMapping("/vistas")
public class ProductoController {


	@Autowired
	private IProductoServicio iproductoservicio;


	@GetMapping("ListaProductos")
	public String ListadoProducto(Model modelo) {

	    List<Producto> listado = iproductoservicio.ListaProductos();
	    for (Producto lis : listado) {
	        System.out.println("codigo " + lis.getIDPRODUCTOCL3() + " " + " nombre " + lis.getNOMBRECL3());
	    }

	    modelo.addAttribute("listado", listado);
	    // Retornamos
	    return "/vistas/ListaProductos";
	} 


	@GetMapping("/RegistrarProducto")
	public String RegistrarProducto(Model modelo) {

		Producto producto = new Producto();

	    modelo.addAttribute("regproducto", producto);

	    return "/Vistas/RegistrarProducto";
	}


	@PostMapping("/GuardarProducto")
	public String GuardarProducto(@ModelAttribute Producto producto, Model modelo) {
	    iproductoservicio.RegistrarProducto(producto);
	    System.out.println("dato registrado en la bd");

	    return "redirect:/vistas/ListadoProducto";
	}


	@GetMapping("/editar/{id}")
	public String Editar(@PathVariable("id") Integer idproductocl3, Model modelo) {
		Producto producto = iproductoservicio.BuscarporId(idproductocl3);

	    modelo.addAttribute("regproducto", producto);

	    return "/Vistas/RegistrarProducto";
	} 

	//
	@GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Integer idProducto, Model modelo) {
        iproductoservicio.Eliminar(idProducto);
        System.out.println("dato Eliminado en la bd");
        return "redirect:/vistas/ListadoProducto";
    }
	
}