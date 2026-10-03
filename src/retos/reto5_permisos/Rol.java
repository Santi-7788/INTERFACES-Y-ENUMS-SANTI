package retos.reto5_permisos;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 * Roles del sistema, cada uno con su conjunto de permisos optimizado con EnumSet.
 */
public enum Rol {
    INVITADO(EnumSet.of(Permiso.LEER)),
    USUARIO(EnumSet.of(Permiso.LEER, Permiso.ESCRIBIR)),
    MODERADOR(EnumSet.of(Permiso.LEER, Permiso.ESCRIBIR, Permiso.BORRAR)),
    ADMINISTRADOR(EnumSet.allOf(Permiso.class));

    private final EnumSet<Permiso> permisos;

    Rol(EnumSet<Permiso> permisos) {
        this.permisos = permisos;
    }

    /**
     * Comprueba si el rol posee el permiso indicado.
     * EnumSet.contains se ejecuta a nivel de operaciones de bits (bitmask), siendo extremadamente veloz.
     */
    public boolean puede(Permiso p) {
        return permisos.contains(p);
    }

    public Set<Permiso> getPermisos() {
        return Collections.unmodifiableSet(permisos);
    }
}
