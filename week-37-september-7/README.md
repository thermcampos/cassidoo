# Week 37 - September 7, 2026

Week's question:

You have a backpack lock's starting position, and the code to unlock it,
represented as two strings of integers. In one move, you may rotate any
single digit one step up or down, with 0 and 9 considered adjacent. Return
the minimum number of moves needed to transform the starting code into the
unlock code.

Example:
```
minMoves("8051", "1199")
> 10

minMoves("000", "555")
> 15

minMoves("109", "990")
> 4
```

---

## Solution

> Compiled with Java 25 graalvm.

### Reasoning

Both directions always sum up to `10`. But the directions tricked me up
for a bit.

When I started coding it, I wrongly considered fixed forward and backwards
directions, and ended up with several if cases. Then I realized that the
directions could swap based in the starting and targeting values. Then I
got simpler. =D

