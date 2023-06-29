Write a function that returns how long it takes to enter a password into a 4 x 4 keypad, with a single finger.

The keypad layout is a square that has 4 rows and 4 columns of keys. Each key is an alphanumeric character (letter or number).

+ Your finger starts at the first key of the password, so no time is spent before pressing the first key
+ You can press a key instantly
+ It takes `1` second to move your finger from one key to an adjacent key, including diagonally adjacent keys
+ Moving to a non-adjacent key is done as a series of moves to adjacent keys.

Your function takes two inputs:

+ `password`: String to type into the keypad. Arbitrary length.
+ `keypa`d: String of 16 digits where each group of 4 digits represents a row on the keypad, in order. For example, `0123456789abcdef` represents the keypad:
```
0 1 2 3
4 5 6 7
8 9 a b
c d e f
````

## Example

`entryTime(15ebb, 0123456789abcdef)`

+ password: 15ebb
+ keypad: 0123456789abcdef

We calculate the time it takes to type password = 15ebb as follows:

+ `1`: We start at this key so it takes 0 seconds.
+ `5`: It takes 1 second to move from `1` -> `5`
+ `e`: It takes 2 seconds to move from `5` -> `e`
+ `b`: It takes 1 seconds to move from `e` -> `b`
+ `b`: It takes 0 seconds to move from `b` -> `b`

The total time is `4`.

