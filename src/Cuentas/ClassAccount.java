
package Cuentas;
import Cuentas.Accounts;
import static Cuentas.Accounts.player; // se importa el package de la Clase Accounts (asi se accede al array) 
import java.util.Collections;

public class ClassAccount {
    // variables donde se van a guardar
    public String loggedUser;
    String username;
    String password;
    String nombre;
    int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    



  
    public ClassAccount() {
       
                          }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public static int guardar_posicion = 0;         // index para el array
    
    
    // Constructor
    public ClassAccount(String username, String password, String nombre,int score){
        this.username = username;
        this.password = password;
        this.nombre=nombre;
        this.score=score;                                                         }
    
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


    // metodo modificar cuenta 
    public static String modificarCuenta(String user, String name, String password){
    for (int i = 0; i <player.size(); i++) {
      if (player.get(i).getUsername().equals(user) && player.get(i).getPassword().equals(password) && player.get(i).getNombre().equals(name)) {
                 
                }
                                                }
        return "";
                                         }
    
    //metodo eliminar cuenta
    public static String RemoveAccount(String user){
        for (int i = 0; i <player.size(); i++) {
            if (player.get(i).getUsername().equals(user)) {
                player.remove(user);
                return "Cuenta Eliminada!";
                                                          }
                                               }
        return "Cuenta Eliminada!";
}
       // get SCoreboard
    public String ScoreBoard(){
        String lista = "";
        
        
        
        for (int i = 0; i <player.size(); i++) {
            
        lista = "Name: "+(String)getNombre() + "User: "+(String)getUsername()+ "Score: ";
         System.out.print(player.get(i));   
                                              }
        return lista;
                                     }//for
    public String toString() { 
    return "Name: '" + this.nombre + "', User: '" + this.username + "', Score: " +this.score+"\n" ;
                             }
   public String ultimasP(){
       String format="";
       format="Gano contra: "+this.nombre+ "Perdio contra: " +this.nombre+ "\n";
       return format;
                           }
    
           public static boolean searchUserS(String user){
        for (int i = 0; i <player.size(); i++) {
            if (player.get(i).getUsername().equals(user)) {
                guardar_posicion=i;
                return true;
                
            } // End del If
        }// End del For
        return false;
    
     } 
           //metodo de sumar score
    public int sumarScore(String user, int score){
        for (int i = 0; i <player.size(); i++) {
            if (player.get(i).getUsername().equals(user)) {
                
                
                                }
                                     }
        searchUser(user);
        int suma=score+1;
        return score;
    }
    

    }


