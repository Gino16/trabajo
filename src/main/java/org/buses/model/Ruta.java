package org.buses.model;

import java.util.Date;

public class Ruta {
  private Date fecha;
  private Ciudad ciudadPartida;
  private Ciudad ciudadDestino;
  private Double precio;
  private Vehiculo vehiculo;
  private Integer numConductores;

  public Ruta(Date fecha, Ciudad ciudadPartida, Ciudad ciudadDestino, Double precio, Integer numConductores,Vehiculo vehiculo) {
    this.fecha = fecha;
    this.ciudadPartida = ciudadPartida;
    this.ciudadDestino = ciudadDestino;
    this.precio = precio;
    this.numConductores = numConductores;
    this.vehiculo = vehiculo;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  public Ciudad getCiudadPartida() {
    return ciudadPartida;
  }

  public void setCiudadPartida(Ciudad ciudadPartida) {
    this.ciudadPartida = ciudadPartida;
  }

  public Ciudad getCiudadDestino() {
    return ciudadDestino;
  }

  public void setCiudadDestino(Ciudad ciudadDestino) {
    this.ciudadDestino = ciudadDestino;
  }

  public Vehiculo getVehiculo() {
    return vehiculo;
  }

  public void setVehiculo(Vehiculo vehiculo) {
    this.vehiculo = vehiculo;
  }

  public Integer getConductor() {
    return numConductores;
  }

  public void setConductor(Integer numConductores) {
    this.numConductores = numConductores;
  }

  public Double getPrecio() {
    return precio;
  }

  public void setPrecio(Double precio) {
    this.precio = precio;
  }
}
