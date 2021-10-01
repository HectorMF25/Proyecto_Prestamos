package vista;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class VistaClientes extends JFrame { //ventana principal donde se agregaran y busc

    //atributos
    Image imagen;
    int X, Y;
    JLabel jLabelNombre,  jLabelId, jLabelProvincia, jLabelCanton, jLabelDistrito, jLabelImagen;
    JTextField jTextFProvincia, jTextFNombre, jTextFI;
    JComboBox jComboCanton, jComboDistrito;
    JButton btnBuscar, btnGuardar;

    public VistaClientes(){

        setVisible(true);

        setTitle("Marco con Imagen");

        setBounds(100, 25, 950, 730);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            imagen = ImageIO.read(new File("src/imagenes/Provincias (2).png")); //recibe un objeto de tipo File (es necesario colocar un try)
        }
        catch(IOException e) {
            System.out.println("La imagen no se encuentra");
        }

        this.addComponents();
    }

    void formatoPanel(){ //establece el formato del panel y verifica la existencia de la imagen
        this.getContentPane().setLayout(null);
    }

    void addComponents(){
       this.formatoPanel();
       //Colocamos la imagen en el panel
        jLabelImagen = new JLabel(new ImageIcon(imagen));
        jLabelImagen.setBounds(30,250,400,400);
        this.add(jLabelImagen);
    }

}
