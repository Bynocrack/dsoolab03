import java.util.*;

public class Matricula {
    private Alumno alumno;
    private Curso curso;
    private ArrayList<Double> notas;

    public Matricula(Alumno alumno, Curso curso) {
        this.alumno = alumno;
        this.curso = curso;
        this.notas = new ArrayList<>();
    }
    // Getters y Setters
    public Alumno getAlumno() {
        return alumno;
    }
    public Curso getCurso() {
        return curso;
    }
    public ArrayList<Double> getNotas() {
        return notas;
    }
    public void agregarNota(double nota) {
        this.notas.add(nota);
    }
    // Método para calcular el promedio ponderado
    public double calcularPromedio() {
        if (notas.isEmpty()) {
            return 0.0;
        }
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }
}