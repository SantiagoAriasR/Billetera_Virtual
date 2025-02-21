package App;

import models.Empresa;

public class App {
    // Creamos nuestra empresa ya que se instancia una sola vez
    public static Empresa empresa = new Empresa("Banco");
    // Metodo para obtener nuestro App con la empresa unica (Getter)
    public static Empresa getEmpresa() {
        return empresa;
    }
}
