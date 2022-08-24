package mainPack;



/**
 *
 * @author hlopez
 */
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
//import org.jpl7.Query;
//import org.jpl7.Term;
import org.jpl7.Query;
import org.jpl7.Term;

/**
 * Se encarga de gestionar la consulta de las bases de conocimiento.
 */
public class conexion {

    String consulta;
    Query q;
    private Map<String, Term> solucion;

    public conexion(String[] name) {
        for (String f : name) {
            consulta = "consult('" + f + "')";
            q = new Query(consulta);
            if (!q.hasSolution()) {
                JOptionPane.showMessageDialog(null, "No encuentra la base de conocimiento:" + f, "ERROR", JOptionPane.ERROR);
            }
        }
    }
    public void iniciarTablero(){
        consulta = "iniciarTablero";
        q = new Query(consulta);
        q.allSolutions();
        
    }
    public String[] colocarN() {
        consulta = "fichasn(_L),member(pair(X,Y),_L)";
        q = new Query(consulta);
        int tam = q.allSolutions().length;
        String resultado[] = new String[tam+1];

        if (!q.hasSolution()) {
            //resultado[1] += "No se encontraron\n";
        } else {
            //ciclo para concatenar todas las soluciones de la consulta
            int i=1;
            while (q.hasMoreSolutions()) {
                solucion = q.nextSolution();
                resultado[i] = solucion.get("X")+""+solucion.get("Y") +"";
                //System.out.println(resultado[i]);
                i++;
            }
        }
        
        return resultado;
    }
    public String[] colocarB() throws InterruptedException {
        consulta = "fichasb(_L),member(pair(X,Y),_L)";
        q = new Query(consulta);
        int tam = q.allSolutions().length;
        String resultado[] = new String[tam+1];

        if (!q.hasSolution()) {
            //resultado[1] += "No se encontraron\n";
        } else {
            //ciclo para concatenar todas las soluciones de la consulta
            int i=1;
            while (q.hasMoreSolutions()) {
                solucion = q.nextSolution();
                resultado[i] = solucion.get("X")+ "" +solucion.get("Y") +"";
                //System.out.println(resultado[i]);
                i++;
            }
        }
        //TimeUnit.SECONDS.sleep(1);
        return resultado;
    }
    public String[] movB(String x,String y) throws InterruptedException{
        consulta = "movimientoB("+x+","+y+")";
        q = new Query(consulta);
        q.allSolutions();
        //Si se puede voltear Izq-Arr
        consulta = "comienzoVolteoLUN("+x+","+y+")";
        q = new Query(consulta);
        q.allSolutions();
        //Si se puede voltear Arr
        consulta = "comienzoVolteoUN("+x+","+y+")";
        q = new Query(consulta);
        q.allSolutions();
        //Si se puede voltear Der-Arr
        consulta = "comienzoVolteoRUN("+x+","+y+")";
        q = new Query(consulta);
        q.allSolutions();
        //Si se puede voltear Der
        consulta = "comienzoVolteoRN("+x+","+y+")";
        q = new Query(consulta);
        q.allSolutions();
        //Si se puede voltear Izq
        consulta = "comienzoVolteoLN("+x+","+y+")";
        q = new Query(consulta);
        q.allSolutions();
        //Si se puede voltear Izq-Aba
        consulta = "comienzoVolteoLDN("+x+","+y+")";
        q = new Query(consulta);
        q.allSolutions();
        //Si se puede voltear Der-Aba
        consulta = "comienzoVolteoRDN("+x+","+y+")";
        q = new Query(consulta);
        q.allSolutions();
        //Si se puede voltear Aba
        consulta = "comienzoVolteoDN("+x+","+y+")";
        q = new Query(consulta);
        q.allSolutions();
        return colocarB();
        
    }
    public String[] movN(String x,String y){
        consulta = "movimientoN("+x+","+y+")";
        q = new Query(consulta);
        q.allSolutions();
        //Si se puede voltear Izq-Arr
        consulta = "comienzoVolteoLUB("+x+","+y+")";
        q = new Query(consulta);
        q.allSolutions();
        //Si se puede voltear Arr
        consulta = "comienzoVolteoUB("+x+","+y+")";
        q = new Query(consulta);
        q.allSolutions();
        //Si se puede voltear Der-Arr
        consulta = "comienzoVolteoRUB("+x+","+y+")";
        q = new Query(consulta);
        q.allSolutions();
        //Si se puede voltear Der
        consulta = "comienzoVolteoRB("+x+","+y+")";
        q = new Query(consulta);
        q.allSolutions();
        //Si se puede voltear Izq
        consulta = "comienzoVolteoLB("+x+","+y+")";
        q = new Query(consulta);
        q.allSolutions();
        //Si se puede voltear Izq-Aba
        consulta = "comienzoVolteoLDB("+x+","+y+")";
        q = new Query(consulta);
        q.allSolutions();
        //Si se puede voltear Der-Aba
        consulta = "comienzoVolteoRDB("+x+","+y+")";
        q = new Query(consulta);
        q.allSolutions();
        //Si se puede voltear Aba
        consulta = "comienzoVolteoDB("+x+","+y+")";
        q = new Query(consulta);
        q.allSolutions();        
        return colocarN();
    }
    public boolean validMovN(String x,String y){
        consulta = "validoN("+x+","+y+")";
        q = new Query(consulta);
        //System.out.println(q.hasSolution());
        return q.hasSolution();
    }
    public boolean validMovB(String x,String y){
        consulta = "validoB("+x+","+y+")";
        q = new Query(consulta);
        //System.out.println(q.hasSolution());
        return q.hasSolution();
    }
    public int cantNegras(){
        consulta = "cantNegras(X)";
        q = new Query(consulta);
        q.allSolutions();
        if(q.hasMoreSolutions()){
            solucion = q.nextSolution();
            return Integer.parseInt(solucion.get("X")+"");
        }else{
            return 0;
        }
    }
    public int cantBlancas(){
        consulta = "cantBlancas(X)";
        q = new Query(consulta);
        q.allSolutions();
        if(q.hasMoreSolutions()){
            solucion = q.nextSolution();
            return Integer.parseInt(solucion.get("X")+"");
        }else{
            return 0;
        }
    }
    public boolean finJuego(){
        consulta = "findeljuego";
        q = new Query(consulta);
        return q.hasSolution();
    }
    public boolean cantMovsBlancos(){
       consulta = "all_movesB(L)";
       q = new Query(consulta);
       //System.out.println(q.hasSolution());
       return q.hasSolution();
    }
    public boolean cantMovsNegros(){
       consulta = "all_movesN(L)";
       q = new Query(consulta);
        
       return q.hasSolution(); 
    }
    public String jugadaIAB() throws InterruptedException{
        consulta = "juegaIAB(X,Y)";
        q = new Query(consulta);
        //q.allSolutions();
        String x="";
        String y="";
        if(q.hasMoreSolutions()){
            solucion = q.nextSolution();
            x = solucion.get("X")+"";
            y = solucion.get("Y")+"";
            //System.out.println(""+x+" "+y);
        }
        return x+","+y;  
    }
    public String jugadaIAN() throws InterruptedException{
        consulta = "juegaIAN(X,Y)";
        q = new Query(consulta);
        //q.allSolutions();
        String x="";
        String y="";
        if(q.hasMoreSolutions()){
            solucion = q.nextSolution();
            x = solucion.get("X")+"";
            y = solucion.get("Y")+"";
            //System.out.println(""+x+" "+y);
        }
        return x+","+y;  
    }
    public void limpiarTablero(){
        consulta = "retract(pair(Z,X,Y))";
        q = new Query(consulta);
        q.allSolutions();
    }
    
}
