/*
 * Proyecto Final POO
*  PROGRAMACION ORIENTADA A OBJETOS (VIR/DO-1)
*  GRUPO No. 8 
 */
package hn.uth.proyecto_final;

/**
 *
 * @author arian
 */

import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.opencsv.CSVWriter;
import java.lang.Object;
import java.util.Arrays;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;


public class ProyectoFinal {

    final static String PANEL1 = "Nuevo";
    final static String PANEL2 = "Venta";
    final static String PANEL3 = "Stock";
    final static String PANEL4 = "Reporte";
    final static int extraWindowWidth = 100;
 
    private JTable table;
    private JTextField textFieldBuscar;
    JTextField Nombre;
    JTextField ID;
    JTextField Stock;
    JTextField Valor;
    JTextField[] Labels ={Nombre,ID,Stock,Valor};
  


    private JTextField statusText;


    public void addComponentToPane(Container pane)  {
        JTabbedPane tabbedPane = new JTabbedPane();

        JTable tbl = new JTable();
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        // add header of the table
        String header[] = new String[] { "Nombre", "ID", "Stock", "Valor de venta" };
        // add header in table model     
        dtm.setColumnIdentifiers(header);  
        tbl.setModel(dtm);
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(tbl);

        //Crea la tabla
        JTable tablaVenta = new JTable();
        DefaultTableModel negro = new DefaultTableModel(0,0);
        String headersVenta[] = new String[] {"Nombre", "Stock", "Cantidad a Vender"};
        negro.setColumnIdentifiers(headersVenta);
        tablaVenta.setModel(negro);
        JScrollPane scrollPaneVenta = new JScrollPane(tablaVenta);


        //Create the "cards".
        //Create card 1

        JPanel card1 = new JPanel(new GridLayout(2,1)) {
            //Make the panel wider than it really needs, so
            //the window's wide enough for the tabs to stay
            //in one row.
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width += extraWindowWidth;
                size.height+= extraWindowWidth;
                return size;
            }
        };

         //Hace listener para el Boton Aceptar 
        String[] labels = {"Nombre: ", "ID: ", "stock inicial: ", "Valor venta: "};
        int numPairs = labels.length;

        JPanel card11;
        card11 = new JPanel(new GridLayout(numPairs,1));
        JLabel[] labels1 = new JLabel[numPairs];
        for (int i = 0; i < numPairs; i++) {
            labels1[i]= new JLabel(labels[i], JLabel.CENTER);
            card11.add(labels1[i]);  
            Labels[i] = new JTextField(20); //Listener? 
            card11.add(Labels[i]);
            int junior=5;
        }
        JPanel card12 = new JPanel();
        JButton botonAceptar = new JButton("Aceptar"); //LISTENER
//       botonAceptar.addActionListener(this);

        botonAceptar.addActionListener ( new ActionListener(){
               public void actionPerformed(ActionEvent event){
                   if (event.getSource() == botonAceptar){
                        System.out.println( Labels[0].getText() );  //ACA SE LEE LO QUE ESTA EN LA PESTAÃ‘A DE NUEVO
                        System.out.println( Labels[1].getText() );
                        System.out.println( Labels[2].getText() );
                        System.out.println( Labels[3].getText() );
                        dtm.addRow(new Object[] { Labels[0].getText(), Labels[1].getText(), Labels[2].getText(),Labels[3].getText()});
                        negro.addRow(new Object[] {Labels[0].getText(),Labels[2].getText(),0});
                         //JOptionPane.showMessageDialog(null,"Jnior");
                   }                          

               };
        });
        
        //LISTENER
        card12.add(botonAceptar);
        card1.add(card11);
        card1.add(card12);

        //create card 2 venta
        JPanel card2 = new JPanel(new BorderLayout());

        JPanel card21 =new JPanel(new GridLayout(1,0));
        JPanel card22 = new JPanel(new GridLayout(1,0));


        JButton botonVender = new JButton("Vender"); //LISTENER
        botonVender.addActionListener ( new ActionListener(){
               public void actionPerformed(ActionEvent event){
                   if(event.getSource()==botonVender){
                       System.out.println("in");
                       System.out.println(negro.getRowCount());
                       for (int i = 0;i <= negro.getRowCount();i++){
                           String nombreVenta = negro.getValueAt(i, 0).toString();
                           int cantidadVenta = Integer.parseInt(negro.getValueAt(i, 2).toString());
                           int stockVenta = Integer.parseInt(negro.getValueAt(i,1).toString());
                           int difVenta = stockVenta - cantidadVenta;
                           System.out.println( "deb" );
                           if (cantidadVenta != 0)  {
                               System.out.println( "si" );
                               if (difVenta > 0){
                                   dtm.setValueAt(difVenta, i, 2);
                                   negro.setValueAt(difVenta, i, 1);
                                }
                                else {
                                    dtm.removeRow(i);
                                    negro.removeRow(i);
                                }
                            }
                        }
                    }                
                };
            });
         
        card22.add(botonVender);
        card21.add(scrollPaneVenta); //AÃ±ade la tabla para venta
        card2.add(card21, BorderLayout.CENTER);
        card2.add(card22, BorderLayout.SOUTH);


        //create card 3 stock
        JPanel card3 = new JPanel(new BorderLayout());

        JPanel card31 =new JPanel(new GridLayout(1,0));
        card31.add(scrollPane); //Add the scroll pane to this panel.
        JButton botonRecargar = new JButton("Actualizar");
        textFieldBuscar = new JTextField("Buscador", 20);


        JPanel card32 = new JPanel();
        card32.add(textFieldBuscar);
        card32.add(botonRecargar);

        card3.add(card31, BorderLayout.CENTER);
        card3.add(card32, BorderLayout.SOUTH);

        //create card 4
        JPanel card4 = new JPanel(new GridLayout(2,1));
        JPanel card41 =new JPanel();
        JPanel card42 =new JPanel();

        JLabel labelReporte = new JLabel("Para generar reporte presione boton Generar");
        JButton botonReporte = new JButton("Generar");
        botonReporte.addActionListener ( new ActionListener(){
 
            public void actionPerformed(ActionEvent event){
                CSVWriter writer = null;
                try {
                    writer = new CSVWriter(new FileWriter("output.csv"), ',' , '\t');
                } catch (IOException e) {
                    e.printStackTrace();
                }
                csv csv = new csv(writer);
                try {
                    csv.writeProduct(negro);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("reporte");
            };
        });

        card41.add(labelReporte);
        card42.add(botonReporte);
        card4.add(card41);
        card4.add(card42);

        // add panels to tabbed panel
        tabbedPane.addTab(PANEL1, card1);
        tabbedPane.addTab(PANEL2, card2);
        tabbedPane.addTab(PANEL3, card3);
        tabbedPane.addTab(PANEL4, card4);
        //aÃ±ade tabbeds panel al panel central
        pane.add(tabbedPane, BorderLayout.CENTER);
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Software de inventario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        ProyectoFinal demo = new ProyectoFinal();
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
        
  /*  public void actionPerformed (ActionEvent event) {
                 System.out.println("Junior" );
                 Jr.getText();
                 JOptionPane.showMessageDialog(null,
                 "Nada");                 

      
    }*/
    
}
