package app;

public class Ejer10 {
    public static void main(String[] args) {
        /**
         * a "SQLstate" string, which follows either the XOPEN SQLstate conventions or the SQL:2003 conventions.
         * The values of the SQLState string are described in the appropriate spec. The DatabaseMetaData method
         * getSQLStateType can be used to discover whether the driver returns the XOPEN type or the SQL:2003 type.
         *
         * Esto es lo que dice la documentación de SQLException sobre los SQLState, que son Strings que almacenan el
         * código de error que devuelve mysql al ejecutar una operación de cualquier tipo, como un código de error de
         * java, pero su equivalente en el sistema gestor de base de datos. Es muy útil obtener este dato ya que gracias
         * a la documentación de SQL podemos saber qué es exactamente lo que está fallando en nuestra aplicación.
         */

    }
}