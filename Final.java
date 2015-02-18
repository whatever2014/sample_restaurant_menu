import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.text.*;

public class Final extends JApplet {
	  
	// Declare one button to let users add to  order 
	private JButton jbtAddToOrderStarters = new JButton("Add to Order");
	private JButton jbtAddToOrderPizzas = new JButton("Add to Order");
	private JButton jbtAddToOrderSalads = new JButton("Add to Order");
	private JButton jbtAddToOrderDrinks = new JButton("Add to Order");
	private JButton jbtAddToOrderDesserts = new JButton("Add to Order");
	
	// Declare one button to let users finish the order and exit 
	private JButton jbtComplete = new JButton("Complete my Order"); 
	 
	// Create two radio buttons to mention customer's options
	private JRadioButton jrbPickUp, jrbDelivery;
	 
	// Create three radio buttons for Pizzas,soft drinks
	private JRadioButton jrbSPizza, jrbMPizza, jrbLPizza;
	private JRadioButton jrbSDrinks, jrbMDrinks, jrbLDrinks;
	  
	//Declare an array of Strings for Starts, Pizzas, salads, soft drinks, and desserts
	private String[] starts = {"Fried Mushrooms", "Mozzarella Sticks", "Garlic Bread"};
	private String[] pizzas = {"Thick Crust Pizza", "Stuffed Pizza", "Triple Meet"};
	private String[] salads = {"Roasted Tomato Salad", "Spicy Italian Salad", "Bocconcini Salad"};
	private String[] drinks = {"Sprite", "Coke", "Pepsi"};
	private String[] desserts = {"Zeppole","Tiramisu", "Ricotta Pie"};


	
	// Declare and create a description panel for Starts, Pizzas, salads, soft drinks, and desserts
	private DescriptionPanel titleAndDescriptionsStarts = new DescriptionPanel();
	private DescriptionPanel titleAndDescriptionsPizzas = new DescriptionPanel();
	private DescriptionPanel titleAndDescriptionsSalads = new DescriptionPanel();
	private DescriptionPanel titleAndDescriptionsDrinks = new DescriptionPanel();
	private DescriptionPanel titleAndDescriptionsDesserts = new DescriptionPanel();
		
		
	// Create two check boxes to ask for double cheese and/or toppings (Pizza)
	private JCheckBox jchkDoubleCheese = new JCheckBox("Double Cheese - $2.00");
	private JCheckBox jchkDoubleToppings = new JCheckBox("Double Toppings - $2.00");

	private double startsPrice = 0.00;
	private double pizzaPrice = 0.00;
	private double extrasPrice = 0.00;
	private double saladsPrice = 0.00;
	private double drinksPrice = 0.00;
	private double dessertsPrice = 0.00;
	private double deliveryFee = 0.00;
	private double subTotalPrice = 0.00;
	private double totalPrice = 0.00;

	// Format text fields to show currency value
	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
	private JFormattedTextField subTotal = 
		new JFormattedTextField(currencyFormat);
	private JFormattedTextField total = 
		new JFormattedTextField(currencyFormat);


	private Border border;

