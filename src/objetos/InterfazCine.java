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

    //frame modifica peliculas de la cartelera
    JFrame frameModificaCartelera;
    JPanel panelModificaCartelera;
    JLabel idPeliculaModificaCarteleraL;
    JTextField idPeliculaModificaCarteleraT;
    JLabel nombreModificaCarteleraL;
    JTextField nombreModificaCarteleraT;
    JLabel generoModificaCarteleraL;
    JTextField generoModificaCarteleraT;
    JLabel idSalaModificaCarteleraL;
    JTextField idSalaModificaCarteleraT;
    JLabel precioModificaCarteleraL;
    JTextField precioModificaCarteleraT;
    JLabel horaModificaCarteleraL;
    JComboBox horaModificaCarteleraT;
    JComboBox minutoModificaCarteleraT;
    JLabel sinopsisModificaCarteleraL;
    JTextArea sinopsisModificaCarteleraT;
    JButton modificaModificaCarteleraB;
    JButton salirModificaCarteleraB;

    //frame añadir salas
    JFrame frameAnadeSala;
    JPanel panelAnadeSala;
    JLabel idSalaAnadeSalaL;
    JTextField idSalaAnadeSalaT;
    JLabel aforoAnadeSalaL;
    JTextField aforoAnadeSalaT;
    JLabel tridimensionAnadeSalaL;
    JLabel dolbyAtmosAnadeSalaL;
    JButton anadeAnadeSalaB;
    JButton salirAnadeSalaB;
    JComboBox tridimensionAnadeSalaT;
    JComboBox dolbyAtmosAnadeSalaT;
    String[] booleanos = {"false", "true"};

    //frame borrar salas
    JFrame frameBorraSala;
    JPanel panelBorraSala;
    JLabel idSalaBorraSalaL;
    JTextField idSalaBorraSalaT;
    JButton borraBorraSalaB;
    JButton salirBorraSalaB;

    //frame modifica salas
    JFrame frameModificaSala;
    JPanel panelModificaSala;
    JLabel idSalaModificaSalaL;
    JTextField idSalaModificaSalaT;
    JLabel aforoModificaSalaL;
    JTextField aforoModificaSalaT;
    JLabel tridimensionModificaSalaL;
    JLabel dolbyAtmosModificaSalaL;
    JButton modificaModificaSalaB;
    JButton salirModificaSalaB;
    JComboBox tridimensionModificaSalaT;
    JComboBox dolbyAtmosModificaSalaT;

    //frame añadir a la cafeteria
    JFrame frameAnadeBar;
    JPanel panelAnadeBar;
    JLabel idProductoAnadeBarL;
    JTextField idProductoAnadeBarT;
    JLabel nombreAnadeBarL;
    JTextField nombreAnadeBarT;
    JLabel stockAnadeBarL;
    JTextField stockAnadeBarT;
    JLabel precioAnadeBarL;
    JTextField precioAnadeBarT;
    JButton anadeAnadeBarB;
    JButton salirAnadeBarB;
    
    //frame borrar del bar
    JFrame frameBorraBar;
    JPanel panelBorraBar;
    JLabel idProductoBorraBarL;
    JTextField idProductoBorraBarT;
    JButton borraBorraBarB;
    JButton salirBorraBarB;

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

        //setup frame modificar cartelera
        frameModificaCartelera = new JFrame("Modifica Pelicula");
        frameModificaCartelera.setSize(350, 550);
        frameModificaCartelera.setResizable(false);
        frameModificaCartelera.setLocationRelativeTo(null);
        frameModificaCartelera.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelModificaCartelera = new JPanel();
        panelModificaCartelera.setLayout(null);

        //elementos del frame modificar la cartelera
        idPeliculaModificaCarteleraL = new JLabel("ID pelicula: ");
        idPeliculaModificaCarteleraL.setBounds(20, 20, 100, 30);
        panelModificaCartelera.add(idPeliculaModificaCarteleraL);

        nombreModificaCarteleraL = new JLabel("Nuevo nombre: ");
        nombreModificaCarteleraL.setBounds(20, 70, 100, 30);
        panelModificaCartelera.add(nombreModificaCarteleraL);

        generoModificaCarteleraL = new JLabel("Nuevo Genero: ");
        generoModificaCarteleraL.setBounds(20, 120, 100, 30);
        panelModificaCartelera.add(generoModificaCarteleraL);

        idSalaModificaCarteleraL = new JLabel("Nueva sala: ");
        idSalaModificaCarteleraL.setBounds(20, 170, 100, 30);
        panelModificaCartelera.add(idSalaModificaCarteleraL);

        precioModificaCarteleraL = new JLabel("Nuevo Precio: ");
        precioModificaCarteleraL.setBounds(20, 220, 100, 30);
        panelModificaCartelera.add(precioModificaCarteleraL);

        horaModificaCarteleraL = new JLabel("Nueva Hora: ");
        horaModificaCarteleraL.setBounds(20, 270, 100, 30);
        panelModificaCartelera.add(horaModificaCarteleraL);

        sinopsisModificaCarteleraL = new JLabel("Nueva Sinopsis: ");
        sinopsisModificaCarteleraL.setBounds(20, 320, 100, 30);
        panelModificaCartelera.add(sinopsisModificaCarteleraL);

        idPeliculaModificaCarteleraT = new JTextField();
        idPeliculaModificaCarteleraT.setBounds(120, 20, 80, 30);
        panelModificaCartelera.add(idPeliculaModificaCarteleraT);

        nombreModificaCarteleraT = new JTextField();
        nombreModificaCarteleraT.setBounds(120, 70, 200, 30);
        panelModificaCartelera.add(nombreModificaCarteleraT);

        generoModificaCarteleraT = new JTextField();
        generoModificaCarteleraT.setBounds(120, 120, 150, 30);
        panelModificaCartelera.add(generoModificaCarteleraT);

        idSalaModificaCarteleraT = new JTextField();
        idSalaModificaCarteleraT.setBounds(120, 170, 80, 30);
        panelModificaCartelera.add(idSalaModificaCarteleraT);

        precioModificaCarteleraT = new JTextField();
        precioModificaCarteleraT.setBounds(120, 220, 100, 30);
        panelModificaCartelera.add(precioModificaCarteleraT);

        horaModificaCarteleraT = new JComboBox(horas);
        horaModificaCarteleraT.setSelectedIndex(0);
        horaModificaCarteleraT.setBounds(120, 270, 50, 30);
        horaModificaCarteleraT.addActionListener(this);
        panelModificaCartelera.add(horaModificaCarteleraT);

        minutoModificaCarteleraT = new JComboBox(minutos);
        minutoModificaCarteleraT.setSelectedIndex(0);
        minutoModificaCarteleraT.setBounds(180, 270, 50, 30);
        minutoModificaCarteleraT.addActionListener(this);
        panelModificaCartelera.add(minutoModificaCarteleraT);

        sinopsisModificaCarteleraT = new JTextArea();
        sinopsisModificaCarteleraT.setBounds(120, 320, 200, 100);
        panelModificaCartelera.add(sinopsisModificaCarteleraT);

        //botones frame modificar
        modificaModificaCarteleraB = new JButton("Añadir");
        modificaModificaCarteleraB.setBounds(60, 450, 100, 30);
        panelModificaCartelera.add(modificaModificaCarteleraB);

        salirModificaCarteleraB = new JButton("Salir");
        salirModificaCarteleraB.setBounds(200, 450, 100, 30);
        panelModificaCartelera.add(salirModificaCarteleraB);

        //setup frame añadir a salas
        frameAnadeSala = new JFrame("Añadir Salas");
        frameAnadeSala.setSize(350, 320);
        frameAnadeSala.setResizable(false);
        frameAnadeSala.setLocationRelativeTo(null);
        frameAnadeSala.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelAnadeSala = new JPanel();
        panelAnadeSala.setLayout(null);

        //elementos del frame de añadir a salas
        idSalaAnadeSalaL = new JLabel("ID Sala: ");
        idSalaAnadeSalaL.setBounds(20, 20, 100, 30);
        panelAnadeSala.add(idSalaAnadeSalaL);

        aforoAnadeSalaL = new JLabel("Aforo: ");
        aforoAnadeSalaL.setBounds(20, 70, 100, 30);
        panelAnadeSala.add(aforoAnadeSalaL);

        tridimensionAnadeSalaL = new JLabel("3D: ");
        tridimensionAnadeSalaL.setBounds(20, 120, 100, 30);
        panelAnadeSala.add(tridimensionAnadeSalaL);

        dolbyAtmosAnadeSalaL = new JLabel("Dolby Atmos: ");
        dolbyAtmosAnadeSalaL.setBounds(20, 170, 100, 30);
        panelAnadeSala.add(dolbyAtmosAnadeSalaL);

        idSalaAnadeSalaT = new JTextField();
        idSalaAnadeSalaT.setBounds(100, 20, 80, 30);
        panelAnadeSala.add(idSalaAnadeSalaT);

        aforoAnadeSalaT = new JTextField();
        aforoAnadeSalaT.setBounds(100, 70, 100, 30);
        panelAnadeSala.add(aforoAnadeSalaT);

        tridimensionAnadeSalaT = new JComboBox(booleanos);
        tridimensionAnadeSalaT.setSelectedIndex(0);
        tridimensionAnadeSalaT.setBounds(100, 120, 80, 30);
        tridimensionAnadeSalaT.addActionListener(this);
        panelAnadeSala.add(tridimensionAnadeSalaT);

        dolbyAtmosAnadeSalaT = new JComboBox(booleanos);
        dolbyAtmosAnadeSalaT.setSelectedIndex(0);
        dolbyAtmosAnadeSalaT.setBounds(100, 170, 80, 30);
        dolbyAtmosAnadeSalaT.addActionListener(this);
        panelAnadeSala.add(dolbyAtmosAnadeSalaT);

        //botones frame añadir salas
        anadeAnadeSalaB = new JButton("Añadir");
        anadeAnadeSalaB.setBounds(60, 230, 100, 30);
        panelAnadeSala.add(anadeAnadeSalaB);

        salirAnadeSalaB = new JButton("Salir");
        salirAnadeSalaB.setBounds(200, 230, 100, 30);
        panelAnadeSala.add(salirAnadeSalaB);

        //setup frame borrar de la sala
        frameBorraSala = new JFrame("Borra Sala");
        frameBorraSala.setSize(350, 250);
        frameBorraSala.setResizable(false);
        frameBorraSala.setLocationRelativeTo(null);
        frameBorraSala.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelBorraSala = new JPanel();
        panelBorraSala.setLayout(null);

        //componentes frame borrar de la sala
        idSalaBorraSalaL = new JLabel("ID Sala: ");
        idSalaBorraSalaL.setBounds(20, 20, 100, 30);
        panelBorraSala.add(idSalaBorraSalaL);

        idSalaBorraSalaT = new JTextField();
        idSalaBorraSalaT.setBounds(100, 20, 80, 30);
        panelBorraSala.add(idSalaBorraSalaT);

        //botones del frame de borrar
        borraBorraSalaB = new JButton("Borrar");
        borraBorraSalaB.setBounds(60, 150, 100, 30);
        panelBorraSala.add(borraBorraSalaB);

        salirBorraSalaB = new JButton("Salir");
        salirBorraSalaB.setBounds(200, 150, 100, 30);
        panelBorraSala.add(salirBorraSalaB);

        //setup frame modifica salas
        frameModificaSala = new JFrame("Modificar Salas");
        frameModificaSala.setSize(350, 320);
        frameModificaSala.setResizable(false);
        frameModificaSala.setLocationRelativeTo(null);
        frameModificaSala.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelModificaSala = new JPanel();
        panelModificaSala.setLayout(null);

        //elementos del frame de modificar salas
        idSalaModificaSalaL = new JLabel("ID Sala: ");
        idSalaModificaSalaL.setBounds(20, 20, 100, 30);
        panelModificaSala.add(idSalaModificaSalaL);

        aforoModificaSalaL = new JLabel("Nuevo Aforo: ");
        aforoModificaSalaL.setBounds(20, 70, 100, 30);
        panelModificaSala.add(aforoModificaSalaL);

        tridimensionModificaSalaL = new JLabel("Nuevo 3D: ");
        tridimensionModificaSalaL.setBounds(20, 120, 100, 30);
        panelModificaSala.add(tridimensionModificaSalaL);

        dolbyAtmosModificaSalaL = new JLabel("Nuevo Dolby Atmos: ");
        dolbyAtmosModificaSalaL.setBounds(20, 170, 150, 30);
        panelModificaSala.add(dolbyAtmosModificaSalaL);

        idSalaModificaSalaT = new JTextField();
        idSalaModificaSalaT.setBounds(100, 20, 80, 30);
        panelModificaSala.add(idSalaModificaSalaT);

        aforoModificaSalaT = new JTextField();
        aforoModificaSalaT.setBounds(160, 70, 100, 30);
        panelModificaSala.add(aforoModificaSalaT);

        tridimensionModificaSalaT = new JComboBox(booleanos);
        tridimensionModificaSalaT.setSelectedIndex(0);
        tridimensionModificaSalaT.setBounds(160, 120, 80, 30);
        tridimensionModificaSalaT.addActionListener(this);
        panelModificaSala.add(tridimensionModificaSalaT);

        dolbyAtmosModificaSalaT = new JComboBox(booleanos);
        dolbyAtmosModificaSalaT.setSelectedIndex(0);
        dolbyAtmosModificaSalaT.setBounds(160, 170, 80, 30);
        dolbyAtmosModificaSalaT.addActionListener(this);
        panelModificaSala.add(dolbyAtmosModificaSalaT);

        //botones frame modifica salas
        modificaModificaSalaB = new JButton("Modifica");
        modificaModificaSalaB.setBounds(60, 230, 100, 30);
        panelModificaSala.add(modificaModificaSalaB);

        salirModificaSalaB = new JButton("Salir");
        salirModificaSalaB.setBounds(200, 230, 100, 30);
        panelModificaSala.add(salirModificaSalaB);
        
        //setup frame añadir a Bar
        frameAnadeBar = new JFrame("Añadir Prod. Cafeteria");
        frameAnadeBar.setSize(350, 320);
        frameAnadeBar.setResizable(false);
        frameAnadeBar.setLocationRelativeTo(null);
        frameAnadeBar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelAnadeBar = new JPanel();
        panelAnadeBar.setLayout(null);

        //elementos del frame de añadir a Bar
        idProductoAnadeBarL = new JLabel("ID Prod: ");
        idProductoAnadeBarL.setBounds(20, 20, 100, 30);
        panelAnadeBar.add(idProductoAnadeBarL);

        nombreAnadeBarL = new JLabel("Nombre: ");
        nombreAnadeBarL.setBounds(20, 70, 100, 30);
        panelAnadeBar.add(nombreAnadeBarL);

        stockAnadeBarL = new JLabel("stock: ");
        stockAnadeBarL.setBounds(20, 120, 100, 30);
        panelAnadeBar.add(stockAnadeBarL);

        precioAnadeBarL = new JLabel("Precio: ");
        precioAnadeBarL.setBounds(20, 170, 100, 30);
        panelAnadeBar.add(precioAnadeBarL);

        idProductoAnadeBarT = new JTextField();
        idProductoAnadeBarT.setBounds(100, 20, 80, 30);
        panelAnadeBar.add(idProductoAnadeBarT);

        nombreAnadeBarT = new JTextField();
        nombreAnadeBarT.setBounds(100, 70, 100, 30);
        panelAnadeBar.add(nombreAnadeBarT);

        stockAnadeBarT = new JTextField();
        stockAnadeBarT.setBounds(100, 120, 100, 30);
        panelAnadeBar.add(stockAnadeBarT);

        precioAnadeBarT = new JTextField();
        precioAnadeBarT.setBounds(100, 170, 100, 30);
        panelAnadeBar.add(precioAnadeBarT);

        //botones frame añadir Bar
        anadeAnadeBarB = new JButton("Añadir");
        anadeAnadeBarB.setBounds(60, 230, 100, 30);
        panelAnadeBar.add(anadeAnadeBarB);

        salirAnadeBarB = new JButton("Salir");
        salirAnadeBarB.setBounds(200, 230, 100, 30);
        panelAnadeBar.add(salirAnadeBarB);
        
        //setup frame borrar del bar
        frameBorraBar = new JFrame("Borra del Bar");
        frameBorraBar.setSize(350, 250);
        frameBorraBar.setResizable(false);
        frameBorraBar.setLocationRelativeTo(null);
        frameBorraBar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelBorraBar = new JPanel();
        panelBorraBar.setLayout(null);

        //componentes frame borrar de la sala
        idProductoBorraBarL = new JLabel("ID Producto: ");
        idProductoBorraBarL.setBounds(20, 20, 100, 30);
        panelBorraBar.add(idProductoBorraBarL);

        idProductoBorraBarT = new JTextField();
        idProductoBorraBarT.setBounds(100, 20, 80, 30);
        panelBorraBar.add(idProductoBorraBarT);

        //botones del frame de borrar
        borraBorraBarB = new JButton("Borrar");
        borraBorraBarB.setBounds(60, 150, 100, 30);
        panelBorraBar.add(borraBorraBarB);

        salirBorraBarB = new JButton("Salir");
        salirBorraBarB.setBounds(200, 150, 100, 30);
        panelBorraBar.add(salirBorraBarB);

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
        modificaModificaCarteleraB.addActionListener(this);
        salirModificaCarteleraB.addActionListener(this);
        anadeAnadeSalaB.addActionListener(this);
        salirAnadeSalaB.addActionListener(this);
        borraBorraSalaB.addActionListener(this);
        salirBorraSalaB.addActionListener(this);
        modificaModificaSalaB.addActionListener(this);
        salirModificaSalaB.addActionListener(this);
        anadeAnadeBarB.addActionListener(this);
        salirAnadeBarB.addActionListener(this);
        borraBorraBarB.addActionListener(this);
        salirBorraBarB.addActionListener(this);

        //añadimos paneles a los frames
        this.add(panelPrinci);
        frameGestion.add(panelGestion);
        frameCartelera.add(panelCartelera);
        frameSalas.add(panelSalas);
        frameBar.add(panelBar);
        frameAnadeCartelera.add(panelAnadeCartelera);
        frameBorraCartelera.add(panelBorraCartelera);
        frameModificaCartelera.add(panelModificaCartelera);
        frameAnadeSala.add(panelAnadeSala);
        frameBorraSala.add(panelBorraSala);
        frameModificaSala.add(panelModificaSala);
        frameAnadeBar.add(panelAnadeBar);
        frameBorraBar.add(panelBorraBar);

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
        if (e.getSource() == salirModificaCarteleraB) {
            frameModificaCartelera.dispose();
        }
        if (e.getSource() == salirAnadeSalaB) {
            frameAnadeSala.dispose();
        }
        if (e.getSource() == salirBorraSalaB) {
            frameBorraSala.dispose();
        }
        if (e.getSource() == salirModificaSalaB) {
            frameModificaSala.dispose();
        }
        if (e.getSource() == salirAnadeBarB) {
            frameAnadeBar.dispose();
        }
        if (e.getSource() == salirBorraBarB) {
            frameBorraBar.dispose();
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
        if (e.getSource() == carteleraModificaB) {
            frameModificaCartelera.setVisible(true);
        }
        if (e.getSource() == salasAnadeB) {
            frameAnadeSala.setVisible(true);
        }
        if (e.getSource() == salasEliminaB) {
            frameBorraSala.setVisible(true);
        }
        if (e.getSource() == salasModificaB) {
            frameModificaSala.setVisible(true);
        }
        if (e.getSource() == barAnadeB) {
            frameAnadeBar.setVisible(true);
        }
        if (e.getSource() == barEliminaB) {
            frameBorraBar.setVisible(true);
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
        if (e.getSource() == modificaModificaCarteleraB) {

            int idPeliculaModC = Integer.valueOf(idPeliculaModificaCarteleraT.getText());
            String nombreModC = nombreModificaCarteleraT.getText().trim();
            String generoModC = generoModificaCarteleraT.getText().trim();
            int idSalaModC = Integer.valueOf(idSalaModificaCarteleraT.getText());
            double precioModC = Double.valueOf(precioModificaCarteleraT.getText());
            Time horaModC = Time.valueOf(horas[horaModificaCarteleraT.getSelectedIndex()]
                    + ":" + minutos[minutoModificaCarteleraT.getSelectedIndex()] + ":00");
            String sinopsisModC = sinopsisModificaCarteleraT.getText().trim();

            gestor.modificaPelicula(idPeliculaModC, nombreModC, generoModC,
                    idSalaModC, precioModC, horaModC, sinopsisModC);

            idPeliculaModificaCarteleraT.setText("");
            nombreModificaCarteleraT.setText("");
            generoModificaCarteleraT.setText("");
            idSalaModificaCarteleraT.setText("");
            precioModificaCarteleraT.setText("");
            horaModificaCarteleraT.setSelectedIndex(0);
            minutoModificaCarteleraT.setSelectedIndex(0);
            sinopsisModificaCarteleraT.setText("");

        }
        if (e.getSource() == anadeAnadeSalaB) {

            int idSalaAnadeS = Integer.valueOf(idSalaAnadeSalaT.getText());
            int aforoAnadeS = Integer.valueOf(aforoAnadeSalaT.getText());
            boolean trifimensionAnadeS = Boolean.valueOf(booleanos[tridimensionAnadeSalaT.getSelectedIndex()]);
            boolean dolbyAtmosAnadeS = Boolean.valueOf(booleanos[dolbyAtmosAnadeSalaT.getSelectedIndex()]);

            gestor.anadeSala(idSalaAnadeS, aforoAnadeS, trifimensionAnadeS, dolbyAtmosAnadeS);

            idSalaAnadeSalaT.setText("");
            aforoAnadeSalaT.setText("");
            tridimensionAnadeSalaT.setSelectedIndex(0);
            dolbyAtmosAnadeSalaT.setSelectedIndex(0);

        }
        if (e.getSource() == borraBorraSalaB) {
            int idSalaBorraS = Integer.valueOf(idSalaBorraSalaT.getText());

            gestor.borraSala(idSalaBorraS);

            idSalaBorraSalaT.setText("");
        }
        if (e.getSource() == modificaModificaSalaB) {

            int idSalaAnadeS = Integer.valueOf(idSalaModificaSalaT.getText());
            int aforoAnadeS = Integer.valueOf(aforoModificaSalaT.getText());
            boolean trifimensionAnadeS = Boolean.valueOf(booleanos[tridimensionModificaSalaT.getSelectedIndex()]);
            boolean dolbyAtmosAnadeS = Boolean.valueOf(booleanos[dolbyAtmosModificaSalaT.getSelectedIndex()]);

            gestor.modificaSala(idSalaAnadeS, aforoAnadeS, trifimensionAnadeS, dolbyAtmosAnadeS);

            idSalaModificaSalaT.setText("");
            aforoModificaSalaT.setText("");
            tridimensionModificaSalaT.setSelectedIndex(0);
            dolbyAtmosModificaSalaT.setSelectedIndex(0);

        }
        if (e.getSource() == anadeAnadeBarB) {

            int idBarAnadeB = Integer.valueOf(idProductoAnadeBarT.getText());
            String nombreAnadeB = nombreAnadeBarT.getText().trim();
            int stockAnadeB = Integer.valueOf(stockAnadeBarT.getText());
            double precioAnadeB = Double.valueOf(precioAnadeBarT.getText());

            gestor.anadeBar(idBarAnadeB, nombreAnadeB, stockAnadeB, precioAnadeB);

            idProductoAnadeBarT.setText("");
            nombreAnadeBarT.setText("");
            stockAnadeBarT.setText("");
            precioAnadeBarT.setText("");

        }
        if (e.getSource() == borraBorraBarB) {
            int idProductoBorraB = Integer.valueOf(idProductoBorraBarT.getText());

            gestor.borraBar(idProductoBorraB);

            idProductoBorraBarT.setText("");
        }

    }
}
