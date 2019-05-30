@echo off

echo This command should run from folder location not from eclips

echo copy started

robocopy frontend\build\ src\main\resources\templates index.html
rem copy frontend\public\index.html src\main\resources\templates\ /Y
rem copy frontend\public\error.html src\main\resources\templates\ /Y
robocopy frontend\build\static src\main\resources\static /E

echo copy completed

pause