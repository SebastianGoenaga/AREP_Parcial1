/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem;

/**
 *
 * @author Sebastian Goenaga
 */
import java.io.*;
import java.net.*;

public class Client {
	
	
	/**
	 * Para probar directamente desde la aplicacion en Heroku usar la URL
	 * 
	 * https://desolate-beyond-92495.herokuapp.com/index
	 * 
	 * @param args
	 * @throws Exception
	 */

    public static void main(String[] args) throws Exception {
        URL heroku = new URL("https://desolate-beyond-92495.herokuapp.com/resp?realNumber=45%2C45%2C4%2C4%2C4%2C5%2C5%2C4%2C5%2C5");
        try (BufferedReader reader
                = new BufferedReader(new InputStreamReader(heroku.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }

}