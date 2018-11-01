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
    private static double x1;
    private static double x2;
    private static double fx1;
    private static double fx2;
    private static double pm;      //Variável P.M., aonde este é o Ponto Médio entre os dois valores escolhidos: (x1 + x2) / 2
    private static double fpm;
    private static double modulo;
    private static double precisao;
    
 
    
    
    
    
//Construtor
    public Dicotomia (double x1, double precisao) {
        setX1(x1);
        setX2();
        setFx1(x1);
        setFx2(getX2());
        setPm(getX1(), getX2());
        setFpm(getPm());
        setModulo(getX1(), getX2());
        
    }
    
    
 //Getters    
    public static double getX1() {
        return x1;
    }
    
    public static double getX2() {
        return x2;
    }
    
    public static double getFx1() {
        return fx1;
    }
    
    public static double getFx2() {
        return fx2;
    }
    
    public static double getPm() {
        return pm;
    }
    
    public static double getFpm() {
        return fpm;
    }
    
    public static double getModulo() {
        return modulo;
    }
    
    public static double getPrecisao() {
        return precisao;
    }
    
 //Setters
    public void setX1(double x1) {
        this.x1 = x1;
    }
    
    public void setX2() {
        this.x2 = 0;
    }
    
    public void setFx1(double x1) {
        this.fx1 = sqrt(x1);
    }
    
    public void setFx2(double x2) {
        this.fx2 = sqrt(x2);
    }
    
    public void setPm(double x1, double x2) {
        this.pm = (x1 + x2) / 2;
    }
    
    public void setFpm(double pm) {
        this.fpm = sqrt(pm);
    }
    
    public void setModulo (double x1, double x2) {
        this.modulo = abs(x1 - x2);
    }
    
    public void setPrecisao(double precisao) {
        this.precisao = precisao;
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

        
        while (modulo >= precisao) {
            String[] s = {Double.toString(getX1()), Double.toString(getX2()), Double.toString(getFx1()), 
                Double.toString(getFx2()), Double.toString(getPm()), Double.toString(getFpm()), Double.toString(getModulo())};
            modelo.addRow(s);
        }
        
        
        return modelo;
    }
    
}
