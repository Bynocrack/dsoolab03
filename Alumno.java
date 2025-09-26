import java.util.*;
public class Alumno {

// ================= ATRIBUTOS =================
    private String nombres;
    private String apellidos;
    private int edad;  
    private String carrera; 
    private int DNI;
    private String codigoUnico;
    private Scanner sc = new Scanner(System.in);

// ================= CONSTRUCTOR =================
    public Alumno() {

        // Pedir y validar nombres
        System.out.print("Ingrese los nombres del alumno: ");
            String nombresSinValidar= sc.nextLine();
            while (!setNombres(nombresSinValidar)) {
                System.out.print("No es un nombre válido, ingrese los nombres del alumno nuevamente: ");
                    nombresSinValidar= sc.nextLine();
            }


        // Pedir y validar apellidos
        System.out.print("Ingrese los apellidos del alumno: ");
            String apellidosSinValidar= sc.nextLine();
            while (!setApellidos(apellidosSinValidar)) {
                System.out.print("No es un apellido válido, ingrese los apellidos del alumno nuevamente: ");
                    apellidosSinValidar= sc.nextLine();
            }

        // Pedir y validar edad
        System.out.print("Ingrese la edad del alumno:");
            int edadSinValidar= sc.nextInt();
            while(!setEdad(edadSinValidar)){
                System.out.println("Edad no válida, ingrese la edad del alumno nuevamente:");
                    edadSinValidar= sc.nextInt();
            }

        // Pedir carrera (no necesita validación)
        System.out.print("Ingrese la carrera del alumno:");
            this.carrera = sc.next();

        // Pedir y validar DNI
        System.out.println("Ingrese el DNI del alumno:");
            int dniSinValidar= sc.nextInt();
            while(!setDni(dniSinValidar)){
                System.out.print("DNI no válido, ingrese el DNI del alumno nuevamente:");
                    dniSinValidar= sc.nextInt();
            }
        System.out.println("El código único del alumno es: "+setCodigoUnico());
       
    }

// ================= MÉTODOS GETTERS  =================

    // Métodos para obtener información (lectura de atributos)
    public String getNombres() { return this.nombres; }
    public String getApellidos() { return this.apellidos; }
    public int getEdad() { return edad; }
    public String getCarrera() { return carrera; }
    public int getDNI() { return DNI; }
    public String getCodigoUnico() { return codigoUnico; }

// ================= MÉTODOS SETTERS  =================

    // Validar y asignar nombres (solo letras y espacios)
    public boolean setNombres(String nombres){
        for (int i = 0; i < nombres.length(); i++) {
            char c = nombres.charAt(i);

                // Acepta letras mayúsculas, minúsculas y espacios
                if (!( (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == ' ' )) {
                    return false; // Si encuentra un carácter inválido, retorna false
                }
        }
        this.nombres=nombres; // Si todo está bien, asigna el valor
        return true;
    }

    // Validar y asignar apellidos (solo letras y espacios)
    public boolean setApellidos(String apellidos){
        for (int i = 0; i < apellidos.length(); i++) {
            char c = apellidos.charAt(i);
                if (!( (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == ' ' )) {
                    return false;
                }
        }
        this.apellidos=apellidos;
        return true;
    }

    // Validar y asignar edad (entre 1 y 119)
    public boolean setEdad(int edad){
        if(edad>0 && edad<120){
            this.edad=edad;
            return true;
        }
        else{
            return false;
        }
    }

    // Validar y asignar DNI (7 a 8 dígitos)
    public boolean setDni(int dni){
        if(dni>1000000 && dni<99999999){
            this.DNI=dni;
                return true;
        }
        else{
                return false;
        }
    }

    // ================= GENERAR CÓDIGO ÚNICO =================
    public String setCodigoUnico(){
        String codigoUnico;
        // Tomar inicial del nombre en mayúscula
        char inicialNombre= Character.toUpperCase(nombres.charAt(0));
        // Tomar inicial del apellido en mayúscula
        char inicialApellido= Character.toUpperCase(apellidos.charAt(0));
        // Tomar los primeros 5 dígitos del DNI
        String parteDNI= String.valueOf(DNI).substring(0,5);
            // Concatenar para formar el código único
            codigoUnico= inicialNombre+""+inicialApellido+""+parteDNI;
        this.codigoUnico=codigoUnico;
            return this.codigoUnico;
    }
}
