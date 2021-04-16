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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



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
	JTextField[] Labels = {Nombre,  ID,  Stock,  Valor };
	private JTextField statusText;



		public void addComponentToPane(Container pane) {
  			JTabbedPane tabbedPane = new JTabbedPane();

  			JTable tbl = new JTable();
  			final DefaultTableModel dtm = new DefaultTableModel(0, 0);
  			// add header of the table
  			String header[] = new String[] {"Nombre","ID","Stock","Valor de venta"  };
  			// add header in table model     
  			dtm.setColumnIdentifiers(header);
  			tbl.setModel(dtm);
  			//Create the scroll pane and add the table to it.
  			JScrollPane scrollPane = new JScrollPane(tbl);
  			//Crea la tabla
  			JTable tablaVenta = new JTable();
  			final DefaultTableModel negro = new DefaultTableModel(0, 0);
  			String headersVenta[] = new String[] {"Nombre","Stock","Cantidad a Vender"};
  			negro.setColumnIdentifiers(headersVenta);
  			tablaVenta.setModel(negro);
  			JScrollPane scrollPaneVenta = new JScrollPane(tablaVenta);
  			JPanel card1 = new JPanel(new GridLayout(2, 1)) {
   			//Make the panel wider than it really needs, so
   			//the window's wide enough for the tabs to stay
   			//in one row.
   			public Dimension getPreferredSize() {
    			Dimension size = super.getPreferredSize();
    			size.width += extraWindowWidth;
    			size.height += extraWindowWidth;
    			return size;
			}
  		};

  	//Hace listener para el Boton Aceptar 
  	String[] labels = {
   	"Nombre: ",
   	"ID: ",
   	"stock inicial: ",
   	"Valor venta: "
   	 };
   	int numPairs = labels.length;

	JPanel card11;
  	card11 = new JPanel(new GridLayout(numPairs, 1));
  	JLabel[] labels1 = new JLabel[numPairs];
  	
  	for (int i = 0; i < numPairs; i++) {
   		labels1[i] = new JLabel(labels[i], JLabel.CENTER);
   		card11.add(labels1[i]);
   		Labels[i] = new JTextField(20); //Listener? 
   		card11.add(Labels[i]);
   		int junior = 5;
  	}
  	
  	JPanel card12 = new JPanel();
  	final JButton botonAceptar = new JButton("Aceptar");
	final JButton botonCargar = new JButton("Cargar Inventario"); //LISTENER
  	//       botonAceptar.addActionListener(this);
	botonCargar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evento){
				String csvFile = "output.csv";
        		BufferedReader br = null;
        		String line = "";
        		String cvsSplitBy = ",";
				int contador = 1;
			
        		try {
		            br = new BufferedReader(new FileReader(csvFile));
            		while ((line = br.readLine()) != null) {
						String[] inventario = line.split(cvsSplitBy);
	               		 	
	                // use comma as separator
					
						
				//	System.out.prtintln(dtm.getValueAt(contador,1).toString().equals(inventario[1].toString()));
					
					for (int i = 0; i < negro.getRowCount(); i++)	{
					if(dtm.getValueAt(i,1).toString().equals(inventario[1].toString())){
							
							int stocki = Integer.parseInt(dtm.getValueAt(i,2).toString());
							int stockf = stocki+Integer.parseInt(inventario[2]);
							
							dtm.setValueAt(stockf, i, 2);
        					negro.setValueAt(stockf, i, 1);
							contador = 0;
					}
					}
					if(contador!=0){
                	
					dtm.addRow(new Object[] {inventario[0],inventario[1], inventario[2], inventario[3]});
       				negro.addRow(new Object[] {inventario[0], inventario[2], 0});
						contador=1;	}
					contador=1;
						
            		} 
				 
        		} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, "No existe el archivo output.csv");
        		    e.printStackTrace();
       			} catch (IOException e) {
            			e.printStackTrace();
        		} finally {
            		if (br != null) {
                		try {
                    		br.close();
                		} catch (IOException e) {
                   			 e.printStackTrace();
                			}
            			}
        		}			
		}
    });

  	botonAceptar.addActionListener(new ActionListener() {
   	int primeraventa = 1;
   	boolean ErrorValor;
   	boolean ErrorStock;
   	boolean Error;

   	public void actionPerformed(ActionEvent event) {

    if (event.getSource() == botonAceptar) {

    	int Auxiliar1 = 0;
     	boolean a = Labels[0].getText().trim().isEmpty();
     	boolean b = Labels[1].getText().trim().isEmpty();
     	boolean c = Labels[2].getText().trim().isEmpty();
     	boolean d = Labels[3].getText().trim().isEmpty();

     	try {
      		double check = Double.parseDouble(Labels[2].getText());
     	} catch (NumberFormatException nfe) {

      		if (!c) JOptionPane.showMessageDialog(null, "Valor de stock no valido");
     	}
     

     	try {
      		double check = Double.parseDouble(Labels[3].getText());
     	} catch (NumberFormatException nfe) {

      		if (!d) JOptionPane.showMessageDialog(null, "Valor de venta no valido");
     	}


  		if (a | b | c | d) {

    		JOptionPane.showMessageDialog(null, "Hay campos vacios");
      		Error = true;
  		}

    

    	if (!c | !d) {

    		if (!c) {
        		if (((Double.parseDouble(Labels[2].getText()) < 0))) {
        		JOptionPane.showMessageDialog(null, "Valor de stock no valido");
        		Error = true;
       			}
      		}
  	
  			if (!d) {
       			if (((Double.parseDouble(Labels[3].getText()) < 0))) {
        		JOptionPane.showMessageDialog(null, "Valor de venta no valido");
        		Error = true;
      			}
 			}

		}


     	if (!Error) {
      		if (primeraventa != 1) {
       			for (int i = 0; i < dtm.getRowCount(); i++) {

        			String nombreVenta = dtm.getValueAt(i, 0).toString();
        			String ADDid = dtm.getValueAt(i, 1).toString();
        			String Oldid = Labels[1].getText().toString();
        			int Valor = Integer.parseInt(dtm.getValueAt(i, 3).toString());
        			int stockVenta = Integer.parseInt(dtm.getValueAt(i, 2).toString());
        			

        			if (Labels[1].getText().equals(dtm.getValueAt(i, 1).toString()) |
         				Labels[0].getText().equals(dtm.getValueAt(i, 0).toString())) {
         					if (!Labels[0].getText().equals(nombreVenta) | !Labels[1].getText().equals(ADDid)) {
          					JOptionPane.showMessageDialog(null, "El nombre no coincide con la ID");
          					Auxiliar1 = 1;
          					break;
         					}
         				
         				int Stock = stockVenta + Integer.parseInt(Labels[2].getText());
         				dtm.setValueAt(Stock, i, 2);
         				negro.setValueAt(Stock, i, 1);
         				Auxiliar1 = 1;
         				break;
        			}


       			}
      		}


     		if (Auxiliar1 != 1) {
       			
       			dtm.addRow(new Object[] {Labels[0].getText(), Labels[1].getText(), Labels[2].getText(), Labels[3].getText()});
       			negro.addRow(new Object[] {Labels[0].getText(), Labels[2].getText(), 0});
       			primeraventa = 0;
      			} 

      		else Auxiliar1 = 0;

     		} // e ste es del else		   
     		Error = false;
     		//JOptionPane.showMessageDialog(null,"Jnior");
    	}

  	};
   	});

  	//LISTENER
  	card12.add(botonAceptar);
	card12.add(botonCargar);
  	card1.add(card11);
  	card1.add(card12);

  	//create card 2 venta
  	JPanel card2 = new JPanel(new BorderLayout());

  	JPanel card21 = new JPanel(new GridLayout(1, 0));
  	JPanel card22 = new JPanel(new GridLayout(1, 0));
  	final JButton botonVender = new JButton("Vender"); //LISTENER
  
  	botonVender.addActionListener(new ActionListener() {
  		public void actionPerformed(ActionEvent event) {
    		if (event.getSource() == botonVender) {

    			for (int i = 0; i < negro.getRowCount(); i++) {
      				String nombreVenta = negro.getValueAt(i, 0).toString();
      				int cantidadVenta = Integer.parseInt(negro.getValueAt(i, 2).toString());
      				int stockVenta = Integer.parseInt(dtm.getValueAt(i, 2).toString());
      				int difVenta = stockVenta - cantidadVenta;
				negro.setValueAt(stockVenta, i, 1);

      				if (cantidadVenta != 0) {

       					if (difVenta > 0) {
        					dtm.setValueAt(difVenta, i, 2);
        					negro.setValueAt(difVenta, i, 1);
        					negro.setValueAt(0, i, 2);
						negro.setValueAt(dtm.getValueAt(i,0).toString(), i, 0);
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
  	JPanel card31 = new JPanel(new GridLayout(1, 0));
  	card31.add(scrollPane); //Add the scroll pane to this panel.
  	JButton botonRecargar = new JButton("Actualizar");
	
	botonRecargar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ev){
			for(int k=0	; k < dtm.getRowCount(); k++){
				String x =dtm.getValueAt(k,0).toString();
				String y =dtm.getValueAt(k,1).toString();
				String w =dtm.getValueAt(k,2).toString();
				String z =dtm.getValueAt(k,3).toString();
				dtm.setValueAt(x,k,0);
				dtm.setValueAt(y,k,1);
				dtm.setValueAt(w,k,2);
				dtm.setValueAt(z,k,3);
				negro.setValueAt(x,k,0);
				negro.setValueAt(w,k,1);				
			}			
		}
	});

  	
  	JPanel card32 = new JPanel();
  	
  	card32.add(botonRecargar);
  	card3.add(card31, BorderLayout.CENTER);
  	card3.add(card32, BorderLayout.SOUTH);
  	//create card 4
  	JPanel card4 = new JPanel(new GridLayout(2, 1));
  	JPanel card41 = new JPanel();
  	JPanel card42 = new JPanel();
  	JLabel labelReporte = new JLabel("Para generar reporte presione boton Generar");
  	JButton botonReporte = new JButton("Generar");
  	

  	botonReporte.addActionListener(new ActionListener() {  
  		public void actionPerformed(ActionEvent event) {
			String csvFile = "output.csv";
			FileWriter writer2;
			try {
				writer2 = new FileWriter(csvFile);
     			for (int i = 0; i < dtm.getRowCount(); i++){
					String no =dtm.getValueAt(i,0).toString();
					String idd =dtm.getValueAt(i,1).toString();
					String  st =dtm.getValueAt(i,2).toString();
					String ve =dtm.getValueAt(i,3).toString();
				    CSVUtils.writeLine(writer2, Arrays.asList(no,idd,st,ve));
				}
				writer2.flush();
        		writer2.close();
        	} catch (IOException e) {
     				e.printStackTrace();
    			}
		 	
			
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


 /*  	public void actionPerformed (ActionEvent event) {
                System.out.println("Junior" );
                Jr.getText();
                JOptionPane.showMessageDialog(null,
                "Nada");                 

     
   }*/

}


