/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.pkg001;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Ventana extends JFrame implements ActionListener {

    //declaración de elementos que usaremos en nuestra ventana, Importante: JLabel img es la imagen que sera leida del bfred image
    JButton btn_cargar;
    JButton btn_aclarar;
    JButton btn_oscurece;
    JLabel img_original;
    JLabel img_tratada;
    Container cp = this.getContentPane();
    JPanel pan_img;
    JPanel pan_btn;
    FlowLayout lay_btn;
    BorderLayout lay_gen = new BorderLayout();
    GridBagLayout lay_img;
    BufferedImage bfd_img;
    Imagen trat_img;

    public Ventana() throws HeadlessException {

        iniciarComps();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    //evento para cargar la imagen al hacer click en el boton cargar imagen
    private void cargarImagen() {
        btn_cargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    
                    bfd_img = ImageIO.read(new File("C:\\Users\\Pacho\\Documents\\NetBeansProjects\\SM-001\\img.jpg"));
                    trat_img = new Imagen(bfd_img);
                    img_original = new JLabel(new ImageIcon(bfd_img));
                    img_tratada = new JLabel(new ImageIcon(trat_img));
                    
                    addImg();

                } catch (Exception b) {
                    System.out.println("No ha sido posible cargar la imagen!");
                }
            }
        });
    }
    
    //metodo que añade los componentes a y los añade al contenedor
    public void iniciarComps() {

        cp.setLayout(lay_gen);
        addBtn();
        cargarImagen(); //cargar img
        cp.add(pan_btn, BorderLayout.SOUTH);

    }

    //metodo para añadir los botones a la ventana
    public void addBtn() {

        lay_btn = new FlowLayout();
        btn_cargar = new JButton("Cargar Imagen");
        btn_aclarar = new JButton("Aclarar");
        btn_oscurece = new JButton("Oscurecer");
        pan_btn = new JPanel();

        pan_btn.setLayout(lay_btn);
        pan_btn.add(btn_cargar);
        pan_btn.add(btn_aclarar);
        pan_btn.add(btn_oscurece);

    }

    //metodo para añadir las imagenes
    public void addImg() {

        lay_img = new GridBagLayout();
        pan_img = new JPanel();

        pan_img.setLayout(lay_img);
        pan_img.add(img_original);
        pan_img.add(img_tratada);
        cp.add(pan_img, BorderLayout.CENTER);

        this.pack();
        this.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
