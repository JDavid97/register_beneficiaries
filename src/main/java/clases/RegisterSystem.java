/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import javax.swing.*;

import java.awt.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author judav
 */

public class RegisterSystem extends JFrame{
    public RegisterSystem() {
        // Configuración básica de la ventana
        super("Registro de beneficiarios ");

        // Obtener la configuración de la pantalla
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        DisplayMode dm = gd.getDisplayMode();

        // Establecer el tamaño de la ventana a las dimensiones de la pantalla
        System.out.println("W: " + dm.getWidth());
        System.out.println("H: " + dm.getHeight());
        setSize(dm.getWidth(), dm.getHeight());

        //Maximiza la ventana
        setExtendedState(JFrame.MAXIMIZED_BOTH);             
    }

    public void create_UI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear un contenedor y establecer el layout
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());

        // Crear restricciones para el layout
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);  // Espacios entre componentes

        // Agregar un espacio en blanco para centrar el título
        constraints.gridx = 0;
        constraints.gridy = 0;
        container.add(new JLabel(""), constraints);

        // Crear el título y centrarlo
        constraints.gridy++;
        constraints.gridwidth = 2; // Ocupa dos columnas para centrar el título
        JLabel titleLabel = new JLabel("Registro de beneficiarios Amor y Vida");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(titleLabel, constraints);

        // Restaurar el valor de gridwidth
        constraints.gridwidth = 1;
        
        constraints.gridy++;
        container.add(new JLabel("Nombre:"), constraints);


        constraints.gridx++;
        JTextField jtaName = new JTextField(20);
        container.add(jtaName, constraints);

        constraints.gridy++;
        constraints.gridx--;
        container.add(new JLabel("Apellido:"), constraints);

        constraints.gridx++;
        JTextField jtaLastname = new JTextField(20);
        container.add(jtaLastname, constraints);

        constraints.gridy++;
        constraints.gridx--;
        container.add(new JLabel("ID:"), constraints);

        constraints.gridx++;
        JTextField jtaId = new JTextField(20);
        container.add(jtaId, constraints);

        //pack();
        // Centrar la ventana en la pantalla
        setLocationRelativeTo(null);    
        setVisible(true);
    }

    public void writeXlxs(Object[][] data) {
        // Crear un libro de trabajo de Excel
        Workbook workbook = new XSSFWorkbook();

        // Crear una hoja en el libro
        Sheet sheet = workbook.createSheet("Beneficiarios");

        // Crear datos de ejemplo
        //Object[][] data = {
        //        {"Nombre", "Edad", "Ciudad"},
        //        {"Juan", 25, "Madrid"},
        //        {"Ana", 30, "Barcelona"},
        //        {"Carlos", 22, "Sevilla"}
        //};

        // Escribir datos en la hoja
        int rowNum = 0;
        for (Object[] rowData : data) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : rowData) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
                // Puedes agregar más tipos de datos según sea necesario
            }
        }

        // Guardar el libro en un archivo
        try (FileOutputStream fileOut = new FileOutputStream("db_register/Registro_beneficiarios.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Archivo Excel creado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Cerrar el libro de trabajo
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Crear e mostrar la ventana
        //RegisterSystem registerSystem = new RegisterSystem();
        //registerSystem.setVisible(true);
        //registerSystem.create_UI();
        //registerSystem.writeXlxs();
    }
}




