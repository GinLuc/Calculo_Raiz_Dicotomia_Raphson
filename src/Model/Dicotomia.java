/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static java.lang.Math.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GianL
 */
public class Dicotomia {
    private double x1;
    private double x2;
    private double fx1;
    private double fx2;
    private double pm;      //Variável P.M., aonde este é o Ponto Médio entre os dois valores escolhidos: (x1 + x2) / 2
    private double fpm;
    private double modulo;
    
    
 //Getters    
    public double getX1() {
        return x1;
    }
    
    public double getX2() {
        return x2;
    }
    
    public double getFx1() {
        return fx1;
    }
    
    public double getFx2() {
        return fx2;
    }
    
    public double getPm() {
        return pm;
    }
    
    public double getFpm() {
        return fpm;
    }
    
    public double getModulo() {
        return modulo;
    }
    
 //Setters
    public void setX1(double x1) {
        this.x1 = x1;
    }
    
    public void setX2(double x2) {
        this.x2 = x2;
    }
    
    public void setFx1(double x1) {
        this.fx1 = sqrt(x1);
    }
    
    public void setFx2(double x2) {
        this.fx2 = sqrt(x2);
    }
    
    public void setPm(double pm) {
        this.pm = pm;
    }
    
    public void setFpm(double pm) {
        this.fpm = sqrt(pm);
    }
    
    public void setModulo (double x1, double x2) {
        this.modulo = abs(x1 - x2);
    }
    
    
    
    
    
    
    public static DefaultTableModel getTableModel() {
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("X1");
        modelo.addColumn("f(X1)");
        modelo.addColumn("X2");
        modelo.addColumn("f(X2)");
        modelo.addColumn("P.M.");       
        modelo.addColumn("f(P.M.)");       
        modelo.addColumn("|X1 - X2|");       

        return modelo;
    }
    
}
