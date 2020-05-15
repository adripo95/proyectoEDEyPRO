package objetos;

import java.sql.*;

public class GestionCine {

    public GestionCine() {
    }

    //metodo para añadir peliculas a la cartelera
    public void anadePelicula(int idPelicula, String nombre, String genero, int idSala,
            double precioEntrada, Time hora, String sinopsis) {
        try {
            // Conectamos con la base de datos cine
            Connection miConexion
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine",
                            "root", "");

            PreparedStatement sentencia
                    = miConexion.prepareStatement("INSERT INTO cartelera VALUES(?, ?, ?, 0, ?, ?, ?, ?)");

            sentencia.setInt(1, idPelicula);
            sentencia.setString(2, nombre.trim());
            sentencia.setString(3, genero.trim());
            sentencia.setInt(4, idSala);
            sentencia.setDouble(5, precioEntrada);
            sentencia.setTime(6, hora);
            sentencia.setString(7, sinopsis.trim());

            sentencia.executeUpdate();

            // Desconectamos de la base de datos cine
            miConexion.close();

        } catch (SQLException er) {
            System.out.println(er.getMessage());
        }
    }

    //borra una pelicula de la cartelera
    public void borraPelicula(int idPelicula) {
        try {
            // Conectamos con la base de datos cine
            Connection miConexion
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine",
                            "root", "");

            PreparedStatement sentencia
                    = miConexion.prepareStatement("DELETE FROM cartelera WHERE idPelicula = ?");

            sentencia.setInt(1, idPelicula);

            sentencia.executeUpdate();

            // Desconectamos de la base de datos cine
            miConexion.close();

        } catch (SQLException er) {
            System.out.println(er.getMessage());
        }
    }

    public void modificaPelicula(int idPelicula, String nombre, String genero, int idSala,
            double precioEntrada, Time hora, String sinopsis) {
        try {
            // Conectamos con la base de datos cine
            Connection miConexion
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine",
                            "root", "");

            PreparedStatement sentencia
                    = miConexion.prepareStatement("UPDATE cartelera SET nombre = ?,"
                            + " genero = ?, sala = ?, precio = ?, hora = ?,"
                            + " sinopsis = ? WHERE idPelicula = ? ");

            sentencia.setString(1, nombre.trim());
            sentencia.setString(2, genero.trim());
            sentencia.setInt(3, idSala);
            sentencia.setDouble(4, precioEntrada);
            sentencia.setTime(5, hora);
            sentencia.setString(6, sinopsis.trim());
            sentencia.setInt(7, idPelicula);

            sentencia.executeUpdate();

            // Desconectamos de la base de datos cine
            miConexion.close();

        } catch (SQLException er) {
            System.out.println(er.getMessage());
        }

    }

    public void compraEntrada(int idPelicula, int numEntradas) {
        try {
            int entradasCompradas = 0;
            // Conectamos con la base de datos cine
            Connection miConexion
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine",
                            "root", "");

            //recuperamos el numero de entradas vendidas que tiene la pelicula
            PreparedStatement sentenciaEntradas
                    = miConexion.prepareStatement("SELECT entradasVendidas FROM cartelera WHERE idPelicula = ?");

            sentenciaEntradas.setInt(1, idPelicula);

            ResultSet resultado = sentenciaEntradas.executeQuery();

            //si la pelicula existe y se puede recuperar el numero de entradas
            //se le suman las que le pasamos y se modifica en la BBDD
            if (resultado.next()) {
                entradasCompradas = resultado.getInt("entradasVendidas");

                entradasCompradas += numEntradas;

                PreparedStatement sentencia
                        = miConexion.prepareStatement("UPDATE CARTELERA SET entradasVendidas = ?");

                sentencia.setInt(1, entradasCompradas);

                sentencia.executeUpdate();
            }

            // Desconectamos de la base de datos cine
            miConexion.close();

        } catch (SQLException er) {
            System.out.println(er.getMessage());
        }
    }

}
