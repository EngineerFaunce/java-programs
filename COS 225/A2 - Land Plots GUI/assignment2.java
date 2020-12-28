// William Faunce
// This program generates a field using javaFX to display plots

package wFaunceA2;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class assignment2 extends Application {
	Rectangle2D[] plots = new Rectangle2D[6]; // creates an array for the plots
	Random ran = new Random(); // used as a randomizer for plot points

	@Override
	public void start(Stage primaryStage) {
		Rectangle2D[] plots = new Rectangle2D[6]; // creates an array for the plots
		Random ran = new Random(); // used as a randomizer for plot points
		int count = 0; // counter

		Boolean bool = true;
		while (bool) { // while loop that fills the array with plots and ensures no overlap
			for (int a = 0; a < 6; a++) {
				plots[a] = new Rectangle2D((double) (ran.nextInt(180)), (double) (ran.nextInt(180)), 20.0, 20.0);
			}
			count = 0;
			for (int u = 0; u < 6; u++) { // nested for loop to ensure that there is no plots overlapping
				for (int i = 0; i < 6; i++) {
					if (plots[u] == plots[i])
						;
					else if ((plots[u].overlaps(plots[i])) || (plots[u].contains(plots[i])))
						count++;
				}
			}
			if (count == 0) // if statement that breaks out of the while loop
				bool = false;
		}

		Pane pane = new Pane(); // creates a new grid pane

		ImagePattern grass = new ImagePattern(new Image("grass.jpg")); // grass texture for the field

		Rectangle field = new Rectangle(); // rectangle with a grass texture fill and brown outline
		field.setWidth(200);
		field.setHeight(200);
		field.setX(100);
		field.setY(70);
		field.setFill(grass);
		field.setStroke(Color.BROWN);
		field.setStrokeWidth(3);

		Text name = new Text(100, 300, "Field Plot by William Faunce"); // title of field plot followed by each plot's coordinates
		name.setFont(new Font("Comic Sans MS", 16)); // changes font and font size
		Text plot1 = new Text(115, 320, plots[0].getPoint().toString());
		plot1.setFont(new Font("Comic Sans MS", 12));
		Text plot2 = new Text(115, 340, plots[1].getPoint().toString());
		plot2.setFont(new Font("Comic Sans MS", 12));
		Text plot3 = new Text(115, 360, plots[2].getPoint().toString());
		plot3.setFont(new Font("Comic Sans MS", 12));
		Text plot4 = new Text(115, 380, plots[3].getPoint().toString());
		plot4.setFont(new Font("Comic Sans MS", 12));
		Text plot5 = new Text(115, 400, plots[4].getPoint().toString());
		plot5.setFont(new Font("Comic Sans MS", 12));
		Text plot6 = new Text(115, 420, plots[5].getPoint().toString());
		plot6.setFont(new Font("Comic Sans MS", 12));

		Rectangle p1 = new Rectangle(); // plot 1 square in the field
		p1.setWidth(20);
		p1.setHeight(20);
		p1.setX(plots[0].getPoint().getX() + 100);
		p1.setY(plots[0].getPoint().getY() + 70);
		p1.setFill(Color.WHITE);

		Rectangle sp1 = new Rectangle(); // small plot 1 square near the coordinates
		sp1.setWidth(10);
		sp1.setHeight(10);
		sp1.setX(100);
		sp1.setY(311);
		sp1.setFill(Color.WHITE);
		sp1.setStroke(Color.BLACK);

		Rectangle p2 = new Rectangle(); // plot 2 square in the field
		p2.setWidth(20);
		p2.setHeight(20);
		p2.setX(plots[1].getPoint().getX() + 100);
		p2.setY(plots[1].getPoint().getY() + 70);
		p2.setFill(Color.RED);

		Rectangle sp2 = new Rectangle(); // small plot 2 square near the coordinates
		sp2.setWidth(10);
		sp2.setHeight(10);
		sp2.setX(100);
		sp2.setY(331);
		sp2.setFill(Color.RED);
		sp2.setStroke(Color.BLACK);

		Rectangle p3 = new Rectangle(); // plot 3 square in the field
		p3.setWidth(20);
		p3.setHeight(20);
		p3.setX(plots[2].getPoint().getX() + 100);
		p3.setY(plots[2].getPoint().getY() + 70);
		p3.setFill(Color.BLUE);

		Rectangle sp3 = new Rectangle(); // small plot 3 square near the coordinates
		sp3.setWidth(10);
		sp3.setHeight(10);
		sp3.setX(100);
		sp3.setY(351);
		sp3.setFill(Color.BLUE);
		sp3.setStroke(Color.BLACK);

		Rectangle p4 = new Rectangle(); // plot 4 square in the field
		p4.setWidth(20);
		p4.setHeight(20);
		p4.setX(plots[3].getPoint().getX() + 100);
		p4.setY(plots[3].getPoint().getY() + 70);
		p4.setFill(Color.PINK);

		Rectangle sp4 = new Rectangle(); // small plot 4 square near the coordinates
		sp4.setWidth(10);
		sp4.setHeight(10);
		sp4.setX(100);
		sp4.setY(371);
		sp4.setFill(Color.PINK);
		sp4.setStroke(Color.BLACK);

		Rectangle p5 = new Rectangle(); // plot 5 square in the field
		p5.setWidth(20);
		p5.setHeight(20);
		p5.setX(plots[4].getPoint().getX() + 100);
		p5.setY(plots[4].getPoint().getY() + 70);
		p5.setFill(Color.ORANGE);

		Rectangle sp5 = new Rectangle(); // small plot 5 square near the coordinates
		sp5.setWidth(10);
		sp5.setHeight(10);
		sp5.setX(100);
		sp5.setY(391);
		sp5.setFill(Color.ORANGE);
		sp5.setStroke(Color.BLACK);

		Rectangle p6 = new Rectangle(); // plot 6 square in the field
		p6.setWidth(20);
		p6.setHeight(20);
		p6.setX(plots[5].getPoint().getX() + 100);
		p6.setY(plots[5].getPoint().getY() + 70);
		p6.setFill(Color.YELLOW);

		Rectangle sp6 = new Rectangle(); // small plot 6 square near the coordinates
		sp6.setWidth(10);
		sp6.setHeight(10);
		sp6.setX(100);
		sp6.setY(411);
		sp6.setFill(Color.YELLOW);
		sp6.setStroke(Color.BLACK);
		// creates a group to store all the nodes
		Group group = new Group(name, field, plot1, p1, sp1, plot2, p2, sp2, plot3, p3, sp3, plot4, p4, sp4, plot5, p5,
				sp5, plot6, p6, sp6);
		pane.getChildren().add(group); // adds the group to the pane

		Scene scene = new Scene(pane, 400, 500); // creates a 400x500 scene that the user will look at
		primaryStage.setTitle("Assignment 2"); // title of the application
		primaryStage.setScene(scene); // adds the scene to the stage
		primaryStage.show(); // displays the application
	}

	public static void main(String[] args) { // launches application
		Application.launch(args);
	}

}
