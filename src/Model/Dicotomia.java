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
        setX2(0);
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
    public static void setX1(double x1) {
        Dicotomia.x1 = x1;
    }
    
    public static void setX2(double x2) {
        Dicotomia.x2 = x2;
    }
    
    public static void setFx1(double x1) {
        Dicotomia.fx1 = sqrt(x1);
    }
    
    public static void setFx2(double x2) {
        Dicotomia.fx2 = sqrt(x2);
    }
    
    public static void setPm(double x1, double x2) {
        Dicotomia.pm = (x1 + x2) / 2;
    }
    
    public static void setFpm(double pm) {
        Dicotomia.fpm = sqrt(pm);
    }
    
    public static void setModulo (double x1, double x2) {
        Dicotomia.modulo = abs(x1 - x2);
    }
    
    public static void setPrecisao(double precisao) {
        Dicotomia.precisao = precisao;
    }
    
    
    public static void passaValor(double fx1,double fx2, double fpm) {
        if(fpm <= 0) {
            if (fx1 <= 0)
                setX1(Dicotomia.getPm());
            else if (fx2 <= 0)
                setX2(Dicotomia.getPm());
        }
        else if (fx1 >= 0)
            setX1(Dicotomia.getPm());
        else if (fx2 >= 0)
            setX2(Dicotomia.getPm());
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
            
            String[] s = {
                Double.toString(getX1()), Double.toString(getX2()), Double.toString(getFx1()), 
                Double.toString(getFx2()), Double.toString(getPm()), Double.toString(getFpm()), 
                Double.toString(getModulo())
            };
            modelo.addRow(s);    
            passaValor(getFx1(), getFx2(), getFpm());
            
        }

        return modelo;
    }
    
}
