package objetos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        
        //añadimos paneles a los frames
        this.add(panelPrinci);
        frameGestion.add(panelGestion);
        frameCartelera.add(panelCartelera);
        frameSalas.add(panelSalas);
        
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
        
        //metodos
        if (e.getSource() == carteleraAtualizaListaB) {
            carteleraListaArea.setText(gestor.listadoPeliculas());
        }
        if (e.getSource() == salasAtualizaListaB) {
            salasListaArea.setText(gestor.listadoSalas());
        }
    }
}
