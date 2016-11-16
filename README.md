# Simplex Boiler Plate

This boilerplate covers the needs of most of the Android apps that you can think of. It's simple, well architected and easily adjustable to your specific requirements.

The boiler plate is based on MVP architecture (Model, View, Presenter) which is better than MVC when it comes to coupling. MVP makes your view code way cleaner than when using MVC, since the Views, Activities and the fragments will only have the code related to rendering the customizing the UI and no interactions with the controllers.

The project is fully based in Dependency Injection design pattern using Dagger2. Which adds another layer of separation and makes things even less coupled.

The dependencies currently handled by the boiler plate are the following:
- Database dependency: encapsulates all the database operations.
- Shared preferences dependency: deals with shared preferences.
- Local Storage dependency: which deals with saving on files.
- Analytics dependency: covers all the operation of reporting events to your analytics backend (GA, Segment, FB, Flurry ..)
- Logging dependency: encapsulates all the operations related to logging to your console
- Api dependency: encapsulates all the API related operations


The power of dependency injection comes really handy especially for testing since you can easily switch your dependencies in the test environment to dummy dependencies.

As an example, you can change your Api dependency on testing environment so it returns a specific response without doing the actual call to your server. Share pref dependency can be overridden to return specific values for certain keys instead of saving and retrieving actual values in your test device, and the same applies for local storage and data dependencies. Both logging and analytics dependencies can be overridden to deliver the logs and reports to a server or file to be analyzed after running the tests instead of the console or the actual analytics server.

Moreover, dependency injection makes it really easy when you need to change certain dependencies let's say moving from google analytics to flurry, Or migrating from DbFlow database to SQLBrite.

The boiler plates consist of 4 layers: View, Presenter, Controller, Model. The communication between the layers is all done using EventBus Design pattern. I'm using a custom bus implemented using RxJava.




## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Give examples
```

### Installing

A step by step series of examples that tell you have to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

Explain what these tests test and why

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags).

## Authors

* **Billie Thompson** - *Initial work* - [PurpleBooth](https://github.com/PurpleBooth)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone who's code was used
* Inspiration
* etc
