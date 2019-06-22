public class RandomHelper {
    String apiURL = System.getProperty("apiURL");

    double dices = Double.parseDouble(System.getProperty("dices"));
    double rolls = Double.parseDouble(System.getProperty("rolls"));
    double deviationPercentage = Double.parseDouble(System.getProperty("deviationPercentage"));

    double minNumberOfCombinations = 1*dices;
    double maxNumberOfCombinations = 6*dices;

    double maxNumberOfCombinations () {
        double counter = dices-1;
        double result = 0;
        if (dices == 1) {
            result = maxNumberOfCombinations;
        } else {
            result = maxNumberOfCombinations - counter;
        }
        return result;
    }
}
