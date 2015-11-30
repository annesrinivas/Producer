FROM java:8
COPY jars /home/root/excercise
WORKDIR /home/root/excercise
RUN java -jar Producer.jar
CMD ("java", "Producer")