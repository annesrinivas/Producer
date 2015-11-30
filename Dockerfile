FROM java:8

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

COPY jars /home/root/excercise
WORKDIR /home/root/excercise
RUN java -jar Producer.jar
CMD ("java", "Producer")