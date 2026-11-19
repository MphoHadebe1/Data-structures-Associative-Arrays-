# CSC2001F DS4: Hashing

Java implementations of linear probing and quadratic probing hash tables, plus a brute-force search for the hash function weights that minimise probes when inserting a personalised list of usernames.

## Files

**Task One: hash tables**
- `LPHashTable.java`: linear probing hash table (completes `findIndex()`)
- `QPHashTable.java`: quadratic probing hash table (completes `findIndex()`; returns `-1` when probes exceed the table size)
- `LPAutoTest.java`, `QPAutoTest.java`: provided test drivers

**Task Two: hash weight optimisation**
- `Optimize.java`: tries every combination of the 9 weights (values 0 to 4), inserts the usernames into an `LPHashTable` of size 37, and prints the least number of probes and how many weight combinations achieve it
- `mydata.txt`: personalised list of 36 usernames, generated with `DataMaker`
- `results.txt`: output of `Optimize`: least probe count, then number of weight combinations

**Documentation**
- `Assignment_DS4.pdf`: assignment brief

## Requirements

- Java 11 or later

The provided framework classes (`HashTable`, `Monitorable`, `AutoTest`, `DataMaker`) and `students.txt` come from the course Amathuba page and are needed to compile and run. Add them to the same folder if they are not in this repo.

## Compile

```bash
javac *.java
```

## Run Task One

```bash
java LPAutoTest
java QPAutoTest
```

The first input is the table size. Then use the commands `INSERT`, `ISEMPTY`, `SIZE`, `CONTAINS`, `DUMP`, `PROBECOUNT`, `RESETCOUNT`, `LOAD <file> <n>` and `QUIT`.

Example:

```
11
load students.txt 9
dump
probecount
quit
```

## Run Task Two

Generate the data file (already done, shown for reference):

```bash
java DataMaker <your-username> 36 > mydata.txt
```

Run the optimiser:

```bash
java Optimize
```

It reads `mydata.txt` and prints one line: `<least probes> <number of weight combinations>`.

## Notes

- Linear and quadratic probing both report failure (`-1`) when the table is full or probing fails.
- `AutoTest` does not tolerate incorrect input, as it was designed for the automarker.
