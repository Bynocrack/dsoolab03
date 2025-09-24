import java.util.*;
public class Alumnos {
    private String nombres;
    private String apellidos;
    private int edad;  
    private String carrera; 
    private int DNI;
    private String codigoUnico;
    private Scanner sc = new Scanner(System.in);

    public Alumnos(String apellidos, int edad, String carrera, int DNI, String codigoUnico) {
        System.out.print("Ingrese los nombres del alumno: ");
            String nombresSinValidar= sc.nextLine();
        while (!setNombres(nombresSinValidar)) {
            System.out.print("No es un nombre válido, ingrese los nombres del alumno nuevamente: ");
            nombresSinValidar= sc.nextLine();
        }
        this.nombres = nombresSinValidar;
        this.apellidos = apellidos;
        this.edad = edad;
        this.carrera = carrera;
        this.DNI = DNI;
        this.codigoUnico = codigoUnico;
    }
    public String getNombres() {
        return this.nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    public int getEdad() {
        return edad;
    }
    public String getCarrera() {
        return carrera;
    }
    public int getDNI() {
        return DNI;
    }
    public String getCodigoUnico() {
        return codigoUnico;
    }
    public boolean setNombres(String nombres){
        for (int i = 0; i < nombres.length(); i++) {
            if(!(nombres.charAt(i)>='A' && nombres.charAt(i)<='Z') || !(nombres.charAt(i)>='a' && nombres.charAt(i)<='z')){
                return false;
            }
        }
        return true;
        
    }

}
