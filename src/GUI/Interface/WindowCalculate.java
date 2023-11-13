package GUI.Interface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WindowCalculate extends Frame {

    private Button[] btn;  // Array of 10 numeric Buttons
    public TextField tfDisplay,rsDisplay;
    public Label tfLabel,rsLabel;
    private float Result=0;
    private char optTex=' ';
    private String Tex,rTex="";




    public void Affichage(String title) {
        //super(title);
        this.setSize(new Dimension(600, 600));
        this.setLocationRelativeTo(null);
        Panel container = new Panel(new GridLayout(2, 2));
        rsDisplay = new TextField(rTex, 20);
        Tex = "0";
        tfDisplay = new TextField(Tex, 20);
        rsDisplay = new TextField(rTex, 20);
        tfLabel = new Label("Operation");
        rsLabel = new Label("Result");
        container.add(tfLabel);
        container.add(tfDisplay);
        container.add(rsLabel);
        container.add(rsDisplay);
        // Set up button panel
        Panel panelButtons = new Panel(new GridLayout(4, 4));


        btn = new Button[10];
        int j = 0;
        for (int i = 0; i < 16; i++) {
            switch (i) {
                case 3: {
                    Button btnPlus = new Button("+");
                    panelButtons.add(btnPlus);

                    btnPlus.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (optTex == ' ') {
                                optTex = '+';
                                Result = Float.parseFloat(Tex);
                                Tex += optTex;
                                rsDisplay.setText(String.valueOf(Result));
                                tfDisplay.setText(Tex);
                            }
                        }
                    });

                }
                break;
                case 7: {
                    Button btnMinus = new Button("-");
                    panelButtons.add(btnMinus);

                    btnMinus.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (optTex == ' ') {
                                optTex = '-';
                                Result = Float.parseFloat(Tex);
                                Tex += optTex;
                                rsDisplay.setText(String.valueOf(Result));
                                tfDisplay.setText(Tex);
                            }
                        }
                    });

                }
                break;
                case 11: {
                    Button btnMultiply = new Button("*");
                    panelButtons.add(btnMultiply);

                    btnMultiply.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (optTex == ' ') {
                                optTex = '*';
                                Result = Float.parseFloat(Tex);
                                Tex += optTex;
                                rsDisplay.setText(String.valueOf(Result));
                                tfDisplay.setText(Tex);
                            }
                        }
                    });

                }
                break;
                case 12: {
                    Button btnDot = new Button(".");
                    panelButtons.add(btnDot);
                }
                break;
                case 13: {
                    btn[9] = new Button("0");
                    btn[9].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (Tex == "0")
                                Tex = e.getActionCommand();
                            else Tex += e.getActionCommand();
                            tfDisplay.setText(Tex);
                            if (Result != 0)
                                rTex += e.getActionCommand();
                            //

                        }
                    });
                    panelButtons.add(btn[9]);
                }
                break;
                case 14: {
                    Button btnEqual = new Button("=");
                    panelButtons.add(btnEqual);

                    btnEqual.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            switch (optTex) {
                                case '+':
                                    if (Result != 0)
                                        Result += Integer.parseInt(rTex);
                                    break;
                                case '*':
                                    if (Result != 0)
                                        Result *= Integer.parseInt(rTex);
                                    break;
                                case '-':
                                    if (Result != 0)
                                        Result -= Integer.parseInt(rTex);
                                    break;
                                case '/':
                                    if (Result != 0)
                                        Result /= Integer.parseInt(rTex);
                                    break;
                            }
                            rsDisplay.setText(String.valueOf(Result));
                            optTex = ' ';
                            Tex = "0";
                            tfDisplay.setText(Tex);
                            Result = 0;
                            rTex = "";
                        }
                    });


                }
                break;
                case 15: {
                    Button btnDivide = new Button("/");
                    panelButtons.add(btnDivide);

                    btnDivide.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (optTex == ' ') {
                                optTex = '/';
                                Result = Float.parseFloat(Tex);
                                Tex += optTex;
                                rsDisplay.setText(String.valueOf(Result));
                                tfDisplay.setText(Tex);
                            }
                        }
                    });

                }
                break;
                default: {
                    btn[j] = new Button(String.valueOf(j + 1));
                    btn[j].addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (Tex == "0")
                                Tex = e.getActionCommand();
                            else Tex += e.getActionCommand();
                            tfDisplay.setText(Tex);
                            if (Result != 0)
                                rTex += e.getActionCommand();
                            //

                        }
                    });
                    panelButtons.add(btn[j]);
                    j++;
                }
                ;
            }
        }
    }
}
