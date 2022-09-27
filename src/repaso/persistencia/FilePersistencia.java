/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso.persistencia;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import repaso.model.Piscina;

/**
 *
 * @author mfernandez
 */
public class FilePersistencia {

    public static void write(Piscina piscina, String ruta) {

        try (
                 FileOutputStream fos = new FileOutputStream(ruta); 
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(piscina);
        } catch (FileNotFoundException ex) {
            System.err.println("Ha ocurrido una excepción" + ex);
        } catch (IOException ex) {
            System.err.println("Ha ocurrido una excepción" + ex);
        }

    }

}
