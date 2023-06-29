Given a tree representing an org chart for a company where each node's value contains that employees fun rating, give me the total amount of fun this company can have at a party where there is 1 restriction:

+ If I go to the party, my _direct_ reports can NOT go to the party.

## Example

```
        8
       / \
      5   1
     / \
    2   6
   / \ / \
  7  4 1  3
```

Result: `8 + 6 + 7 + 4 = 25`