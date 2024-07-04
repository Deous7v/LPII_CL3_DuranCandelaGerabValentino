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



@Controller
@RequestMapping("/vistas")
public class ProductosController {

	
	//inyeccion de dependencia...

			@Autowired

			private IProductoServicio iproductoservicio;


			@GetMapping("/ListaProductos")

			public String ListaProductos(Model modelo) {



				List<Producto> listado=iproductoservicio.ListaProductos();

				for(Producto lis:listado) {

			System.out.println("CODIGO "+lis.getIdProducto()+" "+
								" NOMBRE "+lis.getNombre()+" "+
								" PRECIO VENTA "+lis.getPrecioComp()+" "+
								" STOCK "+lis.getStock()+" "+
								" PRECIO COMPRA "+lis.getPrecioComp()+" "+
								" ESTADO "+lis.getEstado()+" "+
								" DESCRIPCION "+lis.getDescrip()
								);

				}

				//enviamos la data hacia la vista..

				modelo.addAttribute("listado",listado);

				//retornamos

				return "/vistas/ListaProductos";

				

			}  //fin del metodo listado...
			
			
			//creamos los respectivos para metodos para registrar...

			@GetMapping("/RegistrarProducto")

			public String RegistrarProducto(Model modelo) {

				//realizamos la respectiva instancia...

				Producto producto=new Producto();

				//enviamos a la vista...

				modelo.addAttribute("regproducto",producto);

				//retornamos

				return "/vistas/RegistrarProducto";

			}  //fin del metodo registrar.
			
			
			
			//realizamos el mapeo con postmapping

			@PostMapping("/GuardarProducto")

			public String GuardarProducto(@ModelAttribute Producto  producto,Model modelo) {

				iproductoservicio.RegistrarProducto(producto);

				System.out.println("Producto registrado en la base de datos");

				//retornamos al listado...

				return "redirect:/vistas/ListadoProductos";

			}  //fin del metodo string...
			
			//*****************crearmos el metodo editar...

			@GetMapping("/editar/{id}")

			public String Editar(@PathVariable("id") Integer IDPRODUCTOCL3,Model modelo) {

				Producto producto=iproductoservicio.BuscarporId(IDPRODUCTOCL3);

				//enviamos hacia la vista...

				modelo.addAttribute("regproducto",producto);

				//retornamos el frmcrearcliente...

				return "/vistas/RegistrarProducto";


			}  //fin del metodo editar...
			
			@GetMapping("/eliminar/{id}")
		    public String eliminar(@PathVariable("id") Integer idProducto, Model modelo) {
		        iproductoservicio.Eliminar(idProducto);
		        return "redirect:/vistas/ListadoProductos";
		    }
	
	
	}//fin del metodo 
	
