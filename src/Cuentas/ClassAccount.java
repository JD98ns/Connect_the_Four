
package Cuentas;
import static Cuentas.Accounts.player; // se importa el package de la Clase Accounts (asi se accede al array) 

public class ClassAccount {
    // variables donde se van a guardar
    String username;
    String password;
    
    public static int guardar_posicion = 0;         // index para el array
    
    
    // Constructor
    public ClassAccount(String username, String password){
        this.username = username;
        this.password = password;
        
    }
    
    // buscar pos
    
    public static int search(String user, String pass){
        for (int i = 0; i < player.size(); i++) {
            if (player.get(i).getUsername().equals(user) && player.get(i).getPassword().equals(pass)) { 
                guardar_posicion=i; // save pos
                return i; // return
            } // fin del if
  
        }//fin del for
    return -1;
    }
    
    // buscar el usuario si ya existe
    public static int searchUser(String user){
        for (int i = 0; i <player.size(); i++) {
            if (player.get(i).getUsername().equals(user)) {
                guardar_posicion=i;
                return i;
                
            } // End del If
        }// End del For
        return -1;
    
     } 

    
    
    
    
    
    // Set y Get
    public String getUsername(){
        return username;
        
    }
    public void setUsername(String user){
        this.username = user;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
    this.password = password;
   
    } 
}
