# Week 33 - August 10 2026

This week's question:

Write a function `trim(type, s)` that trims a string based on a trim type. The type parameter is one of four modes: "leading" (remove leading spaces), "trailing" (remove trailing spaces), "both" (remove leading and trailing spaces), or "compress" (collapse any sequence of multiple consecutive spaces into a single space, but leave single spaces intact). Return the trimmed string.

Example:
```
trim("leading", "   hello world   ")
> "hello world   "
trim("trailing", "   hello world   ")
> "   hello world"
trim("both", "   hello world   ")
> "hello world"
trim("compress", "hello   world  !")
> "hello world !"
trim("compress", "  hi   there  ")
> " hi there "
```

