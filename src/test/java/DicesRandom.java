import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.get;

public class DicesRandom extends RandomHelper {
    @Test
    public void random() {
        // Get all rolls
        Response response = get(apiURL
                + "/integers/?num=" + rolls
                + "&min=" + minNumberOfCombinations
                + "&max=" + maxNumberOfCombinations
                + "&col=1&base=10&format=plain&rnd=new");
        Assert.assertEquals(response.statusCode(), 200);
        String allRolls = response.getBody().asString();

        // Put all rolls in the sting array
        String [] ch = allRolls.split("\n");

        // Count rolls by number on the dice
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String a: ch){
            if (hashMap.containsKey(a)){
                hashMap.put(a, hashMap.get(a)+1);
            } else {
                hashMap.put(a, 1);
            }
        }

        // Check that array has all elements
        double hashMapSize = hashMap.size();
        Assert.assertEquals(hashMapSize, maxNumberOfCombinations(), "Array doesn't have all dice numbers");

        // How many times each number was found
        for(int i = (int)minNumberOfCombinations; i<=maxNumberOfCombinations; i++) {
            System.out.println("Number " + i + " was found "+ hashMap.get(""+ i +"") + " times");
        }

        // Get percentage for one throw
        double percentagePerThrow = 100/rolls;

        // Percentage for each number
        for(int i = (int)minNumberOfCombinations; i<=maxNumberOfCombinations; i++) {
            double percentageForNumber = hashMap.get(""+ i +"")*percentagePerThrow;
            System.out.println("Percentage for number " + i + " = "+ percentageForNumber  + "%");
        }

        // Check that deviation percentage is correct
        double minDeviationPercentage = (100/maxNumberOfCombinations())-deviationPercentage;
        double maxDeviationPercentage = (100/maxNumberOfCombinations())+deviationPercentage;
        System.out.println("minDeviationPercentage = " + minDeviationPercentage);
        System.out.println("maxDeviationPercentage = " + maxDeviationPercentage);

        for(int i = (int)minNumberOfCombinations; i<=maxNumberOfCombinations; i++) {
            double percentageForNumber = hashMap.get(""+ i +"")*percentagePerThrow;
            Assert.assertTrue(percentageForNumber >= minDeviationPercentage && percentageForNumber <= maxDeviationPercentage, "percentage for number " + i + " is wrong");
        }
    }
}
