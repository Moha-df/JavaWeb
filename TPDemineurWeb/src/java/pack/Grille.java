package pack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Random;


/**
 *
 * @author e2500138
 */
public class Grille {
    
    private Cell[][] grid;
    private static final int SIZE = 10;

    
    public Grille(){
        
        Random rand = new Random();
        grid = new Cell[SIZE][SIZE];
        
        int randomInt;
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grid[i][j] = new Cell();
                // 20% de chance d’avoir une bombe
                if (rand.nextInt(100) < 20) {
                    grid[i][j].setBomb(true);
                }
            }
        }
        
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int bombsAround = countBombsAround(i, j);
                grid[i][j].setBombsAround(bombsAround);
            }
        }
        
        
        
    }
    
    private int countBombsAround(int row, int col) {
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < SIZE && j >= 0 && j < SIZE) {
                    if (grid[i][j].hasBomb()) {
                        count++;
                    }
                }
            }
        }
        // Ne pas compter la case elle-même si elle a une bombe
        if (grid[row][col].hasBomb()) {
            count--;
        }
        return count;
    }
    
    // Méthodes pour accéder à une cellule, modifier son état, etc.
    public Cell getCell(int row, int col) {
        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE) {
            return grid[row][col];
        } else {
            throw new IndexOutOfBoundsException("Index hors limites");
        }
    }
    
    public Cell[][] getGrid() {
        return grid;
    }
    /*
    public void setValue(int row, int col, int value) {
        if (row >= 0 && row < 10 && col >= 0 && col < 10) {
            Cell[row][col] = value;
        } else {
            throw new IndexOutOfBoundsException("Index hors limites");
        }
    }
    
    public int getValue(int row, int col) {
        if (row >= 0 && row < 10 && col >= 0 && col < 10) {
            return grid[row][col];
        } else {
            throw new IndexOutOfBoundsException("Index hors limites");
        }
    }
    */
    
}
