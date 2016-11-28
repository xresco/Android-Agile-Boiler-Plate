# Agile Boiler Plate

The main task at the innovation labs of Avast is to find new ideas to work on, prototype these ideas, and quickly implement them. And because this nature of our work we might end up building so many ideas in a very short time. And since quality is something we can’t sacrifice, and since it usually requires additional time we decided to come up with a solid, lean, readable, upgradable, testable boilerplate for our Android apps. We named it Agile Boiler Plate.

This boilerplate covers the needs that most of the Android apps might require. It's simple, well architected and easily adjustable to your specific requirements.

The project is fully based on Dependency Injection design pattern using Dagger2, which adds a layer of separation and makes things even less coupled.

The dependencies currently handled by the boiler plate are the following:
- Database dependency: encapsulates all the database operations.
- Shared preferences dependency: deals with shared preferences.
- Local files dependency: deals with all the operations related to local files.
- Analytics dependency: covers all the operation of reporting events to your analytics backend (GA, Segment, FB, Flurry ..)
- Logging dependency: encapsulates all the operations related to logging to your console
- Api dependency: encapsulates all the API related operations


The power of dependency injection comes really handy especially for testing since you can easily switch your dependencies in the test environment to dummy dependencies.

As an example, you can change your Api dependency in testing environment so it returns a specific response without doing the actual call to your server. Share pref dependency can be overridden to return specific values for certain keys instead of saving and retrieving actual values in your test device, and the same applies for local files and data dependencies. Both logging and analytics dependencies can be overridden to deliver the logs and reports to a server or file to be analyzed after running the tests instead of the console or the actual analytics server.

Moreover, dependency injection makes it really easy when you need to change certain dependencies. Let's say moving from google analytics to flurry, Or migrating from DbFlow database to SQLBrite.

Agile boiler plate consist of 4 layers: View, Presenter, Controller, Model. The communication between the layers is all done using EventBus Design pattern. I'm using a custom bus implemented using RxJava.


Libraries and tools included:
- Support libraries
- RecyclerViews and CardViews
- [RxJava](https://github.com/ReactiveX/RxJava)
- [Retrofit 2](http://square.github.io/retrofit/)
- [Retrolambda](https://github.com/orfjackal/retrolambda)
- [Dagger 2](http://google.github.io/dagger/)
- [DbFlow](https://github.com/Raizlabs/DBFlow)
- [Data Binding](https://developer.android.com/topic/libraries/data-binding/index.html)
- [Timber](https://github.com/JakeWharton/timber)
- [Glide](https://github.com/bumptech/glide)
- Functional tests with [Espresso](https://google.github.io/android-testing-support-library/docs/espresso/index.html)
- [Robolectric](http://robolectric.org/)
- [Mockito](http://mockito.org/)


## Architecture

The boiler plate is based on MVP architecture (Model, View, Presenter) which is better than MVC when it comes to coupling. MVP makes your view code way cleaner than when using MVC, since the views, activities and the fragments will only have the code related to rendering the customizing the UI and no interactions with the controllers.



![MVP architecture](https://s21.postimg.org/ce0tc11qf/Screen_Shot_2016_11_17_at_12_04_58_PM.png)



## Prerequisites

- JDK 1.8
- [Android SDK](http://developer.android.com/sdk/index.html).
- Android N [(API 24) ](http://developer.android.com/tools/revisions/platforms.html).
- Latest Android SDK Tools and build tools.




## Running the tests


### Tests

To run **unit** tests on your machine:

```
./gradlew test
```

To run **instrumentation** tests on connected devices:

```
./gradlew connectedAndroidTest
```

### Code Quality and Style Tools

1- [CheckStyle:](http://checkstyle.sourceforge.net/) We are using Checkstyle to insure that the code follows our Android coding style and standards.

The rules we enforce are as the following:
- **Imports rules:** which prevents redundant and star imports
- **Naming:** sets the rules for naming packages, classes, attributes, parameter, local variables, and types.
- **White Space rules:** sets specific rules for white spaces. Things like: nothing can follow a semi-column ';', defining the rules for the white space allowed before the left curly brace '{' and after the right curly brace '}', 1 white space after a comma ',' ....
- **General code styles rules:** deals with things like: preventing empty catch, modifiers order (public, static, final, volatile ..)

To run Checkstyle, first you should install the tool on your device or CI server using the following command

```
brew install checkstyle
```

and then run the command:
```
./gradlew checkstyle
```


2- [PMD:](https://pmd.github.io/) Which is a source code analyzer that finds common programming flaws like unused variables, empty catch blocks, unnecessary object creation, and so forth. See this project's PMD ruleset.

Follow this [link](https://pmd.github.io/pmd-5.5.2/pmd-java/rules/index.html) to check all the rules that PMD enforces.

PMD can be executed using the following command:

```
./gradlew pmd
```


3- [Findbugs:](http://findbugs.sourceforge.net/) This tool uses static analysis to look for bugs in Java code. Unlike PMD & Checkstyle, it uses compiled Java bytecode instead of source code.

Follow this [link](http://findbugs.sourceforge.net/manual/running.html#d0e465) if you want a quick intro about how to configure and start Findbugs.
To read more about Findbugs, you can check the following [article](https://androidbycode.wordpress.com/2015/02/13/static-code-analysis-automation-using-findbugs-android-studio/)

Findbugs can be executed using the following command:

```
./gradlew findbugs
```


To run the all the previous checks and the unit tests simple run the command

```
./gradlew check
```



##Debuging

1- [Stetho](http://facebook.github.io/stetho/): Beside using the console and the debugging tools that comes with Android studio, we are using Stetho.
The boilerplate is pre-configured to use Stetho in the debug build variant and to avoid it in the release build variant (thanks to dependency injection).

Stetho is a sophisticated debug bridge for Android applications built by facebook which enables developers to have access to the Chrome Developer Tools feature natively part of the Chrome desktop browser.

Here are some of the features it gives:

- **View hierarchy support:** for ICS (API 15) and up! Lots of goodies such as instances virtually placed in the hierarchy, view highlighting, and the ability to tap on a view to jump to its position in the hierarchy.
- **Database Inspection:** SQLite databases can be visualized and interactively explored with full read/write capabilities.
- **Network Inspection:** This is possible with the full spectrum of Chrome Developer Tools features, including image preview, JSON response helpers, and even exporting traces to the HAR format.

To inspect the app using Stetho, simple run the app, make sure the phone is connected to the PC, open the link `chrome://inspect` in chrome and choose your device.


2- [Leak Canary](https://github.com/square/leakcanary): Which is A memory leak detection library for Android built by Sqaure. Leak canary runs only on debug and it  will automatically show a notification when an activity memory leak is detected in your debug build.
For more info check this [link](https://github.com/square/leakcanary/wiki/FAQ)


## Authors

* **Abed Almoradi** - *Senior Android Developer at Avast* - [Linkedin](https://www.linkedin.com/in/abdalmunem)


## License

This project is licensed under  Apache License Version 2.0 - see the [LICENSE.md](http://www.apache.org/licenses/LICENSE-2.0) file for details

## Acknowledgments

* [Ribot Boiler Plate](https://github.com/ribot/android-boilerplate)
* [Avast](https://www.avast.com)



![MVP architecture](http://files.avast.com/files/marketing/logos/logo-rgb.jpg)