package com.example.tienda.recyclerview;

public class MuestraProducto {
    private String nombre;
    private String imagen;
    private float precio;
    private boolean existencia;

    private MuestraProducto()//se agrega un constructor vacio para que funcione bien con firestore, si no no funciona
    {

    }
    public MuestraProducto(String nombre, String imagen,float precio, boolean existencia) {
        this.nombre=nombre;
        this.imagen = imagen;
        this.precio=precio;
        this.existencia=existencia;

    }

    public String getImagen() {
        return imagen;
    }
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    public float getPrecio() {return precio; }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public boolean isExistencia() {
        return existencia;
    }
    public void setExistencia(boolean existencia) {
            this.existencia = existencia;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
