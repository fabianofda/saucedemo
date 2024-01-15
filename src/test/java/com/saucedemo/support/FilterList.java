package com.saucedemo.support;

import java.util.List;

public class FilterList {

    public boolean isListInDescendingOrder(List<String> items) {
        for (int i = 0; i < items.size() - 1; i++) {
            if (items.get(i).compareTo(items.get(i + 1)) < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isListInAscendingOrder(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPriceListInAscendingOrder(List<String> priceList) {
        for (int i = 0; i < priceList.size() - 1; i++) {
            double price1 = Double.parseDouble(priceList.get(i).replace("$", ""));
            double price2 = Double.parseDouble(priceList.get(i + 1).replace("$", ""));

            if (price1 > price2) {
                return false;
            }
        }
        return true;
    }

    public boolean isPriceListInDescendingOrder(List<String> priceList) {
        for (int i = 0; i < priceList.size() - 1; i++) {
            double currentPrice = parsePrice(priceList.get(i));
            double nextPrice = parsePrice(priceList.get(i + 1));

            if (currentPrice < nextPrice) {
                return false;
            }
        }
        return true;
    }

    private double parsePrice(String price) {
        return Double.parseDouble(price.replace("$", ""));
    }

}
