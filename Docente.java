import java.util.Scanner;

class Docente {
   // Declaramos las variables y sus tipos
    private Scanner sc = new Scanner(System.in);
    private String dni;
    private String nombres;
    private String apellidos;
    private String especialidad;
    private int experiencia;

    // Metodo set DNI, que a su vez valida que tenga una longitud de 8
    public boolean setDni (String dni) {
        if (dni.length() != 8) { return false; }
        this.dni = dni;
        return true;
    }

    // Metodo set nombres, que valida que sean solo letras o un espacio en blanco (ñ no soportada)
    public boolean setNombres (String nombres) {
        for (int i = 0; i < nombres.length(); i++) {
	    char c = nombres.charAt(i);
            if(!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == ' ')) {
                return false;
            }
        }        
        this.nombres = nombres;
        return true;
    }

    // Metodo set apellidos, igual que el de nombres
    public boolean setApellidos (String apellidos) { 
        for (int i = 0; i < apellidos.length(); i++) {
	   char c = apellidos.charAt(i);
	   if(!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == ' ')) {
                return false;
            }
        }        
        this.apellidos = apellidos;
        return true;
    }

    // Metodo para setear especialidad, no hace falta validar nada
    public void setEspecialidad (String especialidad) { this.especialidad = especialidad; }

    // Metodo para setear la experiencia, se valida que sea un numero entero
    public boolean setExperiencia (String experiencia) {
        try {
            int exp = Integer.parseInt(experiencia);
            this.experiencia = exp;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Los getters
    public String getDni () { return this.dni; }
    public String getNombres () { return this.nombres; }
    public String getApellidos () { return this.apellidos; }
    public String getEspecialidad () { return this.especialidad; }
    public int getExperiencia () { return this.experiencia; }

    // Constructor
    public Docente() {
        // Solicitamos el DNI y no se avanza hasta que sea valido
        System.out.print("Digite el dni del nuevo docente: ");
        String dni = sc.next();
        while (!setDni(dni)) {
            System.out.print("Ese no es un dni válido, intente de nuevo: ");
            dni = sc.next();
        }
	// Limpiamos el buffer
	sc.nextLine();

	// Solicitamos los nombres, y damos vueltas hasta que sean validos
        System.out.print("Digite los nombres del docente: ");
        String nombres = sc.nextLine();
        while (!setNombres(nombres)) {
            System.out.print("Ese no es un nombre válido, intente de nuevo: ");
            nombres = sc.nextLine();
        }

	// Solicitamos los apellidos y, si, otra vez damos vueltas hasta que sea valido
        System.out.print("Digite los apellidos del docente: ");
        String apellidos = sc.nextLine();
        while (!setNombres(apellidos)) {
            System.out.print("Ese no es un apellido válido, intente de nuevo: ");
            apellidos = sc.nextLine();
        }

	// Para la especialidad siempre es valido :D
        System.out.print("Digite su especialidad: ");
        setEspecialidad(sc.nextLine());
        
	// Solicitamos los años de experiencia, ya sabes ... vueltas... valido...
        System.out.print("Digite sus años de experiencia: ");
        String experiencia = sc.next();
        while (!setExperiencia(experiencia)) {
            System.out.print("Digite solo numeros enteros: ");
            experiencia = sc.next();
        }
    }
}
