import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class RealFinalProject


{



public static void main(String[] args) throws IOException


{


JFrame window = new JFrame("The ultimate tanks game");
window.setSize(600, 480);
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setResizable(false); // lock window size


final JPanel container = new JPanel();
container.setBackground(Color.CYAN);// Set background colour

BufferedImage spriteSheet = ImageIO.read(new File("BasicArkanoidPack.png"));

BufferedImage subImageBall = spriteSheet.getSubimage(0, 80, 25, 24);

ImageIcon spriteBall = new ImageIcon(subImageBall);// ball


//BufferedImage spriteSheet2 = ImageIO.read(new File("BasicArkanoidPack.png"));

BufferedImage subImageBat = spriteSheet.getSubimage(183, 111, 97, 25);

ImageIcon spriteBat = new ImageIcon(subImageBat);


//BufferedImage spriteSheet3 = ImageIO.read(new File("BasicArkanoidPack.png"));


BufferedImage subImageBlock = spriteSheet.getSubimage(71, 0, 66, 32);

ImageIcon spriteBlock = new ImageIcon(subImageBlock);


//BufferedImage spriteSheet4 = ImageIO.read(new File("BasicArkanoidPack.png"));


BufferedImage subImageBlock2 = spriteSheet.getSubimage(144, 0, 65, 32);

ImageIcon spriteBlock2 = new ImageIcon(subImageBlock2);


final ImageIcon sprites = new ImageIcon("BasicArkanoidPack.png");

final JLabel spritesLabel = new JLabel(sprites);

final JLabel Ball = new JLabel(spriteBall);

JOptionPane.showMessageDialog(null, Ball);

final JLabel Bat = new JLabel(spriteBat);

JOptionPane.showMessageDialog(null, Bat);

final JLabel Block = new JLabel(spriteBlock);

JOptionPane.showMessageDialog(null, Block);



final JLabel Block2 = new JLabel(spriteBlock2);

JOptionPane.showMessageDialog(null, Block2);



Ball.setBounds(320 - 12, 240, 25, 24); // x, y, width, height

Bat.setBounds(320 - 48, 480 - 67, 97, 25);// x, y, width, height

Block.setBounds(320 - 33, 60, 66, 32);// x, y, width, height


final JButton onOffButton = new JButton("Click On");


container.setLayout(null); // set layout to grid layout

container.add(Ball);// add the ball to the window

container.add(Bat);// add the bat to the window

container.setFocusable(true);// lets the input to go to the window when selected

container.requestFocusInWindow();// Selects the windows

window.add(container);

final int BAT_SPEED = 10;


JRootPane rootPane = window.getRootPane();

InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

ActionMap actionMap = rootPane.getActionMap();


inputMap.put(KeyStroke.getKeyStroke("pressed A"), "moveLeft");

actionMap.put("moveLeft", new AbstractAction() {

@Override

public void actionPerformed(ActionEvent e) {

int x = Bat.getX();

if (x > 0) {

Bat.setLocation(x - BAT_SPEED, Bat.getY());

}

}

});


inputMap.put(KeyStroke.getKeyStroke("pressed D"), "moveRight");

actionMap.put("moveRight", new AbstractAction() {

@Override

public void actionPerformed(ActionEvent e) {

int x = Bat.getX();

int maxX = container.getWidth() - Bat.getWidth();

if (x < maxX) {

Bat.setLocation(x + BAT_SPEED, Bat.getY());

}

}

});



int blockWidth = 66;

int blockHeight = 32;



int rows = 4;

int cols = 8;



int startX = 10;

int startY = 10;

int gap = 5;



for (int row = 0; row < rows; row++) {

for (int col = 0; col < cols; col++) {



JLabel block;



// Alternate block types

if ((row + col) % 2 == 0) {

block = new JLabel(spriteBlock);

} else {

block = new JLabel(spriteBlock2);

}



int x = startX + col * (blockWidth + gap);

int y = startY + row * (blockHeight + gap);



block.setBounds(x, y, blockWidth, blockHeight);

container.add(block);

}

}


window.setVisible(true);// This needs to be at the end





}

}


