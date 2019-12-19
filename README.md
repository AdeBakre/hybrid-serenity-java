#HYBRID FRAMEWORK FOR API and WEB

## Getting Started

The framework was created with JAVA using Serenity BDD which is a cucumber plug in that enables you
to write effective acceptance tests and great reporting. More info on the link below:

[Serenity](http://www.thucydides.info/#/)

Folder structure was very simple, creating classes for step definitions to support the feature files, access the service and
functions to support the steps in step lib/Search user class.

### Quick Start

Cloning this repository:

```bash
    cd <path-to-desired-directory>
    git clone https://github.com/AdeBakre/hybrid-serenity-java.git
```

## Test Execution

To execute tests:

```bash
    gradle clean test aggregate
```

### Overriding Test Parameters

To execute test locally using Chrome, you'll need download [chromedriver](http://chromedriver.storage.googleapis.com/index.html) and set the path as outlined:

```bash
    gradle clean test aggregate -Dwebdriver.chrome.driver="<path-to-chrome-driver>"
```