public class Persona {

    private int edad;
    private Sexo sexo;

    public Persona(int edad, Sexo sexo) {
        this.edad = edad;
        this.sexo = sexo;
    }

    public Persona() {

    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}
