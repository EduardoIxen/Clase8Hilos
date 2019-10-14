
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Denis
 */
public class Hilo extends Thread {

    private JLabel Personaje;
    private JLabel Enemigo;
    private JPanel Arena;
    private boolean Caminar=true;

    public Hilo() {
    }

    public Hilo(JLabel Personaje, JLabel Enemigo, JPanel Arena) {
        this.Personaje = Personaje;
        this.Enemigo = Enemigo;
        this.Arena = Arena;
    }

    public Hilo(JLabel Personaje, JPanel Arena) {
        this.Personaje = Personaje;
        this.Arena = Arena;
    }

    public boolean isCaminar() {
        return Caminar;
    }

    public void setCaminar(boolean Caminar) {
        this.Caminar = Caminar;
    }
    

    @Override
    public void run() {
        while (Caminar) {
            try {
                if (Personaje.getX() < Arena.getWidth() - (Personaje.getWidth())) {
                    Personaje.setLocation(Personaje.getX() + 20, Personaje.getY());
                    System.out.println("Caminando");
                    Arena.repaint();
                    Thread.sleep(100);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public void DetenerHilo(){
        setCaminar(false);
    }
}
