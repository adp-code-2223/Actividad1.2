/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reservasService;

import repasojava.model.Piscina;
import repasojava.util.DuplicateDNIException;

/**
 *
 * @author mfernandez
 */
public class BookingManager {

    public static final int MAX_FRANJAS = 6;
    public static final int MIN_FRANJAS = 1;

    private Piscina piscina;

    private String[][] reservasPorFranja;

    public BookingManager(Piscina piscina) {
        this.piscina = piscina;
        this.reservasPorFranja = new String[MAX_FRANJAS][piscina.getAforo()];
    }

    public boolean isDisponible(int franja) {
        boolean vacio = false;
        for (int i = 0; !vacio && i < this.reservasPorFranja[franja - 1].length; i++) {
            if (reservasPorFranja[franja - 1][i] == null) {
                vacio = true;
            }
        }
        return vacio;
    }

    public boolean reservar(int franja, String dni) throws DuplicateDNIException {
        boolean reservado = false;
        
        if(existeDni(dni))
            throw new DuplicateDNIException("DNI duplicado", dni);
        
        int index = getIndexLibre(franja);
        if (index > -1 && index <= reservasPorFranja[franja-1].length) {
            reservasPorFranja[franja-1][index] = dni;
            reservado = true;
        }
        return reservado;
    }
/***
 * 
 * @param franja: Número introducido por el usuario entre [MIN_FRANJAS, MAX_FRANJAS]
 * @return 
 */
    private int getIndexLibre(int franja) {
        int libre = -1;
        for (int i = 0; (libre == -1) && i < this.reservasPorFranja[franja - 1].length; i++) {
            if (reservasPorFranja[franja - 1][i] == null) {
                libre = i;
            }
        }
        return libre;
    }

    private boolean existeDni(String dni) {
        boolean encontrado = false;
        for (int i = 0; (!encontrado) && i < reservasPorFranja[MIN_FRANJAS-1].length; i++) {
            for (int j = 0; (!encontrado) && j < reservasPorFranja[i].length; j++) {
                if ((reservasPorFranja[i][j] != null)
                        && (reservasPorFranja[i][j].compareToIgnoreCase(dni) == 0)) {
                    encontrado = true;
                }
            }
        }
        return encontrado;

    }

}
