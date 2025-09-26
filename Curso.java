import java.util.*;

public class Curso {
    private Scanner sc = new Scanner(System.in);
    private String codigo;
    private String nombre;
    private Docente docente; 

    public boolean setCodigo(String codigo) {
        if (codigo.length() != 4) { 
            return false; 
        }
        this.codigo = codigo;
        return true;
    } 

    //setter
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    //getter
    public String getCodigo() {
        return this.codigo;
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    //constructor
    public Curso() {
        
        System.out.println("Digite el código del curso (4 dígitos):");
        String codigoInput = sc.nextLine();
        while (!setCodigo(codigoInput)) {
            System.out.println("El código debe ser de 4 dígitos. Intente nuevamente:");
            codigoInput = sc.nextLine();
        }
        
        System.out.println("Digite el nombre del nuevo curso:");
                this.nombre = sc.nextLine();
            }
        }
        
