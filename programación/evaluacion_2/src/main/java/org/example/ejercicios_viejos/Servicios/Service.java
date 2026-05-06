package org.example.ejercicios_viejos.Servicios;

import java.util.ArrayList;

public class Service {
    String name;
    ArrayList<ServiceType> types;

    public Service(String name) {
        this.name = name;
    }
}

class ServiceType {
    String type;

    public ServiceType(String type) {
        this.type = type;
    }
}

class ServiceContract {
    Service service;
    ServiceType serviceType;
    ArrayList<Field> fields;

    public ServiceContract(Service service, ServiceType serviceType, ArrayList<Field> fields) {
        this.service = service;
        this.serviceType = serviceType;
    }
}

class Field {
    String name;

    public Field(String name) {
        this.name = name;
    }
}

class Test {
    static void main() {
        Service paginaWeb = new Service("Página web");

        ServiceType replica = new ServiceType("Réplica");
        ServiceType aMedida = new ServiceType("A la medida");

        paginaWeb.types.add(replica);
        paginaWeb.types.add(aMedida);

        ArrayList<Field> campos = new ArrayList<Field>() {{
            add(new Field("dominio"));
            add(new Field("encargado"));
        }};

        ServiceContract marketingSeo = new ServiceContract(paginaWeb, aMedida, campos);
    }
}
