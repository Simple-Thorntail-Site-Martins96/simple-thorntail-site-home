@echo off
@echo *** Stating Home module ***
@echo ** Starting Backend **
cd home
start "BACKEND Console" mvn clean thorntail:run -DskipTests
cd ..
@echo ** Starting Frontend **
cd home-fe
start "FRONTEND Console" ng serve --port=4201
cd ..
@echo *** End start trigger, batch finished ***