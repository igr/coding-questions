Many languages use the ordering of the characters in the Roman alphabet to induce an ordering on their words. For example:

```
car < cat
```

because

```
r < t
```

Conversely, an ordering of words induces an ordering on characters. That is, if we did not know the ordering of the alphabet, but we knew that

```
ball < bat
```

we could deduce that

```
l < t
```

in the alphabet.

Suppose that there is an alien language that uses our alphabet and symbols, but with a radically different ordering on them. Given a sorted list of _words_ in this alien language, deduce whatever possible about the ordering of the _characters_ in the words in that list.

We assume that the ordering on the characters is transitive in the sense that `a < b` and `b < c` implies `a < c`.

## Examples

1. Input: `['bc', 'bb', 'bba', 'bbc']`

   Output _could_ be: `['a', 'c', 'b']`

2. Input: `['bc', 'bb', 'bba', 'bbc', 'bbcz', 'bbcb']`

   Output: `?`

## Output Specification

Engineers routinely face problems in which the input data are well-defined but it's unclear what the output should be when it's time begin designing a solution.

Example (1.) is meant to illustrate an ideal situation in which we can deduce everything that we want about the input data. In that case, returning a list is fine, but with example (2.) we quickly see how that might go awry.

What we can get out of example (2.) is exactly the same ordering as example (1.) with an additional character, `z`, and all we know about `z` is that `z < b`. We know nothing about how `z` relates to `a` or `c`. Thus, while returning a list would be sufficient for example (1.), we don't want to do that for example (2.) since we would lose information.

This is where candidate evaluation should begin. The problem statement should be presented along with the above examples, and the candidate should be asked how they might represent the output. The natural choice is a directed graph. The candidate should be guided toward this choice but it should not be given up front.

Once using a graph is decided upon, the following parameters should be established:

1. The vertices in the graph are the characters in the input data.
2. A directed edge `a -> b` is equivalent to the statement `a < b` in the alien lexicon.
3. The output graph contains no superfluous edges, since we assume the ordering on the characters is transitive. That is, if the edges `a -> b` and `b -> c` are in the graph, the edge `a -> c` is _not_ in the graph.

Hopefully, the candidate can establish most of these by themselves, with the possible exception of (3.).

The candidate may use whatever data structure(s) they want to encode the graph, but whatever it is it should exist in their chosen language's native libraries. That is, they should not have to lean on some heavy-handed graph implementation with a bunch of bells and whistles.
