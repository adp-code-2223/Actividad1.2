/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso;

import java.util.ArrayList;
import repaso.model.Piscina;
import repaso.persistencia.FilePersistencia;

/**
 *
 * @author maria
 */
public class MainVariosObjetos {

    private static final String PISCINAS_FILE = "piscinas.dat";

    public static void main(String[] args) {
        Piscina p1 = new Piscina(10, 20, 30, 40);
        Piscina p2 = new Piscina(15, 25, 35, 45);

        ArrayList<Piscina> piscinas = new ArrayList();

        piscinas.add(p1);
        piscinas.add(p2);

        FilePersistencia.writeList(piscinas, PISCINAS_FILE);

        piscinas = FilePersistencia.readList(PISCINAS_FILE);

        System.out.println("Se han recuperado: " + piscinas.toString());

    }

}
