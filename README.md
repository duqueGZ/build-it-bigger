Udacity Android Developer Nanodegree. Project 4

This project is composed of an Android app module (a joke telling example app), a Java library module
 (providing random jokes), an Android library (with a reusable activity for displaying jokes) and a
 GCE server module (from which jokes can be retrieved).

The app is presented in two flavors: free and paid (with no ads).

Both unit and connected tests has been implemented. And it is also provided a gradle task (testToLocalServer),
 that allows to automatically start a local GCE server, run the all the tests and then stop the server.