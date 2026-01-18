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


test5


{



public static void main(String[] args) throws IOException



{

// Window Code

JFrame window = new JFrame("The ultimate tanks game");

window.setSize(640, 480);// 480p, 4:3

window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Close window when x is pressed



// Graphics container

// Needed to set the layout for your graphics

final JPanel container = new JPanel();

container.setBackground(Color.CYAN);// Set background colour



// get input context of the window to listen for events

//

//

//

//

//

//

//



// Layout

// GridBagLayout layout = new GridBagLayout();// Layout used to set ui element

// alignments

// GridBagConstraints constraints = new GridBagConstraints();// Used for spacing

// and location



// take out the ball

BufferedImage spriteSheet = ImageIO.read(new File("BasicArkanoidPack.png"));



// Extract sprite

BufferedImage subImageBall = spriteSheet.getSubimage(0, 80, 25, 24);



// Convert to ImageIcon if needed (e.g. for JLabel)

ImageIcon spriteBall = new ImageIcon(subImageBall);// ball



// take out the bat

BufferedImage spriteSheet2 = ImageIO.read(new File("BasicArkanoidPack.png"));



// Extract sprite

BufferedImage subImageBat = spriteSheet2.getSubimage(183, 111, 97, 25);



// Convert to ImageIcon if needed (e.g. for JLabel)

ImageIcon spriteBat = new ImageIcon(subImageBat);



// take out the bat

BufferedImage spriteSheet3 = ImageIO.read(new File("BasicArkanoidPack.png"));



// Extract sprite

BufferedImage subImageBlock = spriteSheet3.getSubimage(71, 0, 66, 32);



// Convert to ImageIcon if needed (e.g. for JLabel)

ImageIcon spriteBlock = new ImageIcon(subImageBlock);

// take out the bat

BufferedImage spriteSheet4 = ImageIO.read(new File("BasicArkanoidPack.png"));



// Extract sprite

BufferedImage subImageBlock2 = spriteSheet4.getSubimage(144, 0, 65, 32);



// Convert to ImageIcon if needed (e.g. for JLabel)

ImageIcon spriteBlock2 = new ImageIcon(subImageBlock2);



// Image

// final ImageIcon light = new ImageIcon("Light_On_Small.png"); // Light on

// final ImageIcon lightOff = new ImageIcon("Light_Off_Small.png"); // Light off

final ImageIcon sprites = new ImageIcon("BasicArkanoidPack.png");

// final JLabel imageLabel = new JLabel(lightOff); // Set this label to a

// picture

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

// On/Off button

final JButton onOffButton = new JButton("Click On");

// This adds function to your button

// You can make an actionlistener yourself outside of the program and add that

// if you like

// onOffButton.addActionListener(new ActionListener() {

// boolean isOn = false;

//

// @Override

// // Default procedure used when the button is pressed

// public void actionPerformed(ActionEvent e) {

// // Logic to change the image of the label

// if (isOn) {

// isOn = false;

// onOffButton.setText("Click On");

// imageLabel.setIcon(lightOff);

// container.setBackground(Color.CYAN);

// } else {

// isOn = true;

// onOffButton.setText("Click Off");

// imageLabel.setIcon(light);

// container.setBackground(Color.RED);

// }

// }

// });



// Add Components

container.setLayout(null); // set layout to grid layout

// container.add(imageLabel);

// container.add(spritesLabel);

container.add(Ball);// add the ball to the window

container.add(Bat);// add the bat to the window

//container.add(Block);// add the block to he window

//container.add(Block2);// add the second block to the widow

container.setFocusable(true);// lets the input to go to the window when selected

container.requestFocusInWindow();// Selects the windows



// constraints.gridy = 1; // put the button image beneath the light image, 0 =

// light, 1 = button

// insets(top, left, bottom, right);

// constraints.insets = new Insets(25, 0, 0, 0);// Set padding above the button

// by 25 pixels

// container.add(onOffButton, constraints);

window.add(container);

final int BAT_SPEED = 10;



JRootPane rootPane = window.getRootPane();

InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);

ActionMap actionMap = rootPane.getActionMap();



// Move Left (A)

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



// Move Right (D)

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





// Do this at the end

window.setVisible(true);// This needs to be at the end

window.setSize(600, 480);

window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

window.setResizable(false); // lock window size











//

//

//

//



}

}


