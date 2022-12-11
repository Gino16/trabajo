package org.buses;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.buses.controller.RutaController;
import org.buses.model.Ciudad;
import org.buses.model.Pasajero;
import org.buses.model.Ruta;
import org.buses.model.Servicio;
import org.buses.model.Vehiculo;

/**
 * Hello world!
 */
public class App {

  private static RutaController rutaController;

  public static void main(String[] args) {
    int opcionGeneral = 0;
    Scanner leer = new Scanner(System.in);
    rutaController = new RutaController();
    initRutas(rutaController);
    do {
      System.out.println("SELECCIONE UNA OPCION");
      System.out.println("0: Cerrar Programa");
      System.out.println("1: Entrar a Rutas");
      System.out.println("2: Entrar a Gestion de Pasajeros");
      System.out.println("3: Entrar a Gestion de Rutas");
      opcionGeneral = leer.nextInt();
      leer.nextLine();


      if (opcionGeneral > 0) {
        switch (opcionGeneral) {
          case 1:
            int menuRuta = 0;
            do {
              List<Ruta> rutas = rutaController.getRutas();
              int i = 1;
              System.out.println("Elija una ruta (Presione 0 para Salir):");
              for (Ruta ruta : rutas) {
                System.out.println(i + " De: " + ruta.getCiudadPartida().getNombre() + " A: "
                    + ruta.getCiudadDestino().getNombre() + " EN SERVICIO " + ruta.getVehiculo()
                    .getServicio().getNombre());
                i++;
              }
              menuRuta = leer.nextInt();
              leer.nextLine();

              if (menuRuta > 0) {

                int menuRutaElegida = 0;
                Ruta rutaElegida = rutas.get(menuRuta - 1);
                do {
                  System.out.println("ELIGA UNA OPCION: (Presione 0 para SALIR");
                  System.out.println("1: Listar pasajeros de ruta");
                  System.out.println("2: Agregar pasajero");
                  menuRutaElegida = leer.nextInt();
                  leer.nextLine();

                  switch (menuRutaElegida) {
                    case 1:
                      int indice = 1;
                      for (Pasajero pasajero: rutaElegida.getVehiculo().getPasajeros()) {
                        System.out.println(indice + ": " + pasajero.getNombre() + " - " + pasajero.getDni());
                      }
                      break;
                    case 2:
                      String dni = "";
                      System.out.println("DIGITE EL DNI DEL PASAJERO: ");
                      dni = leer.nextLine();
                      Pasajero pasajero = rutaController.searchPasajeroEnBus(dni, rutaElegida);
                      if (pasajero != null) {
                        System.out.println("PASAJERO YA ESTA REGISTRADO EN ESTA RUTA");
                        return;
                      }
                      pasajero = rutaController.searchPasajeroEnBD(dni);
                      if (pasajero == null) {
                        pasajero = new Pasajero();
                        System.out.println("Digite nombre del pasajero: ");
                        pasajero.setNombre(leer.nextLine());
                        pasajero.setDni(dni);
                      } else {
                        System.out.println(
                            "PASAJERO YA SE ENCUENTRA REGISTRADO EN EL SISTEMA, AGREGANDO A LA RUTA ELEGIDA");
                      }
                      rutaController.addPasajeroARuta(pasajero, rutaElegida);
                      break;
                  }

                } while (menuRutaElegida > 0);

              }

            } while (menuRuta > 0);

        }
      }

    } while (opcionGeneral > 0);
  }

  private static void initRutas(RutaController rutaController) {
    Ciudad ciudad1 = new Ciudad(1, "Chimbote");
    Ciudad ciudad2 = new Ciudad(2, "Lima");
    Ciudad ciudad3 = new Ciudad(3, "Chiclayo");
    Ciudad ciudad4 = new Ciudad(4, "Trujillo");
    Ciudad ciudad5 = new Ciudad(5, "Piura");
    rutaController.addCiudad(ciudad1);
    rutaController.addCiudad(ciudad2);
    rutaController.addCiudad(ciudad3);
    rutaController.addCiudad(ciudad4);
    rutaController.addCiudad(ciudad5);

    Servicio economico = new Servicio("economico");
    Servicio ejecutivo = new Servicio("ejecutivo");
    Servicio corporativo = new Servicio("corporativo");
    rutaController.addServicio(economico);
    rutaController.addServicio(ejecutivo);
    rutaController.addServicio(corporativo);

    Vehiculo v1 = new Vehiculo("123-XRF", 3, 30, 2, economico);
    Vehiculo v2 = new Vehiculo("123-LWS", 4, 35, 2, ejecutivo);
    Vehiculo v3 = new Vehiculo("142-WAS", 3, 15, 1, corporativo);

    rutaController.addRuta(
        new Ruta(parseDate("2023-01-11 11:00:00"), ciudad1, ciudad2, 50.00, 2, v1)
    );

    rutaController.addRuta(
        new Ruta(parseDate("2023-01-30 14:30:00"), ciudad3, ciudad3, 80.00, 2, v2)
    );

    rutaController.addRuta(
        new Ruta(parseDate("2023-02-16 20:00:00"), ciudad5, ciudad1, 180.00, 2, v3)
    );
  }

  private static Date parseDate(String date) {
    try {
      return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
    } catch (ParseException e) {
      return null;
    }
  }
}
