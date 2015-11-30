FROM java:8
COPY src/com/cpsot/excercise/ /home/root/excercise

WORKDIR /home/root/excercise

RUN mkdir bin

RUN javac -d bin ./Producer.java

CMD ("java", "Producer")