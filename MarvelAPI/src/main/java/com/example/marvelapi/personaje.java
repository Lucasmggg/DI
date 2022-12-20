package com.example.marvelapi;

public class personaje{
    private String nombre;
    private String description;
    private String imagen;

    public personaje(String nombre, String description, String imagen) {
        this.nombre = nombre;
        this.description = description;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
