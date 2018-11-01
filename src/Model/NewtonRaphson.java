/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GianL
 */
public class NewtonRaphson {
    private static double xi;
    private static double fxi;
    private static double fdxi;    //Variável da Derivada de Xi
    private static double xf;      //Variável que representa o X a ser substituído no Xi na próxima interação
    private static double modulo;
    private static double precisao;

    
    
//Construtor
    public NewtonRaphson (double xi, double precisao) {
        setXi(xi);
        setFxi(xi);
        setFdxi(xi);
        setXf(xi, getFxi(), getFdxi());
        setModulo(xi, getXf());
    }
    
    
//Getters
    public static double getXi() {
        return xi;
    }
    
    public static double getFxi() {
        return fxi;
    }
    
    public static double getFdxi() {
        return fdxi;
    }
    
    public static double getXf() {
        return xf;
    }
    
    public static double getModulo() {
        return modulo;
    }
    
    
//Setters
    public void setXi(double xi) {
        this.xi = xi;
    }
    
    public void setFxi(double xi) {
        this.fxi = sqrt(xi);
    }
    
    public void setFdxi(double xi) {
        this.fdxi = (sqrt(1 / xi)) / 2; // Derivada de Raíz Quadrada é: 1/2 * RAIZ(1/xi)
    }
    
    public void setXf(double xi, double fxi, double fdxi) {
        this.xf = xi - (fxi/fdxi); //Retorno do próximo valor a ser utilizado, aonde: Xf = Xi - (F(xi) / F'(Xi))
    }
    
    public void setModulo(double xi, double xf) {
        this.modulo = abs(xf - xi);
    }
    
    
    

    public static DefaultTableModel getTableModel() {
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Xi");
        modelo.addColumn("f(Xi)");
        modelo.addColumn("f'(Xi)");
        modelo.addColumn("Xi - (f(Xi)/f'(Xi))");
        modelo.addColumn("|Xf - Xi|");
        
        
        while (modulo >= precisao) {
            String[] s = {Double.toString(getXi()), Double.toString(getFxi()), Double.toString(getFdxi()), 
                Double.toString(getXf()), Double.toString(getModulo())};
            modelo.addRow(s);
        }
        return modelo;
    }
    
    
}
