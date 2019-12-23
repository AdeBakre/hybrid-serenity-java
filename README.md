#HYBRID FRAMEWORK FOR API and WEB

## Getting Started

The framework was created with JAVA using Serenity BDD which is a cucumber plug in that enables you
to write effective acceptance tests and great reporting. More info on the link below:

[Serenity](http://www.thucydides.info/#/)

Folder structure was split into two different part; UI and API. This is to ensure that both
tests can be run independently. There are also separate runner classes to that effect.

Both UI and API are written using cucumber feature files.

The serenity properties file was not used for this task. Instead, the serenity.conf file was used and
it contains all the configuration settings for both UI and API.

Due to the sensitive nature of the API key, I have included this in my system file to be accessed
only locally. Please be aware that you will need to get your own api key to enable the back end
tests run.


### Quick Start

Cloning this repository:

```bash
    cd <path-to-desired-directory>
    git clone https://github.com/AdeBakre/hybrid-serenity-java.git
```

## Test Execution

The tests can be run either via the command line or setting up a configuration within your
chose IDE. For the purpose of this task, I am using IntelliJ IDEA.


To execute all tests via commandline:

```bash
    gradle clean test aggregate
```

### Running tests by tags:

```bash
    gradle test -Dcucumber.options="--tags @tagname"
```

### Overriding Test Parameters

The project has been implemented such that we do not need chrome driver installed locally.

Please refer to the CustomWebdriver to see the implementation for the webdriver instances.

The tasks for running the tests via IDE configuration settings are as follows:

```tasks
:cleanTest :test
```
```arguments
--tests "com.gbk.hybrid.qa.ui.RunUITests"
```
In the case of the API tests, I have added system variables which can not be disclosed here.

For simplicity, I have disabled logger function.

