/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo;

/**
 *
 * @author e2500138
 */
public class Donnees {
    public Dvd[] dvdList;

   
    public int index;
    public int indexMax;

    public Donnees() {
        dvdList = new Dvd[10000];
        this.index = -1;
        this.indexMax = -1;
    }
    
    public String prixTotal(){
        if(indexMax==-1){
            return "0";
        }
        int prixTotal = 0;
        for(int i = 0; i<=indexMax; i++){
            prixTotal += dvdList[i].price * dvdList[i].quantity;
        }
        
        String s = String.valueOf(prixTotal);
        
        return s;
    }
    
    public void addDvd(String title, int price, int quantity){
        Dvd dvd = new Dvd(title, price, quantity);
        indexMax++;
        index = indexMax;
        dvdList[index] = dvd;
    }
    
    public Dvd getDvd(){
        if(index == -1){
            return null;
        }
        else{
            return dvdList[index];
        }
    }
    
    public void deleteDvd(){
        if(indexMax==-1){
            return;
        }if(indexMax==0){
            index = -1;
            indexMax = -1;
        }else{
            for(int i = index; i<indexMax; i++){
                dvdList[i] = dvdList[i+1];
            }
            indexMax--;
            index--;
        }
    }
    
    public void suivant(){
        if(index == indexMax){
            index = 0;
        }else{
            index++;
        }
    }
    
    public void precedent(){
        if(index == 0){
            index = indexMax;
        }else{
            index--;
        }
    }
    
     public Dvd[] getDvdList() {
        return dvdList;
    }
}
