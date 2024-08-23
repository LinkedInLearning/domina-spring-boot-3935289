package domina.springboot.verduleria.back;

import org.springframework.data.annotation.Id; // retirar para pasar de H2 a MySQ


public record Verdura(@Id long id, String nombre, Double precio, boolean troceable) {
}
