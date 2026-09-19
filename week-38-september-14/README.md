# Week 38 - September 14, 2026

Week's question:

Given a sentence, return the longest word whose letters appear in alphabetical order.

Example:
```
> longestSorted("The autumn leaves almost glow.")
> "almost"

> longestSorted("A cool sheep sleeps.")
> ""
```

---

## Solution

> Compiled with Java 25 graalvm.

### Reasoning

> Uppercase letters are treated as lowercase (small conversion)

Go letter by letter and see if it's a work. If the next letter comes before
the last one, go to the next word (after a blank space, if any)
