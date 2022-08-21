import java.awt.*;
import java.awt.event.*;
class Anim extends Frame implements ItemListener{
    int x1,x2,y1,y2;
    String st = "";
    Anim(){
        Checkbox c1;
        Checkbox c2;
        CheckboxGroup cbg = new CheckboxGroup();
        c1 = new Checkbox("rain",true,cbg);
        c2 = new Checkbox("no rain",true,cbg);
        x1 = 50;
        x2 = 50;
        y1 = 30;
        y2 = 40;
        setSize(500,500);
        setTitle("man in rain");
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(c1);
        c1.addItemListener(this);
        add(c2);
        c2.addItemListener(this);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e){
                dispose();
            }
        });


    }
    public void itemStateChanged(ItemEvent e){
        st=(e.getItem()).toString();
        repaint();
    }
    public void paint(Graphics g){
        g.drawLine(x1,255,x2,400);
        g.drawOval(x1,250,30,30);
        g.setColor(Color.black);
        g.fillOval(x1,250,30,30);
        g.drawLine(10,400,1000,400);
        if(st.equals("rain")){
            g.drawLine(x1,190,x2,255);
            g.drawOval(x1-50,160,120,30);
            g.drawLine(50,y1,50,y2);
            g.drawLine(100,y1,100,y2);
            g.drawLine(150,y1,150,y2);
            g.drawLine(200,y1,200,y2);
            g.drawLine(250,y1,250,y2);
            g.drawLine(300,y1,300,y2);
            g.drawLine(350,y1,350,y2);
            g.drawLine(400,y1,400,y2);
        
        }
        if(x1<500){
            x1+=1;
            x2+=1;
        }else{
            x1=50; x2=50;
        }
        
        if(y2<400){
            y2+=10;
        }
        else{
            y2=40;
        }

        try{
            Thread.sleep(150);
            repaint();
        }catch(Exception e){
            e.printStackTrace();
        }


    }
    public static void main(String args[]){
        Anim a = new Anim();
    }
}