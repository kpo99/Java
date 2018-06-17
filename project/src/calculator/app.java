package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;


public class app {

    private static Storage_Stack storage;
    static DiagramCalculation CalcModule;

    private JButton save_button;
    private JPanel main_panel;
    private JButton calculateButton;
    private JTextArea input;

    private app() {

        calculateButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                char[][][] temp = CalcModule.Calculate(DiagramCalculation.parser( input.getText()));
                DiagramCalculation.print( temp,0 );
               // JOptionPane.showMessageDialog( null, DiagramCalculation.print( temp,0 ) );
                JLabel label = new JLabel(DiagramCalculation.print( temp,0 ));
                label.setFont(new Font("Arial", Font.BOLD, 18));

                JOptionPane.showMessageDialog( null,label,"Result",1 );

            }
        } );
    }

    public static void main(String[] args) {
        JFrame  frame = new JFrame( "calculator" );
        frame.setContentPane( new app().main_panel );
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        frame.setSize( 400 ,300 );
        frame.setVisible( true );

        storage = Serialization.Deserealize();
        CalcModule = new DiagramCalculation();


        /*char[][][] temp = CalcModule.Calculate(
                new char[] { '0', '0', '0', '1', '*', '*', '0', '*', '*', '*' },
                new char[] { '0', '0', '0', '0', '1', '1', '1','0','1','1' },
                new char[] { '0', '0', '0', '1', '1', '1', '1','1','1','0' },
                new char[] { '0', '0', '1', '1', '1', '1', '0','0','0','0' },
                new char[] { '0', '1', '1', '1', '1', '0', '0','0','0','0' },
                new char[] { '*', '*', '*', '*', '*', '*', '0','*','1','*'});


       // storage.addElement(new StorageItem(temp,"Second element"));*/


        Serialization.Serealize(storage);
    }
}
