package cajero.controllers;

import cajero.models.CajeroAutomatico;
import cajero.models.Cuenta;
import cajero.views.View;

import java.util.ArrayList;


public class Controller {
    CajeroAutomatico cajeroAutomatico;
    View view;
    ArrayList<Cuenta> cuentas;
    boolean autenticado;

    public Controller(View view, CajeroAutomatico cajeroAutomatico, ArrayList<Cuenta> cuentas) {
        this.view = view;
        this.cajeroAutomatico = cajeroAutomatico;
        this.cuentas = cuentas;
        this.autenticado = false;
    }

    public void autenticarse() {
        view.menuHeaderView();
        String cuenta = view.solicitarCuenta();
        String pin = view.solicitarPin();
        autenticado = cajeroAutomatico.autenticar(cuenta, pin, cuentas);
        if (autenticado) {
            view.autenticacionExitosaView();
        } else {
            view.autenticacionFallidaView();
            if (view.salirView().equals("2")) {
                autenticarse();
            }
        }
    }

    public void iniciar() {
        autenticarse();
        if (autenticado) {
            String opcionSeleccionada;
            do {
                opcionSeleccionada = view.menuView();
                switch (opcionSeleccionada) {
                    case "1":
                        verBalance();
                        break;
                    case "2":
                        sacarDinero();
                        break;
                    case "3":
                        depositar();
                        break;
                    case "4":
                        break;
                    default:
                        view.opcionInvalidaView();
                        break;
                }
            } while (!opcionSeleccionada.equals("4"));
        }
    }

    public void depositar() {
        cajeroAutomatico.depositar(view.solicitarMontoView());
    }

    public void sacarDinero() {
        try {
            cajeroAutomatico.sacarDinero(view.solicitarMontoView());
        } catch (Exception e) {
            view.exceptionView(e);
        }
    }

    public void verBalance() {
        view.returnDoubleView(cajeroAutomatico.verBalance());
    }
}
