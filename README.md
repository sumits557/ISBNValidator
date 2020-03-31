# Followed by Test driven development (TDD)

Positive, Negative test cases by assertions, Stubing, mockito etc.


# ISBN logic
10 Digit valid ISBN number (0140449116): 

 `ISBN`    |0 |1 |4 |0 |4 |4 |9 |1|1|6
 `x`       |10|9 |8 |7 |6 |5 |4 |3|2|1
 `=`       |0 |9 |32|0 |24|20|36|3|2|6

Total = 0+9+32+0+24+36+3+2+6 = 132/11 = 12


10 Digit Invalid ISBN number (0140449117): 

 `ISBN`    |0 |1|4 |0|4 |4 |9 |1|1|7
 `x`       |10|9|8 |7|6 |5 |4 |3|2|1
 `=`       |0 |9|32|0|24|20|36|3|2|7

Total = 0+9+32+0+24+36+3+2+7 = 133/11 = 12.0909



