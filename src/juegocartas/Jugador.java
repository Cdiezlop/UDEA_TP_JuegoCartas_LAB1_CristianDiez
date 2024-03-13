//Realizado por: Cristian David Diez Lopez CC: 1036967493
package juegocartas;

import java.util.*; 
import javax.swing.*; 


public class Jugador { 
    
    private int TOTALCARTAS = 10;
    private int MARGEN =20;
    private int DISTANCIA=50;
    
    private Carta[] cartas = new Carta[TOTALCARTAS];
    
    private Random r=new Random(); 
    

    
    /*INICIO CODIGO DE LA CLASE CON EL PROFESOR
    public void repartir() 
    {
        //Instanciar las 10 cartas 
        for(int i=0; i < TOTALCARTAS; i++) {
            cartas[i]=new Carta(r);
        }
    }
    
        FIN CODIGO DE LA CLASE CON EL PROFESOR*/ 
    
     //METODO REPARTIR MAS COMPLETO TENIENDO EN CUENTA EL ORDEN.    
    public void repartir() {
        // Instanciar las 10 cartas
        for (int i = 0; i < TOTALCARTAS; i++) {
            cartas[i] = new Carta(r);
        }

        // Ordenar las cartas sin usar Arrays.sort()
        for (int i = 0; i < TOTALCARTAS - 1; i++) {
            for (int j = 0; j < TOTALCARTAS - i - 1; j++) {
                if (cartas[j].obtenerPinta().ordinal() > cartas[j + 1].obtenerPinta().ordinal()
                        || (cartas[j].obtenerPinta().ordinal() == cartas[j + 1].obtenerPinta().ordinal()
                        && cartas[j].obtenerNombre().ordinal() > cartas[j + 1].obtenerNombre().ordinal())) {
                    // Intercambiar las cartas
                    Carta temp = cartas[j];
                    cartas[j] = cartas[j + 1];
                    cartas[j + 1] = temp;
                }
            }
        }
    }
    
        public void mostrar(JPanel pnl) 
    { 
        //Limpiar el panel 
        pnl.removeAll(); 

        int x =MARGEN;
        //Mostrar cada carta 
        for(Carta c: cartas) {
            c.mostrarcarta(pnl, x, MARGEN);
            x+=DISTANCIA;
        }
        
        
        //Redibujar el panel 
        pnl.repaint();
    } 
   
        
    
    public String obtenerGrupos() {
        String mensaje = "No se encontraron grupos";
        int[] contadores = new int[NombreCarta.values().length];
        for(Carta c: cartas) {
            contadores[c.obtenerNombre().ordinal()]++;
        }
        int totalGrupos = 0;
        for(int c : contadores){
            if (c>=2){
                totalGrupos++;
            }
        if(totalGrupos > 0) {
            mensaje="Los grupos encontrados son los siguientes:\n";
            for(int i=0 ;i<contadores.length;i++){
                if(contadores[i]>=2){
                    mensaje+=Grupo.values()[contadores[i]]+ " de "+NombreCarta.values()[i]+"\n";
                    
                }
            }
        }
        }
        
        
        return mensaje;
    }
    
