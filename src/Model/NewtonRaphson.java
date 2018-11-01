/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static java.lang.Math.sqrt;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GianL
 */
public class NewtonRaphson {
    private double xi;
    private double fxi;
    private double fdxi;    //Variável da Derivada de Xi
    private double xf;      //Variável que representa o X a ser substituído no Xi na próxima interação
    private double modulo;
    
    
//Getters
    public double getXi() {
        return xi;
    }
    
    public double getFxi() {
        return fxi;
    }
    
    public double getFdxi() {
        return fdxi;
    }
    
    public double getXf() {
        return xf;
    }
    
    public double getModulo() {
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
    
    public void setModulo(double modulo) {
        this.modulo = modulo;
    }
    
    public static DefaultTableModel getTableModel() {
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Xi");
        modelo.addColumn("f(Xi)");
        modelo.addColumn("f'(Xi)");
        modelo.addColumn("Xi - (f(Xi)/f'(Xi))");
        modelo.addColumn("|Xf - Xi|");
        
        return modelo;
    }
    
    
}
