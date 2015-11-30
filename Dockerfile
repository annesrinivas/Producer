FROM java:7
COPY jars /home/root/excercise
WORKDIR /home/root/excercise
RUN java -jar Producer.jar
CMD ("java", "Producer")