package Modelo;

import javax.swing.table.AbstractTableModel;
import java.util.List;


import javax.print.attribute.standard.NumberOfInterveningJobs;
import javax.swing.table.AbstractTableModel;
import javax.xml.transform.Templates;
import java.util.List;

public class JTable_Prestamos extends AbstractTableModel {

        private List<Prestamo> filas;
        private String columnas[] = {"Id", "Nombre", "Premios"};

        public JTable_Prestamos(List<Prestamo> filas) {
            this.filas = filas;
        }

        @Override
        public int getRowCount() {
            return filas.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        public List<Prestamo> getFilas() {
            return filas;
        }

        /*@Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Prestamo pres = filas.get(rowIndex); //almaceno el empleado que se encuentra en la fila
            switch (columnIndex) {
                case 0:
                    return actor.getID(); //retorno el id de la persona
                case 1:
                    return actor.getNombreA(); //retorno el nombre de la persona
                case 2:
                    return actor.getCantidadPremiosA(); //retorno el salario de la persona
                default:
                    return null;
            }
        }*/

        @Override
        public String getColumnName(int col){
            return columnas[col]; //obtiene el nombre de las columnas  de una posicion especifica
        }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
