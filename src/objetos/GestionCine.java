package objetos;

import java.sql.*;

public class GestionCine {

    //constructor vacio
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
                            + " genero = ?, idSala = ?, precio = ?, hora = ?,"
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

    //metodo para ver todas las peliculas guardadas
    public String listadoPeliculas() {

        // creamos el string que almacena el listado de peliculas
        String listaPeliculas = "";

        try {

            // Conectamos con la base de datos cine
            Connection miConexion
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine",
                            "root", "");

            PreparedStatement sentencia
                    = miConexion.prepareStatement("SELECT * FROM cartelera");
            ResultSet resultado = sentencia.executeQuery();

            listaPeliculas += "Listado de peliculas disponibles:\n";

            ResultSet resultado2;

            while (resultado.next()) {
                //se realiza una segunda consulta para ver el aforo de la sala
                PreparedStatement sentencia2
                        = miConexion.prepareStatement("SELECT * FROM salas WHERE idSala = ?");

                sentencia2.setInt(1, resultado.getInt("idSala"));

                resultado2 = sentencia2.executeQuery();
                resultado2.next();

                listaPeliculas += "*********************************** \n";
                listaPeliculas += "ID pelicula: " + resultado.getInt("idPelicula") + "\n";
                listaPeliculas += "Titulo: " + resultado.getString("nombre") + "\n";
                listaPeliculas += "Genero: " + resultado.getString("genero") + "\n";
                listaPeliculas += "Entradas Vendidas: " + resultado.getInt("entradasVendidas") + "\n";
                listaPeliculas += "Entradas Totales: " + resultado2.getInt(2) + "\n";
                listaPeliculas += "Precio: " + resultado.getDouble("precio") + " euros\n";
                listaPeliculas += "Hora: " + resultado.getTime("Hora") + "\n";
                listaPeliculas += "Sinopsis: " + resultado.getString("sinopsis") + "\n";

            }

            // Desconectamos de la base de datos cine
            miConexion.close();

        } catch (SQLException er) {
            System.out.println(er.getMessage());
        }

        return listaPeliculas;

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

