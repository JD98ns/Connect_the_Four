import java.util.*;
import Cuentas.Accounts;
import Cuentas.ClassAccount;
import static Cuentas.Accounts.player;

public class Connect_Four {

    private static String[] args;
    Logica toLogica = new Logica(); // llamamos al tablero
    static ClassAccount ok = new ClassAccount();
    public static void main(String[] args) {
     ClassAccount ca = new ClassAccount();   
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
                         ok.loggedUser=fieldUser;
                         System.out.print("\nIngrese password: ");
                         fieldPass=ingreso.next();
                         
      
                         
                         
                       

                         
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
                                        ClassAccount agregar = new ClassAccount(fieldUser, fieldPass, placeholder,0);
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
               ClassAccount cl = new ClassAccount();
                cl.ScoreBoard();
                System.out.println("");
                
                break;
            case 3:
                System.out.println("\n**** Mi Perfil ****");
                System.out.println("\n1-Editar Perfil \n2-Ver Ultimas Partidas \n3-Eliminar Cuenta \n4-Menu Principal");
                op=ingreso.nextInt();
                if(op==1){Editar_Perfil(); }
                        
                else if(op==2){
                    
                         }
                else if(op==3){

                    System.out.println("Usuario Logged: "+ok.loggedUser );
                    System.out.println("Esta seguro de eliminar la cuenta?");
                    String eliminar = ingreso.next().toLowerCase();
                    
                     if(eliminar.equals("si"))
                         
                         ClassAccount.RemoveAccount(ok.loggedUser);
                         
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
        System.out.println("*** Editar Perfil ***");
        
        System.out.print("\nIngrese nuevo username: "); String nUser = ingreso.next();
        System.out.print("\nIngrese nuevo nombre: "); String nName = ingreso.next();
        System.out.print("\nIngrese nuevo password: "); String nPassword = ingreso.next();
        
        ListIterator<ClassAccount> iterator = player.listIterator();//iterator

        

                                      } // fin del metodo Editar  Perfil    

    
    
}// fin del class
