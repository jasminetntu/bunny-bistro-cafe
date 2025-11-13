package com.bunnybistrocafe.util;

import com.bunnybistrocafe.models.MenuItem;
import com.bunnybistrocafe.models.Order;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    public String getReceipt(Order order) {
        final double taxPercent = 0.09;

        StringBuilder sb = new StringBuilder();
        // innerWidth = 45;

        // add header
        sb.append("""
                   ∩_∩
                 („• •„) Bunny Bistro Cafe 🍵ིྀ༘₊˚⊹
                •··U U··················•·······················•
                ·                    Receipt 🧾                 ·
                •·······················•·······················•
                """);

        // add individual items
        for (MenuItem item : order.getItems()) {
            sb.append(String.format("%s%n", item.toString()));
        }

        // add totals
        String subtotalStr = String.format("Subtotal: $%.2f", order.calculateSubtotal());
        String taxStr = String.format("Tax (9%%): $%.2f", order.calculateTax(taxPercent));
        String totalStr = String.format("Total: $%.2f", order.calculateTotal(taxPercent));

        sb.append(String.format("•·······················•·······················•" +
                        "%n%45s%n%45s%n%45s%n" +
                        "•·······················•·······················•",
                subtotalStr, taxStr, totalStr));

        return sb.toString();
    }

    public void writeToTxtFile(Order order) throws IOException {
        //File name format: yyyyMMdd-hhmmss.txt (e.g., 20230329-121523.txt)
        final String RECEIPT_FOLDER = "receipts";

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("/yyyyMMdd-hhmmss");

        File file = new File(RECEIPT_FOLDER + formatter.format(dateTime) + ".txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            formatter = DateTimeFormatter.ofPattern("MM dd, yyyy | hh:mm:ss");
            bw.write("Date & Time: " + formatter.format(dateTime) + "\n\n");
            bw.write(getReceipt(order));
        }
    }
}
