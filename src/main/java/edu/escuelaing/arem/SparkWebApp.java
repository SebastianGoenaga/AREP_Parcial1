package edu.escuelaing.arem;

import static spark.Spark.*;

import spark.Request;
import spark.Response;

public class SparkWebApp {

    public static void main(String[] args) {
        port(getPort());
        get("/index", (req, res) -> "<!DOCTYPE html>"
                + "<html>"
                + "    <head>"
                + "        <title>App</title>"
                + "        <meta charset=UTF-8>"
                + "    </head>"
                + "    <body>"
                + "        <h2>Estadísticos</h2>"
                + "        <p>La siguiente aplicación web calcula el máximo, mínimo, sumatoria y multiplicatoria de un conjunto de números reales.<br /> Éstos se podrán ingresar en el siguiente campo, separándolos por un espacio</p>"
                + "        <form action=/resp>"
                + "            Conjunto de números:<br>"
                + "            <input type=text name=realNumber value= ><br><br>"
                + "            <input type=submit value=Calcular>"
                + "        </form>"
                + "    </body>"
                + "</html>");
        get("/resp", (req, res) -> result(req, res));

    }
    
    private static String result(Request req, Response res) {
        String numbers = req.queryParams("realNumber");
        App.calculate(numbers);
        String pageContent = "{ " + App.getNumbersList() + " , \"Maximo\" : " + "\"" + App.getMax() + "\"" + " , \"Minimo\" : " + "\"" + App.getMin() + "\"" + " , \"Sumatoria\" : " + "\"" + App.getSumatoria() + "\"" + " , \"Multiplicatoria\" : " + "\"" + App.getMultiplicatoria() + "\"" + " }";
        return pageContent;
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set

    }
}
