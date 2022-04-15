FROM erlang:23-alpine
RUN apk --no-cache add openjdk11
ADD jar/type-checker.jar /temp/
ADD examples /temp/
RUN ["chmod", "+x", "/temp/type-checker.jar"]
ENTRYPOINT ["java","-jar", "/temp/type-checker.jar", "/temp/three-buyer"]
