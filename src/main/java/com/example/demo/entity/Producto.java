package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idProducto;
    private String nombre;
    private double precioVenta;
    private int stock;
    private double precioComp;
    private String estado;
    private String descrip;

    // Getters y Setters

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioComp() {
        return precioComp;
    }

    public void setPrecioComp(double precioComp) {
        this.precioComp = precioComp;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    @Override
    public String toString() {
        return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", precioVenta=" + precioVenta + ", stock=" + stock 
                + ", precioComp=" + precioComp + ", estado=" + estado + ", descrip=" + descrip + "]";
    }
}