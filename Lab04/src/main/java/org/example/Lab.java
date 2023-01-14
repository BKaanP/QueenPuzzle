package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Lab extends Application {

    private static List<List<Integer>> chessboard = new ArrayList<>();
    private static int column = 0;
    private static int numQueens = 0;

    public static void main(String[] args) {

        // Initializes the Matrix size X size
        initMat(13);
        insert(column);
        launch(args);
    }

    public static void initMat(int size) {
        for (int i = 0; i < size; i++) {
            chessboard.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                chessboard.get(i).add(0);
            }
        }
    }

    /**
     * Multiple checks for diagonal, row, column Queen threat
     * @param row
     * @param col
     * @return
     */
    public static boolean isSafe(int row, int col) {
        for (int i = 0; i < chessboard.size(); i++) {
            if (chessboard.get(row).get(i) == 1) {
                return false;
            }
        }
        // Check the column
        for (int i = 0; i < chessboard.size(); i++) {
            if (chessboard.get(i).get(col) == 1) {
                return false;
            }
        }
        // Check the diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (chessboard.get(i).get(j) == 1) {
                return false;
            }
        }
        for (int i = row, j = col; i < chessboard.size() && j >= 0; i++, j--) {
            if (chessboard.get(i).get(j) == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < chessboard.size(); i--, j++) {
            if (chessboard.get(i).get(j) == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i < chessboard.size() && j < chessboard.size(); i++, j++) {
            if (chessboard.get(i).get(j) == 1) {
                return false;
            }
        }

        return true;
    }

    /**
     * Recursive method that inserts '1' into the Matrix for possible Queen placements. Does until the maximum amount of Queens have been 'placed' (i.e. '1' in each column/row)
     * @param col
     * @return
     */
    public static boolean insert(int col) {
        if (col == chessboard.size()) {
            return true;
        }

        for (int i = 0; i < chessboard.size(); i++) {
            if (isSafe(i, col)) {
                chessboard.get(i).set(col, 1);
                if (insert(col + 1)) {
                    return true;
                }
                chessboard.get(i).set(col, 0);
            }
        }
        return false;
    }

    /**
     * A simple JavaFx application that displays a chessboard with Queen placements
     * @param primaryStage the primary stage for this application, onto which
     * the application scene can be set. The primary stage will be embedded in
     * the browser if the application was launched as an applet.
     * Applications may create other stages, if needed, but they will not be
     * primary stages and will not be embedded in the browser.
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        grid.setVgap(5);
        grid.setHgap(5);

        // Load the images of the black and white squares and the queen
        Image blackSquare = new Image("file:black_square.png");
        Image whiteSquare = new Image("file:white_square.png");
        Image queen = new Image("file:queen.png");


        // Create an image view for each cell in the chessboard
        for (int i = 0; i < chessboard.size(); i++) {
            for (int j = 0; j < chessboard.size(); j++) {
                ImageView cell = new ImageView();
                cell.setPreserveRatio(true);
                cell.setFitWidth(46);
                cell.setFitHeight(46);
                if ((i + j) % 2 == 0) {
                    cell.setImage(whiteSquare);
                } else {
                    cell.setImage(blackSquare);
                }

                if (chessboard.get(i).get(j) == 1) {
                    cell.setImage(queen);
                }
                GridPane.setHgrow(cell, javafx.scene.layout.Priority.ALWAYS);
                GridPane.setVgrow(cell, javafx.scene.layout.Priority.ALWAYS);
                grid.add(cell, j, i);
            }
        }


        Scene scene = new Scene(new Group(grid));
        primaryStage.setHeight(700);
        primaryStage.setWidth(700);
        primaryStage.setScene(scene);

        primaryStage.setTitle("N-Queens");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}