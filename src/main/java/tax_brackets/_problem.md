Income tax brackets are ranges of numbers with a percentage associated to each range.

For example, we might have income tax brackets defined as follows:

```
0	10,000	10%
10,001	25,000	13%
25,001	50,000	15%
50,001	\infty	20%
```

To calculate someone's tax obligation on their earnings, we take the percentage associated to each tax bracket from their earnings in that range. For example:

1. If someone's earnings are `$56,000`, their tax obligation is:

```
(10,000 * 0.10) + (15,000 * 0.13) + (25,000 * 0.15) + (6,000 * 0.20) = 7,900
```

2. If someone's earnings are $36,000, their tax obligation is:

```
(10,000 * 0.10) + (15,000 * 0.13) + (11,000 * 0.15) + (0 * 0.20) = 4,600
```

Write a function that computes someones tax obligation, given their earnings and a data
structure that represents the tax brackets.