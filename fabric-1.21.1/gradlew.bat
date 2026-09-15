@echo off
set APP_HOME=%~dp0
java -classpath "%APP_HOME%..\neoforge-1.21.1\gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %*
