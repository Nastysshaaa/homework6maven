package ru.netology.stats;

public class StatsService {
    public long sum(long[] sales) {
        long totalSale = 0; // изначальная сумма всех продаж

        for (long sale : sales) {
            totalSale = totalSale + sale;
        }
        return totalSale;

    }

    public long averageAmount(long[] sales) {
        return sum(sales) / 12; // или из вебинара поделить не на сумму мес.,а на длину массива: return  sun(sales) / sales.length;
    }

    public int monthMaxSales(long[] sales) {
        int monthMax = 0;
        long maxSales = sales[0];
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= maxSales) {   //чтобы выполнить условие (последний месяц с макс. продажами)
                monthMax = i;
                maxSales = sales[i];
            }

        }
        return monthMax + 1;
    }

    public int monthMinSales(long[] sales) {
        int monthMin = 0;
        long minSales = sales[0];
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] <= minSales) {   //чтобы выполнить условие (последний месяц с макс. продажами)
                monthMin = i;
                minSales = sales[i];
            }
        }
        return monthMin + 1;
    }

    public int monthsBelowAverage(long[] sales) {
        int counter = 0;
        // long averageAmountSale = averageAmount(sales); - из вебинара чтобы не вызывать многократно, задаем вне цикла
        for (long sale : sales) {
            if (sale < averageAmount(sales)) {  // заменяем averageAmount(sales) на averageAmountSale
                counter++;
            }
        }
        return counter;
    }

    public int monthsAboveAverage(long[] sales) {
        int counter = 0;
        long averageAmountSale = averageAmount(sales);
        for (long sale : sales) {
            if (sale > averageAmountSale) {
                counter++;
            }
        }
        return counter;
    }
}