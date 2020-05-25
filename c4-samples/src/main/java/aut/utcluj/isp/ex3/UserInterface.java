package aut.utcluj.isp.ex3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserInterface extends JFrame implements ActionListener {

    StockController stockController = new StockController();
    private JButton but1;
    private JButton but2;
    private JButton but3;
    private JButton but4;
    private JButton but5;


    UserInterface() {
        JFrame mainframe = new JFrame("StockController");
        JPanel panel = new JPanel();
        panel.setLayout(null);


        but1 = new JButton("Add product");
        but1.setBounds(new Rectangle(10, 50, 270, 30));
        but1.addActionListener(this);

        but2 = new JButton("Get prod. with same id");
        but2.setBounds(new Rectangle(10, 100, 270, 30));
        but2.addActionListener(this);


        but3 = new JButton("Total number of prod.");
        but3.setBounds(new Rectangle(10, 150, 270, 30));
        but3.addActionListener(this);

        but4 = new JButton("Remove prod. with specific id");
        but4.setBounds(new Rectangle(10, 200, 270, 30));
        but4.addActionListener(this);

        but5 = new JButton("Update price");
        but5.setBounds(new Rectangle(10, 250, 270, 30));
        but5.addActionListener(this);

        panel.add(but1);
        panel.add(but2);
        panel.add(but3);
        panel.add(but4);
        panel.add(but5);
        mainframe.add(panel);

        mainframe.setSize(300, 400);
        mainframe.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        mainframe.show();
    }


    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == but1) {
            Interface1 interface1 = new Interface1();
        }
        if (ae.getSource() == but2) {
            Interface2 interface2 = new Interface2();
        }

        if (ae.getSource() == but3) {
            Interface3 interface3 = new Interface3();
        }


        if (ae.getSource() == but4) {
            Interface4 interface4 = new Interface4();
        }

        if (ae.getSource() == but5) {
            Interface5 interface5 = new Interface5();
        }

    }


    class Interface1 extends JFrame implements ActionListener {
        private JTextField id;
        private JTextField name;
        private JTextField price;
        private JTextField quantity;
        JFrame frame = new JFrame("Add product");

        Interface1() {
            JPanel panel = new JPanel();
            panel.setLayout(null);


            JButton butok = new JButton("Add product");
            butok.setBounds(new Rectangle(10, 140, 270, 30));
            butok.addActionListener(this);

            JLabel label1 = new JLabel("Type id: ");
            label1.setBounds(new Rectangle(10, 10, 100, 20));

            id = new JTextField(5);
            id.setBounds(new Rectangle(120, 10, 100, 20));

            JLabel label2 = new JLabel("Type Name: ");
            label2.setBounds(new Rectangle(10, 40, 100, 20));

            name = new JTextField(5);
            name.setBounds(new Rectangle(120, 40, 100, 20));

            JLabel label3 = new JLabel("Type price: ");
            label3.setBounds(new Rectangle(10, 70, 100, 20));

            price = new JTextField(5);
            price.setBounds(new Rectangle(120, 70, 100, 20));

            JLabel label4 = new JLabel("Type quantity: ");
            label4.setBounds(new Rectangle(10, 100, 100, 20));

            quantity = new JTextField(5);
            quantity.setBounds(new Rectangle(120, 100, 100, 20));

            panel.add(id);
            panel.add(label1);
            panel.add(name);
            panel.add(label2);
            panel.add(butok);
            panel.add(price);
            panel.add(label3);

            panel.add(quantity);
            panel.add(label4);
            frame.add(panel);

            frame.setSize(300, 250);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frame.show();
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            String prod_id = id.getText();
            String prod_name = name.getText();
            String prod_price_string = price.getText();
            double prod_price = Double.parseDouble(prod_price_string);
            String prod_quantity_string = quantity.getText();
            int prod_quantity = Integer.parseInt(prod_quantity_string);


            stockController.addProductToCatalogue(new Product(prod_id, prod_name, prod_price), prod_quantity);
            id.setText("");
            name.setText("");
            price.setText("");
            quantity.setText("");

        }
    }


    class Interface2 extends JFrame implements ActionListener {

        private JButton butok;
        private JTextField id;
        JFrame frame = new JFrame("Same ID");

        Interface2() {
            JPanel panel = new JPanel();
            panel.setLayout(null);


            butok = new JButton("Submit");
            butok.setBounds(new Rectangle(10, 60, 270, 30));
            butok.addActionListener(this);

            JLabel label1 = new JLabel("Type id: ");
            label1.setBounds(new Rectangle(10, 10, 100, 20));

            id = new JTextField(5);
            id.setBounds(new Rectangle(120, 10, 100, 20));

            panel.add(id);
            panel.add(label1);
            panel.add(butok);
            frame.add(panel);

            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frame.show();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String id_prod = id.getText();
            System.out.println(stockController.getProductsWithSameId(id_prod).toString());
            id.setText("");
        }
    }

    class Interface3 extends JFrame {

        private JTextField id;
        JFrame frame = new JFrame("Total number");

        Interface3() {
            JPanel panel = new JPanel();
            panel.setLayout(null);

            id = new JTextField(5);
            id.setBounds(new Rectangle(160, 10, 80, 20));
            id.setText(stockController.getTotalNumberOfProducts() + "");

            JLabel label1 = new JLabel("Total nr. of products: ");
            label1.setBounds(new Rectangle(10, 10, 150, 20));

            frame.add(label1);
            frame.add(id);
            frame.add(panel);

            frame.setSize(300, 100);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frame.show();
        }

    }

    class Interface4 extends JFrame implements ActionListener {
        private JButton butok;
        private JTextField id;
        JFrame frame = new JFrame("Delete product");

        Interface4() {
            JPanel panel = new JPanel();
            panel.setLayout(null);


            butok = new JButton("Delete product");
            butok.setBounds(new Rectangle(10, 60, 270, 30));
            butok.addActionListener(this);

            JLabel label1 = new JLabel("Type id: ");
            label1.setBounds(new Rectangle(10, 10, 100, 20));

            id = new JTextField(5);
            id.setBounds(new Rectangle(120, 10, 100, 20));


            panel.add(id);
            panel.add(label1);
            panel.add(butok);
            frame.add(panel);

            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frame.show();
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            String prod_id = id.getText();
            stockController.removeAllProductsWitProductId(prod_id);
            id.setText("");
        }
    }

    class Interface5 extends JFrame implements ActionListener {

        private JButton butok;
        private JTextField id;
        private JTextField price;
        JFrame frame = new JFrame("Change price");

        Interface5() {
            JPanel panel = new JPanel();
            panel.setLayout(null);


            butok = new JButton("Submit");
            butok.setBounds(new Rectangle(10, 90, 270, 30));
            butok.addActionListener(this);

            JLabel label1 = new JLabel("Type id: ");
            label1.setBounds(new Rectangle(10, 10, 100, 20));

            id = new JTextField(5);
            id.setBounds(new Rectangle(120, 10, 100, 20));

            JLabel label2 = new JLabel("New price: ");
            label2.setBounds(new Rectangle(10, 40, 100, 20));

            price = new JTextField(5);
            price.setBounds(new Rectangle(120, 40, 100, 20));

            panel.add(id);
            panel.add(label1);
            panel.add(price);
            panel.add(label2);
            panel.add(butok);
            frame.add(panel);

            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frame.show();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String id_prod = id.getText();
            String price_prod_string = price.getText();
            double price_prod = Double.parseDouble(price_prod_string);
            stockController.updateProductPriceByProductId(id_prod, price_prod);

            id.setText("");
            price.setText("");
        }
    }
}






