FROM java:8
COPY Producer.java
COPY JSONSource.txt
RUN javac Producer.java

CMD ("java", "Producer")