class StockPrice {

    Map<Integer, Integer> timePrice;
    TreeMap<Integer, Integer> priceCount;
    int latestTime;

    public StockPrice() {
        timePrice = new HashMap<>();
        priceCount = new TreeMap<>();
        latestTime = 0;
    }

    public void update(int timestamp, int price) {

        if (timePrice.containsKey(timestamp)) {
            int oldPrice = timePrice.get(timestamp);

            // remove old price count
            priceCount.put(oldPrice, priceCount.get(oldPrice) - 1);
            if (priceCount.get(oldPrice) == 0) {
                priceCount.remove(oldPrice);
            }
        }

        timePrice.put(timestamp, price);
        priceCount.put(price, priceCount.getOrDefault(price, 0) + 1);

        latestTime = Math.max(latestTime, timestamp);
    }

    public int current() {
        return timePrice.get(latestTime);
    }

    public int maximum() {
        return priceCount.lastKey();
    }

    public int minimum() {
        return priceCount.firstKey();
    }
}
