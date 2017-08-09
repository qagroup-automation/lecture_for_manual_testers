# Lecture for manual testers

Prerequisites:
Java 8 (jdk1.8) and Maven have to be installed on your system.


To download drivers, run

`
mvn driver-binary-downloader:selenium
`

It will download webdrivers into `selenium_standalone_binaries` folder within your project.

The test class is `LocalHtmlFileInBrowserTest` and placed in `/src/test/java/com/qagroup/start` folder.

One should edit the test class a little bit to provide correct paths to both webdriver and `example.html` files.

Have a fun learning!



