Given is a list of sentences, a list of keywords and an integer x. Find the most popular x keywords in order of most to least frequently mentioned.

The comparison of strings is case-insensitive.
Multiple occurrences of a keyword in a review should be considered as a single mention.

If keywords are mentioned an equal number of times in reviews, sort alphabetically.

Input:

```
x = 2
keywords = ["nagarro", "the", "website"]
reviews = [
"nagarro provides the best services in the city",
"nagarro has awesome website",
"Best services provided by nagarro, everyone should use nagarro",
]
```

Output:

```
["nagarro", "the"]
```