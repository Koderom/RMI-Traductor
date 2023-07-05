/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Traductor;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author MIRKO
 */
public interface TraductorInt extends Remote{
    String traducir(String idiomaOrigen, String texto, String idiomaDestino) throws RemoteException;
}