    //metodo para añadir salas a la tabla salas
    public void anadeSala(int idSala, int aforo, boolean tridimension, boolean dolbyAtmos) {
        try {
            // Conectamos con la base de datos cine
            Connection miConexion
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine",
                            "root", "");

            PreparedStatement sentencia
                    = miConexion.prepareStatement("INSERT INTO salas VALUES(?, ?, ?, ?)");

            sentencia.setInt(1, idSala);
            sentencia.setInt(2, aforo);
            sentencia.setBoolean(3, tridimension);
            sentencia.setBoolean(4, dolbyAtmos);

            sentencia.executeUpdate();

            // Desconectamos de la base de datos cine
            miConexion.close();

        } catch (SQLException er) {
            System.out.println(er.getMessage());
        }
    }

    //borra una sala de la lista, para ello no debera proyectarse ninguna pelicula en ella
    public void borraSala(int idSala) {
        try {
            // Conectamos con la base de datos cine
            Connection miConexion
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine",
                            "root", "");

            PreparedStatement sentencia
                    = miConexion.prepareStatement("DELETE FROM salas WHERE idSala = ?");

            sentencia.setInt(1, idSala);

            sentencia.executeUpdate();

            // Desconectamos de la base de datos cine
            miConexion.close();

        } catch (SQLException er) {
            System.out.println(er.getMessage());
        }
    }

    //metodo para modificar una sala
    public void modificaSala(int idSala, int aforo, boolean tridimension, boolean dolbyAtmos) {
        try {
            // Conectamos con la base de datos cine
            Connection miConexion
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine",
                            "root", "");

            PreparedStatement sentencia
                    = miConexion.prepareStatement("UPDATE salas SET aforo = ?,"
                            + " 3d = ?, dolbyAtmos = ? WHERE idSala = ? ");

            sentencia.setInt(1, aforo);
            sentencia.setBoolean(2, tridimension);
            sentencia.setBoolean(3, dolbyAtmos);
            sentencia.setInt(4, idSala);

            sentencia.executeUpdate();

            // Desconectamos de la base de datos cine
            miConexion.close();

        } catch (SQLException er) {
            System.out.println(er.getMessage());
        }

    }

    //metodo para ver todas las salas guardadas
    public String listadoSalas() {

        // creamos el string que almacena el listado de salas
        String listaSalas = "";

        try {

            // Conectamos con la base de datos cine
            Connection miConexion
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine",
                            "root", "");

            PreparedStatement sentencia
                    = miConexion.prepareStatement("SELECT * FROM salas");
            ResultSet resultado = sentencia.executeQuery();

            listaSalas += "Listado de salas disponibles:\n";

            while (resultado.next()) {

                listaSalas += "*********************************** \n";
                listaSalas += "Sala numero: " + resultado.getInt("idSala") + "\n";
                listaSalas += "Aforo: " + resultado.getInt("aforo") + "\n";
                listaSalas += "3D: " + resultado.getBoolean("3d") + "\n";
                listaSalas += "Dolby Atmos: " + resultado.getBoolean("dolbyAtmos") + "\n";

            }

            // Desconectamos de la base de datos cine
            miConexion.close();

        } catch (SQLException er) {
            System.out.println(er.getMessage());
        }

        return listaSalas;

    }

    //metodo para añadir salas a la tabla cafeteria
    public void anadeBar(int idProducto, String nombre, int stock, double precio) {
        try {
            // Conectamos con la base de datos cine
            Connection miConexion
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine",
                            "root", "");

            PreparedStatement sentencia
                    = miConexion.prepareStatement("INSERT INTO cafeteria VALUES(?, ?, ?, ?)");

            sentencia.setInt(1, idProducto);
            sentencia.setString(2, nombre);
            sentencia.setInt(3, stock);
            sentencia.setDouble(4, precio);

            sentencia.executeUpdate();

            // Desconectamos de la base de datos cine
            miConexion.close();

        } catch (SQLException er) {
            System.out.println(er.getMessage());
        }
    }

    //borra un item de la cafeteria
    public void borraBar(int idProducto) {
        try {
            // Conectamos con la base de datos cine
            Connection miConexion
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine",
                            "root", "");

            PreparedStatement sentencia
                    = miConexion.prepareStatement("DELETE FROM cafeteria WHERE idProducto = ?");

            sentencia.setInt(1, idProducto);

            sentencia.executeUpdate();

            // Desconectamos de la base de datos cine
            miConexion.close();

        } catch (SQLException er) {
            System.out.println(er.getMessage());
        }
    }

    //metodo para modificar un producto de la cafeteria
    public void modificaBar(int idProducto, String nombre, int stock, double precio) {
        try {
            // Conectamos con la base de datos cine
            Connection miConexion
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine",
                            "root", "");

            PreparedStatement sentencia
                    = miConexion.prepareStatement("UPDATE cafeteria SET nombre = ?,"
                            + " stock = ?, precio = ? WHERE idProducto = ? ");

            sentencia.setString(1, nombre);
            sentencia.setInt(2, stock);
            sentencia.setDouble(3, precio);
            sentencia.setInt(4, idProducto);

            sentencia.executeUpdate();

            // Desconectamos de la base de datos cine
            miConexion.close();

        } catch (SQLException er) {
            System.out.println(er.getMessage());
        }

    }
    
    //metodo para ver todas las salas guardadas
    public String listadoBar() {

        // creamos el string que almacena el listado de salas
        String listaCafeteria = "";

        try {

            // Conectamos con la base de datos cine
            Connection miConexion
                    = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine",
                            "root", "");

            PreparedStatement sentencia
                    = miConexion.prepareStatement("SELECT * FROM cafeteria");
            ResultSet resultado = sentencia.executeQuery();

            listaCafeteria += "Listado de productos disponibles:\n";

            while (resultado.next()) {

                listaCafeteria += "*********************************** \n";
                listaCafeteria += "Producto numero: " + resultado.getInt("idProducto") + "\n";
                listaCafeteria += "Nombre: " + resultado.getString("nombre") + "\n";
                listaCafeteria += "Stock: " + resultado.getInt("stock") + "\n";
                listaCafeteria += "Precio: " + resultado.getDouble("precio") + " euros\n";

            }

            // Desconectamos de la base de datos cine
            miConexion.close();

        } catch (SQLException er) {
            System.out.println(er.getMessage());
        }

        return listaCafeteria;

    }
}
