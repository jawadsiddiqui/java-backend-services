### Streams Examples

At a foundation we have a BaseStream (Generic Interface). BaseStream extends the AutoCloseable interface; thus, a stream can be managed in a try-with-resources statement.
- Intermediate operations produce another stream
- A terminal operation consumes the stream. It is used to produce a result, such as finding the minimum value in the stream, or to execute some action

* [Terminal / Intermediate Operations](https://github.com/jawadsiddiqui/ProblemSolvings/blob/master/src/com/company/StreamClass.java)
* [Reduce](https://github.com/jawadsiddiqui/ProblemSolvings/blob/master/src/com/company/StreamClass.java)
