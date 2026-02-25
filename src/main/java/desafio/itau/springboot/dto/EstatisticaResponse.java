package desafio.itau.springboot.dto;

import java.util.DoubleSummaryStatistics;

public class EstatisticaResponse {

    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;


    public EstatisticaResponse(DoubleSummaryStatistics statistics){
        if(statistics.getCount() == 0){
            this.count = 0;
            this.sum = 0.0;
            this.avg = 0.0;
            this.min = 0.0;
            this.max = 0.0;
        }
        else{
            this.count = statistics.getCount();
            this.sum = statistics.getSum();
            this.avg = statistics.getAverage();
            this.min = statistics.getMin();
            this.max = statistics.getMax();
        }
    }

    public double getAvg() {
        return avg;
    }

    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public double getSum() {
        return sum;
    }

    public long getCount() {
        return count;
    }
}


