FROM erlang:23-alpine
RUN apk --no-cache add openjdk11
ADD jar/type-checker.jar /temp/
ADD examples /
RUN ["chmod", "+x", "/temp/type-checker.jar"]
RUN ["ls", "temp"]
ENTRYPOINT ["java","-jar", "/temp/type-checker.jar"]
