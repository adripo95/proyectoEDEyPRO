package objetos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

public class InterfazCine extends JFrame implements ActionListener {

    //creamos la clase de gestion
    GestionCine gestor = new GestionCine();

    //componentes de la ventana principal
    JPanel panelPrinci;
    JLabel infoPrinci;
    JButton gestionPrinciB;
    JButton cajaPrinciB;
    JButton salirPrinciB;

    //componentes del frame del modo gestion
    JFrame frameGestion;
    JPanel panelGestion;
    JButton gestionCartB;
    JButton gestionSalaB;
    JButton gestionBarB;
    JButton gestionSalB;

    //componentes del frame de gestion de cartelera
    JFrame frameCartelera;
    JPanel panelCartelera;
    JScrollPane panelScrollCartelera;
    JButton carteleraAnadeB;
    JButton carteleraEliminaB;
    JButton carteleraModificaB;
    JButton carteleraAtualizaListaB;
    JButton carteleraSalirB;
    JTextArea carteleraListaArea;

    //componentes del frame de gestion de salas
    JFrame frameSalas;
    JPanel panelSalas;
    JScrollPane panelScrollSalas;
    JButton salasAnadeB;
    JButton salasEliminaB;
    JButton salasModificaB;
    JButton salasAtualizaListaB;
    JButton salasSalirB;
    JTextArea salasListaArea;

    //componentes del frame de gestion de la cafeteria
    JFrame frameBar;
    JPanel panelBar;
    JScrollPane panelScrollBar;
    JButton barAnadeB;
    JButton barEliminaB;
    JButton barModificaB;
    JButton barAtualizaListaB;
    JButton barSalirB;
    JTextArea barListaArea;

