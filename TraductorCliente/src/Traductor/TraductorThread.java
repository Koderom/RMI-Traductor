/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Traductor;
import Events.TraductorListener;
import Events.TranslationReadyEvent;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.EventListenerList;
/**
 *
 * @author MIRKO
 */
public class TraductorThread extends Thread{
    String idiomaOrigen, idiomaDestino, texto;
    TraductorInt traductor;
    
    public TraductorThread(String idiomaOrigen, String texto, String idiomaDestino){
        this.idiomaDestino = idiomaDestino;
        this.idiomaOrigen = idiomaOrigen;
        this.texto = texto;
        
        Registry registry;
        try {
            registry = LocateRegistry.getRegistry();
            traductor = (TraductorInt) registry.lookup("Traductor");
            
        } catch (RemoteException ex) {
        } catch (NotBoundException ex) {
        }
    }
    @Override
    public void run() {
        try {
            String resultado  = traductor.traducir(idiomaOrigen, texto, idiomaDestino);
            resultado = resultado.substring(2);
            TranslationReadyEvent event = new TranslationReadyEvent(resultado, this);
            fireTranslationReasyEvent(event);
        } catch (RemoteException ex) {
            
        }
    }
    // EVENTS
    protected EventListenerList listenerList = new EventListenerList();
    public void addTraductorListener(TraductorListener listener){
        listenerList.add(TraductorListener.class, listener);
    }
    public void removeTraductorListener(TraductorListener listener){
        listenerList.remove(TraductorListener.class, listener);
    }
    void fireTranslationReasyEvent(TranslationReadyEvent event){
        Object[] listeners = listenerList.getListenerList();
        for(int i = 0; i < listeners.length; i = i + 2){
            if(listeners[i] == TraductorListener.class){
                ((TraductorListener)listeners[i+1]).onTranslationReady(event);
            }
        }
    }
    
}
