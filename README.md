# Installation Guide: (Ubuntu 16.04 LTS)

API Project Zombie Survivor Social Network Evaluation of Codiminer42.

## Install

### Install GIT

```sh
$ sudo apt-get install git
```

### Install PostgreSQL

```sh
$ sudo apt-get update
$ sudo apt-get install postgresql
```

### Install Java 8

```sh
$ sudo add-apt-repository ppa:webupd8team/java
$ sudo apt-get update
$ sudo apt-get install oracle-java8-installer
```

### Install Gradle

```sh
$ sudo add-apt-repository ppa:cwchien/gradle
$ sudo apt-get update
$ sudo apt-get install gradle
```

### Create the project's database

```sh
$ sudo -i -u postgres
$ createdb sajadv
```

### Change the password of the user "postgres"

```sh
$ psql
$ \password postgres
```
* Repeat the "postgres" password twice
```sh
$ \q
$ exit
```

### Clone the project zssn-api na pasta desejada

```sh
$ git clone https://github.com/guilherme737/zssn-api.git
```

### Run the application (Spring Boot) via Gradle

```sh
$ cd sajadv-processos-api
$ gradle bootRun
```
