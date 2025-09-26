import java.util.Scanner;

public class Curso {
    private String nombre;

    // Constructor que pide el nombre al crear el curso
    public Curso() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite el nombre del curso: ");
        this.nombre = sc.nextLine();
    }

    // Constructor que recibe el nombre directamente
    public Curso(String nombre) {
        this.nombre = nombre;
    }

    // Getter
    public String getNombre() {
        return nombre;
    }

    // Setter 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
