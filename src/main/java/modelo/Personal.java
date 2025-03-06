package modelo;

public class Personal {
    private String runPersonal;
    private String nombrePersonal;
    private String cargo;

    public Personal(String runPersonal, String nombrePersonal, String cargo) {
        this.runPersonal = runPersonal;
        this.nombrePersonal = nombrePersonal;
        this.cargo = cargo;
    }

    public String getRunPersonal() {
        return runPersonal;
    }

    public void setRunPersonal(String runPersonal) {
        this.runPersonal = runPersonal;
    }

    public String getNombrePersonal() {
        return nombrePersonal;
    }

    public void setNombrePersonal(String nombrePersonal) {
        this.nombrePersonal = nombrePersonal;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
