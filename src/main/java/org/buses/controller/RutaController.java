package org.buses.controller;

import java.util.ArrayList;
import java.util.List;
import org.buses.model.Ciudad;
import org.buses.model.Pasajero;
import org.buses.model.Ruta;
import org.buses.model.Servicio;
import org.buses.model.Vehiculo;

public class RutaController {

  private List<Ruta> rutas;
  private List<Vehiculo> vehiculos;
  private List<Pasajero> pasajeros;
  private List<Servicio> servicios;

  private List<Ciudad> ciudades;

  public RutaController() {
    this.initData();
  }

  private void initData() {
    rutas = new ArrayList<>();
    vehiculos = new ArrayList<>();
    pasajeros = new ArrayList<>();
    servicios = new ArrayList<>();
    ciudades = new ArrayList<>();
  }

  public void addRuta(Ruta ruta) {
    this.rutas.add(ruta);
  }

  public void addPasajeroABD(Pasajero pasajero) {
    this.pasajeros.add(pasajero);
  }

  public Pasajero searchPasajeroEnBD(String dni) {
    return pasajeros.stream().filter(pasajero -> pasajero.getDni().equals(dni)).findFirst()
        .orElse(null);
  }

  public Pasajero searchPasajeroEnBus(String dni, Ruta ruta) {
    return ruta.getVehiculo().getPasajeros().stream()
        .filter(pasajero -> pasajero.getDni().equals(dni)).findFirst().orElse(null);
  }

  public void removePasajeroDeRuta(Pasajero pasajero, Ruta ruta) {
    ruta.getVehiculo().removePasajero(pasajero);
  }

  public void addPasajeroARuta(Pasajero pasajero, Ruta ruta) {
    ruta.getVehiculo().addPasajero(pasajero);
  }

  public void addCiudad(Ciudad ciudad) {
    this.ciudades.add(ciudad);
  }

  public void addServicio(Servicio servicio) {
    this.servicios.add(servicio);
  }

  public Ruta searchRuta(String ciudadOrigen, String ciudadDestino) {
    return rutas.stream().filter(
            ruta -> ruta.getCiudadPartida().getNombre().equals(ciudadOrigen) && ruta.getCiudadDestino()
                .getNombre().equals(ciudadDestino))
        .findFirst()
        .orElse(null);
  }

  public List<Ruta> getRutas() {
    return rutas;
  }

  public List<Vehiculo> getVehiculos() {
    return vehiculos;
  }

  public List<Pasajero> getPasajeros() {
    return pasajeros;
  }

  public List<Servicio> getServicios() {
    return servicios;
  }

  public List<Ciudad> getCiudades() {
    return ciudades;
  }
}
