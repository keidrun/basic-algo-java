# basic-algo-java

[![tests][tests]][tests-url]
[![coverage][cover]][cover-url]

Basic algorithm library in java.

## Complexities of Searching algorithms
| Algorithm              | Best time      | Average time  | Worst time  | Worst space   |
|:-----------------------|:--------------:|:-------------:|:-----------:|:-------------:|
| Linear Search          |          Ω(1) |         Θ(n) |        O(n) |          O(1) |
| Binary Search          |          Ω(1) |    Θ(log(n)) |   O(log(n)) |          O(1) |
| Self-Organizing Search |          Ω(1) |         Θ(n) |        O(n) |          O(1) |

## Complexities of Sorting algorithms of Array
| Algorithm             | Best time       | Average time  | Worst time  | Worst space  | Stable |
|:----------------------|:---------------:|:-------------:|:-----------:|:------------:|:------:|
| Bubble Sort           |           Ω(n) |       Θ(n^2) |      O(n^2) |         O(1) | Yes    |
| Quick Sort            |    Ω(n log(n)) |  Θ(n log(n)) |      O(n^2) |    O(log(n)) | No     |
| Merge Sort            |    Ω(n log(n)) |  Θ(n log(n)) | O(n log(n)) |         O(n) | Yes    |
| Comb Sort             | Ω((n^2)/(2^p)) |  Θ(n log(n)) |      O(n^2) |         O(1) | No     |
| Insertion Sort        |           Ω(n) |       Θ(n^2) |      O(n^2) |         O(1) | Yes    |
| Binary Insertion Sort |    Ω(n log(n)) |       Θ(n^2) |      O(n^2) |         O(1) | Yes    |

## Complexities of Data structures
| Data Structure                    | Access (AVG. time) | Insertion (AVG. time) | Deletion (AVG. time) | Search (AVG. time) | Access (WST. time) | Insertion (WST. time) | Deletion (WST. time) | Search (WST. time) | WST. space  |
|:----------------------------------|:---------:|:---------:|:---------:|:-----------------------------:|:---------:|:---------:|:---------:|:-----------------------------:|:-----------:|
| Basic Array                       |     Θ(1) |     Θ(n) |     Θ(n) | Depend on Searching algorithm |      O(1) |      O(n) |      O(n) | Depend on Searching algorithm |        O(n) |
| Dynamic Array (ArrayList in java) |     Θ(1) |     Θ(n) |     Θ(n) | Depend on Searching algorithm |      O(1) |      O(n) |      O(n) | Depend on Searching algorithm |        O(n) |
| Singly Linked List                |     Θ(n) |     Θ(1) |     Θ(1) |                          O(n) |      O(n) |      O(1) |      O(1) |                          O(n) |        O(n) |
| Doubly Linked List                |     Θ(n) |     Θ(1) |     Θ(1) |                          O(n) |      O(n) |      O(1) |      O(1) |                          O(n) |        O(n) |
| Stack                             |     Θ(n) |     Θ(1) |     Θ(1) |                          O(n) |      O(n) |      O(1) |      O(1) |                          O(n) |        O(n) |
| Queue                             |     Θ(n) |     Θ(1) |     Θ(1) |                          O(n) |      O(n) |      O(1) |      O(1) |                          O(n) |         O(n) |

## Common Rates Of Growth
| Rate Of Growth | Name               | Complexity |
|:--------------:|:------------------:|:----------:|
| 2^(2n)         |     -              |  Biggest   |
| n!             | Factorial          |     -      |
| 4^n            |     -              |     -      |
| 2^n            | Exponential        |     -      |
| n^3            | Cubic              |     -      |
| n^2            | Quadratic          |     -      |
| n log(n)       | Linear Logarithmic |     -      |
| log(n!)        | Log Factorial      |     -      |
| n              | Linear             |     -      |
| 2^(log(n))     |     -              |     -      |
| (log^2)(n)     |     -              |     -      |
| log(n)         | Logarithmic        |     -      |
| √(log(n))     |     -              |     -      |
| log(log(n))    | Log Logarithmic    |     -      |
| 1              | Constant           |  Smallest  |

## Terms
- 'log(n)' means 'log2(n)'.
- '(log^2)(n)' means '(log(n))^2'.
- 'Ω' notation is the lower bound, and means the best case.
- 'O' notation is the upper bound, and means the worst case.
- 'Θ' notation is between the lower bound and the upper bound, and means the average case.

## Reference
- [Big-O Complexity Chart](http://bigocheatsheet.com/ "Big-O Complexity Chart")
- [Big O notation](https://en.wikipedia.org/wiki/Big_O_notation "Big O notation")
- [Best, Worst and Average case](https://en.wikipedia.org/wiki/Best,_worst_and_average_case "Best, Worst and Average case")
- [Sorting Algorithms](https://en.wikipedia.org/wiki/Sorting_algorithm#Comparison_of_algorithms "Sorting Algorithms")
- [Data Structures](https://en.wikipedia.org/wiki/Search_data_structure#Asymptotic_amortized_worst-case_analysis "Data Structures")
- [Common Time Complexities](https://en.wikipedia.org/wiki/Time_complexity#Table_of_common_time_complexities "Common Time Complexities")

[tests]:https://travis-ci.org/keidrun/basic-algo-java.svg?branch=master
[tests-url]:https://travis-ci.org/keidrun/basic-algo-java

[cover]:https://codecov.io/gh/keidrun/basic-algo-java/branch/master/graph/badge.svg
[cover-url]:https://codecov.io/gh/keidrun/basic-algo-java
