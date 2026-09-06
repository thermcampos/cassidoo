# Week 36 - August 31, 2026

Week's question:

Given an integer n representing the number of steps in a staircase, 
return the number of distinct ways you can reach the top if you can 
climb either 1 or 2 steps at a time.

Example:
```
climbStairs(2)
> 2

climbStairs(4)
> 5

climbStairs(10)
> 89
```

---

## Solution

> Compiled with Java 25 graalvm.

### Reasoning

I started looking for permutations, but that's not quite the case.
But this is more like: **counting the number of ordered sequences
of 1s and 2s that sum to n**

So for `n=4` for example, that would be:
- 1+1+1+1
- 1+1+2
- 1+2+1
- 2+1+1
- 2+2

This would produce:
- n=1 -> 1 way
- n=2 -> 2 ways
- n=3 -> 3 ways
- n=4 -> 5 ways
- n=10 -> 89 ways

That's the **Fibonacci Sequence** =D