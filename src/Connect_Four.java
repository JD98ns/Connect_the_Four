import java.util.*;
import Cuentas.Accounts;
import Cuentas.ClassAccount;
import static Cuentas.Accounts.player;
        
public class Connect_Four {
    static String loggedUser;
    private static String[] args;
    Logica toLogica = new Logica(); // llamamos al tablero
    
    public static void main(String[] args) {
      
     Scanner ingreso = new Scanner(System.in);   
     boolean salir = true; int op;   String fieldUser=""; String fieldPass="";
     
     
       while(salir!=false){
           System.out.print("\n1 - Login \n2 - Crear Usuario \n3 - Salir \n\tIngrese opcion: ");
           op=ingreso.nextInt();
           
           switch(op){
               case 1:
                         int r = ClassAccount.search(fieldUser,fieldPass); // llamamos al meetodo search 
                         
                         System.out.print("\nIngrese usuario: ");
                         fieldUser=ingreso.next();
                         System.out.print("\nIngrese password: ");
                         fieldPass=ingreso.next();
                         
                         loggedUser = fieldUser;
                         
                         
                        // verificar el arreglo
                        if(r!=-1){
                            System.out.println("Success!");
                            Menu_Principal();               // incia el codigo de menu principal
                                 }    

                        else{
                            System.out.println("Verifique usuario y password!");
                            }
                      
                   break;
                   
               case 2:
                   System.out.println("\nIngrese su nombre: ");
                   String placeholder = ingreso.next();
                   System.out.print("\nIngrese el nombre del user: ");
                   fieldUser = ingreso.next();
                   System.out.print("\nIngrese el password: ");
                   fieldPass = ingreso.next();
                   
                           // condicionales
                                    if (fieldUser.equals("") || fieldPass.equals("")) {
                                        System.out.println("Llene los campos!");           // esta condicion verifica si hay espacios vacios en los fields
                                                                 }
                                    int r2=ClassAccount.searchUser(fieldUser);                     // se llama el metodo buscar, para ello se crea un int r
                                    // verificamos si ya existe el user
                                       if(r2!=-1){
                                           System.out.println("Usuario ya existe!");
                                            }

                                       else{
                                        ClassAccount agregar = new ClassAccount(fieldUser, fieldPass);
                                        player.add(agregar);   // agregamos el user y password al arraylist
                                           System.out.println("\nSuccess!");
            
                                          }
                   
                   break;
                   
               case 3:
                   salir = false;
                   break;
               default:
                   System.out.println("\nNo es una opcion valida!");
                     }// fin del swithc principal
           
                         } // fin del while principal 
    } // fin del main
    
    
    //Menu Principal
    public static void Menu_Principal () {
        Scanner ingreso = new Scanner(System.in);
        int op; boolean salir = true;
        while(salir!=false){
            System.out.println("\n**** Menu Principal ****");
        System.out.println("\n1 - Jugar Connect4 \n2 - Ranking \n3 - Mi Perfil \n4 - Cerrar Sesión");
        op=ingreso.nextInt();
        
        switch(op) {
            case 1:
                Logica.main(args);
                
                break;
            case 2:
                System.out.println("\n**** Ranking ****");
                System.out.println("\nNombre \tUsuario \tPuntos \n____________________________________");
                System.out.println("\n1- Marvin \tMrd \t8");
                System.out.println("\n2- Raul \tRps \t7"); System.out.println("\n2- Marcia \tMarciabae \t5"); System.out.println("\n4- Fred \tFredtheman \t3"); System.out.println("\n5- Brian \tBadB \t-1");
                
                break;
            case 3:
                System.out.println("\n**** Mi Perfil ****");
                System.out.println("\n1-Editar Perfil \n2-Ver Ultimas Partidas \n3-Eliminar Cuenta \n4-Menu Principal");
                op=ingreso.nextInt();
                if(op==1){Editar_Perfil(); }
                        
                else if(op==2){
                    System.out.println("\n1- Gano vs Rps \n2-Perdio vs BadB por RETIRO \n3- Gano vs Mrd \n4- Perdi vs Rps \n5- Empate vs Fredtheman");
                         }
                else if(op==3){
                    System.out.println("Esta seguro de eliminar la cuenta?");
                    String eliminar = ingreso.next().toLowerCase();
                    
                     if(eliminar.equals("si"))
                         System.out.println("Cuenta eliminada!");
                         
                         main(args);
                              }
                else if(op==4){break;}
                
                break;
            case 4:
                salir=false;
                break;
            default:
                System.out.println("No es una opcion valida!");
                break;
            
                   } // fin del Switch Menu Principals
               }// fin del switch Menu Principal
                                         } // fin del metodo Menu_Principal
    
    
    // Metodo Editar Perfil
    public static void Editar_Perfil(){
        Scanner ingreso = new Scanner (System.in);
        int op;
        System.out.println("\n1-Cambiar nombre \n2-Cambiar User \n3-Cambiar Password \n4-Regresar           \n\tIngrese Opcion");
        op=ingreso.nextInt();
        
        switch(op){
            case 1:
                System.out.println("Ingrese el nuevo nombre: ");
                String name = ingreso.next();
                
                break;
            case 2:
                System.out.println("Ingrese el nuevo user");
                String user = ingreso.next();
                break;
            case 3:
                System.out.println("Ingrese el nuevo password: ");
                String password = ingreso.next();
                break;
            case 4:
                
                break;
            default:
                System.out.println("No es una opcion valida!");
                break;
                  }
        
        
                                      } // fin del metodo Editar  Perfil    
    

    public static void Usuario_Logged(){
       
                                       }
    
    
}// fin del class
