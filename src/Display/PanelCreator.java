/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import CartManager.*;
import InventoryManager.Product;
import InventoryManager.ProductHelper;
import UserManager.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Tom
 */
public class PanelCreator {
    
    
    
    public static GridLayout getLayout(){
        GridLayout grid = new GridLayout(2, 2);
        grid.setHgap(30);
        grid.setVgap(30);
        return grid;
    }
    
    public static JButton getIconButton(String label, ImageIcon icon){
        JButton button = new JButton(label, icon);
        button.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        
        return button;
    }
    
    public static JButton getButton(String label){
        JButton button = new JButton(label);
        button.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        //button.setOpaque(false);
        //button.setContentAreaFilled(false);
        //button.setBorderPainted(false);
        
        return button;
    }
    
    public static JPanel getNavBar(){
        JPanel navPanel = new JPanel();
        navPanel.setLayout(new FlowLayout());
        String[] navButtons = {"Home", "Cart", "Log Out"};
        for (int i=0; i<navButtons.length; i++){
            final String label = navButtons[i];
            JButton navButton = getButton(label);
            navPanel.add(navButton);
            navButton.addActionListener(Action.addListener("navBar", label));
        }
        return navPanel;
    }
    
    public static JPanel getCategoriesPanel(){
        JPanel categoryPanel = new JPanel();
        categoryPanel.setLayout(getLayout());
        String[] categories = {"Shirts", "Pants", "Shorts", "Sweatshirts"};
        String[] img = {
            "images/shirts.jpg",
            "images/pants.jpg",
            "images/pants.jpg",
            "images/shirts.jpg"
        };
        for (int i=0; i < categories.length; i++){
            final String label = categories[i];
            ImageIcon icon = new ImageIcon(img[i]);
            JButton categoryButton = getIconButton(label, icon);
            categoryPanel.add(categoryButton);
            categoryButton.addActionListener(Action.addListener("category", label));
        }
        return categoryPanel;
    }
    
    public static JPanel getCategoryPanel(String category) throws IOException, ClassNotFoundException {
        
        ArrayList<Product> products = ProductHelper.getProducts(category);
       
        int rows = (products.size() + 1) / 2;
        
        JPanel categoryPanel = new JPanel();
        GridLayout grid = new GridLayout(rows, 2);
        grid.setHgap(30);
        grid.setVgap(30);
        categoryPanel.setLayout(grid);
        
        Product product;
        for (int i=0; i < products.size(); i++){
            product = products.get(i);
            String name = product.getName();
            String price = Double.toString(product.getPrice());
            String label = name + " - $" + price;
            final int productID = product.getProductID();
            ImageIcon productIcon = new ImageIcon(product.getImgLocation());
            Image imageThumbnail = productIcon.getImage().getScaledInstance(
                    200, 200, java.awt.Image.SCALE_SMOOTH);
            ImageIcon thumbnail = new ImageIcon(imageThumbnail);
            JButton productButton = getIconButton(label, thumbnail);
            categoryPanel.add(productButton);
            productButton.addActionListener(Action.addProductListener(productID));
        }
        return categoryPanel;
    }
    
    public static JPanel getProductPanel(int productID) throws IOException, ClassNotFoundException{
        
        Product product = ProductHelper.getProduct(productID);
        
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new BorderLayout(0, 10));
        
        JPanel namePanel = new JPanel();
        JLabel productName = new JLabel(product.getName());
        productName.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        namePanel.add(productName);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        JPanel imgPanel = new JPanel();
        JLabel productImg = new JLabel(new ImageIcon(product.getImgLocation()));
        imgPanel.add(productImg);
        mainPanel.add(imgPanel);
        
