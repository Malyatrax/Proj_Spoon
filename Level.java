package missionSpoon;

import java.awt.*;



public class Levels {

	static int tile = 8;

	public boolean[][] freeSpaces = new boolean[10][10];

	public int currentLevel = 0;

	public Image background;

	

	public static boolean checkIfFree(int x,int y){

		return freeSpaces[x][y];

	}

	public static void updateSpaces(int oldX, int oldY, int newY, int newX){

		freeSpaces[oldX][oldY] = true;

		freeSpaces[newX][newY] = false;

	}

	public static Levels(String image, boolean[][] space){

		background = getImage(image);

		for(int i =0;i<10;i++){

			for(int n =0; n<10;n++){

				freeSpaces[i][n] = space[i][n];

			}

	}

	

}



