package GUI;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// An AWT GUI program inherits the top-level container java.awt.Frame
public class exemple extends Frame {
    private Button[] btn;  // Array of 10 numeric Buttons
    public TextField tfDisplay,rsDisplay;
    public Label tfLabel,rsLabel;
    private float Result=0;
    private char optTex=' ';
    private String Tex,rTex="";

    public exemple () {

        Panel panelDisplay = new Panel(new GridLayout(2, 2) );
        Tex="0";
        tfDisplay = new TextField(Tex, 20);
        rsDisplay = new TextField(rTex, 20);
        tfLabel=new Label("Operation");
        rsLabel=new Label("Result");
        panelDisplay.add(tfLabel);
        panelDisplay.add(tfDisplay);
        panelDisplay.add(rsLabel);
        panelDisplay.add(rsDisplay);
        // Set up button panel
        Panel panelButtons = new Panel(new GridLayout(4, 4));

        btn = new Button[10];
        int j=0;
        for(int i=0; i<16; i++)
        {  switch(i) {
            case 3 : {  Button btnPlus = new Button("+");
                panelButtons.add( btnPlus);

                btnPlus.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (optTex==' ')
                        {optTex='+';
                            Result=Float.parseFloat(Tex);
                            Tex+=optTex;
                            rsDisplay.setText(String.valueOf(Result));
                            tfDisplay.setText(Tex );}
                    }});

            }break;
            case 7: {  Button btnMinus = new Button("-");
                panelButtons.add(btnMinus);

                btnMinus.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (optTex==' ')
                        {optTex='-';
                            Result=Float.parseFloat(Tex);
                            Tex+=optTex;
                            rsDisplay.setText(String.valueOf(Result));
                            tfDisplay.setText(Tex );}
                    }});

            }break;
            case 11: { Button btnMultiply = new Button("*");
                panelButtons.add(btnMultiply);

                btnMultiply.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (optTex==' ')
                        {optTex='*';
                            Result=Float.parseFloat(Tex);
                            Tex+=optTex;
                            rsDisplay.setText(String.valueOf(Result));
                            tfDisplay.setText(Tex );
                        }	}});

            }break;
            case 12: {  Button btnDot = new Button(".");
                panelButtons.add(btnDot);
            }break;
            case 13: { btn [9] = new Button("0");
                btn[9].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (Tex=="0")
                            Tex=e.getActionCommand();
                        else Tex+=e.getActionCommand();
                        tfDisplay.setText(Tex );
                        if(Result!=0)
                            rTex+=e.getActionCommand();
                        //

                    }});
                panelButtons.add(btn [9]);
            }break;
            case 14: { Button btnEqual  = new Button("=");
                panelButtons.add(btnEqual );

                btnEqual .addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        switch(optTex) {
                            case '+' :if (Result!=0)
                                Result+=Integer.parseInt(rTex);
                                break;
                            case '*' :if (Result!=0)
                                Result*=Integer.parseInt(rTex); break;
                            case '-' :if (Result!=0)
                                Result-=Integer.parseInt(rTex); break;
                            case '/' :if (Result!=0)
                                Result/=Integer.parseInt(rTex); break;
                        }
                        rsDisplay.setText(String.valueOf(Result));
                        optTex=' ';
                        Tex="0";
                        tfDisplay.setText(Tex );
                        Result=0;
                        rTex="";
                    }});



            }break;
            case 15: { Button btnDivide  = new Button("/");
                panelButtons.add(btnDivide );

                btnDivide.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (optTex==' ')
                        { optTex='/';
                            Result=Float.parseFloat(Tex);
                            Tex+=optTex;
                            rsDisplay.setText(String.valueOf(Result));
                            tfDisplay.setText(Tex );
                        }
                    }});

            }break;
            default:{ btn[j] = new Button(String.valueOf(j+1));
                btn[j].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (Tex=="0")
                            Tex=e.getActionCommand();
                        else Tex+=e.getActionCommand();
                        tfDisplay.setText(Tex );
                        if(Result!=0)
                            rTex+=e.getActionCommand();
                        //

                    }});
                panelButtons.add(btn[j]);
                j++;
            }; }  }

        setLayout(new BorderLayout());  // "super" Frame sets to BorderLayout
        add(panelDisplay, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);

        setTitle("caculatrice"); // "super" Frame sets title
        setSize(300, 300);  // la taille de l'afichage           // "super" Frame sets initial size
        setVisible(true);
        // "super" Frame shows
    }

    // The entry main() method
    public static void main(String[] args) {
        new exemple();  // Let the constructor do the job
    }

}
