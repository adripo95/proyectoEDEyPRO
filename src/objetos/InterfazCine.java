package objetos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCine extends JFrame implements ActionListener {

    //componentes de la ventana principal
    JPanel panelPrinci;
    JLabel infoPrinci;
    JButton gestionPrinciB;
    JButton cajaPrinciB;
    JButton salirPrinciB;

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
        
        //botones a la escucha
        gestionPrinciB.addActionListener(this);
        cajaPrinciB.addActionListener(this);
        salirPrinciB.addActionListener(this);
        
        //añadimos paneles a los frames
        this.add(panelPrinci);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        //if de los botones de salir
        if (e.getSource() == salirPrinciB) {
            System.exit(0);
        }
        
        //if para hacer visibles los frames
    }
}
