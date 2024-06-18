import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Paint extends JFrame {
    int RectX = 0;
    int RectY = 0;
    int y = 0;
    int x = 0;
    Color color = Color.BLACK;
    boolean isPressed;
    boolean isRect = false;
    boolean isEraser = false;
    boolean isLine = true;

    public Paint(){
        setSize(1000,800);
        setTitle("Paint");
        setLayout(null);
        setResizable(false);
        getContentPane().setBackground(Color.WHITE);


        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (isLine){
                    Line(e);
                } else if (isRect) {
                    Rect(e);
                } else if (isEraser) {
                    Erasing(e);
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                    x = e.getX();
                    y = e.getY();
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                isPressed = true;
                RectX = e.getX();
                RectY = e.getY();

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isPressed = false;
            }
        });

        JTextField currentColor = new JTextField("current color");
        currentColor.setHorizontalAlignment(JTextField.CENTER);
        currentColor.setEditable(false);
        currentColor.setBounds(700,5,100,50);
        currentColor.setFont(new Font("Arial", Font. PLAIN, 15));
        currentColor.setBackground(color);
        currentColor.setForeground(Color.WHITE);
        add(currentColor);

        JButton red = new JButton();
        red.setBounds(500,5,20,20);
        red.setBackground(Color.RED);
        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.RED;
                currentColor.setBackground(color);
                currentColor.setForeground(Color.WHITE);
            }
        });
        add(red);

        JButton orange = new JButton();
        orange.setBounds(525,5,20,20);
        orange.setBackground(Color.ORANGE);
        orange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.ORANGE;
                currentColor.setBackground(color);
                currentColor.setForeground(Color.WHITE);
            }
        });
        add(orange);

        JButton yellow = new JButton();
        yellow.setBounds(550,5,20,20);
        yellow.setBackground(Color.YELLOW);
        yellow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.YELLOW;
                currentColor.setBackground(color);
                currentColor.setForeground(Color.WHITE);
            }
        });
        add(yellow);

        JButton green = new JButton();
        green.setBounds(575,5,20,20);
        green.setBackground(Color.GREEN);
        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.GREEN;
                currentColor.setBackground(color);
                currentColor.setForeground(Color.WHITE);
            }
        });
        add(green);

        JButton blue = new JButton();
        blue.setBounds(600,5,20,20);
        blue.setBackground(Color.BLUE);
        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.BLUE;
                currentColor.setBackground(color);
                currentColor.setForeground(Color.WHITE);
            }
        });
        add(blue);

        JButton cyan = new JButton();
        cyan.setBounds(625,5,20,20);
        cyan.setBackground(Color.CYAN);
        cyan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.CYAN;
                currentColor.setBackground(color);
                currentColor.setForeground(Color.WHITE);
            }
        });
        add(cyan);

        JButton purple = new JButton();
        purple.setBounds(650,5,20,20);
        purple.setBackground(new Color(153, 0, 153));
        purple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = new Color(153, 0, 153);
                currentColor.setBackground(color);
                currentColor.setForeground(Color.WHITE);
            }
        });
        add(purple);

        JButton pink = new JButton();
        pink.setBounds(675,5,20,20);
        pink.setBackground(Color.PINK);
        pink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.PINK;
                currentColor.setBackground(color);
                currentColor.setForeground(Color.WHITE);
            }
        });
        add(pink);

        JButton black = new JButton();
        black.setBounds(500,25,20,20);
        black.setBackground(Color.BLACK);
        black.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = Color.BLACK;
                currentColor.setBackground(color);
                currentColor.setForeground(Color.WHITE);
            }
        });
        add(black);



        JButton lineB = new JButton("/");
        lineB.setBounds(300,5,50,50);
        lineB.setFont(new Font("Arial", Font. PLAIN, 25));
        lineB.setBackground(Color.GRAY);
        lineB.setForeground(Color.WHITE);

        add(lineB);

        JButton eraserB = new JButton("○");
        eraserB.setBounds(360,5,50,50);
        eraserB.setFont(new Font("Arial", Font. PLAIN, 25));
        eraserB.setBackground(Color.BLACK);
        eraserB.setForeground(Color.WHITE);

        add(eraserB);

        JButton rectB = new JButton("■");
        rectB.setBounds(420,5,50,50);
        rectB.setFont(new Font("Arial", Font. PLAIN, 25));
        rectB.setBackground(Color.BLACK);
        rectB.setForeground(Color.WHITE);
        setVisible(true);
        add(rectB);

        JTextField currentMode  = new JTextField("Line");
        currentMode.setBounds(50,5,100,50);
        currentMode.setBackground(Color.BLACK);
        currentMode.setForeground(Color.WHITE);
        currentMode.setHorizontalAlignment(JTextField.CENTER);
        currentMode.setEditable(false);
        add(currentMode);

        lineB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isLine){
                    isLine = true;
                    lineB.setBackground(Color.GRAY);
                    isRect = false;
                    rectB.setBackground(Color.BLACK);
                    isEraser = false;
                    eraserB.setBackground(Color.BLACK);
                    currentMode.setText("Line");
                }
            }
        });

        eraserB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isEraser){
                    isEraser = true;
                    eraserB.setBackground(Color.GRAY);
                    isLine = false;
                    lineB.setBackground(Color.BLACK);
                    isRect = false;
                    rectB.setBackground(Color.BLACK);
                    currentMode.setText("Eraser");
                }
            }
        });
        rectB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isRect){
                    isRect = true;
                    rectB.setBackground(Color.GRAY);
                    isLine = false;
                    lineB.setBackground(Color.BLACK);
                    isEraser = false;
                    eraserB.setBackground(Color.BLACK);
                    currentMode.setText("Cube");
                }
            }
        });


        repaint();
        setVisible(true);
    }

//    public void paint(Graphics g){
//        g = getGraphics();
//        g.setColor(Color.WHITE);
//        g.drawRect(0,0,1000,1);
//    }

    private void Line(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.drawLine(x,y, e.getX(), e.getY());
        x = e.getX();
        y = e.getY();
        return;
    }

    private void Rect(MouseEvent e){
        Graphics g = getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(RectX,RectY,e.getX()-RectX+150,e.getY()-RectY+150);
        g.setColor(color);
        g.drawRect(RectX,RectY,e.getX()-RectX,e.getY()-RectY);
        return;
    }

    private void Erasing(MouseEvent e){
        Graphics g = getGraphics();
        g.setColor(Color.WHITE);
        g.fillOval(e.getX()-10,e.getY()-10,30,30);
    }


}
