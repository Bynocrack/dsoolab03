import java.util.*;

public class SistemaAcademico {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Alumno> alumnos = new ArrayList<>();
    static ArrayList<Docente> docentes = new ArrayList<>();
    static ArrayList<Curso> cursos = new ArrayList<>();
    static ArrayList<Matricula> matriculas = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENU SISTEMA ACADEMICO ---");
            System.out.println("1. Registrar Alumno");
            System.out.println("2. Registrar Docente");
            System.out.println("3. Registrar Curso");
            System.out.println("4. Matricular Alumno en Curso");
            System.out.println("5. Registrar Nota");
            System.out.println("6. Mostrar Promedio de un Alumno");
            System.out.println("7. Alumno con mejor promedio");
            System.out.println("8. Listar Aprobados/Desaprobados por curso");
            System.out.println("0. Salir");
            System.out.println("------------------------------");
            System.out.print("Eliga una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> registrarAlumno();
                case 2 -> registrarDocente();
                case 3 -> registrarCurso();
                case 4 -> matricularAlumno();
                case 5 -> registrarNota();
                case 6 -> mostrarPromedioAlumno();
                case 7 -> mejorPromedio();
                case 8 -> listarPorCurso();
                case 0 -> System.out.println("Saliendo");
            }
        } while (opcion != 0);
    }

    private static void registrarAlumno() {
        System.out.println("\nREGISTRO ALUMNO");
        Alumno a = new Alumno();
        alumnos.add(a);
        System.out.println("\nAlumno registrado");
    }

    private static void registrarDocente() {
        System.out.println("\nREGISTRO DOCENTE");
        Docente d = new Docente(); 
        docentes.add(d);
        System.out.println("\nDocente registrado");
    }

    private static void registrarCurso() {
        System.out.println("\nREGISTRO CURSO");
        Curso c = new Curso();
        cursos.add(c);
        System.out.println("\nCurso registrado");
    }

    private static void matricularAlumno() {
        if (alumnos.isEmpty() || cursos.isEmpty()) {
            System.out.println("Debe haber alumnos y cursos registrados primero.");
            return;
        }
        System.out.println("\nMATRICULA\nSeleccione un alumno:");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(i + ". " + alumnos.get(i).getNombres());
        }
        System.out.print("\nEliga una opción: ");
        int idxAlumno = sc.nextInt();
        System.out.println("\nSeleccione el curso:");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println(i + ". " + cursos.get(i).getNombre());
        }
        System.out.print("\nEliga una opción: ");
        int idxCurso = sc.nextInt();

        Alumno alumno = alumnos.get(idxAlumno); 
        Curso curso = cursos.get(idxCurso);     

        Matricula m = new Matricula(alumno, curso);
        matriculas.add(m);

        System.out.println("\nMatrícula registrada. Se matriculó exitosamente a " + alumno.getNombres() + 
                        " en el curso " + curso.getNombre() + ".");
    }

    private static void registrarNota() {
        if (matriculas.isEmpty()) {
            System.out.println("No hay matrículas registradas.");
            return;
        }
        System.out.println("\nREGISTRO DE NOTAS");
        for (int i = 0; i < matriculas.size(); i++) {
            System.out.println(i + ". " + matriculas.get(i).getAlumno().getNombres() + 
                               " - " + matriculas.get(i).getCurso().getNombre());
        }
        System.out.print("\nSeleccione matrícula: ");
        int idx = sc.nextInt();
        System.out.print("Ingrese nota (0-20): "); //falta validar
        double nota = sc.nextDouble();
        matriculas.get(idx).agregarNota(nota);
        System.out.println("\nNota registrada.");
    }

    private static void mostrarPromedioAlumno() {
        System.out.println("\nPROMEDIO POR ALUMNO");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(i + ". " + alumnos.get(i).getNombres());
        }
        System.out.print("\nSeleccione alumno: ");
        int idx = sc.nextInt();
        double suma = 0;
        int count = 0;
        for (Matricula m : matriculas) {
            if (m.getAlumno() == alumnos.get(idx)) {
                suma += m.calcularPromedio();
                count++;
            }
        }
        if (count > 0) {
            System.out.println("\nPromedio del alumno: " + (suma / count));
        } else {
            System.out.println("\nEste alumno no tiene notas.");
        }
    }

    private static void mejorPromedio() {
        Alumno mejor = null;
        double max = -1;
        for (Alumno a : alumnos) {
            double suma = 0;
            int count = 0;
            for (Matricula m : matriculas) {
                if (m.getAlumno() == a) {
                    suma += m.calcularPromedio();
                    count++;
                }
            }
            if (count > 0) {
                double prom = suma / count;
                if (prom > max) {
                    max = prom;
                    mejor = a;
                }
            }
        }
        if (mejor != null) {
            System.out.println("\nMejor alumno: " + mejor.getNombres() + " con promedio " + max);
        } else {
            System.out.println("\nNo hay promedios registrados.");
        }
    }

    private static void listarPorCurso() {
        if (cursos.isEmpty()) {
            System.out.println("\nNo hay cursos registrados.");
            return;
        }
        System.out.println("\nLISTADO POR CURSOS");
        for (int i = 0; i < cursos.size(); i++) {
            System.out.println(i + ". " + cursos.get(i).getNombre());
        }
        System.out.print("\nSeleccione curso: ");
        int idxCurso = sc.nextInt();
        Curso curso = cursos.get(idxCurso);

        System.out.println("\nAprobados:");
        for (Matricula m : matriculas) {
            if (m.getCurso() == curso && m.calcularPromedio() >= 11) {
                System.out.println(m.getAlumno().getNombres() + " - " + m.calcularPromedio());
            }
        }
        System.out.println("\nDesaprobados:");
        for (Matricula m : matriculas) {
            if (m.getCurso() == curso && m.calcularPromedio() < 11) {
                System.out.println(m.getAlumno().getNombres() + " - " + m.calcularPromedio());
            }
        }
    }
}
