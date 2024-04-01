package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

public class ProductMgmtApp {
    public static void main(String[] args) {
        Product[] products = {
                new Product(3128874119L, "Banana", LocalDate.of(2023, 1, 24), 124, 0.55),
                new Product(2927458265L, "Apple", LocalDate.of(2022, 12, 9), 18, 1.09),
                new Product(9189927460L, "Carrot", LocalDate.of(2023, 3, 31), 89, 2.99)};

        Arrays.sort(products, Comparator.comparing(Product::getName));
        printProducts(products);

    }
    private static void printProducts (Product[] products){
        System.out.println(
                printJSON(products) + "\n----------------------------------\n" +
                        printXML(products) + "\n----------------------------------\n" +
                        printCSV(products));
    }

    private static String printJSON(Product[] products) {
        StringBuilder str = new StringBuilder("Printed in JSON Format\n[");
        for (Product p : products) {
            str.append("\n\t{ \"productId\":").append(p.getProductId()).append(", \"name\":\"").append(p.getName()).append("\"").append(", \"dateSupplied\":\"").append(p.getDateSupplied()).append("\"").append(", \"quantityInStock\":").append(p.getQuantityInStock()).append(", \"unitPrice\":").append(p.getUnitPrice()).append(" }");
        }
        str.append("\n]");
        return str.toString();
    }

    private static String printXML(Product[] products) {
        StringBuilder str = new StringBuilder("Printed in XML Format\n<?xml version=\"1.0\"?>\n<products>");
        for (Product p : products) {
            str.append("\n\t<product productId=\"").append(p.getProductId()).append("\"").append(" name=\"").append(p.getName()).append("\"").append(" dateSupplied=\"").append(p.getDateSupplied()).append("\"").append(" quantityInStock=\"").append(p.getQuantityInStock()).append("\"").append(" unitPrice=\"").append(p.getUnitPrice()).append("\">");
        }
        str.append("\n</products>");
        return str.toString();
    }

    private static String printCSV(Product[] products) {
        StringBuilder str = new StringBuilder("Printed in Comma-Separated Value(CSV) Format");
        for (Product p : products) {
            str.append("\n").append(p.getProductId()).append(", ").append(p.getName()).append(", ").append(p.getDateSupplied()).append(", ").append(p.getQuantityInStock()).append(", ").append(p.getUnitPrice());
        }
        return str.toString();
    }
}
