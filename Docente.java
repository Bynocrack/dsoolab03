import java.util.Scanner;

class Docente {
    private Scanner sc = new Scanner(System.in);
    private String dni;
    private String nombres;
    private String apellidos;
    private String especialidad;
    private int experiencia;

    public boolean setDni (String dni) {
        if (dni.length() != 8) { return false; }
        this.dni = dni;
        return true;
    }

    public void setNombres (String nombres) { this.nombres = nombres; }
    public void setApellidos (String apellidos) { this.apellidos = apellidos; }
    public void setEspecialidad (String especialidad) { this.especialidad = especialidad; }
    public boolean setExperiencia (String experiencia) {
        try {
            int exp = Integer.parseInt(experiencia);
            this.experiencia = exp;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getDni () { return this.dni; }
    public String getNombres () { return this.nombres; }
    public String getApellidos () { return this.apellidos; }
    public String getEspecialidad () { return this.especialidad; }
    public int getExperiencia () { return this.experiencia; }

    public Docente() {
        System.out.println("Digite el dni del nuevo docente: ");
        String dni = sc.next();
        while (!setDni(dni)) {
            System.out.println("Ese no es un dni válido, intente de nuevo: ");
            dni = sc.next();
        }

        System.out.println("Digite los nombres del docente: ");
        setNombres(sc.next());
        System.out.println("Digite los apellidos del docente: ");
        setApellidos(sc.nextLine());
        System.out.println("Digite su especialidad: ");
        setEspecialidad(sc.nextLine());
        
        System.out.println("Digite sus años de experiencia: ");
        String experiencia = sc.next();
        while (!setExperiencia(experiencia)) {
            System.out.println("Digite solo numeros enteros: ");
            experiencia = sc.next();
        }
    }
}