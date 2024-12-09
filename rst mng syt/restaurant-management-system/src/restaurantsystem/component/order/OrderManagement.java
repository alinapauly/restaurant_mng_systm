package restaurantsystem.component.order;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import restaurantsystem.MainMenu;
import restaurantsystem.model.Cart;
import restaurantsystem.model.CartItem;
import restaurantsystem.model.Item;
import restaurantsystem.model.Order;
import restaurantsystem.model.OrderLine;
import restaurantsystem.service.ItemService;
import restaurantsystem.service.OrderService;
public class OrderManagement extends javax.swing.JFrame {

    private final ItemService itemService;
    private final OrderService orderService;

    public OrderManagement() {
        this.initComponents();
        this.itemService = new ItemService();
        this.orderService = new OrderService();
        this.performFileRelatedTask();
    }

    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        totalPriceField = new javax.swing.JTextField();
        clearCartButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        itemIDToOrderField = new javax.swing.JTextField();
        itemOrderQuantityField = new javax.swing.JTextField();
        addToCartButton = new javax.swing.JButton();
        orderButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
    
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    
        // Main layout setup
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel3)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel5))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(jLabel10)
                                    .addGap(40, 40, 40)
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(totalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearCartButton)))
                        .addGap(40, 40, 40)))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clearCartButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    
        // Other components setup (before the layout setup)
        jPanel3.setBackground(new java.awt.Color(100, 100, 200));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    
        text.setEditable(false);
        text.setBackground(new java.awt.Color(104, 20, 204));
        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);
    
        jPanel1.setBackground(new java.awt.Color(15, 25, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
    
        jPanel2.setBackground(new java.awt.Color(10, 24, 155));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    
        jLabel1.setText("Which ID Item You want?");
    
        jLabel4.setText("Enter  Quantity");
    
        addToCartButton.setText("Add to cart");
        addToCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartButtonActionPerformed(evt);
            }
        });
    
        orderButton.setText("Order");
        orderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderButtonActionPerformed(evt);
            }
        });
    
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addToCartButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemOrderQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemIDToOrderField, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(orderButton)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(itemIDToOrderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(itemOrderQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(addToCartButton)
                            .addGap(29, 29, 29))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(orderButton)
                            .addContainerGap())))
                );
        
                // Setting up the panel for the main frame
                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addComponent(backButton)
                        .addContainerGap())
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backButton))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
        
                pack();
            }
        
            private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {
                // Action when back button is pressed
                System.out.println("Back button clicked.");
            }
        
            private void addToCartButtonActionPerformed(java.awt.event.ActionEvent evt) {
                // Action to add item to cart
                String itemID = itemIDToOrderField.getText();
                String quantity = itemOrderQuantityField.getText();
                System.out.println("Item ID: " + itemID + ", Quantity: " + quantity);
                // Add logic to add item to the cart
            }
        
            private void orderButtonActionPerformed(java.awt.event.ActionEvent evt) {
                // Action to place an order
                String total = totalPriceField.getText();
                System.out.println("Order placed with total: " + total);
                // Add logic to place the order
            }
        }
        
    

    private void orderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderButtonActionPerformed

        Cart cart = orderService.getCart();
        
        if (cart.getCartItems().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Opps, You haven't added any "
                    + "item to cart. Please add item to the cart");
            return;
        }

        int lastOrderNumber = 0;

        // Scan the order file and get the last order number
        try (Scanner scanner = new Scanner(new FileInputStream("storage/orderLine.txt"))) {
            while (scanner.hasNextLine()) {
                String orderLine = scanner.nextLine();
                if (orderLine.length() > 0) {
                    String orderParts[] = orderLine.split(",");

                    OrderLine orderLineObj = new OrderLine(
                            Integer.parseInt(orderParts[0]),
                            orderParts[1],
                            Integer.parseInt(orderParts[2]),
                            Double.parseDouble(orderParts[3]));

                    lastOrderNumber = orderLineObj.getOrderID();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

        // new order number
        int orderNumber = ++lastOrderNumber;

        // create order line line with unique order number - incremental
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("storage/orderLine.txt", true))) {
            for (int i = 0; i < cart.getCartItems().size(); i++) {
                CartItem cartItem = cart.getCartItems().get(i);

                OrderLine orderLine = new OrderLine(
                        orderNumber,
                        cartItem.getItem().getName(),
                        cartItem.getQuantity(),
                        cartItem.getPrice());

                pw.println(orderLine.getOrderID() + "," + orderLine.getName() + "," + orderLine.getQuantity() + "," + orderLine.getPrice());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

        // create order with the same order number as order line
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("storage/order.txt", true))) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();

            Order order = new Order(orderNumber, cart.getTotalPrice(), sdf.format(date));

            pw.println((order.getOrderID() + ",") + order.getPrice() + "," + order.getDate());

        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Reduce the quantity from item file
        cart.getCartItems().forEach((item) -> {
            itemService.reduceItemQuantityByItemName(item.getItem().getName(), item.getQuantity());
        });

        // Clear the cart
        this.clearCartButtonActionPerformed(evt);

        // Reinitilize the cart area
        this.performFileRelatedTask();
        JOptionPane.showMessageDialog(this, "Order has been created successfully !");

    }
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainMenu im = new MainMenu();
        im.setVisible(true);
        this.setVisible(false);
    }
    private void addToCartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartButtonActionPerformed

        // new item index
        String newItemId = itemIDToOrderField.getText();
        String newItemQuantityAsString = itemOrderQuantityField.getText();

        if (newItemId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter item id to add to cart");
            return;
        }

        if (newItemQuantityAsString.isEmpty()
                || !newItemQuantityAsString.chars().allMatch(Character::isDigit)) {
            JOptionPane.showMessageDialog(this, "Please enter valid quantity to add to cart");
            return;
        }

        // new item quantity
        int newItemQuantity = Integer.parseInt(newItemQuantityAsString);

        Item newItem = itemService.getItemByIndex(Integer.parseInt(newItemId));

        if (newItem == null) {
            JOptionPane.showMessageDialog(this, "Sorry , Please enter a valid Item ID");
            return;
        }

        if (newItemQuantity > newItem.getQuantity()) {

            JOptionPane.showMessageDialog(this, "Sorry , This item is out of stock");
            itemOrderQuantityField.setText("");
            itemIDToOrderField.setText("");

        } else {

            CartItem cartItem = new CartItem(newItem, newItemQuantity, newItem.getPrice() * newItemQuantity);
            orderService.addToCart(cartItem);

            reciptArea.setText(getReciptStringByCart());
            totalPriceField.setText(String.valueOf(orderService.getCart().getTotalPrice()));

            JOptionPane.showMessageDialog(this, "Item has been added to cart");

            itemIDToOrderField.setText("");
            itemOrderQuantityField.setText("");
        }
    }
    private void clearCartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearCartButtonActionPerformed
        orderService.clearCart();
        this.reciptArea.setText("");
        this.totalPriceField.setText("");

    }
    public String getReciptStringByCart() {
        
        List<CartItem> cartItems = orderService.getCart().getCartItems();

        StringBuilder stringBuilder = new StringBuilder();

        cartItems.forEach((item) -> {
            stringBuilder.append(item.getItem().getName())
                    .append("\t")
                    .append(item.getQuantity())
                    .append("\t")
                    .append(item.getPrice())
                    .append("\n");
        });

        return stringBuilder.toString();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OrderManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new OrderManagement().setVisible(true);
        });
    }
    private javax.swing.JButton addToCartButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearCartButton;
    private javax.swing.JTextField itemIDToOrderField;
    private javax.swing.JTextField itemOrderQuantityField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton orderButton;
    private javax.swing.JTextArea reciptArea;
    private javax.swing.JTextArea text;
    private javax.swing.JTextField totalPriceField;
    // End of variables declaration//GEN-END:variables
}
