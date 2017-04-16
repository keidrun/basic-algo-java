# basic-algo-java

[![tests][tests]][tests-url]
[![coverage][cover]][cover-url]

Basic algorithm library in java.

## The order of Sort algorithms
| Algorithm    |      Complexity |  Stability   |
|:-------------|:---------------:|:------------:|
| Bubble Sort  |          O(N^2) |    Stable    |
| Quick Sort   | O(N^2)~O(NlogN) |   Unstable   |
| Merge Sort   |        O(NlogN) |    Stable    |
| Comb Sort    |        O(NlogN) |   Unstable   |
| Insert Sort  |          O(N^2) |    Stable    |
| Binary Sort  |          O(N^2) |    Stable    |

## The order of Search algorithms
| Algorithm           |      Complexity |
|:--------------------|:---------------:|
| Linear Search       |            O(N) |
| Binary Search       |         O(logN) |
| Organization Search |            O(N) |

## The order of Data structures
| Data Structure | Add(Set)/Remove |             Search          |
|:---------------|:---------------:|:---------------------------:|
| Array          |            O(N) | Depends on Search algorithm |
| LinkedList     |            O(1) | The same of 'Linear Search' |

[tests]:https://travis-ci.org/keidrun/basic-algo-java.svg?branch=master
[tests-url]:https://travis-ci.org/keidrun/basic-algo-java

[cover]:https://codecov.io/gh/keidrun/basic-algo-java/branch/master/graph/badge.svg
[cover-url]:https://codecov.io/gh/keidrun/basic-algo-java
