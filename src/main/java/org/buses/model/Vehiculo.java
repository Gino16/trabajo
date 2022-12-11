package org.buses.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Vehiculo {
  private String placa;
  private Integer numEjes;
  private Integer numAsientos;
  private Integer numNiveles;
  private List<Pasajero> pasajeros;
  private Servicio servicio;

  public Vehiculo() {
    this.pasajeros = new ArrayList<>();
  }

  public Vehiculo(String placa, Integer numEjes, Integer numAsientos, Integer numNiveles, Servicio servicio) {
    this.placa = placa;
    this.numEjes = numEjes;
    this.numAsientos = numAsientos;
    this.numNiveles = numNiveles;
    this.servicio = servicio;
    this.pasajeros = new ArrayList<>();
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public Integer getNumEjes() {
    return numEjes;
  }

  public void setNumEjes(Integer numEjes) {
    this.numEjes = numEjes;
  }

  public Integer getNumAsientos() {
    return numAsientos;
  }

  public void setNumAsientos(Integer numAsientos) {
    this.numAsientos = numAsientos;
  }

  public Integer getNumNiveles() {
    return numNiveles;
  }

  public void setNumNiveles(Integer numNiveles) {
    this.numNiveles = numNiveles;
  }

  public List<Pasajero> getPasajeros() {
    return pasajeros;
  }
  public void addPasajero(Pasajero pasajero) {
    this.pasajeros.add(pasajero);
  }

  public void removePasajero(Pasajero pasajero) {
    this.pasajeros.remove(pasajero);
  }

  public void setPasajeros(List<Pasajero> pasajeros) {
    this.pasajeros = pasajeros;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Vehiculo vehiculo = (Vehiculo) o;
    return placa.equals(vehiculo.placa);
  }

  @Override
  public int hashCode() {
    return Objects.hash(placa);
  }

  public Servicio getServicio() {
    return servicio;
  }

  public void setServicio(Servicio servicio) {
    this.servicio = servicio;
  }
}