	public Final() { 
		    
        // Create title for the project 
         
		JLabel jlbRestaurantName = new JLabel("  Ying and Blake's Italian Resturant  ", JLabel.CENTER);
		jlbRestaurantName.setFont(new Font("SansSerif", Font.BOLD, 20));
	
		 
	// Set titles, text and image in the description panel for Starts
        titleAndDescriptionsStarts.setTitle("Starts");
        String startsDescription = "Starters include: Fried Mushrooms, "
        		+ "Mozzarella Sticks, Garlic Bread\n"
        		+ "\nFrom $3.99";
        titleAndDescriptionsStarts.setImageIcon(new ImageIcon(getClass().getResource("image/GarlicBread.jpg")));
        titleAndDescriptionsStarts.setDescription(startsDescription);
        
        // Create a panel to hold the name of product (Starts) 
	  JPanel jpStartNames = new JPanel();
	  jpStartNames.setLayout(new GridLayout(1, 2, 1, 1));
	  jpStartNames.add(new JLabel ("        Type")); 
	  jpStartNames.add(new JComboBox(starts)); 
		
	  
	  // Create a panel to hold combo panel and addToOrder panel (Starts) 
	  JPanel jpStarterOption = new JPanel(new GridLayout(2, 1));
	  jpStarterOption.add(jpStartNames);  
	  jpStarterOption.add(jbtAddToOrderStarters); 
	  
	  // Create a panel to hold title/description panel and option panel (Staters)
	  JPanel jpStarter = new JPanel(new GridLayout(1, 2, 2, 2)); 
	  jpStarter.add(titleAndDescriptionsStarts); 
	  jpStarter.add(jpStarterOption); 
	 
	  border = new LineBorder(Color.BLACK,1);
	  jpStarter.setBorder(border);
	  
        // Set titles, text and image in the description panel for Pizzas 
        titleAndDescriptionsPizzas.setTitle("Pizza");
        String pizzaDescription = "Pizzas include: Thick Crust Pizza, Stuffed Pizza, Triple Meet\n"
              + "\nFrom $8.99";
        titleAndDescriptionsPizzas.setImageIcon(new ImageIcon(getClass().getResource("image/ChickenPizza.jpg")));
        titleAndDescriptionsPizzas.setDescription(pizzaDescription);   
	 
	  // Create a panel to hold the name of product (Pizza) 
	  JPanel jpPizzaNames = new JPanel();
	  jpPizzaNames.setLayout(new GridLayout(1, 2, 1, 1));
	  jpPizzaNames.add(new JLabel("        Type")); 
	  jpPizzaNames.add(new JComboBox(pizzas)); 	  
				  	
	  // Create a panel to hold three radio buttons (Pizza)
	  JPanel jrbtPizza = new JPanel(new GridLayout(1, 3));
	  
	  jrbtPizza.add(jrbSPizza = new JRadioButton("S-$8.99"));
	  jrbtPizza.add(jrbMPizza = new JRadioButton("M-$10.99"));
	  jrbtPizza.add(jrbLPizza = new JRadioButton("L-$12.99"));
	  //add(jrbtPizza, BorderLayout.WEST); 
	 
	  // Create a radio button group to group three buttons
	  ButtonGroup groupPizza = new ButtonGroup();
	  groupPizza.add(jrbSPizza);
	  groupPizza.add(jrbMPizza);
	  groupPizza.add(jrbLPizza);
	  		

	  // Create a panel to hold checkboxes (pizza)
	  JPanel jCheckbox = new JPanel(new GridLayout(1, 2, 2, 2));
	  jCheckbox.add(jchkDoubleCheese, BorderLayout.WEST);
	  jCheckbox.add(jchkDoubleToppings,BorderLayout.EAST);
	  
	  
	  // Create a panel to hold combox, radio button panel, checkbox, and addToOrder panel (Pizza) 
	  JPanel jpPizzaOption = new JPanel(new GridLayout(4, 1, 1,1));
	  jpPizzaOption.add(jpPizzaNames);
	  jpPizzaOption.add(jrbtPizza);
	  jpPizzaOption.add(jCheckbox);    
	  jpPizzaOption.add(jbtAddToOrderPizzas); 
	  	 
	  // Create a panel to hold title/description panel and option panel (Pizza)
	  JPanel jpPizza = new JPanel(new GridLayout(1, 2, 2, 2)); 
	  jpPizza.add(titleAndDescriptionsPizzas); 
	  jpPizza.add(jpPizzaOption); 
	  
	  border = new LineBorder(Color.BLACK,1);
	  jpPizza.setBorder(border);
	  
	  titleAndDescriptionsSalads.setTitle("Salads");
	  String saladDescription = "Salads include: Roasted Tomato Salad, Spicy Italian Salad, "
	  		+ "Bocconcini Salad\n"
	  		+ "\nFrom $2.99";
	  titleAndDescriptionsSalads.setImageIcon(new ImageIcon(getClass().getResource("image/RoastedTomato.jpg")));
	  titleAndDescriptionsSalads.setDescription(saladDescription);
	  	  
	  // Create a panel to hold the name of product (Salads) 
	  JPanel jpSaladNames = new JPanel();
	  jpSaladNames.setLayout(new GridLayout(1, 2, 1, 1));
	  jpSaladNames.add(new JLabel("        Type")); 
	  jpSaladNames.add(new JComboBox(salads)); 
	  
	  // Create a panel to hold radio button panel and addToOrder panel (Salads) 
	  JPanel jpSaladOption = new JPanel(new GridLayout(2, 1));
	  jpSaladOption.add(jpSaladNames);  
	  jpSaladOption.add(jbtAddToOrderSalads); 
	  
	  // Create a panel to hold title/description panel and option panel (Salads)
	  JPanel jpSalad = new JPanel(new GridLayout(1, 2, 2, 2)); 
	  jpSalad.add(titleAndDescriptionsSalads); 
	  jpSalad.add(jpSaladOption); 
	  
	  border = new LineBorder(Color.BLACK,1);
	  jpSalad.setBorder(border);
	  
	  titleAndDescriptionsDrinks.setTitle("Drinks");
	  String drinkDescription = "Drinks include: Sprite, Coke, Pepsi\n"
	  		+ "\nFrom $8.99";
	  titleAndDescriptionsDrinks.setImageIcon(new ImageIcon(getClass().getResource("image/pepsi.gif")));
	  titleAndDescriptionsDrinks.setDescription(drinkDescription);
	  
	  // Create a panel to hold the name of product (drinks) 
	  JPanel jpDrinkNames = new JPanel();
	  jpDrinkNames.setLayout(new GridLayout(1, 2, 1, 1));
	  jpDrinkNames.add(new JLabel("        Type")); 
	  jpDrinkNames.add(new JComboBox(drinks)); 
	  
	  // Create a panel to hold three radio buttons (drinks)
	  JPanel jrbtDrink = new JPanel(new GridLayout(1, 3));
	  
	  jrbtDrink.add(jrbSDrinks = new JRadioButton("12oz-$0.99"));
	  jrbtDrink.add(jrbMDrinks = new JRadioButton("20oz-$1.25"));
	  jrbtDrink.add(jrbLDrinks = new JRadioButton("2L-$2.00"));
	  //add(jrbtPizza, BorderLayout.WEST); 
	  
	  // Create a radio button group to group three buttons
	  ButtonGroup groupDrink = new ButtonGroup();
	  groupDrink.add(jrbSDrinks);
	  groupDrink.add(jrbMDrinks);
	  groupDrink.add(jrbLDrinks);
	  
	  // Create a panel to hold comboboxes, radio button panel and addToOrder panel (Drinks) 
	  JPanel jpDrinkOption = new JPanel(new GridLayout(3, 1));
	  jpDrinkOption.add(jpDrinkNames);
	  jpDrinkOption.add(jrbtDrink);  
	  jpDrinkOption.add(jbtAddToOrderDrinks); 
	  
	  // Create a panel to hold title/description panel and option panel (Drinks)
	  JPanel jpDrink = new JPanel(new GridLayout(1, 2, 2, 2)); 
	  jpDrink.add(titleAndDescriptionsDrinks); 
	  jpDrink.add(jpDrinkOption); 
	  
	  border = new LineBorder(Color.BLACK,1);
	  jpDrink.setBorder(border);
	  
	  titleAndDescriptionsDesserts.setTitle("Desserts");
	  String dessertDescription = "Desserts include: Zeppole, Tiramisu, Ricotta Pie\n"
	  		+ "\nFrom $3.99";
	  titleAndDescriptionsDesserts.setImageIcon(new ImageIcon(getClass().getResource("image/RicottaPie.jpg")));
	  titleAndDescriptionsDesserts.setDescription(dessertDescription);

	  // Create a panel to hold the name of product (desserts) 
	  JPanel jpDessertNames = new JPanel();
	  jpDessertNames.setLayout(new GridLayout(1, 1, 1, 1));
	  jpDessertNames.add(new JLabel("          Type")); 
	  jpDessertNames.add(new JComboBox(desserts));		  
	
	  
	  // Create a panel to hold radio button panel and addToOrder panel (Desserts) 
	  JPanel jpDessertOption = new JPanel(new GridLayout(2, 1));
	  jpDessertOption.add(jpDessertNames);
	  jpDessertOption.add(jbtAddToOrderDesserts); 
	  
	  // Create a panel to hold title/description panel and option panel (Desserts)
	  JPanel jpDessert = new JPanel(new GridLayout(1, 2, 2, 2)); 
	  jpDessert.add(titleAndDescriptionsDesserts); 
	  jpDessert.add(jpDessertOption); 
	  
	  border = new LineBorder(Color.BLACK,1);
	  jpDessert.setBorder(border);
	  
		// Create panel (left) to hold all product info for Starts, Pizzas, salads, soft drinks, and desserts
	  JPanel pAllLeft = new JPanel(new GridLayout(5, 1, 2, 2)); 
	  pAllLeft.add(jpStarter);
	  pAllLeft.add(jpPizza); 
	  pAllLeft.add(jpSalad); 
	  pAllLeft.add(jpDrink); 
	  pAllLeft.add(jpDessert); 

	  // Create panel to hold the menu
	  // JPanel pMenu = new JPanel(new GridLayout(5, 1, 12, 12)); 
	  // pMenu.add(jMenuList);
	  // add(new JScrollPane(jMenuList), BorderLayout.WEST);
	  
	  // Create a panel to hold two radio buttons 
	  JPanel jrbOptions = new JPanel(new GridLayout(2,1));
	  jrbOptions.add(jrbPickUp = new JRadioButton("Pick Up-free"));
	  jrbOptions.add(jrbDelivery = new JRadioButton("Delivery-$4.00"));
	  //add(jrbOptions, BorderLayout.WEST); 
	  
	  // Create a radio button group to group two buttons
	   ButtonGroup groupOptions = new ButtonGroup();
	   groupOptions.add(jrbPickUp);
	   groupOptions.add(jrbDelivery);
	 
	   
	  // Create a summary name 
	   JLabel jlbSummaryName = new JLabel(" Order Summary ", JLabel.CENTER);
	   jlbSummaryName.setFont(new Font("SansSerif", Font.BOLD, 13));
	

	  // final JTextField total = new JTextField();

	
	  final String infoStarter = new String ("Starter"); 
	  final String infoPizza = new String ("Pizza"); 
	  final String infoSalad = new String ("Salad"); 
	  final String infoDrink = new String ("Drink"); 
	  final String infoDessert = new String ("Dessert"); 
	  
	  final JTextArea jTextAreaProduct = new JTextArea(); 
	  
	  // Create a new panel for product info printout 
	  JPanel pProductInfo = new JPanel(new GridLayout(2, 1, 2, 2)); 
	  
	  pProductInfo.add(new JLabel("Products"));
	  pProductInfo.add(new JScrollPane(jTextAreaProduct));
	 
	  
	  // Create a new panel for the total panel 
	  JPanel jpPriceTotal = new JPanel(new GridLayout(2, 2, 2, 2)); 
	  
	  jpPriceTotal.add(new JLabel(" "));
	  jpPriceTotal.add(new JLabel("+ Tax:7.5% "));
	  jpPriceTotal.add(new JLabel(" Total "));
	  jpPriceTotal.add(total); 
	  
	  // Create a new panel for the top part of the summary 
	  JPanel jpTopSizeOfSummary = new JPanel(new GridLayout(2, 1)); 
	  
	  jpTopSizeOfSummary.add(pProductInfo);
	  jpTopSizeOfSummary.add(jpPriceTotal);
 
		// Register listeners for check boxes
    jbtAddToOrderStarters.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    			startsPrice = 3.99;
					subTotalPrice = startsPrice + saladsPrice + pizzaPrice + extrasPrice + drinksPrice + dessertsPrice; 	
					subTotal.setValue(subTotalPrice);
    	}
    });

    jbtAddToOrderSalads.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    			saladsPrice = 2.99;
					subTotalPrice = startsPrice + saladsPrice + pizzaPrice + extrasPrice + drinksPrice + dessertsPrice; 	
					subTotal.setValue(subTotalPrice);
    	}
    });

    jrbSPizza.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
         pizzaPrice = 8.99;
      }
    });

    jrbMPizza.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
					pizzaPrice = 10.99;
      }
    });

    jrbLPizza.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         pizzaPrice = 12.99;
      }
    });
			    
		jchkDoubleCheese.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
      	if (jchkDoubleCheese.isSelected()) {
        	extrasPrice += 2.0; 	
				}
			 if (!jchkDoubleCheese.isSelected()) {
         extrasPrice -= 2.0;
    		}
      }
    });

    jchkDoubleToppings.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         if (jchkDoubleToppings.isSelected()) {
         	extrasPrice += 2.0;
					}
				 if (!jchkDoubleToppings.isSelected()) {
				 	extrasPrice -= 2.0;
         }
      }
    });

    jbtAddToOrderPizzas.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
					subTotalPrice = startsPrice + saladsPrice + pizzaPrice + extrasPrice + drinksPrice + dessertsPrice; 	
					subTotal.setValue(subTotalPrice);
    	}
    });    

    jrbSDrinks.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
         drinksPrice = 0.99;
      }
    });

    jrbMDrinks.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
					drinksPrice = 1.25;
      }
    });

    jrbLDrinks.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
         drinksPrice = 2.00;
      }
    });
			    
    jbtAddToOrderDrinks.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
					subTotalPrice = startsPrice + saladsPrice + pizzaPrice + extrasPrice + drinksPrice + dessertsPrice; 	
					subTotal.setValue(subTotalPrice);
    	}
    });

    jbtAddToOrderDesserts.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    			dessertsPrice = 3.99;
					subTotalPrice = startsPrice + saladsPrice + pizzaPrice + extrasPrice + drinksPrice + dessertsPrice; 	
					subTotal.setValue(subTotalPrice);
    	}
    });

		// Listener for delivery fee
    jrbDelivery.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
         if (e.getStateChange() == 1) {
	         deliveryFee = 4.0;
					}
					else if (e.getStateChange() == 2) {
						deliveryFee = 0.0;
					}
      }
    });

    // Listener for total price
    jbtComplete.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
					totalPrice = (subTotalPrice + deliveryFee) * 1.075;
					total.setValue(totalPrice);
    	}
    });
	  	
		// Create a panel to hold "Special instruction"
		JPanel jpSpecialInstruction = new JPanel(new GridLayout(2,1)); 
		jpSpecialInstruction.add(new JLabel("Special Instruction:"),BorderLayout.SOUTH);
		jpSpecialInstruction.add(new JTextField(3));


		JPanel pSubTotal = new JPanel(new FlowLayout());
		pSubTotal.add(new JLabel("Subtotal"));
		pSubTotal.add(subTotal);
		subTotal.setColumns(8);
		subTotal.setHorizontalAlignment(JTextField.RIGHT);

		JPanel pTotal = new JPanel(new FlowLayout());
		pTotal.add(new JLabel("Total"));
		pTotal.add(total);
		total.setColumns(8);
		total.setHorizontalAlignment(JTextField.RIGHT);

		// Create a new panel to hold info about summary 	 
		JPanel pSummary = new JPanel(new GridLayout(6, 1)); 

		pSummary.add(jlbSummaryName); 
		pSummary.add(jpSpecialInstruction);
		// pSummary.add(jpTopSizeOfSummary);
		pSummary.add(pSubTotal);
		pSummary.add(jrbOptions);
		pSummary.add(pTotal);
		pSummary.add(jbtComplete, BorderLayout.SOUTH); 

		total.setEditable(false);
		subTotal.setEditable(false);

		  
		 
		  
		 // Set up the layput for the whole interface 
		 JPanel jpWholeInterface = new JPanel(new BorderLayout(2,1));

		 jpWholeInterface.add(jlbRestaurantName, BorderLayout.NORTH);
		 jpWholeInterface.add(pSummary,BorderLayout.EAST); 
		 jpWholeInterface.add(pAllLeft, BorderLayout.CENTER);
		 add(jpWholeInterface);
		      
	  }

}