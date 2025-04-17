@echo off
set FX="C:\Java\javafx-sdk-17.0.15\lib"
javac --module-path %FX% --add-modules javafx.controls Main.java
java --module-path %FX% --add-modules javafx.controls Main
pause
