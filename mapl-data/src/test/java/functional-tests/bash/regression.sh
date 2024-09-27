### READ @read
./mvn clean test -Dkarate.options='--tags @read' --info

### CREATE @create
./mvn clean test -Dkarate.options='--tags @create' --info

### UPDATE @edit
./mvn clean test -Dkarate.options='--tags @edit' --info

### DELETE @delete
./mvn clean test -Dkarate.options='--tags @delete.All' --info

### OTHER
./mvn clean test -Dkarate.options='--tags @ignore' --info



