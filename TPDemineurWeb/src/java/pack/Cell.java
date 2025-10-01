package pack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author e2500138
 */


public class Cell {
    public enum CellState {
    HIDDEN,    // Non cliquée
    REVEALED,  // Cliquée
    FLAGGED    // Drapeau posé
    }
    
    private boolean hasBomb;
    private CellState state;
    private int bombsAround;
    
    public Cell() {
        this.hasBomb = false;
        this.state = CellState.HIDDEN;
        this.bombsAround = 0;
    }
    
    // Getters et setters
    public boolean hasBomb() {
        return hasBomb;
    }

    public void setBomb(boolean hasBomb) {
        this.hasBomb = hasBomb;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public int getBombsAround() {
        return bombsAround;
    }

    public void setBombsAround(int bombsAround) {
        this.bombsAround = bombsAround;
    }
    
    
    
}
