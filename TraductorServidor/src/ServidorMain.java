
import Traductor.TraductorImp;
import Traductor.TraductorInt;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author MIRKO
 */
public class ServidorMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        TraductorImp traductor = new TraductorImp();
        Remote stub = UnicastRemoteObject.exportObject( traductor, 0);
        Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        System.out.println("ejecutandose en el puerto: "+ Registry.REGISTRY_PORT);
        registry.bind("Traductor", stub);
        
    }
    
}