        JPanel pricePanel = new JPanel();
        JLabel priceLabel = new JLabel(
                "Price: $" + Double.toString(product.getPrice()));
        priceLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 30));
        pricePanel.add(priceLabel);
        mainPanel.add(pricePanel);
        
        
        JPanel detailsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel productInfo = getLabel(product.getInfo());
        detailsPanel.add(productInfo);
        
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout(0,10));
        
        JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel text = new JLabel("Description:");
        text.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
        textPanel.add(text);
        
        JPanel cartPanel = new JPanel();
        JButton addToCart = getButton("Add to Cart");
        addToCart.addActionListener(Action.addToCartListener(product, 1));
        cartPanel.add(addToCart);
        
        
        infoPanel.add(textPanel, BorderLayout.NORTH);
        infoPanel.add(detailsPanel, BorderLayout.CENTER);
        infoPanel.add(cartPanel, BorderLayout.SOUTH);
        
        productPanel.add(namePanel, BorderLayout.NORTH);
        productPanel.add(mainPanel, BorderLayout.CENTER);
        productPanel.add(infoPanel, BorderLayout.SOUTH);
        
        return productPanel;
        
    }
    
    public static JPanel getAddCartPanel (int productID) throws IOException, ClassNotFoundException {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel textPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        JLabel text = new JLabel("Item added to cart");
        text.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        textPanel.add(text);
        
        Product product = ProductHelper.getProduct(productID);
        JPanel imgPanel = new JPanel();
        JLabel productImg = new JLabel(new ImageIcon(product.getImgLocation()));
        imgPanel.add(productImg);
        
        JButton contShopping = getButton("Continue Shopping");
        contShopping.addActionListener(Action.addListener("cart", "shop"));
        
        JButton viewCart = getButton("View Cart");
        viewCart.addActionListener(Action.addListener("cart", "cart"));
        
        buttonPanel.add(contShopping);
        buttonPanel.add(viewCart);
        
        panel.add(textPanel, BorderLayout.NORTH);
        panel.add(imgPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
       return panel;
    }
    
    public static JPanel getCartPanel(){
        
        Cart cart = CartInstance.getInstance().getCart();
        
        
        JPanel cartPanel = new JPanel();
        cartPanel.setLayout(new BorderLayout());
        
        JPanel textPanel = new JPanel();
        JLabel text = new JLabel("Your Shopping Cart");
        text.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        textPanel.add(text);
        cartPanel.add(textPanel, BorderLayout.NORTH);
        
        ArrayList<CartItem> cartArr = cart.getCartArr();
        
        int rows = cartArr.size() + 2;
        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new GridLayout(rows, 5));
        
        if (cartArr.size() > 0){
            JLabel blank1 = new JLabel();
            itemPanel.add(blank1);
            JPanel nPanel = new JPanel();
            nPanel.setLayout(new BorderLayout());
            nPanel.add(new JLabel("Name", JLabel.CENTER), BorderLayout.PAGE_END);
            itemPanel.add(nPanel);
            JPanel pPanel = new JPanel();
            pPanel.setLayout(new BorderLayout());
            pPanel.add(new JLabel("Unit Price", JLabel.CENTER), BorderLayout.PAGE_END);
            itemPanel.add(pPanel);
            JPanel qPanel = new JPanel();
            qPanel.setLayout(new BorderLayout());
            qPanel.add(new JLabel("Quantity", JLabel.CENTER), BorderLayout.PAGE_END);
            itemPanel.add(qPanel);
            JPanel tpPanel = new JPanel();
            tpPanel.setLayout(new BorderLayout());
            tpPanel.add(new JLabel("Total Price", JLabel.CENTER), BorderLayout.PAGE_END);
            itemPanel.add(tpPanel);
            JLabel blank2 = new JLabel();
            itemPanel.add(blank2);
            
            
            double total = 0;
            for (int i = 0; i < cartArr.size(); i++) {

                CartItem item = cartArr.get(i);
                Product p = item.getProduct();
                int quantity = item.getQuantity();
                total = total + (p.getPrice() * quantity);

                //JPanel item = new JPanel();
                JPanel imagePanel = new JPanel();
                ImageIcon productIcon = new ImageIcon(p.getImgLocation());
                Image imageThumbnail = productIcon.getImage().getScaledInstance(
                        100, 100, java.awt.Image.SCALE_SMOOTH);
                ImageIcon thumbnail = new ImageIcon(imageThumbnail);
                JLabel productImg = new JLabel(thumbnail);
                productImg.setBorder(new EmptyBorder(0, 0, 10, 0));
                imagePanel.add(productImg);
                itemPanel.add(imagePanel);

                JPanel namePanel = new JPanel();
                JLabel name = new JLabel(p.getName());
                name.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
                namePanel.add(name);
                itemPanel.add(namePanel);

                JPanel uPricePanel = new JPanel();
                JLabel unitPrice = new JLabel("$" + Double.toString(p.getPrice()));
                unitPrice.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
                uPricePanel.add(unitPrice);
                itemPanel.add(uPricePanel);

                JPanel quantityPanel = new JPanel();
                Integer num[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                JComboBox quantityBox = new JComboBox(num);
                quantityBox.setSelectedIndex(quantity - 1);
                quantityBox.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
                quantityBox.addActionListener(Action.addQuantityListener(quantityBox, i));
                quantityPanel.add(quantityBox);
                itemPanel.add(quantityPanel);

                String unitTotal = String.format("%.2f", (p.getPrice() * quantity));
                JPanel uTotalPanel = new JPanel();
                JLabel uTotalLabel = new JLabel("$" + unitTotal);
                uTotalLabel.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
                uTotalPanel.add(uTotalLabel);
                itemPanel.add(uTotalPanel);

                JPanel deletePanel = new JPanel();
                JButton deleteButton = getButton("Delete");
                deleteButton.addActionListener(Action.deleteItemListener(i));
                deletePanel.add(deleteButton);
                itemPanel.add(deletePanel);
            }

            JLabel blank3 = new JLabel();
            itemPanel.add(blank3);
            JLabel blank4 = new JLabel();
            itemPanel.add(blank4);
            JLabel blank5 = new JLabel();
            itemPanel.add(blank5);
            JPanel tPanel = new JPanel();
            tPanel.setLayout(new BorderLayout());
            JLabel totalLabel1 = new JLabel("Total: ", JLabel.RIGHT);
            totalLabel1.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
            tPanel.add(totalLabel1, BorderLayout.PAGE_START);
            itemPanel.add(tPanel);
            JPanel tPanel2 = new JPanel();
            tPanel2.setLayout(new BorderLayout());
            JLabel totalLabel2 = new JLabel(String.format("%.2f", total), JLabel.CENTER);
            totalLabel2.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
            tPanel2.add(totalLabel2, BorderLayout.PAGE_START);
            itemPanel.add(tPanel2);
            JLabel blank6 = new JLabel();
            itemPanel.add(blank6);
            
            
        } else {
            JPanel panel = new JPanel();
            JLabel label = new JLabel("No Items In Cart");
            label.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
            panel.add(label);
            itemPanel.add(panel);
        }
        
        cartPanel.add(itemPanel, BorderLayout.CENTER);
        
        if (cartArr.size() > 0){
            JPanel buttonPanel = new JPanel();
            JButton shop = getButton("Continue Shopping");
            shop.addActionListener(Action.addListener("cart", "shop"));
            JButton checkout = getButton("Check Out");
            checkout.addActionListener(Action.addListener("cart", "checkout"));
            buttonPanel.add(shop);
            buttonPanel.add(checkout);

            cartPanel.add(buttonPanel, BorderLayout.SOUTH);
        }
        
        
        
        return cartPanel;
    }
    
    
    public static JPanel getCheckOutPanel(){
        
        User customer = UserInstance.getInstance().getCustomer();
        
        JPanel mainPanel = new JPanel();
        BorderLayout layout = new BorderLayout();
        layout.setVgap(30);
        mainPanel.setLayout(layout);
        
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel titleLabel = new JLabel("Check Out");
        titleLabel.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
        titlePanel.add(titleLabel);
        
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        
        
        JPanel cOutPanel = new JPanel();
        cOutPanel.setLayout(new BoxLayout(cOutPanel, BoxLayout.Y_AXIS));
        
        JPanel uInfoPanel = new JPanel();
        uInfoPanel.setLayout(new BoxLayout(uInfoPanel, BoxLayout.Y_AXIS));
        
        JPanel subTitle1Panel = getFormattedPanel();
        JLabel subTitle1Label = new JLabel("Shipping Info");
        subTitle1Label.setFont(new Font(Font.DIALOG, Font.PLAIN, 30));
        subTitle1Panel.add(subTitle1Label);
        uInfoPanel.add(subTitle1Panel);
        
        JPanel namePanel = getFormattedPanel();
        namePanel.add(getLabel("First Name:"));
        JTextField fNameField = new JTextField(customer.getFirstName(), 10);
        fNameField.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        namePanel.add(fNameField);
        namePanel.add(getLabel("Last Name:"));
        JTextField lNameField = new JTextField(customer.getLastName(), 10);
        lNameField.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        namePanel.add(lNameField);
        uInfoPanel.add(namePanel);
        
        JPanel address1Panel = getFormattedPanel();
        address1Panel.add(getLabel("Address:"));
        JTextField addressField = new JTextField(customer.getAddress(), 29);
        addressField.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        address1Panel.add(addressField);
        uInfoPanel.add(address1Panel);
        
        JPanel address2Panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        address2Panel.add(getLabel("City:"));
        JTextField cityField = new JTextField(customer.getCity(), 10);
        cityField.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        address2Panel.add(cityField);
        address2Panel.add(getLabel("State:"));
        JTextField stateField = new JTextField(customer.getState(), 7);
        stateField.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        address2Panel.add(stateField);
        address2Panel.add(getLabel("Zip:"));
        JTextField zipField = new JTextField(customer.getZip(), 7);
        zipField.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        address2Panel.add(zipField);
        uInfoPanel.add(address2Panel);
        
        cOutPanel.add(uInfoPanel);
        
        JPanel cardInfoPanel = new JPanel();
        cardInfoPanel.setLayout(new BoxLayout(cardInfoPanel, BoxLayout.Y_AXIS));
        
        JPanel subTitle2Panel = getFormattedPanel();
        JLabel subTitle2Label = new JLabel("Billing Info");
        subTitle2Label.setFont(new Font(Font.DIALOG, Font.PLAIN, 30));
        subTitle2Panel.add(subTitle2Label);
        uInfoPanel.add(subTitle2Panel);
        
        JPanel cardNamePanel = getFormattedPanel();
        cardNamePanel.add(getLabel("Name on Card:"));
        JTextField cardNameField = new JTextField(21);
        cardNameField.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        cardNamePanel.add(cardNameField);
        cardInfoPanel.add(cardNamePanel);
        
        JPanel cardNumPanel = getFormattedPanel();
        cardNumPanel.add(getLabel("Card Number:"));
        JTextField cardNumField = new JTextField(22);
        cardNumField.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        cardNumPanel.add(cardNumField);
        cardInfoPanel.add(cardNumPanel);
        
        JPanel cardDetPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cardDetPanel.add(getLabel("Expiration Month:"));
        JTextField expMonthField = new JTextField(5);
        expMonthField.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        cardDetPanel.add(expMonthField);
        cardDetPanel.add(getLabel("Year:"));
        JTextField expYearField = new JTextField(4);
        expYearField.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        cardDetPanel.add(expYearField);
        cardDetPanel.add(getLabel("CVV:"));
        JTextField cvvField = new JTextField(3);
        cvvField.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        cardDetPanel.add(cvvField);
        cardInfoPanel.add(cardDetPanel);
        
        cOutPanel.add(cardInfoPanel);
        mainPanel.add(cOutPanel, BorderLayout.CENTER);
        
        
        double total = CartInstance.getInstance().getCart().getSalesTotal();
        JPanel buttonPanel = new JPanel();
        JButton checkOutButton = getButton("Confirm Purchase : " + String.format( "%.2f", total));
        checkOutButton.addActionListener(Action.completePurchaseListener());
        buttonPanel.add(checkOutButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        return mainPanel;
    }
    
    public static JLabel getLabel(String s){
        JLabel label = new JLabel(s);
        label.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        return label;
    }
    
    public static JPanel getFormattedPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.setPreferredSize(new Dimension(800, 60));
        panel.setMaximumSize(panel.getPreferredSize());
        
        return panel;
    }
    
    
}
