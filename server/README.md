
## Tasks

:warning: You need to load environmental variables in order to do these tasks:

```bash
# Load environmental variables, here we choose "development" environment
source ./server/src/main/resources/profile.d/development.sh
```

#### 1. Run a hello server

```bash
sbt server/run
```

Then you can `curl` the server root

```bash
curl http://localhost:8080
> Hello development
```

#### 2. Run all the tests 

```bash
sbt test
```

#### 3. Assemble a hello server module into jar file

```bash
sbt server/assembly
java -jar server/target/scala-2.12/server-assembly-0.1.0.jar
```

Then you can `curl` the server root

```bash
curl http://localhost:8080
> Hello development
```
