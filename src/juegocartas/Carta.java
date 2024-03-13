//Realizado por: Cristian David Diez Lopez CC: 1036967493

package juegocartas;

import java.util.*; 
import javax.swing.*;



public class Carta { 
/* Atributo privado para almacenar el numero de la carta 
* 1= As de Trebol, 14= As de Pica, 27= As de Corazon, 40= As de Diamante, 
* 2= 2 de Trebol, 15= 2 de Pica, 28= 2 de Corazon, 41= 2 de Diamante, 
* 3= 3 de Trebol, 16= 3 de Pica, 29= 3 de Corazon, 42= 3 de Diamante, 
* ... 
* 10= 10 de Trebol, 23= 10 de Pica, 36= 10 de Corazon, 49= 10 de Diamante, 
* 11= J de Trebol, 24= J de Pica, 37= J de Corazon, 50= J de Diamante, 
* 12= Q de Trebol, 25= Q de Pica, 38= Q de Corazon, 51= Q de Diamante, 
* 13= K de Trebol, 26= K de Pica, 39= K de Corazon, 52= K de Diamante 
* */ 
    
    
    private int indice; 
    
    public Carta(Random r) {
        //El numero de la carta es generado aleatoriamente 
        indice = r.nextInt(52) + 1;
    }
    
    public void mostrarcarta(JPanel pnl, int x, int y) 
    { 
        //Obtener el nombre del archivo de la carta 
        String nombreImagen="/imagenes/CARTA" + String.valueOf(indice) + ".JPG";
        
        //Cargar la imagen en memoria 
        ImageIcon imagen = new ImageIcon(getClass().getResource(nombreImagen)); 
        
        
        //Crear Instancia Jlabel para mostrar la imagen 
        JLabel lblCarta = new JLabel(imagen); 
        
        //Llevar la imagen a la etiqueta
        //lblCarta.setIcon(imagen);
        
        //Definir posicion y dimensiones de la imagen 
        lblCarta.setBounds(x, y, imagen.getIconWidth(),imagen.getIconHeight());
        
        //Mostrar la carta en la ventana 
        pnl.add(lblCarta);
                
    }
    
    
    //CLASE EN DONDE SE MANEJA EL ENUMCIADO PintaCarta
    //para obtener la pinta de cada una
    public PintaCarta obtenerPinta() 
    { 
        /* Obtiene la pinta que corresponde a la carta, 
        * basado en el rango en que se ubica el índice 
    
        */
    
        if(indice<=13) 
            return PintaCarta.TREBOL; 
        else if (indice<=26)
            return PintaCarta.PICA; 
        else if (indice<=39) 
            return PintaCarta.CORAZON; 
        else 
            return PintaCarta.DIAMANTE; 
    } 
    
    //CLASE EN DONDE SE MANEJA EL ENUMCIADO NombreCarta
    //para obtener el nombre de cada una
    public NombreCarta obtenerNombre() 
    { 
        //Obtiene el nombre que corresponde al número de la carta 
        int numero = indice % 13; 
        if (numero == 0) { 
            numero = 13; 
        } 
        return NombreCarta.values()[numero-1]; //En la del pdf esta sin el -1
    }
    
    
    
    
    /*COMIENZO PDF    
    El codigo usado aqui en adelante tiene diferencias con el 
    principal de la clase

    public void mostrarCarta(int x, int y, JPanel pnl, boolean tapada) 
    { 
        //Obtener el nombre del archivo de la carta 
        String nombreImagen= "/imagenes/CARTA" + String.valueOf(indice) + ".JPG";
        
        //Cargar la imagen en memoria 
        ImageIcon imagen = new ImageIcon(getClass().getResource(nombreImagen)); 
        
        
        //Crear Instancia Jlabel para mostrar la imagen 
        JLabel lblCarta = new JLabel(imagen); 
        
        //Llevar la imagen a la etiqueta
        lblCarta.setIcon(imagen);
        
        //Definir posicion y dimensiones de la imagen 
        lblCarta.setBounds(x, y, 
                x + imagen.getIconWidth(), 
                y + imagen.getIconHeight()); 
        
        
        String nombreImagen; 
        
        //Obtener el nombre del archivo de la carta 
        if(tapada) 
            nombreImagen = "/imagenes/Tapada.jpg"; 
        else 
            nombreImagen = "/imagenes/CARTA" + String.valueOf(indice) + ".JPG";
        
        //Cargar la imagen en memoria 
        ImageIcon imagen = new ImageIcon(getClass().getResource(nombreImagen)); 
        
        //Crear Instancia Jlabel para mostrar la imagen 
        JLabel lblCarta = new JLabel(imagen); 
        
        //Definir posicion y dimensiones de la imagen 
        lblCarta.setBounds(x, y, 
                x + imagen.getIconWidth(), 
                y + imagen.getIconHeight()); 
        
        //Mostrar la carta en la ventana 
        pnl.add(lblCarta); 
        
        
        
    }
FINAL DE CODIGO PDF */
       
}