    //METODO PARA CALCULAR EL PUNTAJE
    public int calcularPuntajeSinGrupos() {
        int puntaje = 0;
        int[] contadores = new int[NombreCarta.values().length];

        // Contar las cartas para identificar grupos
        for (Carta c : cartas) {
            contadores[c.obtenerNombre().ordinal()]++;
        }

        // Calcular el puntaje sin considerar los grupos
        for (Carta c : cartas) {
            // Si la carta no forma parte de un grupo, se suma su valor al puntaje
            if (contadores[c.obtenerNombre().ordinal()] <= 1) {
                int valorCarta = c.obtenerNombre().ordinal() + 1; // Obtener el valor numérico de la carta

                // Si es "Ace", "Jack", "Queen" o "King", sumar 10
                if (valorCarta == 1 || valorCarta >= 11) {
                    puntaje += 10;
                } else { // Si no, sumar su valor directamente
                    puntaje += valorCarta;
                }
            }
        }

    return puntaje;
}
 
    
public String obtenerEscaleras() {
    String resultadoEscalera = "No se encontraron escaleras de la misma pinta";

    // Mapa para almacenar las cartas por pinta
    Map<PintaCarta, List<Carta>> cartasPorPinta = new HashMap<>();
    for (Carta carta : cartas) {
        PintaCarta pinta = carta.obtenerPinta();
        if (!cartasPorPinta.containsKey(pinta)) {
            cartasPorPinta.put(pinta, new ArrayList<>());
        }
        cartasPorPinta.get(pinta).add(carta);
    }

    // Buscar escaleras en cada pinta
    for (List<Carta> cartasPinta : cartasPorPinta.values()) {
        Collections.sort(cartasPinta, Comparator.comparingInt(c -> c.obtenerNombre().ordinal()));

        List<Carta> escaleraActual = new ArrayList<>();
        for (int i = 0; i < cartasPinta.size() - 2; i++) {
            escaleraActual.clear();
            escaleraActual.add(cartasPinta.get(i));
            for (int j = i + 1; j < cartasPinta.size(); j++) {
                if (cartasPinta.get(j).obtenerNombre().ordinal() - cartasPinta.get(j - 1).obtenerNombre().ordinal() == 1) {
                    escaleraActual.add(cartasPinta.get(j));
                    if (escaleraActual.size() >= 3) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if (escaleraActual.size() >= 3) {
                resultadoEscalera = "Escalera de " + cartasPinta.get(0).obtenerPinta() + ":\n";
                for (Carta carta : escaleraActual) {
                    resultadoEscalera += carta.obtenerNombre() + ", ";
                }
                resultadoEscalera = resultadoEscalera.substring(0, resultadoEscalera.length() - 2); // Eliminar la coma extra al final
                resultadoEscalera += "\n";
                break; // Terminar la búsqueda en esta pinta una vez encontrada una escalera
            }
        }
        if (escaleraActual.size() >= 3) {
            break; // Terminar la búsqueda de escaleras una vez encontrada una escalera en cualquier pinta
        }
    }

    return resultadoEscalera;
}



        
    /*CODIGO DEL PDF
    private Random r; 
    private Carta[] cartas; 
    
    private Figura[] figuras; 
    private NombreCarta[] cartasFigura; 
    
    public Jugador() 
    { 
        //Iniciar el generador de numeros aleatorios 
        r=new Random(); 
    }
    
    public void repartir() 
    {
        
        //Instanciar las 10 cartas 
        cartas=new Carta[10]; 
        for(int i=0;i<10;i++) 
            cartas[i]=new Carta(r); 
    }
    
    
    
    public void mostrar(JPanel pnl, boolean tapada) 
    { 
        //Limpiar el panel 
        pnl.removeAll(); 

        //Mostrar cada carta 
        for(int i=0;i<TOTALCARTAS;i++) 
            cartas[i].mostrarCarta(5+i*40, 5, pnl, tapada); 
        
        //Redibujar el panel 
        pnl.repaint();
    } 
    
    
    public String obtenerFiguras() 
    { 

        //Iniciar la estructura para almacenar las figuras 
        figuras=null; 

        //Declarar los contadores de cada nombre de carta 
        int[] contadores=new int[13]; 


        //Recorrer cada carta e incrementar el contador 
        //del respectivo nombre de carta 
        for(int i=0;i<10;i++) 
            contadores[cartas[i].obtenerNombre().ordinal()-1]++; 


        //Obtener cuantas figuras se encontraron 
        int totalFiguras=0; 
        for(int i=0;i<13;i++) 
            if(contadores[i]>=3) 
                totalFiguras++; 

        //Instanciar las figuras 
        if(totalFiguras>0) 
        { 
            figuras=new Figura[totalFiguras]; 
            cartasFigura=new NombreCarta[totalFiguras]; 
            totalFiguras=0; 
            for(int i=0;i<13;i++) 
                if(contadores[i]>=3) 
                { 
                    figuras[totalFiguras]=Figura.values()[contadores[i]]; 
                    cartasFigura[totalFiguras]=NombreCarta.values()[i+1]; 
                    totalFiguras++; 
                } 
            
        } 
        
        String mensaje=""; 
        if(figuras==null) 
            mensaje="No hay figuras"; 
        else 
        { 
            mensaje="El jugador tiene las siguientes figuras:\n"; 
            for(int i=0;i<figuras.length;i++) 
            mensaje+=figuras[i].name()+ 
                        " de "+cartasFigura[i].toString()+"\n"; 
        } 
        return mensaje; 
    }//obtenerFiguras()
    
FINAL CODIGO PDF*/

}//Clase


