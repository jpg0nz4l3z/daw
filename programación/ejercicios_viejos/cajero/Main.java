package cajero;

import cajero.controllers.Controller;
import cajero.models.CajeroAutomatico;
import cajero.models.Cuenta;
import cajero.views.View;

import java.util.ArrayList;

public class Main {
    static void main() {
        ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
        cuentas.add(new Cuenta("1111", "2314", 24.5));
        cuentas.add(new Cuenta("2222", "2315", 24.5));
        View view = new View();
        CajeroAutomatico cajero = new CajeroAutomatico();

        Controller c = new Controller(view, cajero, cuentas);
        c.iniciar();
    }
}
