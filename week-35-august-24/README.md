# Week 35 - August 24, 2026

Week's question:

Given an array of integers, return a new array where odd numbers come first, 
even numbers come next, and zeros appear at the end. The relative order of 
elements within each group must be preserved.

Example:
```
partitionArray([0, 3, 2, 1, 4, 0, 7])
[3, 1, 7, 2, 4, 0, 0]
```

---

## Solution

> Compiled with Java 25 graalvm.

Loop three times to avoid using heavy List Java implementations.

Output:
```
In: [0, 3, 2, 1, 4, 0, 7] -> Out: [3, 1, 7, 2, 4, 0, 0]
In: [0, 1, 2, 3, 0, 0, 4, 5, 6, 7, 8, 9] -> Out: [1, 3, 5, 7, 9, 2, 4, 6, 8, 0, 0, 0]
In: [2, 4, 6, 8, 10, 12] -> Out: [2, 4, 6, 8, 10, 12]
In: [1, 3, 5, 9, 11, 121] -> Out: [1, 3, 5, 9, 11, 121]
In: [0, 1, 1, 2, 3, 5, 8, 13, 21, 35] -> Out: [1, 1, 3, 5, 13, 21, 35, 2, 8, 0]
```

