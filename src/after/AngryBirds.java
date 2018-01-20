package after;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import after.action.BirdAction;
import after.background.Sling;
import after.background.Stage;
import after.items.Bird;
import after.items.Pig;
import after.utils.Point;

public class AngryBirds extends Panel implements Runnable, MouseListener, MouseMotionListener {                  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1612609160549826721L;

	Stage stage;
    
    Bird currentBird;
    Pig currentPig;
    Sling slingshot;
    BirdAction birdAction;
    
    int score = 0;
    
    Point mousePos;                         // position de la souris lors de la sélection
    boolean gameOver;                           // vrai lorsque le joueur a touché un bord ou le cochon
    boolean selecting;                          // vrai lorsque le joueur sélectionne l'angle et la vitesse
    Image buffer;                               // image pour le rendu hors écran

    // constructeur
    public AngryBirds() {
        addMouseListener(this);
        addMouseMotionListener(this);
        stage = new Stage();
        birdAction = new BirdAction(stage.getGravity());
        init();
        new Thread(this).start();
    }

  
    
    // ----- Controller --------

    void init() {
        gameOver = false;
        selecting = true;

        stage.init(score);
        
        currentBird = stage.getBird();
        currentPig  = stage.getPig();
        
        slingshot = stage.getSlingshot();
        
        mousePos     = new Point();
        
        stage.setMessage("Choisissez l'angle et la vitesse.");
    }
    
    // boucle qui calcule la position de l'oiseau en vol, effectue l'affichage et teste les conditions de victoire
    public void run() {
        while(true) {
            // un pas de simulation toutes les 10ms
            try { Thread.currentThread().sleep(10); } catch(InterruptedException e) { }

            if(!gameOver && !selecting) {
            	birdAction.birdMoving(currentBird);
            	
                // conditions de victoire
                if(currentBird.hitSomething(currentPig.getPigPos())) {
                    stop();
                    score++;
                    stage.setMessage("Gagné : cliquez pour recommencer.");
                } else if(currentBird.hasStopped()) {
                    stop();
                    stage.setMessage("Perdu : cliquez pour recommencer.");
                }

                // redessine
                repaint();
            }
        }
    }

    // fin de partie
    void stop() {
    	currentBird.setBirdVelocity(new Point());
    	
        gameOver = true;
    }


    // -------- Graphics -----------------
    
    // taille de la fenêtre
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    // dessine le contenu de l'écran dans un buffer puis copie le buffer à l'écran
    public void paint(Graphics g2) {
        if(buffer == null) buffer = createImage(800, 600);
        Graphics2D g = (Graphics2D) buffer.getGraphics();

        stage.paint(g, getWidth(), getHeight());

        if(selecting) {
        	slingshot.drawRubber(g, currentBird.getBirdPos(), mousePos);
        }
        
        currentBird.paint(g);
        currentPig.paint(g);

        // affichage à l'écran sans scintillement
        g2.drawImage(buffer, 0, 0, null);
    }
    
    // évite les scintillements
    public void update(Graphics g) {
        paint(g);
    }
    
    // -------- EVENTS --------------------
    public void mouseClicked(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) { }
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) {
        if(gameOver) {
            init();
        } else if(selecting) {
        	
        	currentBird.setBirdVelocity( new Point(
        			(currentBird.getBirdPos().getPx() - mousePos.getPx()) / 20.0,
        			(currentBird.getBirdPos().getPy() - mousePos.getPy()) / 20.0)
        	);
       
            stage.setMessage("L'oiseau prend son envol");
            selecting = false;
        }
        repaint();
    }
    public void mouseDragged(MouseEvent e) { mouseMoved(e); }
    public void mouseMoved(MouseEvent e) { 
    	mousePos.setPx(e.getX());
    	mousePos.setPy(e.getY());
    	
        repaint();
    }

}