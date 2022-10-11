/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repaso.persistencia;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import repaso.model.Piscina;

/**
 *
 * @author mfernandez
 */
public class FilePersistencia {

    public static void write(Piscina piscina, String ruta) {

        try (
                 FileOutputStream fos = new FileOutputStream(ruta);  ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(piscina);
        } catch (FileNotFoundException ex) {
            System.err.println("Ha ocurrido una excepción" + ex);
        } catch (IOException ex) {
            System.err.println("Ha ocurrido una excepción" + ex);
        }

    }

    public static Piscina read(String ruta) {
        Piscina piscina = null;

        try (
                 FileInputStream fis = new FileInputStream(ruta);  ObjectInputStream ois = new ObjectInputStream(fis);) {

            Object object = ois.readObject();
            if (object instanceof Piscina) {
                piscina = (Piscina) object;
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción: " + ex.getMessage());
        }

        return piscina;
    }

    public static void writeList(ArrayList<Piscina> piscinas,
            String ruta) {

        try (
                 FileOutputStream fos = new FileOutputStream(ruta);  ObjectOutputStream oos = new ObjectOutputStream(fos);) {

            for (Piscina piscina : piscinas) {
                oos.writeObject(piscina);
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Ha ocurrido una excepción" + ex);
        } catch (IOException ex) {
            System.err.println("Ha ocurrido una excepción" + ex);
        }

    }

    public static ArrayList<Piscina> readList(String ruta) {
        Piscina piscina = null;
        ArrayList<Piscina> piscinas = new ArrayList();
        Object object = null;
        boolean eof = false;

        try (
                 FileInputStream fis = new FileInputStream(ruta);  ObjectInputStream ois = new ObjectInputStream(fis);) {

            while (true) {
                try {
                    object = ois.readObject();

                    if (object instanceof Piscina) {
                        piscina = (Piscina) object;
                        piscinas.add(piscina);
                    }
                } catch (EOFException ex) {
                    eof = true;
                    //ex.printStackTrace();
                    System.err.println("Se ha alcanzado el final del fichero: " + ex.getMessage());
                }
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción: " + ex.getMessage());

        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción: " + ex.getMessage());
        }

        return piscinas;
    }

    public static ArrayList<Piscina> readList2(String ruta) {
        Piscina piscina = null;
        ArrayList<Piscina> piscinas = new ArrayList();
        Object object = null;
       // boolean eof = false;

        try (
                 FileInputStream fis = new FileInputStream(ruta);  ObjectInputStream ois = new ObjectInputStream(fis);) {

            while (  (object = ois.readObject())!=null) {
               

                if (object instanceof Piscina) {
                    piscina = (Piscina) object;
                    piscinas.add(piscina);
                }

            }
        } catch (EOFException ex) {
            //eof = true;
            //ex.printStackTrace();
            System.err.println("Se ha alcanzado el final del fichero: " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción: " + ex.getMessage());

        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.err.println("Ha ocurrido una excepción: " + ex.getMessage());
        }

        return piscinas;
    }
}
