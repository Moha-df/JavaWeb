/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpTrain.moha;

/**
 *
 * @author e2500138
 */
public class Dessin {
    private char[][] grid;
    private static int w;
    private static int h;
    
    public Dessin(){
        
        w = 30;
        h = 30;
        
        grid = new char[w][h];
        
        for(int i = 0; i<w; i++){
            for(int j = 0; j<h; j++){
                grid[i][j] = ' ';
            }
        }
    }
    
    public void dessiner(int x1, int y1, int x2, int y2, char c){
        for(int i = x1; i<x2; i++){
            grid[i][y1] = c;
            grid[i][y2] = c;
        }
        for(int i = y1; i<y2; i++){
            grid[x1][i] = c;
            grid[x2][i] = c;
        }
    }
    
    public void remplir(char c){
        for(int i = 0; i<w; i++){
            for(int j=0; j<h; j++){
                grid[i][j] = c;
            }
        }   
    }
    
    public String genererLeDessin(){
        String s = "";
        
        for(int i = 0; i<w; i++){
            s+="<tt>";
            for(int j = 0; j<h; j++){
                s+=grid[i][j];
            }
            s += "</tt><br>";
        }
        
        return s;
    }
}
