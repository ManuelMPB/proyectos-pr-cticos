import javax.swing.JOptionPane;

public class ahorcado {
    public static String obtenerDibujoAhorcado(int fallosRestantes) {
        if (fallosRestantes == 6) {
            return "---------------------\n" +
                   " |                     |\n" +
                   " |                     |\n" +
                   " |                      \n" +
                   " |                      \n" +
                   " |                      \n" +
                   " |                      ";
        } else if (fallosRestantes == 5) {
            return "---------------------\n" +
                   " |                     |\n" +
                   " |                     |\n" +
                   " |                  -------\n" +
                   " |                 | -  -  |\n" +
                   " |                 |   o   |\n" +
                   " |                  -------";
        } else if (fallosRestantes == 4) {
            return " ---------------------\n"+
                 " |                     |\n"+
                 " |                     |\n"+
                 " |                  -------\n"+
                 " |                 | -  -  |\n"+
                 " |                 |   o   |\n"+
                 " |                  -------\n"+
                 " |                     |   \n"+
                 " |                     |   \n"+
                 " |                     |   \n"+
                 " |                     |   \n"+
                 " |                     |   \n";
        } else if (fallosRestantes == 3) {
            return " ---------------------\n"+
                " |                     |\n"+
                " |                     |\n"+
                " |                  -------\n"+
                " |                 | -  -  |\n"+
                " |                 |   o   |\n"+
                " |                  -------\n"+
                " |                     |   \n"+
                " |                   / |   \n"+
                " |                  /  |   \n"+
                " |                 /   |   \n"+
                " |                     |   \n";
        } else if (fallosRestantes == 2) {
            return " ---------------------"+"\n"+
                " |                     |"+"\n"+
                " |                     |"+"\n"+
                " |                  -------"+"\n"+
                " |                 | -  -  |"+"\n"+
                " |                 |   o   |"+"\n"+
                " |                  -------"+"\n"+
                " |                     |   "+"\n"+
                " |                   / | \\ "+"\n"+
                " |                  /  |  \\ "+"\n"+
                " |                 /   |    \\ "+"\n"+
                " |                     |   ";
        } else if (fallosRestantes == 1) {
            return " ---------------------"+"\n"+
                " |                     |"+"\n"+
                " |                     |"+"\n"+
                " |                  -------"+"\n"+
                " |                 | -  -  |"+"\n"+
                " |                 |   o   |"+"\n"+
                " |                  -------"+"\n"+
                " |                     |   "+"\n"+
                " |                   / | \\ "+"\n"+
                " |                  /  |  \\ "+"\n"+
                " |                 /   |    \\ "+"\n"+
                " |                     |   "+"\n"+
                " |                    /  "+"\n"+
                " |                   /      "+"\n"+
                " |                  /       ";
        } else{
            return "";
        }
    }
    public static void main(String[] args) {
        String Palabra = "Fortnite";  // La palabra que el jugador debe adivinar
        String letra;
        int fallos = 0; // Número de fallos
        int aciertos = 0;
        int fallosRestantes;
        int edad;
        int Numero=0;
        String UsuarioComposicion="";
        String nombre,apellido;
        int usuarioscrados=0;
        int i;
        int Menu;
        String DecirPalabra; // Es una variable que se utiliza por si el usuario quiere probar directamente, con decir la palabra
        String palabraOculta = "";  // Usamos un string para actualizar los guiones.
        String user;
        int password;
        String usuario = ""; // Inicializamos el nombre del usuario
        int contrasena = 0; // Inicializamos la contraseña
        boolean iniciosesion = false;
        String dibujos="";

        // Inicializamos la palabra oculta con guiones
        for (i = 0; i < Palabra.length(); i++) {
            palabraOculta += ("_");
        }


        // Bucle para inicio de sesión
        while (!iniciosesion) {
            int opciones = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Crear usuario\n2. Iniciar sesion"));
            switch (opciones) {
                case 1:
                nombre = JOptionPane.showInputDialog("Escribe tu Nombre");
                apellido = JOptionPane.showInputDialog("Escribe tu Apellido");
                edad= Integer.parseInt(JOptionPane.showInputDialog("Escribe tu edad"));
                if (edad >=18) {
                    //Calcular cotraseña aleatoria
                    Numero=(int)(Math.random()*1000000000);
                    //Calcular fecha de nacimiento
                    int Fecha=2024-edad;
                    //Extreaer 3 Primeros numeros nombre y apellidos
                   String N =   nombre.substring(0,3);
                   String A =   apellido.substring(0,3);
                   UsuarioComposicion=N+A+Fecha;
                
                   JOptionPane.showMessageDialog(null,"Usuarios: "+UsuarioComposicion+"\nContraseña: "+Numero);
                   usuarioscrados++;
                   
                }else {
                    JOptionPane.showMessageDialog(null, "Acesso denegado menor de 18 años");
                }
                    break;
                case 2:
                if (usuarioscrados == 1) {
                    user = JOptionPane.showInputDialog("Dime nombre de usuario");
                    password = Integer.parseInt(JOptionPane.showInputDialog("Dime la contraseña (número)"));
                    
                    if (user.equals(UsuarioComposicion) && password == Numero) {
                        JOptionPane.showMessageDialog(null, "Nombre de usuario y contraseña correcta");
                        iniciosesion = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Nombre de usuario y contraseña incorrecta");
                    }  
                }else{
                    JOptionPane.showMessageDialog(null, "Crea al menos un usuario");
                }
                    break;
                default:JOptionPane.showMessageDialog(null, "Esa opción no está disponible");
            }
        }


        // Bucle principal del juego
        while (fallos < 6) {
            // Mostramos la palabra oculta y el número de fallos restantes
            String mensaje = "Palabra: " + palabraOculta + "\nFallos restantes: " + (6 - fallos);
            fallosRestantes = 6 - fallos;
            dibujos=obtenerDibujoAhorcado(fallosRestantes);


            Menu = Integer.parseInt(JOptionPane.showInputDialog(null, mensaje +"\n"+dibujos+"\n1. Adivinar letra\n2. Adivinar palabra\n3. Salir"));
            switch (Menu) {
                case 1:
                    // Opción de adivinar una letra
                    letra = JOptionPane.showInputDialog("Di una letra");

                    // Validar que se ingrese solo una letra
                    if (letra.length() != 1) {
                        JOptionPane.showMessageDialog(null, "Por favor, ingresa solo una letra.");
                        break;
                    }

                    // Comprobar si la letra está en la palabra
                    boolean letracorrecta = false;
                    for (i = 0; i < Palabra.length(); i++) {
                        if (("" + Palabra.charAt(i)).equalsIgnoreCase(letra)) {
                            letracorrecta = true;
                            palabraOculta = palabraOculta.substring(0, i) + Palabra.charAt(i) + palabraOculta.substring(i + 1);
                            aciertos++;
                        }
                    }

                    // Si la letra no está, sumar un fallo
                    if (!letracorrecta) {
                        JOptionPane.showMessageDialog(null, "La palabra no tiene esa letra: " + letra);
                        fallos++;
                    }

                    // Verificar si se ha alcanzado el límite de fallos
                    if (fallos == 6) {
                        JOptionPane.showMessageDialog(null, "Has perdido. La palabra era: " + Palabra+"\n"+
                        " ---------------------"+"\n"+
                        " |                     |"+"\n"+
                        " |                     |"+"\n"+
                        " |                  -------"+"\n"+
                        " |                 | X  X  |"+"\n"+
                        " |                 |   o   |"+"\n"+
                        " |                  -------"+"\n"+
                        " |                     |   "+"\n"+
                        " |                   / | \\ "+"\n"+
                        " |                  /  |  \\ "+"\n"+
                        " |                 /   |    \\ "+"\n"+
                        " |                     |   "+"\n"+
                        " |                    / \\"+"\n"+
                        " |                   /   \\  "+"\n"+
                        " |                  /     \\ ");
                        return;
                    }
                    break;

                case 2:
                    // Opción de adivinar la palabra completa
                    DecirPalabra = JOptionPane.showInputDialog("Di la palabra");

                    if (DecirPalabra.equalsIgnoreCase(Palabra)) {
                        JOptionPane.showMessageDialog(null, "¡Felicidades, has ganado!");
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "La palabra no era esa.");
                        fallos++;
                    }

                    // Verificar si se ha alcanzado el límite de fallos
                    if (fallos == 6) {
                        JOptionPane.showMessageDialog(null, "Has perdido. La palabra era: " + Palabra+"\n"+
                        " ---------------------"+"\n"+
                        " |                     |"+"\n"+
                        " |                     |"+"\n"+
                        " |                  -------"+"\n"+
                        " |                 | X  X  |"+"\n"+
                        " |                 |   o   |"+"\n"+
                        " |                  -------"+"\n"+
                        " |                     |   "+"\n"+
                        " |                   / | \\ "+"\n"+
                        " |                  /  |  \\ "+"\n"+
                        " |                 /   |    \\ "+"\n"+
                        " |                     |   "+"\n"+
                        " |                    / \\"+"\n"+
                        " |                   /   \\  "+"\n"+
                        " |                  /     \\ ");
                        return;
                    }
                    break;

                case 3:
                    // Opción de salir
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona una opción válida del menú.");
            }

            // Si el jugador ha adivinado toda la palabra
            if (aciertos == Palabra.length()) {
                JOptionPane.showMessageDialog(null, "¡Felicidades, has adivinado la palabra: " + Palabra + "!");
                return;
            }

        }

        // Si se alcanzan los 6 fallos
    }
}