    //frame añadir peliculas a cartelera
    JFrame frameAnadeCartelera;
    JPanel panelAnadeCartelera;
    JLabel idPeliculaAnadeCarteleraL;
    JTextField idPeliculaAnadeCarteleraT;
    JLabel nombreAnadeCarteleraL;
    JTextField nombreAnadeCarteleraT;
    JLabel generoAnadeCarteleraL;
    JTextField generoAnadeCarteleraT;
    JLabel idSalaAnadeCarteleraL;
    JTextField idSalaAnadeCarteleraT;
    JLabel precioAnadeCarteleraL;
    JTextField precioAnadeCarteleraT;
    JLabel horaAnadeCarteleraL;
    JComboBox horaAnadeCarteleraT;
    JComboBox minutoAnadeCarteleraT;
    JLabel sinopsisAnadeCarteleraL;
    JTextArea sinopsisAnadeCarteleraT;
    JButton anadeAnadeCarteleraB;
    JButton salirAnadeCarteleraB;
    String[] horas = {"00", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
        "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
    String[] minutos = {"00", "10", "20", "30", "40", "50"};
    
    //frame borrar peliculas de la cartelera
    JFrame frameBorraCartelera;
    JPanel panelBorraCartelera;
    JLabel idPeliculaBorraCarteleraL;
    JTextField idPeliculaBorraCarteleraT;
    JButton borraBorraCarteleraB;
    JButton salirBorraCarteleraB;

    //contructor de la interfaz
    public InterfazCine() {

        //setup basico
        this.setTitle("Gestionador de Cine");
        this.setSize(400, 200);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        panelPrinci = new JPanel();
        panelPrinci.setLayout(null);

        //componentes setup principal
        infoPrinci = new JLabel("Seleccione gestion o caja: ");
        infoPrinci.setBounds(120, 10, 190, 30);
        panelPrinci.add(infoPrinci);

        //botones setup principal
        gestionPrinciB = new JButton("Modo Gestion");
        gestionPrinciB.setBounds(50, 70, 120, 30);
        panelPrinci.add(gestionPrinciB);

        cajaPrinciB = new JButton("Modo Caja");
        cajaPrinciB.setBounds(230, 70, 120, 30);
        panelPrinci.add(cajaPrinciB);

        salirPrinciB = new JButton("Salir");
        salirPrinciB.setBounds(140, 130, 120, 30);
        panelPrinci.add(salirPrinciB);

        //setup frame gestion
        frameGestion = new JFrame("Modo Gestion");
        frameGestion.setSize(200, 300);
        frameGestion.setResizable(false);
        frameGestion.setLocationRelativeTo(null);
        frameGestion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelGestion = new JPanel();
        panelGestion.setLayout(null);

        //botones frame de gestion
        gestionCartB = new JButton("Gestion Cartelera");
        gestionCartB.setBounds(30, 20, 140, 35);
        panelGestion.add(gestionCartB);

        gestionSalaB = new JButton("Gestion Salas");
        gestionSalaB.setBounds(30, 80, 140, 35);
        panelGestion.add(gestionSalaB);

        gestionBarB = new JButton("Gestion Bar");
        gestionBarB.setBounds(30, 140, 140, 35);
        panelGestion.add(gestionBarB);

        gestionSalB = new JButton("Salir");
        gestionSalB.setBounds(30, 200, 140, 35);
        panelGestion.add(gestionSalB);

        //setup frame cartelera
        frameCartelera = new JFrame("Gestion Cartelera");
        frameCartelera.setSize(500, 400);
        frameCartelera.setResizable(false);
        frameCartelera.setLocationRelativeTo(null);
        frameCartelera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelCartelera = new JPanel();
        panelCartelera.setLayout(null);

        //componentes frame cartelera
        carteleraListaArea = new JTextArea();
        panelScrollCartelera = new JScrollPane(carteleraListaArea);
        panelScrollCartelera.setBounds(200, 30, 270, 325);
        carteleraListaArea.setBounds(200, 30, 270, 325);
        panelCartelera.add(panelScrollCartelera);

        //botones frame cartelera
        carteleraAnadeB = new JButton("Añadir Pelicula");
        carteleraAnadeB.setBounds(30, 30, 140, 30);
        panelCartelera.add(carteleraAnadeB);

        carteleraEliminaB = new JButton("Elimina Pelicula");
        carteleraEliminaB.setBounds(30, 100, 140, 30);
        panelCartelera.add(carteleraEliminaB);

        carteleraModificaB = new JButton("Modifica Pelicula");
        carteleraModificaB.setBounds(30, 170, 140, 30);
        panelCartelera.add(carteleraModificaB);

        carteleraAtualizaListaB = new JButton("Actualiza Listado");
        carteleraAtualizaListaB.setBounds(30, 240, 140, 30);
        panelCartelera.add(carteleraAtualizaListaB);

        carteleraSalirB = new JButton("Salir");
        carteleraSalirB.setBounds(30, 310, 140, 30);
        panelCartelera.add(carteleraSalirB);

        //setup frame salas
        frameSalas = new JFrame("Gestion Salas");
        frameSalas.setSize(500, 400);
        frameSalas.setResizable(false);
        frameSalas.setLocationRelativeTo(null);
        frameSalas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelSalas = new JPanel();
        panelSalas.setLayout(null);

        //componentes frame salas
        salasListaArea = new JTextArea();
        panelScrollSalas = new JScrollPane(salasListaArea);
        panelScrollSalas.setBounds(200, 30, 270, 325);
        salasListaArea.setBounds(200, 30, 270, 325);
        panelSalas.add(panelScrollSalas);

        //botones frame salas
        salasAnadeB = new JButton("Añadir Sala");
        salasAnadeB.setBounds(30, 30, 140, 30);
        panelSalas.add(salasAnadeB);

        salasEliminaB = new JButton("Elimina Sala");
        salasEliminaB.setBounds(30, 100, 140, 30);
        panelSalas.add(salasEliminaB);

        salasModificaB = new JButton("Modifica Sala");
        salasModificaB.setBounds(30, 170, 140, 30);
        panelSalas.add(salasModificaB);

        salasAtualizaListaB = new JButton("Actualiza Listado");
        salasAtualizaListaB.setBounds(30, 240, 140, 30);
        panelSalas.add(salasAtualizaListaB);

        salasSalirB = new JButton("Salir");
        salasSalirB.setBounds(30, 310, 140, 30);
        panelSalas.add(salasSalirB);

        //setup frame bar
        frameBar = new JFrame("Gestion Cafeteria");
        frameBar.setSize(500, 400);
        frameBar.setResizable(false);
        frameBar.setLocationRelativeTo(null);
        frameBar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelBar = new JPanel();
        panelBar.setLayout(null);

        //componentes frame bar
        barListaArea = new JTextArea();
        panelScrollBar = new JScrollPane(barListaArea);
        panelScrollBar.setBounds(200, 30, 270, 325);
        barListaArea.setBounds(200, 30, 270, 325);
        panelBar.add(panelScrollBar);

        //botones frame bar
        barAnadeB = new JButton("Añadir a bar");
        barAnadeB.setBounds(30, 30, 140, 30);
        panelBar.add(barAnadeB);

        barEliminaB = new JButton("Elimina de bar");
        barEliminaB.setBounds(30, 100, 140, 30);
        panelBar.add(barEliminaB);

        barModificaB = new JButton("Modifica producto");
        barModificaB.setBounds(30, 170, 140, 30);
        panelBar.add(barModificaB);

        barAtualizaListaB = new JButton("Actualiza Listado");
        barAtualizaListaB.setBounds(30, 240, 140, 30);
        panelBar.add(barAtualizaListaB);

        barSalirB = new JButton("Salir");
        barSalirB.setBounds(30, 310, 140, 30);
        panelBar.add(barSalirB);

        //setup frame añadir a cartelera
        frameAnadeCartelera = new JFrame("Añadir Pelicula");
        frameAnadeCartelera.setSize(350, 550);
        frameAnadeCartelera.setResizable(false);
        frameAnadeCartelera.setLocationRelativeTo(null);
        frameAnadeCartelera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelAnadeCartelera = new JPanel();
        panelAnadeCartelera.setLayout(null);

        //elementos del frame de añadir a cartelera
        idPeliculaAnadeCarteleraL = new JLabel("ID pelicula: ");
        idPeliculaAnadeCarteleraL.setBounds(20, 20, 100, 30);
        panelAnadeCartelera.add(idPeliculaAnadeCarteleraL);

        nombreAnadeCarteleraL = new JLabel("Nombre: ");
        nombreAnadeCarteleraL.setBounds(20, 70, 100, 30);
        panelAnadeCartelera.add(nombreAnadeCarteleraL);

        generoAnadeCarteleraL = new JLabel("Genero: ");
        generoAnadeCarteleraL.setBounds(20, 120, 100, 30);
        panelAnadeCartelera.add(generoAnadeCarteleraL);

        idSalaAnadeCarteleraL = new JLabel("ID sala: ");
        idSalaAnadeCarteleraL.setBounds(20, 170, 100, 30);
        panelAnadeCartelera.add(idSalaAnadeCarteleraL);

        precioAnadeCarteleraL = new JLabel("Precio: ");
        precioAnadeCarteleraL.setBounds(20, 220, 100, 30);
        panelAnadeCartelera.add(precioAnadeCarteleraL);

        horaAnadeCarteleraL = new JLabel("Hora: ");
        horaAnadeCarteleraL.setBounds(20, 270, 100, 30);
        panelAnadeCartelera.add(horaAnadeCarteleraL);

        sinopsisAnadeCarteleraL = new JLabel("Sinopsis: ");
        sinopsisAnadeCarteleraL.setBounds(20, 320, 100, 30);
        panelAnadeCartelera.add(sinopsisAnadeCarteleraL);

        idPeliculaAnadeCarteleraT = new JTextField();
        idPeliculaAnadeCarteleraT.setBounds(100, 20, 80, 30);
        panelAnadeCartelera.add(idPeliculaAnadeCarteleraT);

        nombreAnadeCarteleraT = new JTextField();
        nombreAnadeCarteleraT.setBounds(100, 70, 200, 30);
        panelAnadeCartelera.add(nombreAnadeCarteleraT);

        generoAnadeCarteleraT = new JTextField();
        generoAnadeCarteleraT.setBounds(100, 120, 150, 30);
        panelAnadeCartelera.add(generoAnadeCarteleraT);

        idSalaAnadeCarteleraT = new JTextField();
        idSalaAnadeCarteleraT.setBounds(100, 170, 80, 30);
        panelAnadeCartelera.add(idSalaAnadeCarteleraT);

        precioAnadeCarteleraT = new JTextField();
        precioAnadeCarteleraT.setBounds(100, 220, 100, 30);
        panelAnadeCartelera.add(precioAnadeCarteleraT);

        horaAnadeCarteleraT = new JComboBox(horas);
        horaAnadeCarteleraT.setSelectedIndex(0);
        horaAnadeCarteleraT.setBounds(100, 270, 50, 30);
        horaAnadeCarteleraT.addActionListener(this);
        panelAnadeCartelera.add(horaAnadeCarteleraT);

        minutoAnadeCarteleraT = new JComboBox(minutos);
        minutoAnadeCarteleraT.setSelectedIndex(0);
        minutoAnadeCarteleraT.setBounds(160, 270, 50, 30);
        minutoAnadeCarteleraT.addActionListener(this);
        panelAnadeCartelera.add(minutoAnadeCarteleraT);

        sinopsisAnadeCarteleraT = new JTextArea();
        sinopsisAnadeCarteleraT.setBounds(100, 320, 200, 100);
        panelAnadeCartelera.add(sinopsisAnadeCarteleraT);

        //botones frame añadir
        anadeAnadeCarteleraB = new JButton("Añadir");
        anadeAnadeCarteleraB.setBounds(60, 450, 100, 30);
        panelAnadeCartelera.add(anadeAnadeCarteleraB);

        salirAnadeCarteleraB = new JButton("Salir");
        salirAnadeCarteleraB.setBounds(200, 450, 100, 30);
        panelAnadeCartelera.add(salirAnadeCarteleraB);
        
        //setup frame borrar de la cartelera
        frameBorraCartelera = new JFrame("Borra Pelicula");
        frameBorraCartelera.setSize(350, 250);
        frameBorraCartelera.setResizable(false);
        frameBorraCartelera.setLocationRelativeTo(null);
        frameBorraCartelera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelBorraCartelera = new JPanel();
        panelBorraCartelera.setLayout(null);
        
        //componentes frame borrar de la cartelera
        idPeliculaBorraCarteleraL = new JLabel("ID pelicula: ");
        idPeliculaBorraCarteleraL.setBounds(20, 20, 100, 30);
        panelBorraCartelera.add(idPeliculaBorraCarteleraL);
        
        idPeliculaBorraCarteleraT = new JTextField();
        idPeliculaBorraCarteleraT.setBounds(100, 20, 80, 30);
        panelBorraCartelera.add(idPeliculaBorraCarteleraT);
        
        //botones del frame de borrar
        borraBorraCarteleraB = new JButton("Borrar");
        borraBorraCarteleraB.setBounds(60, 150, 100, 30);
        panelBorraCartelera.add(borraBorraCarteleraB);

        salirBorraCarteleraB = new JButton("Salir");
        salirBorraCarteleraB.setBounds(200, 150, 100, 30);
        panelBorraCartelera.add(salirBorraCarteleraB);
        
        //botones a la escucha
        gestionPrinciB.addActionListener(this);
        cajaPrinciB.addActionListener(this);
        salirPrinciB.addActionListener(this);
        gestionSalaB.addActionListener(this);
        gestionBarB.addActionListener(this);
        gestionCartB.addActionListener(this);
        gestionSalB.addActionListener(this);
        carteleraAnadeB.addActionListener(this);
        carteleraEliminaB.addActionListener(this);
        carteleraModificaB.addActionListener(this);
        carteleraAtualizaListaB.addActionListener(this);
        carteleraSalirB.addActionListener(this);
        salasAnadeB.addActionListener(this);
        salasEliminaB.addActionListener(this);
        salasModificaB.addActionListener(this);
        salasAtualizaListaB.addActionListener(this);
        salasSalirB.addActionListener(this);
        barAnadeB.addActionListener(this);
        barEliminaB.addActionListener(this);
        barModificaB.addActionListener(this);
        barAtualizaListaB.addActionListener(this);
        barSalirB.addActionListener(this);
        anadeAnadeCarteleraB.addActionListener(this);
        salirAnadeCarteleraB.addActionListener(this);
        borraBorraCarteleraB.addActionListener(this);
        salirBorraCarteleraB.addActionListener(this);

        //añadimos paneles a los frames
        this.add(panelPrinci);
        frameGestion.add(panelGestion);
        frameCartelera.add(panelCartelera);
        frameSalas.add(panelSalas);
        frameBar.add(panelBar);
        frameAnadeCartelera.add(panelAnadeCartelera);
        frameBorraCartelera.add(panelBorraCartelera);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //if de los botones de salir
        if (e.getSource() == salirPrinciB) {
            System.exit(0);
        }
        if (e.getSource() == gestionSalB) {
            frameGestion.dispose();
        }
        if (e.getSource() == carteleraSalirB) {
            frameCartelera.dispose();
        }
        if (e.getSource() == salasSalirB) {
            frameSalas.dispose();
        }
        if (e.getSource() == barSalirB) {
            frameBar.dispose();
        }
        if (e.getSource() == salirAnadeCarteleraB) {
            frameAnadeCartelera.dispose();
        }
        if (e.getSource() == salirBorraCarteleraB) {
            frameBorraCartelera.dispose();
        }

        //if para hacer visibles los frames
        if (e.getSource() == gestionPrinciB) {
            frameGestion.setVisible(true);
        }
        if (e.getSource() == gestionCartB) {
            frameCartelera.setVisible(true);
            carteleraListaArea.setText(gestor.listadoPeliculas());
        }
        if (e.getSource() == gestionSalaB) {
            frameSalas.setVisible(true);
            salasListaArea.setText(gestor.listadoSalas());
        }
        if (e.getSource() == gestionBarB) {
            frameBar.setVisible(true);
            barListaArea.setText(gestor.listadoBar());
        }
        if (e.getSource() == carteleraAnadeB) {
            frameAnadeCartelera.setVisible(true);
        }
        if (e.getSource() == carteleraEliminaB) {
            frameBorraCartelera.setVisible(true);
        }

        //metodos
        if (e.getSource() == carteleraAtualizaListaB) {
            carteleraListaArea.setText(gestor.listadoPeliculas());
        }
        if (e.getSource() == salasAtualizaListaB) {
            salasListaArea.setText(gestor.listadoSalas());
        }
        if (e.getSource() == barAtualizaListaB) {
            barListaArea.setText(gestor.listadoBar());
        }
        if (e.getSource() == anadeAnadeCarteleraB) {

            int idPeliculaAnadeC = Integer.valueOf(idPeliculaAnadeCarteleraT.getText());
            String nombreAnadeC = nombreAnadeCarteleraT.getText().trim();
            String generoAnadeC = generoAnadeCarteleraT.getText().trim();
            int idSalaAnadeC = Integer.valueOf(idSalaAnadeCarteleraT.getText());
            double precioAnadeC = Double.valueOf(precioAnadeCarteleraT.getText());
            Time horaAnadeC = Time.valueOf(horas[horaAnadeCarteleraT.getSelectedIndex()]
                    + ":" + minutos[minutoAnadeCarteleraT.getSelectedIndex()] + ":00");
            String sinopsisAnadeC = sinopsisAnadeCarteleraT.getText().trim();

            gestor.anadePelicula(idPeliculaAnadeC, nombreAnadeC, generoAnadeC,
                    idSalaAnadeC, precioAnadeC, horaAnadeC, sinopsisAnadeC);

            idPeliculaAnadeCarteleraT.setText("");
            nombreAnadeCarteleraT.setText("");
            generoAnadeCarteleraT.setText("");
            idSalaAnadeCarteleraT.setText("");
            precioAnadeCarteleraT.setText("");
            horaAnadeCarteleraT.setSelectedIndex(0);
            minutoAnadeCarteleraT.setSelectedIndex(0);
            sinopsisAnadeCarteleraT.setText("");

        }
        if (e.getSource() == borraBorraCarteleraB) {
            int idPeliculaBorraC = Integer.valueOf(idPeliculaBorraCarteleraT.getText());
            
            gestor.borraPelicula(idPeliculaBorraC);
            
            idPeliculaBorraCarteleraT.setText("");
        }

    }
}
