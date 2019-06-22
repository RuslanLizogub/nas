## Task
```
Task Description
Create tests for https://www.random.org/dice/?num=1 (num=2) to check the following
hypothesis: &quot;For large number of rolls (number of rolls &gt; 1000) distribution of dice points
strives to uniform distribution.&quot;

Requirements: tests should check that maximum deviation of dice results is within 5% First
test: for 1 dice Second test: for 2 dices (total roll points is a sum of 2 dices)

Hint 1: try 1000, 5000, 10000 number of rolls and see how distribution changes
Hint 2: think about how to implement the solution in the most efficient way
```

##Explanation on the example of 1000 rolls of 1 die.
```
1) First, we throw a dice for 1000 times and save how many times each number has fallen.
2) The probabilities for one die are calculated using the formula (for example, 1000 shots):
`100% / 1000 (dice rolls) = 0.1%` (for one roll). 
3) We create counters in which we count how many times each number falls.
4) Then we simply multiply the number of the drops of each number by the percentage of falling out (0.1%)
5) After we get the percentage, we check that the deviation does not go up by 5%:
`100% / 6 = 16.6%`, tolerance `> = 11.6 && <= 21.6`
```

## Running by gradle
```sh
gradle clean test

System variables:
-DapiURL (default value = "https://www.random.org")
-Ddices (default value = "1")
-Drolls (default value = "1000")
-DdeviationPercentage (default value = "5")
```

## Test results
### Case 1: 1000 number of rolls for 1 dice (deviation of dice results is within 5%) - PASSED
```sh
    Number 1 was found 160 times
    Number 2 was found 158 times
    Number 3 was found 158 times
    Number 4 was found 168 times
    Number 5 was found 167 times
    Number 6 was found 189 times
    Percentage for number 1 = 16.0%
    Percentage for number 2 = 15.8%
    Percentage for number 3 = 15.8%
    Percentage for number 4 = 16.8%
    Percentage for number 5 = 16.7%
    Percentage for number 6 = 18.900000000000002%
    minDeviationPercentage = 11.666666666666668
    maxDeviationPercentage = 21.666666666666668
```
### Case 2: 1000 number of rolls for 2 dice (deviation of dice results is within 5%) - PASSED
```sh
    Number 2 was found 87 times
    Number 3 was found 80 times
    Number 4 was found 98 times
    Number 5 was found 103 times
    Number 6 was found 93 times
    Number 7 was found 96 times
    Number 8 was found 107 times
    Number 9 was found 82 times
    Number 10 was found 85 times
    Number 11 was found 76 times
    Number 12 was found 93 times
    Percentage for number 2 = 8.700000000000001%
    Percentage for number 3 = 8.0%
    Percentage for number 4 = 9.8%
    Percentage for number 5 = 10.3%
    Percentage for number 6 = 9.3%
    Percentage for number 7 = 9.600000000000001%
    Percentage for number 8 = 10.700000000000001%
    Percentage for number 9 = 8.200000000000001%
    Percentage for number 10 = 8.5%
    Percentage for number 11 = 7.6000000000000005%
    Percentage for number 12 = 9.3%
    minDeviationPercentage = 4.090909090909092
    maxDeviationPercentage = 14.090909090909092
```
### Case 3: 5000 number of rolls for 1 dice (deviation of dice results is within 5%) - PASSED
```sh
    Number 1 was found 846 times
    Number 2 was found 815 times
    Number 3 was found 853 times
    Number 4 was found 812 times
    Number 5 was found 835 times
    Number 6 was found 839 times
    Percentage for number 1 = 16.92%
    Percentage for number 2 = 16.3%
    Percentage for number 3 = 17.06%
    Percentage for number 4 = 16.240000000000002%
    Percentage for number 5 = 16.7%
    Percentage for number 6 = 16.78%
    minDeviationPercentage = 11.666666666666668
    maxDeviationPercentage = 21.666666666666668
```
### Case 4: 5000 number of rolls for 2 dice (deviation of dice results is within 5%) - PASSED
```sh
    Number 2 was found 461 times
    Number 3 was found 450 times
    Number 4 was found 470 times
    Number 5 was found 418 times
    Number 6 was found 466 times
    Number 7 was found 400 times
    Number 8 was found 487 times
    Number 9 was found 478 times
    Number 10 was found 461 times
    Number 11 was found 447 times
    Number 12 was found 462 times
    Percentage for number 2 = 9.22%
    Percentage for number 3 = 9.0%
    Percentage for number 4 = 9.4%
    Percentage for number 5 = 8.36%
    Percentage for number 6 = 9.32%
    Percentage for number 7 = 8.0%
    Percentage for number 8 = 9.74%
    Percentage for number 9 = 9.56%
    Percentage for number 10 = 9.22%
    Percentage for number 11 = 8.94%
    Percentage for number 12 = 9.24%
    minDeviationPercentage = 4.090909090909092
    maxDeviationPercentage = 14.090909090909092
```
### Case 5: 10000 number of rolls for 1 dice (deviation of dice results is within 5%) - PASSED
```sh
    Number 1 was found 1720 times
    Number 2 was found 1651 times
    Number 3 was found 1722 times
    Number 4 was found 1589 times
    Number 5 was found 1693 times
    Number 6 was found 1625 times
    Percentage for number 1 = 17.2%
    Percentage for number 2 = 16.51%
    Percentage for number 3 = 17.22%
    Percentage for number 4 = 15.89%
    Percentage for number 5 = 16.93%
    Percentage for number 6 = 16.25%
    minDeviationPercentage = 11.666666666666668
    maxDeviationPercentage = 21.666666666666668
```
### Case 6: 10000 number of rolls for 2 dice (deviation of dice results is within 5%) - PASSED
```sh
    Number 2 was found 938 times
    Number 3 was found 887 times
    Number 4 was found 921 times
    Number 5 was found 932 times
    Number 6 was found 934 times
    Number 7 was found 874 times
    Number 8 was found 899 times
    Number 9 was found 931 times
    Number 10 was found 920 times
    Number 11 was found 883 times
    Number 12 was found 881 times
    Percentage for number 2 = 9.38%
    Percentage for number 3 = 8.870000000000001%
    Percentage for number 4 = 9.21%
    Percentage for number 5 = 9.32%
    Percentage for number 6 = 9.34%
    Percentage for number 7 = 8.74%
    Percentage for number 8 = 8.99%
    Percentage for number 9 = 9.31%
    Percentage for number 10 = 9.200000000000001%
    Percentage for number 11 = 8.83%
    Percentage for number 12 = 8.81%
    minDeviationPercentage = 4.090909090909092
    maxDeviationPercentage = 14.090909090909092
```
